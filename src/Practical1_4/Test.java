package Practical1_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
	public static void main(String[] args) {
		//		List<String> myList = new ArrayList<String>();
		//
		//		myList.add("1");
		//		myList.add("2");
		//		myList.add("3");
		//		myList.add("4");
		//		myList.add("5");
		//
		//		Iterator<String> it = myList.iterator();
		//		while (it.hasNext()) {
		//			String value = it.next();
		//			System.out.println("List Value:" + value);
		//			if (value.equals("3")) {
		//				myList.remove(value);
		//				
		//			}
		//				
		//				
		//		}
		//
		//
		//
		//				Map<String, String> myMap = new HashMap<String, String>();
		//				myMap.put("1", "1");
		//				myMap.put("2", "2");
		//				myMap.put("3", "3");
		//		
		//				Iterator<String> it1 = myMap.keySet().iterator();
		//				while (it1.hasNext()) {
		//					String key = it1.next();
		//					System.out.println("Map Value:" + myMap.get(key));
		//					if (key.equals("2")) {
		//						myMap.put("1", "4");
		//						// myMap.put("4", "4");
		//					}
		//				}


		/*
		 * Avoid concurrent modification*/

		//method 1 for iterator
		List<String> myList2 = new CopyOnWriteArrayList<String>();
		myList2.add("1");
		myList2.add("2");
		myList2.add("3");
		myList2.add("4");
		myList2.add("5");
//
//		Iterator<String> it2 = myList2.iterator();
//		while (it2.hasNext()) {
//			String value = it2.next();
//			System.out.println("List Value:" + value);
//			if (value.equals("3")) {
//				myList2.remove("4");
//				myList2.add("6");
//				myList2.add("7");
//			}
//		}
//		System.out.println("List Size:" + myList2.size());

		Map<String, String> myMap2 = new ConcurrentHashMap<String, String>();
		myMap2.put("1", "1");
		myMap2.put("2", "2");
		myMap2.put("3", "3");

		Iterator<String> it3 = myMap2.keySet().iterator();
		while (it3.hasNext()) {
			String key = it3.next();
			System.out.println("Map Value:" + myMap2.get(key));
			if (key.equals("1")) {
				myMap2.remove("3");
				myMap2.put("4", "4");
				myMap2.put("5", "5");
			}
		}

		System.out.println("Map Size:" + myMap2.size());
		
		//method 2 for loop
		
		for(int i = 0; i<myList2.size(); i++){
			
			if(myList2.get(i).equals("3")){
				myList2.remove(i);
				i--;
			}
			System.out.println(myList2.get(i));
		}
	}

}
