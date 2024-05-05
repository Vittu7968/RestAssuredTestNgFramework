package Api;

import applicationApi.Route;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specbuilder {
	
	
//	static String accessToken="BQAKwICqw3M2NHYHflR7toncnwESexO1L85nVvgnxLXEfn-z5Mmc40JcBiJtk4wwRUje1CzxpuDfNT7ZtPRW9gSJK5owThxs62Dq4cNtfUFqqa9PZyiv6xNTh4LIT4nV4K0d0UO27icuAgdmUElstCLr_i-qMWYSgIsno67BaPrRmrVTUVWgPK1vMTOtqICyQJqBY3HHLyz9JHjf2XdMqW3MrbhTStLYy8mj8ZxSUAzuWSSS6gWTgo93EE1fdSD6VyhDFdsyjMLh";

	public static RequestSpecification getRequestSpecification() {

		
		  return new RequestSpecBuilder()
//		  .setBaseUri("https://api.spotify.com") 
		//Passing base URI from sysytem property
				  .setBaseUri(System.getProperty("BASE_URI"))
		  .setBasePath(Route.BASE_PATH)
		  .addFilter(new AllureRestAssured())
//		  .addHeader("Authorization", "Bearer "+accessToken)
		  .setContentType(ContentType.JSON)
		  .log(LogDetail.ALL) 
		  .build();
		 

	}
	
	public static RequestSpecification getAccountRequestSpec() {

		
		  return new RequestSpecBuilder()
//		  .setBaseUri("https://accounts.spotify.com")
				//Passing base URI from sysytem property
		  .setBaseUri(System.getProperty("ACCOUNT_BASE_URI"))
		  .addFilter(new AllureRestAssured())
//		  .addHeader("Authorization", "Bearer "+accessToken)
		  .setContentType(ContentType.URLENC)
		  .log(LogDetail.ALL) 
		  .build();
		 

	}

	public static ResponseSpecification getResponseSpecification() {
		
		//Cant add Filter For Response Specification
		return new ResponseSpecBuilder()
		.expectContentType(ContentType.JSON)
		.log(LogDetail.ALL)
		.build();

	}

}
