package com.spotify.oauth2.tests;

import java.util.HashMap;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.spotify.oauth2.pojo.ErrorRoot;
import com.spotify.oauth2.pojo.InnerError;
import com.spotify.oauth2.pojo.Playlist;

import Api.Specbuilder;
import Api.StatusCode;
import Utils.DataLoader;
import Utils.FakerUtils;
import applicationApi.playlistApi;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;




@Epic("Spotify Oauth 2.0")
@Feature("Playlist API")
public class PlaylistTests extends BaseTest {
	
//String accessToken="BQCibmIHcTg405ABOCX9zcSJGUNB3UF_5g91hCccngHxwoPfRsCI70WpBA9pHzQ4bK196GbR9zWyGrqbAJSFpt51Hd_Rjqabv3yJfcIxXfzhIVnnurM5kjVn5ibPEG74-RgsCnk4S6ujj29Q0NNhrXsjl_zt-zPsXnfi3lfTDk0LXE9LT8UXQb9HVvuIsS_kPQgt1g89H9e43Txkd9N17MtQlr3NSXY8xYe9sU4jikkk9su_5qRGlE7kXQsdjRIntYtlmKKg4upS-to6hY986AVLkfaU99NmuviW7JD2nrQxLub6sjw8x_CaH2Xql1Hen8fhMMBZ3jnEnKTM5A_2tUJz6hCLvNVmkDl6NGw2iKINTkLCE2XKTP1Tf2VVDAB3x4GtjQBX";
	


//We have created a seperate class which wil return request and response specifications

//	@BeforeClass
//	public void beforeClass()
//	{
//		
//		RequestSpecBuilder reqSpec=new RequestSpecBuilder();
//		
//		RestAssured.requestSpecification=reqSpec
//				.setBaseUri("https://api.spotify.com")
//				.setBasePath("/v1")
//				.addHeader("Authorization", "Bearer "+accessToken)
//				.setContentType(ContentType.JSON)
//				.log(LogDetail.ALL)
//				.build();
//		
//		
//		ResponseSpecBuilder respSpec=new ResponseSpecBuilder();
//		
//		RestAssured.responseSpecification=respSpec
//				.expectContentType(ContentType.JSON)
//				.log(LogDetail.ALL)
//				.build();
//	}
	
	@Story("Create a playlist story")
	@Description("This the create Plylist description")
	@Test(description = "Should be able to create a playlist")
	@Link(name = "allure", url = "mylink")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
	public void creatPlaylist()
	{
		
//		HashMap<String, Object> hp=new HashMap<String, Object>();
//		hp.put("name", "New Playlist");
//		hp.put("description", "New playlist description");
//		hp.put("public", false);
		
		
//		//Using builder patterns
//		Playlist requestPlaylist=new Playlist()
//				.setName("New playlist 02")
//				.setDescription("New description 02")
//				.setPublic(false);
		
		//Replacing above piece of code with playListBuilder Method
		Playlist requestPlaylist=playListBuilder(FakerUtils.generateName(), FakerUtils.generateDescription(), false);
		
		
		//Below is a normal way creating an instance of class and calling setter methods
//		Playlist requestPlaylist=new Playlist();
//		requestPlaylist.setName("New playlist 02");
//		requestPlaylist.setDescription("New description 02");
//		requestPlaylist.setPublic(false);
		
//		Playlist responsePlaylist=RestAssured.given(Specbuilder.getRequestSpecification())
//		.pathParam("user_id", "8kb28eu524jc855qjwzmk4q7w")
//		.body(requestPlaylist)
//		.when()
//		.post("/users/{user_id}/playlists")
//		.then()
//		.spec(Specbuilder.getResponseSpecification())
//		.assertThat()
//		.statusCode(201)
//		.extract()
//		.response()
//		.as(Playlist.class);
		
		
		//Calling the postRequestMethod
	     Response postReq_Resp=playlistApi.postRequest(requestPlaylist);
//	     MatcherAssert.assertThat(postReq_Resp.statusCode(), Matchers.equalTo(201));
	     
	     //replaing above piece of code with assertStatusCode method
	     
	     assertStatusCode(postReq_Resp.statusCode(), StatusCode.CODE_201);
	     
	     Playlist responsePlaylist= postReq_Resp.as(Playlist.class);
		
//		MatcherAssert.assertThat(responsePlaylist.getName(), Matchers.equalTo(requestPlaylist.getName()) );
//		MatcherAssert.assertThat(responsePlaylist.getDescription(), Matchers.equalTo(requestPlaylist.getDescription()) );
//		MatcherAssert.assertThat(responsePlaylist.getPublic(), Matchers.equalTo(false) );
	     
	     //We are replacing above piece of of code with playListEqual method
	     
	     playListEqual(responsePlaylist, requestPlaylist);
	     
	     
//		.assertThat()
//		.body("description", Matchers.equalTo("New playlist description")
//				,"name", Matchers.equalTo("New Playlist")
//				,"public", Matchers.equalTo(false));
	}
	
	
	@Test
	public void getPlaylist()
	{
//		Playlist requestPlaylist=new Playlist();
//		requestPlaylist.setName("New playlist 02");
//		requestPlaylist.setDescription("New description 02");
//		requestPlaylist.setPublic(false);
		
		//Replacing above piece of code with playListBuilder Method
		Playlist requestPlaylist=playListBuilder("New playlist 02", "New description 02", false);
		
		
//		Response getReq_Resp=playlistApi.getRequest("324ndwGXEbgRlZBwKY8628");
		Response getReq_Resp=playlistApi.getRequest(DataLoader.getInstance().getPlayListId());
//		MatcherAssert.assertThat(getReq_Resp.statusCode(), Matchers.equalTo(200));
		
		//replaing above piece of code with assertStatusCode method
	     assertStatusCode(getReq_Resp.statusCode(), StatusCode.CODE_200);
	     
	     Playlist responsePlaylist= getReq_Resp.as(Playlist.class);
		
		
//		Playlist getPlaylistResp=RestAssured.given(Specbuilder.getRequestSpecification())
//		.pathParam("playlist_id", "324ndwGXEbgRlZBwKY8628")
//		.when()
//		.get("/playlists/{playlist_id}")
//		.then()
//		.spec(Specbuilder.getResponseSpecification())
//		.assertThat()
//		.statusCode(200)
//		.extract()
//		.response()
//		.as(Playlist.class);
		
		
//		MatcherAssert.assertThat(responsePlaylist.getName(), Matchers.equalTo(requestPlaylist.getName()));
//		MatcherAssert.assertThat(responsePlaylist.getDescription(), Matchers.equalTo(requestPlaylist.getDescription()) );
//		MatcherAssert.assertThat(responsePlaylist.getPublic(), Matchers.equalTo(requestPlaylist.getPublic()));
	     
	     
	     //We are replacing above piece of of code with playListEqual method
	     playListEqual(responsePlaylist, requestPlaylist);
	     
//		.body("description", Matchers.equalTo("New playlist description")
//				,"name", Matchers.equalTo("New Playlist")
//				,"public", Matchers.equalTo(false));
	}
	
	
	@Test
	public void updatePlaylist()
	{
		
//		HashMap<String, Object> hp=new HashMap<String, Object>();
//		hp.put("name", "Updated Playlist");
//		hp.put("description", "Updated playlist description");
//		hp.put("public", false);
		
//		Playlist requestPlaylist=new Playlist();
//		requestPlaylist.setName("Updated playlist 02");
//		requestPlaylist.setDescription("Updated description 02");
//		requestPlaylist.setPublic(false);
		
		//Replacing above piece of code with playListBuilder Method
		Playlist requestPlaylist=playListBuilder(FakerUtils.generateName(), FakerUtils.generateDescription(), false);
		
//		Response putReq_Resp=playlistApi.updateRequest(requestPlaylist , "324ndwGXEbgRlZBwKY8628");
		Response putReq_Resp=playlistApi.updateRequest(requestPlaylist , DataLoader.getInstance().getUpdatePlaylistId());
//	     MatcherAssert.assertThat(putReq_Resp.statusCode(), Matchers.equalTo(200));
		
		//replaing above piece of code with assertStatusCode method
	     assertStatusCode(putReq_Resp.statusCode(), StatusCode.CODE_200);
	     
//	     Playlist responsePlaylist= putReq_Resp.as(Playlist.class);
		
		
//		Playlist updatePlaylistResp=RestAssured.given(Specbuilder.getRequestSpecification())
//		.pathParam("playlist_id", "324ndwGXEbgRlZBwKY8628")
//		.body(requestPlaylist)
//		.when()
//		.put("/playlists/{playlist_id}")
//		.then()
//		.spec(Specbuilder.getResponseSpecification())
//		.assertThat()
//		.statusCode(200)
//		.extract()
//		.response()
//		.as(Playlist.class);
		
		//No response returned for update API
		
//		MatcherAssert.assertThat(updatePlaylistResp.getName(), Matchers.equalTo(requestPlaylist.getName()));
//		MatcherAssert.assertThat(updatePlaylistResp.getDescription(), Matchers.equalTo(requestPlaylist.getDescription()) );
//		MatcherAssert.assertThat(updatePlaylistResp.getPublic(), Matchers.equalTo(requestPlaylist.getPublic()));
	}
	
	
	@Story("Create a playlist story")
	@Test
	public void shouldNotBeAbleTocreatPlaylistWithoutName()
	{
		
//		HashMap<String, Object> hp=new HashMap<String, Object>();
////		hp.put("name", "New Playlist");
//		hp.put("description", "New playlist description");
//		hp.put("public", false);
		
		
//		Playlist requestPlaylist=new Playlist();
////		requestPlaylist.setName("New playlist 02");
//		requestPlaylist.setDescription("New description 02");
//		requestPlaylist.setPublic(false);
		
		//Replacing above piece of code with playListBuilder Method
		Playlist requestPlaylist=playListBuilder("", FakerUtils.generateDescription(), false);
		
		
		Response postReq_Resp=playlistApi.postRequest(requestPlaylist);
//	     MatcherAssert.assertThat(postReq_Resp.statusCode(), Matchers.equalTo(401));
		
		
		//replaing above piece of code with assertStatusCode method
	     assertStatusCode(postReq_Resp.statusCode(), StatusCode.CODE_400);
	     
	     ErrorRoot errorRoot3= postReq_Resp.as(ErrorRoot.class);
		
//		ErrorRoot errorRoot2=RestAssured.given(Specbuilder.getRequestSpecification())
//		.pathParam("user_id", "8kb28eu524jc855qjwzmk4q7w")
//		.body(requestPlaylist)
//		.when()
//		.post("/users/{user_id}/playlists")
//		.then()
//		.spec(Specbuilder.getResponseSpecification())
//		.assertThat()
//		.statusCode(401)
//		.extract()
//		.as(ErrorRoot.class);
		
//		MatcherAssert.assertThat(errorRoot3.getError().getMessage(), Matchers.equalTo("The access token expired"));
//		MatcherAssert.assertThat(errorRoot3.getError().getStatus(), Matchers.equalTo(401));
		
		assertError(errorRoot3,StatusCode.CODE_400);
		
		
//		.body("error.status", Matchers.equalTo(401),
//				"error.message", Matchers.equalTo("The access token expired"));
	}
	
	
	@Story("Create a playlist story")
	@Test
	public void invalidAccessToken()
	{
		
//		HashMap<String, Object> hp=new HashMap<String, Object>();
////		hp.put("name", "New Playlist");
//		hp.put("description", "New playlist description");
//		hp.put("public", false);
		
		
		String invalid_Token="12345";
//		Playlist requestPlaylist=new Playlist();
//		requestPlaylist.setName("New playlist 02");
//		requestPlaylist.setDescription("New description 02");
//		requestPlaylist.setPublic(false);
		
		Playlist requestPlaylist=playListBuilder(FakerUtils.generateName(), FakerUtils.generateDescription(), false);
		
		
		Response postReq_Resp = playlistApi.postRequest(invalid_Token,requestPlaylist);
//		MatcherAssert.assertThat(postReq_Resp.statusCode(), Matchers.equalTo(401));
		assertStatusCode(postReq_Resp.statusCode(), StatusCode.CODE_401);

		ErrorRoot errorRoot3 = postReq_Resp.as(ErrorRoot.class);
		
//		MatcherAssert.assertThat(errorRoot3.getError().getMessage(), Matchers.equalTo("Invalid access token"));
//		MatcherAssert.assertThat(errorRoot3.getError().getStatus(), Matchers.equalTo(401));
		
		assertError(errorRoot3, StatusCode.CODE_401);
		
		
		//WHENEVER WE ARE EXECUTING THIS TEST Make the requestSpecbuilder cOde in Before class commented Before Executing
//		RestAssured.given(Specbuilder.getRequestSpecification())
//		.baseUri("https://api.spotify.com")
//		.basePath("/v1")
//		.header("Authorization", "Bearer "+"12345")
//		.contentType(ContentType.JSON)
//		.log().all()
//		.pathParam("user_id", "8kb28eu524jc855qjwzmk4q7w")
//		.body(requestPlaylist)
//		.when()
//		.post("/users/{user_id}/playlists")
//		.then()
//		.spec(Specbuilder.getResponseSpecification())
//		.assertThat()
//		.statusCode(401)
//		.body("error.status", Matchers.equalTo(401),
//				"error.message", Matchers.equalTo("Invalid access token"));
	}
	
	@Step
	public Playlist playListBuilder(String Name, String description, boolean _public)
	{
		
		//LOMBOK with Builder annoation
		
		return Playlist.builder()
				.name(Name)
				.description(description)
				._public(_public)
				.build();
		
		
		//LOMBOK without Builder pattern
//		Playlist playlist=new Playlist();
//		playlist.setName(Name);
//		playlist.setDescription(description);
//		playlist.set_public(_public);
//		return playlist;
		

		//WE ARE USING LOMBOK without Builder patter so eliminating this
//		return new Playlist()
//				.setName(Name)
//				.setDescription(description)
//				.setPublic(_public);
	}
	
	@Step
	public void playListEqual(Playlist responsePlaylist, Playlist requestPlaylist)
	{
		//This method is created so that all repeating assert codes are in one place and inorder avoid rewriting the same
		
		MatcherAssert.assertThat(responsePlaylist.getName(), Matchers.equalTo(requestPlaylist.getName()) );
		MatcherAssert.assertThat(responsePlaylist.getDescription(), Matchers.equalTo(requestPlaylist.getDescription()) );
		MatcherAssert.assertThat(responsePlaylist.get_public(), Matchers.equalTo(requestPlaylist.get_public()) );
	}
	
	@Step
	public void assertStatusCode(int actualStatusCode, StatusCode statusCode)
	{
		 MatcherAssert.assertThat(actualStatusCode, Matchers.equalTo(statusCode.code));
	}
	
	
	public void assertError( ErrorRoot errorRoot3 , StatusCode statusCode)
	{
		MatcherAssert.assertThat(errorRoot3.getError().getStatus(), Matchers.equalTo(statusCode.code));
		MatcherAssert.assertThat(errorRoot3.getError().getMessage(), Matchers.equalTo(statusCode.message));
	}

}
