package Utils;

import java.util.Properties;

public class DataLoader {
	
	private final Properties prop;
	private static DataLoader dataLoader;
	
	private DataLoader()
	{
		prop=PropertyUtils.propertyLoader("src/test/java/resources/data.properties");
	}
	
	public static DataLoader getInstance()
	{
		if(dataLoader==null)
		{
			dataLoader=new DataLoader();
		}
		return dataLoader;
	}
	

	
	public String getPlayListId()
	{
		String playListId=prop.getProperty("get_playlist_id");
		if(playListId!=null)
		{
			return playListId;
		}
		else
		{
			throw new RuntimeException("the required property playListId is not specified in data.properties file");
		}
	}
	
	public String getUpdatePlaylistId()
	{
		String updatePlayListId=prop.getProperty("update_playlist_id");
		if(updatePlayListId!=null)
		{
			return updatePlayListId;
		}
		else
		{
			throw new RuntimeException("the required property updatePlayListId is not specified in data.properties file");
		}
	}

}
