package part1Proj1;
import java.util.List;
import java.util.Map;

class coord{
	double Ion;
	double Iat;
}
class weather{
	int id;
	String main;
	String description;
}
class clouds{
	Integer all;
}
class Sys{
	int type;
	int id;
	double message;
	String country;
	long sunrise;
	long sunset;
	public String getCountry() {
		return country;
	}
}
class we4ther{
	int id;
	String main;
	String description;
	String icon;
}
public class WeatherClass {
	Map<String, Double> coord;   //idk why i created this i couldve just used coord object as a datatype
	private List<we4ther> weather;
	private String base; 
	private Map<String, Double> main;  
	private int visibility;
	private Map<String, Double> wind; 
	private Map<String, Integer> clouds; 
	private int dt; 
	private Sys sys; 
	private int timezone;  
	private int id;
	private String name;
	private int cod;	
	// Getters
	public String getMain() {return (weather.get(0).main);}
	public String getDescription() {return (weather.get(0).description);}
	public String getIcon() {return (weather.get(0).icon);}
	public String getBase() {return base;}
	public int getCod(){return cod;}
	public String getName(){return name;}
	public int getId() {return id;}
	public int getTimezone() { return timezone;}
	public String getcountry() {return sys.getCountry();} // for sys country
	public int getDt() { return dt;}
	public double getall() { return (clouds.get("all").intValue()); }
	public double getSpeed() { return (wind.get("speed").doubleValue());}
	public double getDeg() { return (wind.get("deg").doubleValue());}
	public double getGust() { return (wind.get("gust").doubleValue());}
	public int getVisibility() {return visibility;}
	public double getTemp() { return (main.get("temp").doubleValue());}
	public int getPressure() { return (main.get("pressure").intValue());}
	public int getHumidity() { return (main.get("humidity").intValue());}
	public double getTempMax() { return (main.get("temp_max").doubleValue());}
	public double getTempMin() { return (main.get("temp_min").doubleValue());}
}

