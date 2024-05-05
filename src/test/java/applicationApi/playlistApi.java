package applicationApi;

import Api.Specbuilder;
import Utils.ConfigLoader;
import io.qameta.allure.Step;
import io.restassured.response.Response;

//Sice we are using given() regularly , we can use static import for that
import static io.restassured.RestAssured.given;

import com.spotify.oauth2.pojo.Playlist;;

public class playlistApi {
	
	
	
	//Previously we were using hardcoded Token , Noe since we have a class and a method which gennerates Token, We will use that method in below Methods
	
//	static String accessToken="BQDJgk35dvWsOGBfmJSnGAeNniLGt_SpnFKV6SOhXGFKa1xGyJXJWn5iAuM5esW1G9HJApyaXEJXd7yArvybjXhvh_xmTgHU4mneh9-GOC92SJTh-tnFS-C0YY0tOhC0_66s_uA09N3hKoWY7jS7UsblOSblxZiVI6sHdbEl1bchYrIBD_7JEOqYd8uljde5gZ-nbvmNVqverjZ2PjTfweILFULP6IZjQsNO8ziH691Rti9c9lSr4X21rqFWPxa6DuwwMlAQFWwr";
	
	//Make all methods as static in that way we can either call dirrectly through imports are class name
	@Step
	public static Response postRequest(Playlist requestPlaylist)
	{
		
		
//		return RestResource.postRequest("/users/8kb28eu524jc855qjwzmk4q7w/playlists", accessToken, requestPlaylist);
		
			return RestResource.postRequest(Route.USERS+"/"+ConfigLoader.getTnstance().getUser()+Route.PLAYLISTS, TokenManager.generate_Token(), requestPlaylist);
		
//		return given(Specbuilder.getRequestSpecification())
//		.pathParam("user_id", "8kb28eu524jc855qjwzmk4q7w")
//		.body(requestPlaylist)
//		.header("Authorization" , "Bearer "+accessToken)
//		.when()
//		.post("/users/{user_id}/playlists")
//		.then()
//		.spec(Specbuilder.getResponseSpecification())
//		.extract()
//		.response();
	}
	
	public static Response postRequest(String token,Playlist requestPlaylist)
	{
		
//		return RestResource.postRequest("/users/8kb28eu524jc855qjwzmk4q7w/playlists", token, requestPlaylist);
//		return RestResource.postRequest(Route.USERS+"/8kb28eu524jc855qjwzmk4q7w/playlists", token, requestPlaylist);
		
		return RestResource.postRequest(Route.USERS+"/"+ConfigLoader.getTnstance().getUser()+Route.PLAYLISTS, token, requestPlaylist);
//		return given(Specbuilder.getRequestSpecification())
//		.pathParam("user_id", "8kb28eu524jc855qjwzmk4q7w")
//		.body(requestPlaylist)
//		.header("Authorization" , "Bearer "+token)
//		.when()
//		.post("/users/{user_id}/playlists")
//		.then()
//		.spec(Specbuilder.getResponseSpecification())
//		.extract()
//		.response();
	}
	
	public static Response getRequest(String playlistId)
	{
		
//		return RestResource.getRequest("/playlists/"+playlistId, accessToken);
		
		return RestResource.getRequest(Route.PLAYLISTS+"/"+playlistId, TokenManager.generate_Token());
		
//		return given(Specbuilder.getRequestSpecification())
//				.pathParam("playlist_id", playlistId)
//				.header("Authorization" , "Bearer "+accessToken)
//				.when()
//				.get("/playlists/{playlist_id}")
//				.then()
//				.spec(Specbuilder.getResponseSpecification())
//				.extract()
//				.response();
	}
	
	public static Response updateRequest(Playlist requestPlaylist,String playlistId)
	{
		
//		return RestResource.updateRequest("/playlists/"+playlistId, accessToken,requestPlaylist);
		
		return RestResource.updateRequest(Route.PLAYLISTS+"/"+playlistId, TokenManager.generate_Token(),requestPlaylist);
		
//		return given(Specbuilder.getRequestSpecification())
//				.pathParam("playlist_id", playlistId)
//				.header("Authorization" , "Bearer "+accessToken)
//				.body(requestPlaylist)
//				.when()
//				.put("/playlists/{playlist_id}")
//				.then()
//				.spec(Specbuilder.getResponseSpecification())
//				.extract()
//				.response();
	}

}
