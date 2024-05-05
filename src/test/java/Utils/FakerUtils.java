package Utils;

import com.github.javafaker.Faker;

public class FakerUtils {
	
	public static String generateName()
	{
		Faker faker=new Faker();
		//There are many methods in faker class
		
		//In our case the playlist name can have certain restrictions like The length , spacing Etc
		
		//In our case we are providing custom regex- In real Project we get regex from dev team
		
		//The below regex accepts all Alphanumeric with only 3 special character upto 20
		return "Playlist "+faker.regexify("[A-Za-z0-9 ,_-]{20}");
	}
	
	public static String generateDescription()
	{
		Faker faker=new Faker();
		//There are many methods in faker class
		
		//In our case the playlist name can have certain restrictions like The length , spacing Etc
		
		//We have used a different structure for Description Regex
		
		//The below regex will accept still more special characters
		return "Description "+faker.regexify("[A-Za-z0-9_@./#&+-]{50}");
	}

}
