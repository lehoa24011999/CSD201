package Hashing;

import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		//		String str = "ABCDEF";
		//		String test= String.valueOf(str.charAt(0));
		//		char[] ch  = test.toCharArray();
		//		for(char c : ch)
		//		{
		//			int temp = (int)c;
		////			int temp_integer = 96; //for lower case
		//			int temp_integer = 65;
		//			if(temp<=90 & temp>=66)
		//				System.out.print(temp-temp_integer);
		//		}
		
		
//		String str = "ABCDEF";
//
//		char ch  = str.charAt(0);
//		int temp = (int)ch;
//		int temp_integer = 65;
//		if(temp<=90 & temp>=66)
//			System.out.print(temp-temp_integer);
		
		 Set<String> s = new HashSet<String>();
	     String [] a = {"i", "came", "i", "came", "i", "conquered"};
	     for(int i=0; i<a.length;i++)
	      {
	       if(!s.add(a[i]))
	        System.out.println("Duplicate detected : " + a[i]);
	      }

	     System.out.println(s.size() + " distinct words detected : " + s );

	}
}
