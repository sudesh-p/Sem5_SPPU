





// echo server

import java.io.*;	//package for input and output of bytes and streams
import java.net.*;	//package Provides the classes for implementing networking applications.


public class NetServer
{
  public static void main(String args[]) throws IOException	//IOException whenever an input or output operation is failed or interpreted
  {
    ServerSocket ss2=new ServerSocket(4445);	
	
	/*(ServerSocket) This class implements server sockets. A server socket waits for requests to come in over the network. 
	It performs some operation based on that request, and then possibly returns a result to the requester.*/
	
    System.out.println("Server Listening......");
  
    while(true)	//this while loop used for accepting and establishing the connection with multiple clients
    {
        try
	{
      	    Socket s= ss2.accept();
			
			/*Listens for a connection to be made to this socket and accepts it. 
			The method blocks until a connection is made.*/
			
			
            System.out.println("connection Established");
            ServerThread st=new ServerThread(s);
            st.start();

        }
        catch(Exception e)
	{      
	    System.out.println("Connection Error");
	}
     }
  }
}





/*We create a class that extends the java.lang.Thread class.
 This class overrides the run() method available in the Thread class.
 A thread begins its life inside run() method.
 We create an object of our new class and call start() method to start the execution of a thread. 
 Start() invokes the run() method on the Thread object.*/


class ServerThread extends Thread
{  
    String line=null;
    BufferedReader br = null;
    DataOutputStream dos=null;
    DataInputStream dis=null;
    Socket s=null;
   
    public ServerThread(Socket s)
	{
        this.s=s;  //invoke or initiate current class constructor
  	 }

    public void run()	//Start() invokes the run() method on the Thread object
    {
   	 try
   	 {
    	    br= new BufferedReader(new InputStreamReader(System.in));	//br object -> to accept data from user
    	    dos=new DataOutputStream(s.getOutputStream());	//DataInputStream class allows an application to read primitive data from the input stream in a machine-independent way
            dis=new DataInputStream(s.getInputStream());	//The Java DataOutputStream class enables you to write Java primitives to OutputStream 's instead of only bytes

   	 }
	catch(IOException e)
	{
        	System.out.println("IO error in server thread");
  	}

  	try 
	{
	   line="";
     	   while(!line.equals("stop"))
	   {
       		line=dis.readUTF(); 

			/*readUTF() - reads in a string that has been encoded using a modified UTF-8 format. 
			The string of character is decoded from the UTF and returned as String.*/
			

			
		System.out.println("client says: "+line); 
		dos.flush();  
	    }   
        } 
	catch (IOException e)
	{

	  System.out.println("IO Error/ Client ");
        }
        catch(NullPointerException e)
	{
      	   System.out.println("IO Error/ Client");
  	}
		
finally{
try{
   br.close(); 
  dos.close();	//close DataOutputStream
  dis.close();	//close DataInputStream
  s.close();	//close socket
}
  catch(IOException ie){
        System.out.println("Socket Close Error");
}}
}
}





/*

**************************************OUTPUT*********************************************



////////////////server side program output(server cmd)//////////////////////



C:\Users\BHUSHAN\Desktop\CN Practical>javac NetServer.java
C:\Users\BHUSHAN\Desktop\CN Practical>java NetServer
Server Listening......
connection Established
client says: hi this is client 1
connection Established
client says: hi this is client 2
IO Error/ Client
IO Error/ Client





/////////////////Client 1 cmd////////////////////// 




C:\Users\BHUSHAN>cd Desktop\CN practical

C:\Users\BHUSHAN\Desktop\CN Practical>javac NetClient.java

C:\Users\BHUSHAN\Desktop\CN Practical>java NetClient

Enter Data to echo Server ( Enter QUIT to end):
hi this is client 1
Enter Data to echo Server ( Enter QUIT to end):
stop
Connection Cldosed

C:\Users\BHUSHAN\Desktop\CN Practical>




/////////////////Client 2 cmd////////////////////// 



C:\Users\BHUSHAN>cd Desktop

C:\Users\BHUSHAN\Desktop>cd CN practical

C:\Users\BHUSHAN\Desktop\CN Practical>javac NetClient.java

C:\Users\BHUSHAN\Desktop\CN Practical>java NetClient

Enter Data to echo Server ( Enter QUIT to end):
hi this is client 2
Enter Data to echo Server ( Enter QUIT to end):
stop
Connection Closed

C:\Users\BHUSHAN\Desktop\CN Practical>











*/



