package Test1;
import org.jibble.pircbot.*;
import org.jibble.pircbot.*;
import java.text.DecimalFormat;
import part1Proj1.proj1;
import part1Proj1.SongLyrics;
import part1Proj1.WeatherClass;

public class MyBot extends PircBot {
	public MyBot() {
        this.setName("MyWeatherbot979");
    } 
    public void onMessage(String channel, String sender, String login, String hostname, String message){
    	DecimalFormat decimalFormat = new DecimalFormat("#.00");
    	double fahrenheit = 0;
    	String[] separatedMessage = message.split(" ");
    	if(separatedMessage[0].equalsIgnoreCase("weather")){
    		StringBuilder parsing = new StringBuilder(separatedMessage[1]);
    		
    		if(separatedMessage[1].matches("\\d+")){
    			
    			WeatherClass whatIsTheWeather = proj1.getWeather(null , Integer.parseInt(separatedMessage[1]));
    			sendMessage(channel, sender + " The temperature is: " + decimalFormat.format((((whatIsTheWeather.getTemp() - 273.16)*9.0/5.0) + 32.0))  + ": The weather's going to be " + whatIsTheWeather.getMain() + " with a high of " + decimalFormat.format((((whatIsTheWeather.getTempMax() - 273.16)*9.0/5.0) + 32.0)) + " F"  + " and a low of " + decimalFormat.format((((whatIsTheWeather.getTempMin() - 273.16)*9.0/5.0) + 32.0)) + " F");
    		}
    		else if(separatedMessage[1].contains(",")){
//    			StringBuilder build = new StringBuilder(separatedMessage[1]);
    			String[] s = separatedMessage[1].split(",");
    			WeatherClass whatIsTheWeather = proj1.getWeather(s[0], Integer.parseInt(s[1]));
    			sendMessage(channel, sender + " The temperature is: " + decimalFormat.format((((whatIsTheWeather.getTemp() - 273.16)*9.0/5.0) + 32.0))+" : The weather's going to be " + whatIsTheWeather.getMain() + " with a high of " + decimalFormat.format((((whatIsTheWeather.getTempMax() - 273.16)*9.0/5.0) + 32.0)) + " F"  + " and a low of " + decimalFormat.format((((whatIsTheWeather.getTempMin() - 273.16)*9.0/5.0) + 32.0)) + " F");

    		}
    		else{
    			WeatherClass whatIsTheWeather = proj1.getWeather(separatedMessage[1], 0);
    			sendMessage(channel, sender + " The temperature is: " + decimalFormat.format((((whatIsTheWeather.getTemp() - 273.16)*9.0/5.0) + 32.0)) + " The weather's going to be " + whatIsTheWeather.getMain() + " with a high of " + decimalFormat.format((((whatIsTheWeather.getTempMax() - 273.16)*9.0/5.0) + 32.0)) + " F"  + " and a low of " + decimalFormat.format((((whatIsTheWeather.getTempMin() - 273.16)*9.0/5.0) + 32.0)) + " F");
    		}
    	}
    	else if(message.equalsIgnoreCase("time")){
    		String time = new java.util.Date().toString();
    		sendMessage(channel, sender + ": The time is now " + time);
    	}
    	else if(separatedMessage[2].equalsIgnoreCase("weather") && separatedMessage[0].equalsIgnoreCase("how's")){
    		StringBuilder test = new StringBuilder(separatedMessage[4]);
    		 test = test.deleteCharAt(test.length()-1);
    		 String actualString = test.toString();
    		
    		//String[] test = separatedMessage[4].split("?");
    		WeatherClass whatIsTheWeather = proj1.getWeather(actualString, 0); // change this
    		sendMessage(channel, sender + " The temperature is: " + decimalFormat.format((((whatIsTheWeather.getTemp() - 273.16)*9.0/5.0) + 32.0)) + ": The weather's going to be " + whatIsTheWeather.getMain() + " with a high of " + decimalFormat.format((((whatIsTheWeather.getTempMax() - 273.16)*9.0/5.0) + 32.0)) + " F"  + " and a low of " + decimalFormat.format((((whatIsTheWeather.getTempMin() - 273.16)*9.0/5.0) + 32.0)) + " F");
    	}
    	else if(separatedMessage[0].equalsIgnoreCase("song")) {
		SongLyrics song123 = proj1.getSongLyrics(separatedMessage);
		sendMessage(channel, sender + " Lyrics: " + song123.getLyrics());
    	} 
    } 
}
