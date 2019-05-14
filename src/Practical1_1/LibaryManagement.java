package Practical1_1;


import java.util.Scanner;



public class LibaryManagement {


	private static Scanner input=new Scanner(System.in);
	//		private static Hashtable<String, ArrayList<Fruits>> customerTable=new Hashtable<String, ArrayList<Fruits>>();;
	//		private static ArrayList<Fruits> listFruits=new ArrayList<Fruits>();
	//		private static ArrayList<Fruits> listFruitsOfCustomer;


	public static void main(String[] args) {


		int choose=0;
		while(true) {
			System.out.println("============ FRUIT SHOP SYSTEM ===============");
			System.out.println("1.	Create Fruit");
			System.out.println("2.	View orders");
			System.out.println("3.	Shopping (for buyer) ");
			System.out.println("4.	Exit");
			System.out.println("Enter 1 to add fruits, 2 view orders, "
					+ "3 for shopping, 4 to exit");
			System.out.println("==============================================");
			try {
				choose=Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				System.out.println("Please enter number @@!");
			}

			switch (choose) {
			case 1:
				addFruits();
				break;
			case 2:
				viewOrder();
				break;
			case 3:
				forBuyer();
				break;
			case 4:
				System.exit(0);

			default:
				break;
			}

		}


	}


	private static void forBuyer() {
		// TODO Auto-generated method stub
		
	}


	private static void viewOrder() {
		// TODO Auto-generated method stub
		
	}


	private static void addFruits() {
		// TODO Auto-generated method stub
		
	}

}
