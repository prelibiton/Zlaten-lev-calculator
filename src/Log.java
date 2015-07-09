import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
	
	public Log(Connector c, String str, String str2) throws IOException{
        
		File desktop = 
			new File(System.getProperty("user.home"), "Desktop");
        FileWriter fileWriter =
            new FileWriter(desktop + "/Desktop" + "_logFile.txt",true);
        BufferedWriter bufferedWriter =
            new BufferedWriter(fileWriter);
        
        BufferedReader br = new BufferedReader(new FileReader(desktop + "/Desktop" + "_logFile.txt"));     
        if (br.readLine() == null) {
        	bufferedWriter.write(str2);
        	bufferedWriter.newLine();
        	br.close();
        }
        bufferedWriter.write("Date: " + String.valueOf(c.date) + " Price: " + str);
        bufferedWriter.newLine();
        
        bufferedWriter.close(); 
    }
}

