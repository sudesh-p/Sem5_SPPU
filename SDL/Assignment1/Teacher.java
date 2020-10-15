package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

class Teacher
{
	public static void main(String args[])
	{
		ArrayList<Student> obj= new ArrayList<Student>();
		Teacher t= new Teacher();
		Iterator it= obj.iterator();
		Scanner s= new Scanner(System.in);
		int c;
		String ch;
		do
		{
		System.out.println("Enter Your choice\n1:Add\n2:Delete\n3:show\n4.Search\n5.modify");
		c=s.nextInt();
		switch(c)
		{
			case 1:
				obj.add(t.add());
				break;
			case 2:
				it=obj.iterator();
				int rno2;
				System.out.println("Enter roll no of student to be removed");
				rno2=s.nextInt();
				Object el2 = null;
				while(it.hasNext())
				{
					el2=it.next();
					if(((Student)el2).rolno==rno2)
						it.remove();
			
				}
				if(el2==null)
				{
					System.out.println("Student not found");
				}
				break;
			case 3:
				
				it=obj.iterator();
				while(it.hasNext())
				{
					
					((Student) it.next()).display();
			
				}
								//obj.get().display();
				
				
				break;
			case 4:
				
				it=obj.iterator();
				int rno;
				System.out.println("Enter roll no of student to be searched");
				rno=s.nextInt();
				Object el = null;
				while(it.hasNext())
				{
					el=it.next();
					if(((Student)el).rolno==rno)
						((Student)el).display();
			
				}
				if(el==null)
				{
					System.out.println("Student not found");
				}
				break;
				
			case 5:
				
				it=obj.iterator();
				int rno3;
				System.out.println("Enter roll no of student to be modified");
				rno3=s.nextInt();
				Object el3 = null;
				while(it.hasNext())
				{
					el3=it.next();
					if(((Student)el3).rolno==rno3)
						{//
						String name,div;
						double marks;
						System.out.println("Enter name of student");
						name=s.next();
						
						System.out.println("Enter Division of student");
						div=s.next();
						System.out.println("Enter marks of student");
						marks=s.nextDouble();
						((Student)el3).modify(name,div,marks);
						}
				}
				if(el3==null)
				{
					System.out.println("Student not found");
				}
				break;
				
		}
		System.out.println("Do you want to continue?(Y-yes N-no)");
		ch=s.next();
		}while(ch.equals("y")||ch.equals("Y"));
		//obj.get(0).display();
		
	}
	Student add()
	{
		String name;
		int rno;
		String div;
		double marks;
		
		Scanner s= new Scanner(System.in);
		System.out.println("Enter name of student");
		name=s.next();
		System.out.println("Enter roll no of student");
		rno=s.nextInt();
		System.out.println("Enter Division of student");
		div=s.next();
		System.out.println("Enter marks of student");
		marks=s.nextDouble();
		return new Student(name,rno,div,marks);
	}
	
}