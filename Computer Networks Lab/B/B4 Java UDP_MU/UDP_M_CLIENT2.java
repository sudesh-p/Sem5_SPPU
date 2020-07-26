import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;


public class UDP_M_CLIENT2 {

	
	public static void main(String[] args) throws IOException 
	{
	 InetAddress addr=InetAddress.getLocalHost();//this class represents IP address
	 DatagramSocket s=new DatagramSocket(1089);
	 /* This class represents a socket for sending and receiving datagram packets
	  * this class creates a datagram socket & binds it to available port
	  * */
	 
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 /* BufferedReader reads text from a character input-stream,buffering characters*/
	 
	 byte[] buffer=new byte[20];
	 /* The Byte class wraps a value of primitive type byte in an object.
	 * this class provides several methods for converting a byte to a String and a String to a byte,*/
	 
	 
	 String str="";
	 
	 while(!str.equals("bye"))
	 {
	                      
	                  
	 
	 
	                      System.out.println("Client_1:");
                                             str=br.readLine();          //reads a aline of text
		 buffer=str.getBytes(); // stores the byte version of data
		 
		 DatagramPacket p1=new DatagramPacket(buffer,buffer.length,addr,1161);   //wrapping data in packet
		 s.send(p1);          //sending packet to server
		 
		
		 
		 
		 
	 }
	 
	 

	}

}

/*

C:\Users\Alvis\Downloads\drive-download-20171026T130036Z-001>javac UDP_M_CLIENT2.java

C:\Users\Alvis\Downloads\drive-download-20171026T130036Z-001>java UDP_M_CLIENT2
Client_1:
hiii
Client_1:
i m 2
Client_1:
bye

C:\Users\Alvis\Downloads\drive-download-20171026T130036Z-001>

*/

