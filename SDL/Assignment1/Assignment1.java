package Assign1;

import java.io.*;
import java.util.*;


public class Assignment1{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int getRandomNumber(int min, int max) 
  {
		Random rand = new Random(); 
    int marks = rand.nextInt(max-min)+min+1;
    return marks;
	}
	
	static ArrayList <Student> list;
	static TreeMap <Integer, Student> studentmap;
	static PriorityQueue <Student> library_facility;
	static Stack <Student> recently_topped;
	
	Assignment1()
  {
		list = new <Student> ArrayList();
		studentmap = new <Integer, Student> TreeMap();
		library_facility = new <Student> PriorityQueue();
		recently_topped = new <Student> Stack();
	}
	
	//Adds recently topped to stack
	static void addToStack(Student temp) {
		if(recently_topped.empty()==false) {
			if( recently_topped.peek().marks < temp.marks )
				recently_topped.add(temp);
		}
		else
			recently_topped.add(temp);
	}
	
	//Displays list in order of admission
	static void displayList() {
		for(int i=0;i<list.size();i++) {
			list.get(i).display();
		}
	}

	//Displays list in order of roll no
	static void displayMap() {
        Set <Integer> keyset = studentmap.keySet();
        Iterator<Integer> itr = keyset.iterator();
        while(itr.hasNext()) {
            int key = itr.next();
            studentmap.get(key).display();
        }
	}

	//Displays on the basis of marks (Library Facility)
	static void displayPriorityQueue() {
		PriorityQueue <Student> temp = new <Student> PriorityQueue(library_facility);
		while(!temp.isEmpty()) {
			temp.poll().display();
		}
	}

	//Displays recently topped
	static void displayStack() {
		Stack <Student> temp = new <Student> Stack();
		temp.addAll(recently_topped);
		while(!temp.isEmpty()) {
			temp.pop().display();
		}
	}
	
	//Adds Student to all 4 DS
	public static void addToDataStructures(Student arg) {
		list.add(arg);
		studentmap.put(arg.roll_no, arg );
		library_facility.add(arg);
		addToStack(arg);
	}

	//Takes input and ten adds students to all 4 DS
	public static void addToDataStructures() throws IOException {
		Student <String>arg = new Student<String>();
		System.out.println("Enter the Roll No :: ");
		int r = Integer.parseInt(br.readLine());
		System.out.println("Enter the Name :: ");
		String n = br.readLine();
		System.out.println("Enter the Marks :: ");
		int m = Integer.parseInt(br.readLine());
		arg.initialise(r, n, m);
		list.add(arg);
		studentmap.put(arg.roll_no, arg );
		library_facility.add(arg);
		addToStack(arg);
	}

	//Fast Retrieval on the basis of Roll Number
	public static Student retrieveRecord(int roll_no) 
  {
		return studentmap.get(roll_no);
	}
	
	//Library Service Dequeue
	public static void dequePriorityQueue(int num) 
  {
		for(int i=1;i<=num;i++) 
    {
			if(!library_facility.isEmpty())
				library_facility.poll();
		}
	}
	
	public static void main(String args[]) throws IOException 
  {
		Assignment1 a1 = new Assignment1();
	}
}
