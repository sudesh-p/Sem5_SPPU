import java.net.*;
import java.io.*;  


public class Server {
	public static void main(String args[])throws Exception{  
		ServerSocket ss=new ServerSocket(3333);   		      /* create server socket to listen for connections from client*/
		System.out.println("Waiting for client to connect....\n");		
		Socket s=ss.accept();    				      //accept client connection
		System.out.println("Connection established...\n");		
		DataInputStream din=new DataInputStream(s.getInputStream()); /*create input stream to receive data from client over socket connection*/
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());/*create output stream to send data to client over socket connection*/
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  //for reading input from terminal
		  
		String str="",str2="";  				// strings to read and write msgs
		while(!str.equals("stop")){  	 // keep communicating until "stop" is input by client
			str=din.readUTF();  				//receive data from the client
			System.out.println("client says: "+str);  	//print on the terminal
			str2=br.readLine();  				//read input from terminal	
			dout.writeUTF(str2);  				//send data to client
			dout.flush();  					//flush output stream for next response
		}  
		din.close();  						//close input stream when done
		s.close();  						//Close the socket when done
		ss.close();  						//Close the server socket when done
	}}   
	




/*how to execute?
1. execute Server.java in terminal
2. open new terminal and execute Client.java 
3. type msg on client window and server window
*/



/* OUTPUT

sheetal@ubuntu:~/Desktop$ javac Server.java
sheetal@ubuntu:~/Desktop$ java Server
Waiting for client to connect....

Connection established...

client says: hi
hello
client says: how r u?
fine
client says: stop
ok 
sheetal@ubuntu:~/Desktop$ 

*/
