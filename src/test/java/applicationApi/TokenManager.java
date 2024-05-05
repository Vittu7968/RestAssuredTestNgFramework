package applicationApi;

import java.time.Instant;
import java.util.HashMap;

import Api.Specbuilder;
import Utils.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TokenManager {
	
	
	
	private static String access_Token;
	private static Instant expiry_time;
	
	
	public synchronized static String generate_Token()
	{
		try {
			if (access_Token == null || Instant.now().isAfter(expiry_time)) {
				System.out.println("Renewing Token ....");
				Response renewToken_resp = renewToken();
				access_Token = renewToken_resp.path("access_token");
				int expiryDurationInSeconds = renewToken_resp.path("expires_in");
				expiry_time = Instant.now().plusSeconds(expiryDurationInSeconds - 300);
			} else {
				System.out.println("Token is good to use");
			}
		}

		catch (Exception e) {
			throw new RuntimeException("!ABORT .. failed to get token");
		}
		return access_Token;
		 
	}
	
	
	//The below generate Token method is a static method
	public static Response  renewToken()
	{
		HashMap<String, String> hp=new HashMap<String, String>();
//		hp.put("client_id", "4cd1a7ee69cd40b18e28717826a4f903");
//		hp.put("client_secret", "a2f63803131f4af9a2b5e634bb5f560f");
//		hp.put("grant_type", "refresh_token");
//		hp.put("refresh_token", "AQBd4bczn8D7jF7Z9MlzY5MZO9DJFMCVxI9ogV1zqyaPvihmNTAaq_Y2Cj-V2ndBsYiH2fNNFuMJ-juivcpTlhTRG0tXkl_tQbOFcfBW92iew8JuLwZp-sdEdnSeuYfusjY");
//		
		
		hp.put("client_id", ConfigLoader.getTnstance().getClientId());
		hp.put("client_secret", ConfigLoader.getTnstance().getClientSecret());
		hp.put("grant_type", ConfigLoader.getTnstance().getGrantType());
		hp.put("refresh_token", ConfigLoader.getTnstance().getRefreshToken());
		
		
		Response resp=RestResource.postAccount(hp);
		
		//Sifting this method to rest Resource class
		
//		Response resp=RestAssured
//		.given()
//		.baseUri("https://accounts.spotify.com")
//		.formParams(hp)
//		.contentType(ContentType.URLENC)
//		.log()
//		.all()
//		.when()
//		.post("/api/token")
//		.then()
//		.spec(Specbuilder.getResponseSpecification())
//		.extract()
//		.response();
		
		if(resp.statusCode() !=200)
		{
			throw new RuntimeException("!ABORT Renew token failed");
		}
//		return resp.path("access_token");
		
		return resp;
		
	}

}
