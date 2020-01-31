package Test1;
import java.io.IOException;
import org.jibble.pircbot.*;

import part1Proj1.proj1;
import part1Proj1.WeatherClass;
public class MyBotMain {
	// or you can just use --throws Exception
	public static void main(String[] args) throws IOException,IrcException,NickAlreadyInUseException{
		// Now start our bot up.
		MyBot bot = new MyBot();
				
		// enable debugging output
		bot.setVerbose(true);
		
		// connect to the IRC server
		bot.connect("irc.freenode.net");
		// join the #pricbot channel
		bot.joinChannel("#pricbot");
	}

}
