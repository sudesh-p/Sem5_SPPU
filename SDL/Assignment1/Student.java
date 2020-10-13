package Assign1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Student<T> implements Comparable<Student>{

	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int roll_no;
	T name;
	int marks;

	Student(){
		this.roll_no = -1;
		this.marks = -1;
	}
		
	Student(int roll_no, T name, int marks){
		this.initialise(roll_no,name,marks);
	}
	
	public void initialise(int roll_no, T name, int marks) {
		this.roll_no = roll_no;
		this.name = name;
		this.marks = marks;
	}

	public void display() {
		System.out.print("\n"+Integer.toString(this.roll_no)+"\t\t"+this.name+"\t\t\t"+Integer.toString(this.marks));
	}
	
	@Override
	public int compareTo(Student o) {
		if(this.marks < o.marks)
			return 1;
		else if(this.marks > o.marks)
			return -1;
		return 0;
	}


}