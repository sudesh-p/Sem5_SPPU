import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable; 
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import org.bson.Document;
import java.util.*;

class Connector{
	
	
    public Scanner sc;
    public MongoCollection<Document> table;
    public MongoDatabase db;
    public MongoClient mongoClient;
    
    public String Fname,Lname,Prn;
    
Connector(){
	
	try{
		sc = new Scanner(System.in);
		//---------- Connecting DataBase -------------------------//  
        mongoClient = new MongoClient( "localhost" , 27017 );
        //---------- Creating DataBase ---------------------------//  
        db = mongoClient.getDatabase("javatpoint");
        //---------- Creating Collection -------------------------//  
        table = db.getCollection("Emp");
	}
	catch(Exception e) {}
}

public void clearString()
{
	Fname = "";
	Lname = "";
	Prn   = "";
}
}

class Insertion extends Connector{

public void insert(){
	
	clearString();
	System.out.print("\nFIRST NAME : ");
		Fname = sc.nextLine();
	System.out.print("\nLAST NAME  : ");
		Lname = sc.nextLine();
	System.out.print("\nPRN        : ");
	    Prn = sc.nextLine();
	        
			try {
					Document doc = new Document("Fname", Fname);
				     doc.append("Lname",Lname);
				     doc.append("Prn",Prn);
					table.insertOne(doc);
			}
			catch(Exception e) {}
}
}
class Updation extends Insertion{

public void update(){
	
	clearString();
	System.out.print("\nENTER THE PRN OF STUDENT TO BE UPDATED : ");
    Prn = sc.nextLine();
    System.out.print("\nFIRST NAME : ");
	Fname = sc.nextLine();
	System.out.print("\nLAST NAME  : ");
	Lname = sc.nextLine();
	
	 

			try {
					table.updateOne(Filters.eq("Prn", Prn), Updates.set("Fname", Fname));
					table.updateOne(Filters.eq("Prn", Prn), Updates.set("Lname",Lname));
			}
			catch(Exception e) {}
}
}
class Deletion extends Updation{

public void delete(){
	
	clearString();
	System.out.print("\nENTER THE PRN OF STUDENT TO BE DELETED : ");
    Prn = sc.nextLine();
    
    
		    try {
		    	     table.deleteOne(Filters.eq("Prn", Prn));
			}
			catch(Exception e) {}
	
}
}
class Display extends Deletion{

public void display() {
	
		    try {
		    	FindIterable<Document> iterDoc = table.find(); 
		        int i = 1; 
		        Iterator it = iterDoc.iterator(); 
		      
		        while (it.hasNext())
		        {  
			           System.out.println(it.next());  
			           i++; 
		        }
			
	            }
		    catch(Exception e) {}
			}
}


public class MongoTr {

	public static void main(String[] args) {
		
		int choice;
		Scanner sc1 = new Scanner(System.in);
		
		Display obj = new Display();
				
		
			do {
				System.out.println("----------MongoDB---------");
				System.out.println("1.INSERT INTO TABLE ");
				System.out.println("2.UPDATE ENTRY ");
				System.out.println("3.DELETE A ENTRY ");
				System.out.println("4.DISPLAY THE TABLE ");
				System.out.println("5.EXIT \n");
				System.out.println("-----------------------\n");
				System.out.print("\nCHOICE : ");
				choice = sc1.nextInt();
				
				switch(choice)
				{
				case 1:
						obj.insert();
					break;
				case 2:
						obj.update();
					break;
				case 3:
						obj.delete();
					break;
				case 4:
						obj.display();
					break;
				}
			}while(choice <5);
			
			System.out.println("Program Exited");

	}

}