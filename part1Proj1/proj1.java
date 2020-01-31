package part1Proj1;
import com.google.gson.*;

import java.util.List;
import java.util.Map;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.io.IOException;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.net.HttpURLConnection;


public class proj1 extends WeatherClass{

	
	public static SongLyrics getSongLyrics(String[] song)
	{
		SongLyrics songLyricsObject = null;
		String endpt = "";
		String appID = "687d8671c428b65ca53cf5df54b2124e";														//song name
		endpt = "https://api.musixmatch.com/ws/1.1/matcher.lyrics.get?format=jsonp&callback=callback&q_track=" + song[1] + "&q_artist=" + song[3]+ "&apikey=" + appID;
		// handle the proper exception
		try {
			// This is the endpoint/url of the endpoint
			URL url = new URL(endpt);
			try {
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				int status = con.getResponseCode();
				
				// read the response of the request and place in the string
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while((inputLine = in.readLine()) != null)
				{
					content.append(inputLine);
				}
				in.close();
				con.disconnect();
				String strContent = content.toString();
				songLyricsObject = parseJSONf(strContent);
				//System.out.println(content);
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} catch(MalformedURLException e)  // Throws a MalformedURLException catch it 
		{
			e.printStackTrace();
		}
		
		return songLyricsObject;
	}
	// This method creates a GSON object using the GSON library to parse JSON to a Java Object
		public static SongLyrics parseJSONf(String jsonString) {
			Gson gson = new Gson(); // Gson object
			//Use the  gson.fromJson method to parse the json string to the weatherclass
			 //And store it in the weather class object
			// Then simply use getters to display the information the user wants.
			
			SongLyrics songlyric = gson.fromJson(jsonString, SongLyrics.class); 
			return songlyric;
		}


	public static String check(String city, int zipCode)
	{
		String APPID = "dee470034e65a90e0621302f43ef9b74";
		String endpoint1 = "";
		if(city == null) {
			endpoint1 = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + ",us" + "&APPID=" + APPID;
		}
		else if(zipCode == 0)
		{															// if user just puts zipcode assume USA
			endpoint1 = "http://api.openweathermap.org/data/2.5/weather?q=" + city + ",us" + "&APPID=" + APPID;
		}
		else
		{
			endpoint1 = "http://api.openweathermap.org/data/2.5/weather?zip=" + city + "," + zipCode + "&APPID=" + APPID;

		}
		return endpoint1;
	}
	public static WeatherClass getWeather(String city, int zipCode){
		// http://api.openweathermap.org/data/2.5/weather?q=austin&APPID=dee470034e65a90e0621302f43ef9b74
		WeatherClass weatherObject = null;
		
		
		String endpoint =check(city, zipCode);
		// handle the proper exception
		try {
			// This is the endpoint/url of the endpoint
			//System.out.println(endpoint);
			URL url = new URL(endpoint);
			try {
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				int status = con.getResponseCode();
				
				// read the response of the request and place in the string
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while((inputLine = in.readLine()) != null)
				{
					content.append(inputLine);
				}
				in.close();
				con.disconnect();
				String strContent = content.toString();
				weatherObject = parseJSON(strContent);
				//System.out.println(content);
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} catch(MalformedURLException e)  // Throws a MalformedURLException catch it 
		{
			e.printStackTrace();
		}
		
		return weatherObject;
	}
	// This method creates a GSON object using the GSON library to parse JSON to a Java Object
	public static WeatherClass parseJSON(String jsonString) {
		Gson gson = new Gson(); // Gson object
		/* Create a weather class that holds the parsed JSON string 
		 * 
		 *  UML Of The Weather Class
		 *    Create getters and setters for each data field
		 *    
		 * 
		 */
		// Use the  gson.fromJson method to parse the json string to the weatherclass
		// And store it in the weather class object
		// Then simply use getters to display the information the user wants.
		
		WeatherClass weatherToday = gson.fromJson(jsonString, WeatherClass.class); 
		return weatherToday;
	}
}
	


