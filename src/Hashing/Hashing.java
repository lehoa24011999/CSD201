package Hashing;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

class Student{
	private String name;
	private int age;
	private double mark;

	public Student() {
		super();
	}
	public Student(String name, int age, double mark) {
		super();
		this.name = name;
		this.age = age;
		this.mark = mark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
class Node
{
	Student info;
	Node next;
	Node() {}
	Node(Student x, Node p)
	{
		info=x;next=p;
	}
}
class MyList
{
	Node head,tail;
	MyList() {head=tail=null;}
	boolean isEmpty()
	{
		return(head==null);
	}
	void clear() {head=tail=null;}
	void add(Student x)
	{
		if(isEmpty())
			head=tail=new Node(x,null);
		else
		{
			Node q =new Node(x,null);
			tail.next=q;
			tail=q;
		}
	}
	void traverse()
	{
		if(isEmpty())
		{
			System.out.println(" The list is empty");
			return;
		}
		Node p=head;
		while(p!=null)
		{
			System.out.print(" " + p.info);
			p=p.next;
		}
		System.out.println();
	}
	Node search(String x)
	{
		Node p = head;
		while(p!=null)
		{
			if(p.info.getName().contains(x)) return(p);
			p=p.next;
		}
		return(null);
	}
	void dele(String x)
	{
		if(isEmpty())
		{
			System.out.println("\n The list is empty");
			return;
		}
		if(head.info.getName().contains(x))
		{
			head=head.next;
			if(head==null) tail=null;
			return;
		}
		Node f,p;f=null; p = head;
		while(p!=null && !p.info.getName().contains(x))
		{
			f=p;
			p=p.next;
		}
		if(p!=null)
		{
			f.next=p.next;
		}
		else
			System.out.println(x + " is not found in the list, no deletion");
	}
}

class HashTable
{
	MyList [] a;int M; 
	HashTable() 
	{
		M = 26;
		a = new MyList[M];
		for(int i=0;i<M;i++) a[i] = new MyList();
	}
	boolean checkDuplicated(String x) {
		for(int i=0;i<a.length;i++) {
			Node head = a[i].head;
			Node p=head;
			while(p!=null)
			{
				if(p.info.getName().contains(x)) return true;
				p=p.next;
			}
		}
		return false;
	}
	boolean isEmpty()
	{
		boolean empty = true;
		for(int i=0;i<M;i++)
			if(!a[i].isEmpty()) {empty=false;break;}
		return(empty);
	}
	void clear() 
	{
		for(int i=0;i<M;i++)
			a[i].head = a[i].tail = null;
	}
	void add(Student x)
	{
		char ch  = x.getName().charAt(0);
		int magic=0;
		int temp = (int)ch;
		int temp_integer = 65;
		int i=0;
		if(temp<=90 & temp>=66)
			magic=temp-temp_integer;
		i= magic%M;
		a[i].add(x);

	}


	void traverse()
	{
		if(isEmpty())
		{
			System.out.println("\n The Hash table is empty");
			return;
		}
		for(int i=0; i<M; i++)
		{
			System.out.print(" Linked list at " + i + ": ");
			a[i].traverse();
		}
		System.out.println();
	}
	Node search(String x)
	{
		char ch  = x.charAt(0);
		int magic=0;
		int temp = (int)ch;
		int temp_integer = 65;
		if(temp<=90 & temp>=66)
			magic=temp-temp_integer;

		int i = magic%M;
		return(a[i].search(x));
	}
	void dele(String x)
	{
		char ch  = x.charAt(0);
		int magic=0;
		int temp = (int)ch;
		int temp_integer = 65;
		if(temp<=90 & temp>=66)
			magic=temp-temp_integer;

		int i = magic%M;
		a[i].dele(x);
	}
	//		void addArray(int [] b)
	//		{
	//			int i,n;
	//			n = b.length;
	//			for(i=0;i<n;i++)
	//				add(b[i]);
	//		}
	//		void addRandom()
	//		{
	//			int i,n,x;
	//			Scanner s = new Scanner(System.in);
	//			System.out.print(" Enter n = ");
	//			n = s.nextInt();
	//			Random r = new Random();
	//			clear();
	//			for(i=0;i<n;i++)
	//			{
	//				x = r.nextInt(100); // Choose value from 0 to 99
	//				add(x);
	//			}
	//		}
}

public class Hashing {

	private static Scanner s;

	public static void main(String args[])
	{
		s = new Scanner(System.in);
		int choice; Node p;
		String x="";
		//		int [] b = {5,7,11,3,9,2,6,5,17,23,92,25};
		HashTable t = new HashTable();
		//		t.addArray(b);
		
		Student s1=new Student("Hoa", 20, 8.0);
		Student s2=new Student("Linh", 21, 9.0);
		Student s3=new Student("Duong", 21, 8.0);
		Student s4=new Student("Binh", 23, 8.0);
		Student s5=new Student("Ngoc", 25, 8.0);
		Student s6=new Student("Phuong", 25, 8.0);
		Student s7=new Student("Hung", 25, 8.0);
		t.add(s1);t.add(s1);t.add(s1);
		t.add(s7);
		t.add(s2);
		t.add(s3);
		t.add(s4);
		t.add(s5);

		t.traverse();
		p=t.search("Hung");
		if(p!=null)
			System.out.println(s6 + " is found in the list");
		else 
			System.out.println(s6 + " is not found in the list");

		//		
		//		 Set<String> s = new HashSet<String>();
		//	     String [] a = {"i", "came", "i", "came", "i", "conquered"};
		//	     for(int i=0; i<a.length;i++)
		//	      {
		//	       if(!s.add(a[i]))
		//	        System.out.println("Duplicate detected : " + a[i]);
		//	      }

		while(true)
		{
			System.out.println("=====================================");
			System.out.println("\n Choose your option:");
			System.out.println("  0. Add student a list");
			System.out.println("  1. Display a list");
			System.out.println("  2. Search");
			System.out.println("  3. Delete");
			System.out.println("  4. Exit \n");
			System.out.print("  Your selection (1 -> 4): ");
			System.out.println("=====================================");
			choice=Integer.parseInt(s.nextLine());

			switch(choice)
			{
			case 0: 
				Student student=new Student();
				System.out.println("Enter name : ");
				String name = s.nextLine();
				student.setName(name);
				System.out.println("Enter age : ");
				int age=Integer.parseInt(s.nextLine());
				student.setAge(age);
				System.out.println("Enter mark : ");
				double mark=Double.parseDouble(s.nextLine());
				student.setMark(mark);
				p = t.search(name);
				if(p!=null)
					System.out.println("Duplicated student!");
				else 
					t.add(student);
				break;
			case 1: 
				t.traverse();
				break;
			case 2: 
				System.out.print("\n Enter value to be searched: ");
				x = s.nextLine();
				p = t.search(x);
				if(p!=null)
					System.out.println(x + " is found in the list");
				else 
					System.out.println(x + " is not found in the list");
				break;
			case 3: 
				System.out.print("\n Enter value to be deleted: ");
				x =s.nextLine();
				t.dele(x);
				t.traverse();
				break;
			case 4: 
				System.out.println(" Good bye, have a nice day!");
				System.exit(0);
			default: 
				System.out.println("**Invalid choice. Try again.**");
			}
		}
	}
}



