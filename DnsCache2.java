import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.URL;

public class DnsCache2 {
	 

  public static void main(String[] args) throws IOException {
	 long sysTime = 0;
	 long sysTTL = 0;
	  File file = new File("info.txt");
      
	  if (file.exists()){	 	
	  BufferedReader br = new BufferedReader(new FileReader(file));
	  
		String line = null;
		System.out.println("Contents");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				/* words=line.split(" ");
		         long targetX=Long.parseLong(words[0]);*/
				//System.out.println(targetX);		}
		}
			br.close();
			
			System.out.println("========================================");
			System.out.println("Reading from file Line by Line");
			
		 LineNumberReader ln = new LineNumberReader(new FileReader("info.txt"));
         while (ln.getLineNumber() == 0){
             String s = ln.readLine();
             System.out.println("Current system time "+ s);    
             
             sysTTL = Long.parseLong(s);
             sysTTL=sysTTL+10;
             System.out.println("TTL " +sysTTL);
             ln.close();
         }
			
			if(sysTime>sysTTL){
				URL url = new URL("http://www.google.com");
		    	  InetAddress address = InetAddress.getByName(url.getHost());
		    	  String temp = address.toString();
		    	  String IP = temp.substring(temp.indexOf("/")+1,temp.length());
		    	  System.out.println(IP);
		    	  sysTime = System.currentTimeMillis();
		    	   
		    	  System.out.println(sysTime);
		    	  System.out.println("===================================");
		    	  
		    	  PrintWriter writer = new PrintWriter("info.txt", "UTF-8");
		    	  writer.println(sysTime);
		    	  writer.println(IP);
		    	  writer.println("second if block");
		    	  writer.close();
		      }
			else{
				LineNumberReader ln1 = new LineNumberReader(new FileReader("info.txt"));
		         while (ln1.getLineNumber() == 1){
		             String s = ln1.readLine();
		             System.out.println("IP "+ s);    
		             ln1.close();					
			}
		}
   	  }
    
      else{
    	  
    	  URL url = new URL("http://www.google.com");
    	  //System.out.println(url.getHost());
    	  InetAddress address = InetAddress.getByName(url.getHost());
    	  //System.out.println(address.toString());
    	  String temp = address.toString();
    	  String IP = temp.substring(temp.indexOf("/")+1,temp.length());
    	  System.out.println(IP);
    	  
    	   sysTime = System.currentTimeMillis();
    	  //or//long millisStart = Calendar.getInstance().getTimeInMillis();
    	  System.out.println(sysTime);
    	  System.out.println("===================================else");
    	  
    	  PrintWriter writer = new PrintWriter("info.txt", "UTF-8");
    	  writer.println(sysTime);
    	  writer.println(IP);
    	  writer.close();
      }
	 
  }
}

