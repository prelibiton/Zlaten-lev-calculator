import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Connector {

	 public static void main(String[] args) throws IOException {
	        String url = "http://www.zlatenlev.com/capital/index.php?pid=4";

	        Document doc = Jsoup.connect(url).get();
	        
	        Elements prices = doc.select("strong");
	        int i = 0;
	        char[] str = new char[5];
	        double value;
	    
	        
	        for (Element price : prices) {
	        	i = i + 1;
	        	if(i == 5) {
	        		price.text().getChars(0, 5, str, 0);
	        		value = Double.parseDouble(String.valueOf(str));
	        		System.out.println(value);
	        	}
	        }
	        	
	       
	 }
	        
	       
	    private static void print(String msg, Object... args) {
	        System.out.println(String.format(msg, args));
	    }
}
