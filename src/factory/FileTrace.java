package factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *  Writes to debug output when turned on or set by caller. Besides, creates file to write error message.
 *  Implements the signature provided by Trace interface
 * 
 * @author Yergalem
 *
 */
public class FileTrace implements Trace {

	private boolean activateDebug = false;
    private final  static String FILENAME = "trace.debug";

	
	@Override
	public void setDebug(boolean debug) {
		activateDebug = debug;
		
	}

	@Override
	public void debug(String message) {
	   if ( activateDebug )
          writeToFile("File Trace Debug: " + message);
	}

	@Override
	public void error(String message) {
		 writeToFile("File Trace Error: " + message);
		
	}
	
	private  void writeToFile(String message){
        String content;
        try {
            File file = new File( FILENAME );

            // if file doesnt exists, then create it
            if (!file.exists()) {
                content= message;                
                file.createNewFile();
            }else {
                String oldContent = readFromFile( FILENAME );
                content=oldContent.concat(message);
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            System.out.println(" File has been written : '"+message+"'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String  readFromFile(String fileName){
        // This will reference one line at a time
        String line;
        String content="";

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                content = content+line+"\n";
            }
            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        catch(IOException ex) {
            System.out.println( ex.getMessage());
        }
        return content;
    }

}

class ConsoleTrace implements Trace {

	boolean activateDebug;	
	@Override
	public void setDebug(boolean debug) {
		activateDebug = debug;
	}

	@Override
	public void debug(String message) {
		if( activateDebug )
		  System.out.println("Write to Console"+ message);
		
	}

	@Override
	public void error(String message) {
		System.out.println("Write to Console"+ message);
		
	}
	
}
