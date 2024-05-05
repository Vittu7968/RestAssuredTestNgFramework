package applicationApi;

import static io.restassured.RestAssured.given;

import java.util.Map;

import com.spotify.oauth2.pojo.Playlist;

import Api.Specbuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestResource {
	
	public static Response postRequest(String path, String accessToken,Object requestPlaylist)
	{
		return given(Specbuilder.getRequestSpecification())
//		.pathParam("user_id", "8kb28eu524jc855qjwzmk4q7w")
		.body(requestPlaylist)
		//Using outh2 mechanism
		.auth().oauth2(accessToken)
//		.header("Authorization" , "Bearer "+accessToken)
		.when()
		.post(path)
		.then()
		.spec(Specbuilder.getResponseSpecification())
		.extract()
		.response();
	}
	
	
	public static Response postAccount(Map<String, String> formParams)
	{
		return RestAssured
		.given(Specbuilder.getAccountRequestSpec())
		.formParams(formParams)
		.when()
		.post(Route.API+Route.TOKEN)
		.then()
		.spec(Specbuilder.getResponseSpecification())
		.extract()
		.response();
	}
	
	
	public static Response getRequest(String path, String accessToken)
	{
		return given(Specbuilder.getRequestSpecification())
//				.pathParam("playlist_id", playlistId)
				//Using outh2 mechanism
				.auth().oauth2(accessToken)
//				.header("Authorization" , "Bearer "+accessToken)
				.when()
				.get(path)
				.then()
				.spec(Specbuilder.getResponseSpecification())
				.extract()
				.response();
	}
	
	public static Response updateRequest(String path,String accessToken,Object requestPlaylist)
	{
		return given(Specbuilder.getRequestSpecification())
//				.pathParam("playlist_id", playlistId)
				.auth().oauth2(accessToken)
//				.header("Authorization" , "Bearer "+accessToken)
				.body(requestPlaylist)
				.when()
				.put(path)
				.then()
				.spec(Specbuilder.getResponseSpecification())
				.extract()
				.response();
	}
	
//	public static Response postRequest(String path,String token,Object requestPlaylist)
//	{
//		return given(Specbuilder.getRequestSpecification())
//		.pathParam("user_id", "8kb28eu524jc855qjwzmk4q7w")
//		.body(requestPlaylist)
//		.header("Authorization" , "Bearer "+token)
//		.when()
//		.post(path)
//		.then()
//		.spec(Specbuilder.getResponseSpecification())
//		.extract()
//		.response();
//	}

}
