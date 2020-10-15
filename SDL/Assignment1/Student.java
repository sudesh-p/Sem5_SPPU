package com.company;
class Student
{
	String name;
	int rolno;
	String div;
	double marks;
	Student(String name, int rolno, String div,double marks)
	{
		this.name= name;
		this.rolno= rolno;
		this.div=div;
		this.marks=marks;
		
	}
	public void display()
	{
		System.out.println("Name: "+name);
		System.out.println("Rollno: "+rolno);
		System.out.println("Division: "+div);
		
		System.out.println("Marks: "+marks);
		
		
		
	}
	public void modify(String name, String div, double marks)
	{
		this.name= name;
		
		this.div=div;
		this.marks=marks;
	}
	
	}
