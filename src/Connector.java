import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Connector {

	char[] str = new char[6];
    char[] date = new char[10];
    double value;
    
    public Connector() throws IOException{
    
	String url = "http://www.zlatenlev.com/capital/index.php?pid=4";
	Document doc = Jsoup.connect(url).get();
	Elements prices = doc.select("strong");
	
	int i = 0;
	for (Element price : prices) {
		i = i + 1;
    	if(i == 1) price.text().getChars(24,34,date,0);
    	if(i == 5) {
    		price.text().getChars(0, 6, str, 0);
    		value = Double.parseDouble(String.valueOf(str));

	        	}
	        }
    }
}

	        	
	      

