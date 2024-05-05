package Utils;

import java.util.Properties;

public class ConfigLoader {
	
	private final Properties prop;
	private static ConfigLoader configLoader;
	
	private ConfigLoader()
	{
		prop=PropertyUtils.propertyLoader("src/test/java/resources/config.properties");
	}
	
	public static ConfigLoader getTnstance()
	{
		if(configLoader==null)
		{
			configLoader=new ConfigLoader();
		}
		return configLoader;
	}
	
	public String getClientId()
	{
		String clientId=prop.getProperty("client_id");
		if(clientId!=null)
		{
			return clientId;
		}
		else
		{
			throw new RuntimeException("the required property client_Id is not specified in config.properties file");
		}
	}
	
	public String getClientSecret()
	{
		String clientSecret=prop.getProperty("client_secret");
		if(clientSecret!=null)
		{
			return clientSecret;
		}
		else
		{
			throw new RuntimeException("the required property clientSecret is not specified in config.properties file");
		}
	}
	
	public String getGrantType()
	{
		String grantType=prop.getProperty("grant_type");
		if(grantType!=null)
		{
			return grantType;
		}
		else
		{
			throw new RuntimeException("the required property grantType is not specified in config.properties file");
		}
	}
	
	public String getRefreshToken()
	{
		String refreshToken=prop.getProperty("refresh_token");
		if(refreshToken!=null)
		{
			return refreshToken;
		}
		else
		{
			throw new RuntimeException("the required property refreshToken is not specified in config.properties file");
		}
	}
	
	public String getUser()
	{
		String userId=prop.getProperty("user_id");
		if(userId!=null)
		{
			return userId;
		}
		else
		{
			throw new RuntimeException("the required property userId is not specified in config.properties file");
		}
	}

}
