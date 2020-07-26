import java.net.*;
import java.io.*;  

public class Client {

	public static void main(String args[])throws Exception{  
		
		Socket s=new Socket("localhost",3333);  /*establish a connection by creating socket obj of Socket class. Argument localhost is machine name and 3333 is port number  */      
		DataInputStream din=new DataInputStream(s.getInputStream()); /*create input stream to receive data from server over socket connection*/
		DataOutputStream dout=new DataOutputStream(s.getOutputStream()); /*create output stream to send data to server over socket connection*/
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  //for reading input from terminal
		  
		String str="",str2="";   			   // strings to read and write msgs
	
		while(!str.equals("stop")){  			   // keep communicating until "stop" is input
			str=br.readLine();   			   //read input from terminal
			dout.writeUTF(str);  			   //Send data to the server
			dout.flush();  				   //flush output stream for next response
			str2=din.readUTF();  			   //Receive data from the server
			System.out.println("Server says: "+str2);  //print on the terminal
		}  
	  
		dout.close();  	//close output stream when done
		s.close();  	//Close the socket when done
	}}


/*how to execute?
1. execute Server.java in terminal
2. open new terminal and execute Client.java
3. type msg on client window and server window
*/



/*readUTF() reads from the stream in a representation of a Unicode character string 
encoded in modified UTF-8 format; this string of characters is then returned as a String.
same for writeUTF()*/


/* OUTPUT

sheetal@ubuntu:~/Desktop$ javac Client.java
sheetal@ubuntu:~/Desktop$ java Client
hi
Server says: hello
how r u?
Server says: fine
stop
Server says: ok
sheetal@ubuntu:~/Desktop$ 

*/

