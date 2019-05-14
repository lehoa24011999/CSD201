package hello;

import java.util.Stack;

import javax.sound.midi.Soundbank;

public class Test {
	public static void main(String[] args) {
		//E A S * Y * Q U E * * * S T * * * I O * N * * *
		Stack<String> s = new Stack<String>();
		 s.push("E");
		 s.push("A");
		 s.push("s");
		 s.pop();
		 s.push("Q");
		 s.push("U");
		 s.push("E");
		 s.pop();
		 s.pop();
		 s.pop();
		 s.push("S");
		 s.push("T");
		 s.pop();
		 s.pop();
		 s.pop();
		 s.push("I");
		 s.push("O");
		 s.pop();
		 s.pop();
		 int i=0;
		 for(String hello: s) {
			 System.out.println(hello);
			 i++;
		 }
		 
	}

}
