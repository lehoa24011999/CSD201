package Practical2_4;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

import Practical1_4.Booking;
import Practical1_4.Bus;
import Practical1_4.Customer;



public class BusBookingSystem {

	private static Scanner input=new Scanner(System.in);
	private static BSTreeBus listBus=new BSTreeBus();
	private static BSTCustomer listCustomer=new BSTCustomer();
	private static BSTBooking listBooking=new BSTBooking();
	private static String path="Your have to save before execute that function!";
	private static int seat=0;
	private static double departTime=0;
	private static double arrivalTime=0;

	public static void main(String[] args) {


		int choose=0;
		while(true) {
			System.out.println("============ BUS BOOKING SYSTEM ===============");
			System.out.println("1.	Bus list");
			System.out.println("2.	Customer list");
			System.out.println("3.	Booking list ");
			System.out.println("4.	Exit");
			System.out.println("Enter 1 to entrance bus list, 2 to entrance customer list, "
					+ "3 to entrance booking list, 4 to exit");
			System.out.println("==============================================");
			try {
				choose=Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				System.out.println("Please enter number @@!");
			}

			switch (choose) {
			case 1:
				busList();
				break;
			case 2:
				customerList();
				break;
			case 3:
				bookingList();
				break;
			case 4:
				System.exit(0);
			default:
				break;
			}

		}
	}

	private static void bookingList() {

		int choose=0;
		while(true) {
			System.out.println("=============== BOOKING LIST ================");
			System.out.println("1 input data");
			System.out.println("2 display booking data");
			System.out.println("3 sort by bcode+ ccode");
			System.out.println("4 exit");
			System.out.println("==============================================");

			try {
				choose=Integer.parseInt(input.nextLine());
				if(choose==4) break;
			} catch (Exception e) {
				System.out.println("Please enter number @@!");
			}

			switch (choose) {
			case 1:
				inputBooking();
				break;
			case 2:
				displayBooking();
				break;
			case 3:
				sortBooking();
				break;
			default:
				break;
			}

		}

	}

	private static void displayBooking() {
		listBooking.breadth();

	}

	private static boolean checkBookingExist(String bcode, String ccode) {

		if(listBooking.search(ccode)==1 && listBooking.search(bcode)==1) {
			return true;
		}

		return false;
	}

	private static boolean checkCodeExist(String bcode) {

		if(listBus.search(bcode)==1) {
			return true;
		}

		return false;
	}

	private static boolean checkCustomerExist(String ccode) {

		if(listCustomer.search(ccode)==1) {
			return true;
		}

		return false;
	}

	private static int bookedBooking() {
		int seatBooking=0;
		while(true) {
			try {
				System.out.println("Enter the number of seat to be booked:");
				seatBooking=Integer.parseInt(input.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Please must be number or greater than 0 !");
			}
		}
		return seatBooking;
	}

	private static void sortBooking() {
		
		listBooking.inOrder(listBooking.root);

	}

	private static void inputBooking() {
		Booking book=new Booking();

		System.out.println("Enter bus's code:");
		String bcode=input.nextLine();
		System.out.println("Enter customer's code:");
		String ccode=input.nextLine();
		int seatInput=bookedBooking();

		if(!checkCodeExist(bcode) || !checkCustomerExist(ccode)) {
			System.out.println("Data is not accepted.");
		}
		if(checkBookingExist(bcode, ccode)) {
			System.out.println("Data is not accepted 1.");
		}

		if(checkCodeExist(bcode) && checkCustomerExist(ccode)) {
			if(limit(bcode,seatInput)) {
				book.setbCode(bcode);;
				book.setcCode(ccode);
				book.setSeat(seatInput);
				listBooking.insert(book);
			}

		}
		listBooking.preOrder(listBooking.root);

	}

	private static boolean limit(String bcode, int seatInput) {
		LinkedList<BusNode> listTemp= listBus.getListNode();
		for(BusNode bus: listTemp) {
			if(bus.info.getbCode().contains(bcode)) {
				int temp=bus.info.getSeat()-bus.info.getBooked();
				if(seatInput <= temp) {
					return true;
				}
			}
		}
		return false;
	}

	private static void countBus() {
		System.out.println("Total Bus: "+listBus.count());
	}

	private static void balanced() {
		listBus.balance();
		System.out.println("\n Pre-order traverse:");
		listBus.preOrder(listBus.root);
	}

	private static void delete() {
		System.out.println("Enter code want to delete");
		String code=input.nextLine();
		listBus.copyDele(code);
		System.out.println("Deleted!");

	}

	private static void search() {
		System.out.println("Enter code want to find:");
		String code=input.nextLine();
		if(listBus.search(code)==1) System.out.println("Found!");
		else System.out.println("Not Found!");

	}

	private static void inorderTraverseToFile() {
		SaveBusTree.savefile(listBus, path);
		System.out.println("Save file by inorderTraverse successful!");
	}

	private static void breathFirstTraverse() {
		listBus.breadth();
	}

	private static void inorderTraverse() {
		listBus.inOrder(listBus.root);
	}

	private static void add() {
		Bus b=new Bus();
		validateCode(b);
		System.out.println("Enter bus's name:");
		b.setBusName(input.nextLine());
		busSeat(b);
		bookedSeat(b);
		departTime(b);
		arrivalTime(b);
		listBus.insert(b);
		//		for(Bus bus: listBus) {
		//			System.out.println(bus);
		//		}
		listBus.breadth();
	}

	private static void arrivalTime(Bus b) {
		while(true) {
			try {
				System.out.println("Enter the arrival time:");
				arrivalTime=Double.parseDouble(input.nextLine());
				if(arrivalTime>0 && arrivalTime>departTime) {
					b.setArrivalTime(arrivalTime);
				}else throw new Exception();
				break;
			} catch (Exception e) {
				System.out.println("Please enter must be number!");
				System.out.println("): The arrival time of the bus (arrival_time > depart_time)");
			}
		}

	}

	private static void departTime(Bus b) {
		while(true) {
			try {
				System.out.println("Enter the depart time:");
				departTime=Double.parseDouble(input.nextLine());
				if(departTime>0) {
					b.setDepartTime(departTime);
				}else throw new Exception();
				break;
			} catch (Exception e) {
				System.out.println("Please enter must be the number and that number greater than 0!");
			}
		}

	}

	private static void bookedSeat(Bus b) {
		while(true) {
			try {
				System.out.println("Enter the booked seat:");

				int bookedSeat=Integer.parseInt(input.nextLine());
				if(bookedSeat>=0 && bookedSeat<=seat) {
					b.setSeat(bookedSeat);
				}else throw new Exception();
				break;
			} catch (Exception e) {
				System.out.println("Please enter must be number!");
				System.out.println("And the number of  booked seats in the bus (booked >= 0 and booked ≤ seat). ");
			}
		}

	}

	private static void busSeat(Bus b) {
		while(true) {
			try {
				System.out.println("Enter the number of seat:");
				seat=Integer.parseInt(input.nextLine());
				if(seat>0) {
					b.setSeat(seat);
				}else throw new Exception();
				break;
			} catch (Exception e) {
				System.out.println("Please must be number or greater than 0 !");
			}
		}

	}


	private static void validateCode(Bus b) {
		while(true) {
			System.out.println("Enter book's code:");
			String code=input.nextLine();
			if(checkExist(code)) {
				continue;
			}else {
				b.setbCode(code);
				break;
			}
		}

	}

	private static boolean checkExist(String code) {

		if(listBus.search(code)==1) {
			System.out.println("The code is existed!");
			return true;
		}
		return false;
	}

	private static void loadDataFromFile() {
		while(true) {
			try {
				System.out.println("Enter file'path: (ex D:/bus.txt)");
				path=input.nextLine();
				if (!new File(path).exists()){
					throw new Exception();
				}
				listBus=SaveBusTree.readfile(path);
				System.out.println("====================================================");
				System.out.println("--------------------- LIST BUS ---------------------");
				System.out.println("bcode|Bus_name|Seat|booked|depart_time|arrival_time ");
				System.out.println("----------------------------------------------------");
				//				for(Bus bus: listBus) {
				//					System.out.println(bus);
				//				}
				listBus.breadth();
				System.out.println("====================================================");
				break;
			} catch (Exception e) {
				System.out.println("Please check path carefully!");
			}

		}


	}



	private static void customerList() {
		int choose=0;
		while(true) {
			System.out.println("=============== CUSTOMER LIST ================");
			System.out.println("1	Load data from file");
			System.out.println("2 	Input & add to the end");
			System.out.println("3	Display data ");
			System.out.println("4	Save customer list to file");
			System.out.println("5	Search by bcode");
			System.out.println("6	Delete by bcode");
			System.out.println("7	Exit");
			System.out.println("==============================================");

			try {
				choose=Integer.parseInt(input.nextLine());
				if(choose==7) break;
			} catch (Exception e) {
				System.out.println("Please enter number @@!");
			}

			switch (choose) {
			case 1:
				loadCustomerFromFile();
				break;
			case 2:
				addCustomer();
				break;
			case 3:
				displayCustomer();
				break;
			case 4:
				saveCustomer();
				break;
			case 5:
				searchCustomer();
				break;
			case 6:
				deleteCustomer();
				break;
			default:
				break;
			}

		}

	}

	private static void deleteCustomer() {
		System.out.println("Enter code want to delete:");
		String code=input.nextLine();
		if(listCustomer.search(code)==1){
			listCustomer.copyDele(code);
		}else {
			System.out.println("Not Found!");
		}
		listCustomer.breadth();

	}

	private static void searchCustomer() {
		System.out.println("Enter code want to search:");
		String code=input.nextLine();
		if(listCustomer.search(code)==1){
			System.out.println("Found!");
		}else {
			System.out.println("Not Found!");
		}

	}

	private static void saveCustomer() {
		while(true) {
			try {
				System.out.println("Enter file's path:(ex D:/customer.txt)");
				path=input.nextLine();	
				if (!new File(path).exists()){
					throw new Exception();
				}
				Practical2_4.SaveCustomer.savefile(listCustomer, path);
				System.out.println("Save file successfully!");
				break;
			} catch (Exception e) {
				System.out.println("Saved file failed");
				System.out.println("Please check file's path!");
			}
		}

	}

	private static void displayCustomer() {

		System.out.println("====================================================");
		System.out.println("--------------------- LIST CUSTOMER ----------------");
		System.out.println("------------------- Code|Name|Phone -----------------");
		System.out.println("----------------------------------------------------");
		listCustomer.breadth();
		System.out.println("====================================================");


	}

	private static void addCustomer() {
		Customer c=new Customer();
		customerCode(c);
		System.out.println("Enter customer's name:");
		c.setCusName(input.nextLine());
		System.out.println("Enter bus's phone:");
		c.setPhone(input.nextLine());
		listCustomer=Practical2_4.SaveCustomer.readfile(path);
		listCustomer.insert(c);
		listCustomer.breadth();
	}

	private static void customerCode(Customer c) {
		while(true) {
			System.out.println("Enter book's code:");
			String code=input.nextLine();
			if(checkExistCus(code)) {
				continue;
			}else {
				c.setcCode(code);;
				break;
			}
		}

	}

	private static boolean checkExistCus(String code) {

		if(listCustomer.search(code)==1) {
			System.out.println("The code is existed!");
			return true;
		}

		return false;
	}

	private static void loadCustomerFromFile() {
		while(true) {
			try {
				System.out.println("Enter file'path: (ex D:/customer.txt)");
				path=input.nextLine();
				if (!new File(path).exists()){
					throw new Exception();
				}
				listCustomer=Practical2_4.SaveCustomer.readfile(path);
				System.out.println("====================================================");
				System.out.println("--------------------- LIST CUSTOMER ----------------");
				System.out.println("------------------- Code|name|year -----------------");
				System.out.println("----------------------------------------------------");
				//				for(Customer cus: listCustomer) {
				//					System.out.println(cus);
				//				}
				listCustomer.breadth();
				System.out.println("====================================================");
				break;
			} catch (Exception e) {
				System.out.println("Please check path carefully!");
			}

		}

	}

	private static void busList() {
		/*
		 * 1.1.      Load data from file
1.2.      Input & insert data
1.3.      In-order traverse
1.4.      Breadth-first traverse
1.5.      In-order traverse to file
1.6.      Search by pcode
1.7.      Delete by pcode by copying
1.8.      Simply balancing
1.9.      Count number of buses
		 */

		int choose=0;
		while(true) {
			System.out.println("============ BUS LIST===============");
			System.out.println("1	Load data from file");
			System.out.println("2   Input & insert data");
			System.out.println("3 	In-order traverse");
			System.out.println("4	Breadth-first traverse ");
			System.out.println("5	In-order traverse to file");
			System.out.println("6	Search by pcode");
			System.out.println("7	Delete by pcode by copying");
			System.out.println("8	Simply balancing");
			System.out.println("9	Count number of buses");
			System.out.println("10	Exit");
			System.out.println("==============================================");

			try {
				choose=Integer.parseInt(input.nextLine());
				if(choose==10) break;
			} catch (Exception e) {
				System.out.println("Please enter number @@!");
			}

			switch (choose) {
			case 1:
				loadDataFromFile();
				break;
			case 2:
				add();
				break;
			case 3:
				inorderTraverse();
				break;
			case 4:
				breathFirstTraverse();
				break;
			case 5:
				inorderTraverseToFile();
				break;
			case 6:
				search();
				break;
			case 7:
				delete();
				break;
			case 8:
				balanced();
				break;
			case 9:
				countBus();
				break;
			default:
				break;
			}

		}



	}
}
