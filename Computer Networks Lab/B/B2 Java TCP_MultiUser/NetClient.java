// A simple Client Server Protocol .. Client for Echo Server


import java.io.*;	//package for input and output of bytes and streams
import java.net.*;	//package Provides the classes for implementing networking applications.

public class NetClient {

public static void main(String args[]) throws IOException	//IOException whenever an input or output operation is failed or interpreted
{
    InetAddress address=InetAddress.getLocalHost(); //this class represents an IP address using the methods getLocalHost,getByName,or getAllByName to create a new InetAddress instance
    Socket s1=null;
    String line=null;
    BufferedReader br=null;
    BufferedReader br1=null;
    DataOutputStream dos=null;

    try {
        s1=new Socket("localhost", 4445); //creates the object of Socket class where 1st parameter is host name and 2nd is port number
        br= new BufferedReader(new InputStreamReader(System.in));	//br object -> to accept data from user
        br1=new BufferedReader(new InputStreamReader(s1.getInputStream()));
        dos= new DataOutputStream(s1.getOutputStream());	//The Java DataOutputStream class enables you to write Java primitives to OutputStream 's instead of only bytes
    }
   catch (IOException e){
        e.printStackTrace();
        System.err.print("IO Exception");
    }

    System.out.println("Client Address : "+address);
    System.out.println("Enter Data to echo Server ( Enter QUIT to end):");

    String response="";
    try{
        line=br.readLine(); 
        while(!line.equals("stop"))	//while loop continues still user/client enters the "stop" message
		{
			dos.writeUTF(line);  //writes a string to the underlying output stream using modified UTF-8 encoding.
			dos.flush(); 
			System.out.println("Enter Data to echo Server ( Enter QUIT to end):");
            line=br.readLine();
        }
    }
    catch(IOException e){
        e.printStackTrace();
    System.out.println("Socket read Error");
    }
    finally{

        br1.close();
	dos.close();	//close DataOutputStream
	br.close();
	s1.close();		//close socket
        System.out.println("Connection Closed");

    }

}
}
