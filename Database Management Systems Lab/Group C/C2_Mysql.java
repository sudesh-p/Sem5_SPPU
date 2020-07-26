import java.sql.*; 
import java.util.*;
class JDBCDemo{
	public static void main(String args[]) throws Exception{
	Scanner sc = new Scanner(System.in);  
	int choice = 0; 
	while(choice < 4){
		System.out.println("DATABASE OPERATIONS");
		System.out.println("1.INSERT\n2.UPDATE\n3.DELETE\n4.DISPLAY");
		System.out.println("Enter your choice");
		choice = sc.nextInt();
		Connection con=null;
		Statement stmt=null;
       		 try {
			     Class.forName("com.mysql.jdbc.Driver"); 
			     con = DriverManager.getConnection("jdbc:mysql://localhost/DBMS", "root", "root"); 
			     stmt = con.createStatement();
     	    	switch(choice){
     	    		case 1:  System.out.println("Enter Roll No.");
	      			 int rno=sc.nextInt();						  					
	      			  System.out.println("Enter Name.");
	     			 String name=sc.next();
	     			 
           			 String q1 = "INSERT INTO Student VALUES('" +rno+ "', '" +name+"')"; 
            			 int x = stmt.executeUpdate(q1); 
            			 break;
     	    		
     	    		case 2: System.out.println("Enter Roll No to update Name.");
			        int up_rno = sc.nextInt();
			        System.out.println("Enter new Name of the Student.");
			        String new_name = sc.next();
			        String q2 = "UPDATE Student SET Name = '" +new_name+"' WHERE Roll_no = '" +up_rno"'"; 
			        int y = stmt.executeUpdate(q2);
			        if(y > 0)
				    	System.out.println("Successfully Updated.");
			        else
				    	System.out.println("Roll No "+ up_rno +" not found.");
		 	     	 break;
		 	     	 
			 case 3: System.out.println("Enter Roll No to delete.");
           			 int del_rno = sc.nextInt();
      				 String q3 = "DELETE FROM Student WHERE Rollno = '" +del_rno+"'"; 
           			 int z = stmt.executeUpdate(q3); 
           			 if(z > 0)
           		 	System.out.println("Roll No "+ del_rno +" Successfully DELETED.");
           			 else
            				System.out.println("Roll No "+ del_rno +" not found.");
				  break;
				   
			 case 4: String q4 = "SELECT * FROM STUDENT"; 
				 ResultSet rs = stmt.executeQuery(q4); 
			         while(rs.next()){
					System.out.println("Roll No : " + rs.getInt(1)); 
					System.out.println("Name : " + rs.getString(2)); 
				    } //end of while
        		} //end of switch
        	}//end of try
        
        catch(SQLException sqe)
		{
            System.out.println(sqe); 
        }
        
       finally{
          try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(con!=null)
            con.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally
        }
        } //end of while
    } 
} 
