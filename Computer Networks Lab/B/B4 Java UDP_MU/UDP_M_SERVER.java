import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;


public class UDP_M_SERVER {

	
	public static void main(String[] args) throws IOException {

		
		DatagramSocket s=new DatagramSocket(1161);
		/* This class represents a socket for sending and receiving datagram packets
		 * this class creates a datagram socket & binds it to available port
		 * */
                                            System.out.println("Server is listening...........");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 /* BufferedReader reads text from a character input-stream,buffering characters*/
		
	
                                            String str="";

		while(!str.equals("bye"))
		{
		                  
		        
		
			byte[] buffer1=new byte[20];
			/* The Byte class wraps a value of primitive type byte in an object.
	                                             * this class provides several methods for converting a byte to a String and a String to a byte,*/


			DatagramPacket p2=new DatagramPacket(buffer1, buffer1.length); //creating packet 
		                      /* this class represenrs datagram packets
		  *                    datagaram packets are used to implment a connectionless packet delevery service*/
		 

			s.receive(p2);      //receives packet from client

			buffer1=p2.getData();             //converts the data from string format to byte version

			String str1=new String(buffer1,StandardCharsets.UTF_8);  //converting data from byte format to string format

			System.out.println("Client:"+str1);
			
	                         }

	}

}


/*

C:\Users\Alvis\Downloads\drive-download-20171026T130036Z-001>javac UDP_M_SERVER.java

C:\Users\Alvis\Downloads\drive-download-20171026T130036Z-001>java UDP_M_SERVER
Server is listening...........
Client:hii
Client:hello
Client:hiii
Client:i m 2
Client:bye
Client:bye


*/
