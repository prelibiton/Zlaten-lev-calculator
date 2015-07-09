import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
	
	public Log(Connector c, String str) throws IOException{
        
		File desktop = 
				new File(System.getProperty("user.home"), "Desktop");
        FileWriter fileWriter =
            new FileWriter(desktop + "/Desktop" + "_logFile.txt",true);
        BufferedWriter bufferedWriter =
            new BufferedWriter(fileWriter);

        bufferedWriter.write("Date: " + String.valueOf(c.date) + " Price: " + str);
        bufferedWriter.newLine();
        
        bufferedWriter.close();
  
    }
}

