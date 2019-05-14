package Practical1_4;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;



public class BusBookingSystem {


	private static Scanner input=new Scanner(System.in);
	private static LinkedList<Bus>listBus=new LinkedList<Bus>();
	private static LinkedList<Customer>listCustomer=new LinkedList<Customer>();
	private static LinkedList<Booking>listBooking=new LinkedList<Booking>();
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
		/*
		 * 		Enter bus code:
			Enter customer code:
			Enter number of seats to be booked:
			After the user enter bcode and ccode, the program check and acts as follows:
			- If bcode not found in the Bus list or ccode not found in the customer list  then data is not accepted.
			- If  both bcode and ccode are found in the booking list  then  data is not accepted.
			- If bcode and ccode found in Buses and customers lists but booked = seat then inform the user that the bus is  exhausted. 
			- If bcode or ccode found and in the Bus list booked < seat and k is the entered seat then if  k <= seat - booked then data is accepted and  added to the end of the Booking list.
		 */


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

	private static void sortBooking() {
		Collections.sort(listBooking, new SortbyCodeBus());
		Collections.sort(listBooking, new SortbyCodeCustomer());
		for(Booking boo: listBooking) {
			System.out.println(boo);
		}

	}

	private static void displayBooking() {
		listBooking=SaveBooking.readfile("D:/booking.txt");
		for(Booking boo: listBooking) {
			System.out.println(boo);
		}

	}

	private static void inputBooking() {

		Booking book=new Booking();

		System.out.println("Enter bus's code:");
		String bcode=input.nextLine();
		System.out.println("Enter customer's code:");
		String ccode=input.nextLine();
		int seatInput=bookedBooking();

		if(!checkCodeExist(bcode, listBus) || !checkCustomerExist(ccode, listCustomer)) {
			System.out.println("Data is not accepted.");
		}
		if(checkBookingExist(bcode, ccode)) {
			System.out.println("Data is not accepted 1.");
		}
		if(checkCodeExist(bcode, listBus) && checkCustomerExist(ccode, listCustomer)) {
			for(Bus bus: listBus) {
				if(bus.getSeat()==seatInput) {
					System.out.println("The bus is  exhausted!");
				}
			}
		}
		if(checkCodeExist(bcode, listBus) && checkCustomerExist(ccode, listCustomer)) {
			if(limit(bcode, seatInput)) {
				book.setbCode(bcode);
				book.setcCode(ccode);
				book.setSeat(seatInput);
				listBooking.addLast(book);
			}
		}
		for(Booking boo: listBooking) {
			System.out.println(boo);
		}
	}
	private static boolean limit(String bcode, int seatInput) {
		for(Bus bus: listBus) {
			if(bus.getbCode().contains(bcode)) {
				int temp=bus.getSeat()-bus.getBooked();
				if(seatInput<=temp) {
					return true;
				}
			}
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

	private static boolean checkBookingExist(String bcode, String ccode) {
		if(listBooking.isEmpty()) {
			return false;
		}
		for(Booking boo: listBooking) {
			if(boo.getcCode().contains(bcode) && boo.getbCode().contains(bcode)) {
				return true;
			}
		}
		return false;
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
				addToTheEnd();
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
		System.out.println("Enter the code you want to delete:");
		String code=input.nextLine();

		for(int i=0; i<listCustomer.size(); i++) {
			if(listCustomer.get(i).getcCode().contains(code)) {
				listCustomer.remove(i);
				i--;
			}
		}
		for(Customer cus: listCustomer) {
			System.out.println(cus);
		}

	}

	private static void searchCustomer() {
		LinkedList<Customer> listLocalBus=SaveCustomer.readfile(path);
		System.out.println("Enter the code you want to find:");
		String code=input.nextLine();
		if(checkCustomerExist(code,listLocalBus)) {
			System.out.println("Found!");
		}else {
			System.out.println("Not Found!");
		}

	}

	private static boolean checkCustomerExist(String code, LinkedList<Customer> listLocalCus) {
		for(Customer cus: listLocalCus) {
			if(cus.getcCode().contains(code)) {
				return true;
			}
		}
		return false;
	}

	private static void saveCustomer() {
		while(true) {
			try {
				System.out.println("Enter file's path:(ex D:/customer.txt)");
				path=input.nextLine();	
				if (!new File(path).exists()){
					throw new Exception();
				}
				SaveCustomer.savefile(listCustomer, path);
				System.out.println("Save file successfully!");
				break;
			} catch (Exception e) {
				System.out.println("Saved file failed");
				System.out.println("Please check file's path!");
			}
		}

	}

	private static void displayCustomer() {

		listCustomer=SaveCustomer.readfile(path);
		System.out.println("====================================================");
		System.out.println("--------------------- LIST CUSTOMER ----------------");
		System.out.println("------------------- Code|Name|Phone -----------------");
		System.out.println("----------------------------------------------------");
		for(Customer cus: listCustomer) {
			System.out.println(cus);
		}
		System.out.println("====================================================");

	}

	private static void loadCustomerFromFile() {

		while(true) {
			try {
				System.out.println("Enter file'path: (ex D:/customer.txt)");
				path=input.nextLine();
				if (!new File(path).exists()){
					throw new Exception();
				}
				listCustomer=SaveCustomer.readfile(path);
				System.out.println("====================================================");
				System.out.println("--------------------- LIST CUSTOMER ----------------");
				System.out.println("------------------- Code|name|year -----------------");
				System.out.println("----------------------------------------------------");
				for(Customer cus: listCustomer) {
					System.out.println(cus);
				}
				System.out.println("====================================================");
				break;
			} catch (Exception e) {
				System.out.println("Please check path carefully!");
			}

		}

	}

	private static void addToTheEnd() {
		Customer c=new Customer();
		customerCode(c);
		System.out.println("Enter customer's name:");
		c.setCusName(input.nextLine());
		System.out.println("Enter bus's phone:");
		c.setPhone(input.nextLine());
		listCustomer=SaveCustomer.readfile(path);
		listCustomer.addLast(c);
		for(Customer cus: listCustomer) {
			System.out.println(cus);
		}


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
		for(Customer cus: listCustomer) {
			if(cus.getcCode().contains(code)) {
				System.out.println("The code is existed!");
				return true;
			}
		}
		return false;
	}


	private static void busList() {
		//		private static Scanner input=new Scanner(System.in);
		/*
		 * 1.1.      Load data from file
1.2.      Input & add to the head
1.3.      Display data
1.4.      Save bus list to file
1.5.      Search by bcode
1.6.      Delete by bcode
1.7.      Sort by bcode
1.8.      Add before position  k
1.9.      Delete the node before the node having bcode = xCode
		 */
		int choose=0;
		while(true) {
			System.out.println("============ BUS LIST===============");
			System.out.println("1	Load data from file");
			System.out.println("2 	Input & add to the head");
			System.out.println("3	Display data ");
			System.out.println("4	Save bus list to file");
			System.out.println("5	Search by bcode");
			System.out.println("6	Delete by bcode");
			System.out.println("7	Sort by bcode");
			System.out.println("8	Add before position  k");
			System.out.println("9	delete before position  k");
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
				addToTheHead();
				break;
			case 3:
				displayData();
				break;
			case 4:
				saveBus();
				break;
			case 5:
				searchBus();
				break;
			case 6:
				deleteBus();
				break;
			case 7:
				sortBus();
				break;
			case 8:
				addBeforePositionK();
				break;
			case 9:
				deleteBefore();
				break;
			default:
				break;
			}

		}


	}

	private static void deleteBefore() {
		int k=0;
		while(true) {
			try {
				System.out.println("Enter the k to delete:");
				k=Integer.parseInt(input.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Please enter number!");
			}
		}
		for(int i=0; i<listBus.size();i++) {
			if(k==i) {
				int index=i-1;
				listBus.remove(index);
			}
		}
		System.out.println("After insert:");
		for(Bus bus: listBus) {
			System.out.println(bus);
		}

	}

	private static void addBeforePositionK() {
		Bus b=new Bus();
		validateCode(b);
		busName(b);
		busSeat(b);
		bookedSeat(b);
		departTime(b);
		arrivalTime(b);
		int k=0;
		while(true) {
			try {
				System.out.println("Enter the k:");
				k=Integer.parseInt(input.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Please enter number!");
			}
		}
		for(int i=0; i<listBus.size();i++) {
			if(k==i) {
				int index=i-1;
				listBus.add(index, b);
			}
		}
		System.out.println("After insert:");
		for(Bus bus: listBus) {
			System.out.println(bus);
		}


	}

	private static void sortBus() {
		LinkedList<Bus> listLocalBus=SaveBus.readfile(path);
		Collections.sort(listLocalBus, new SortbyCode());
		for(Bus bus: listLocalBus) {
			System.out.println(bus);
		}

	}

	private static void deleteBus() {

		System.out.println("Enter the code you want to delete:");
		String code=input.nextLine();

		for(int i=0; i<listBus.size(); i++) {
			if(listBus.get(i).getbCode().contains(code)) {
				listBus.remove(i);
				i--;
			}
		}
		for(Bus bus: listBus) {
			System.out.println(bus);
		}

	}

	private static void searchBus() {
		/*
		 * Write the function:
Node search(String xCode) {}
which return reference to the node whose info contains the bus with bcode = xCode. 
Allow a user to input the bcode to be searched and display the result: found or not found.
		 */
		LinkedList<Bus> listLocalBus=SaveBus.readfile(path);
		System.out.println("Enter the code you want to find:");
		String code=input.nextLine();
		if(checkCodeExist(code,listLocalBus)) {
			System.out.println("Found!");
		}else {
			System.out.println("Not Found!");
		}
	}

	private static boolean checkCodeExist(String code, LinkedList<Bus> listLocalBus) {
		for(Bus bus: listLocalBus) {
			if(bus.getbCode().contains(code)) {
				return true;
			}
		}
		return false;
	}
	private static void saveBus() {
		while(true) {
			try {
				System.out.println("Enter file's path:(ex D:/bus.txt)");
				path=input.nextLine();	
				if (!new File(path).exists()){
					throw new Exception();
				}
				SaveBus.savefile(listBus, path);
				System.out.println("Save file successfully!");
				break;
			} catch (Exception e) {
				System.out.println("Saved file failed");
				System.out.println("Please check file's path!");
			}
		}
	}
	private static void displayData() {
		DecimalFormat df = new DecimalFormat("#.##");
		LinkedList<Bus> getListBus=SaveBus.readfile("D:/bus.txt");
		System.out.println("================================================================");
		System.out.println("--------------------- LIST BUS ---------------------------------");
		System.out.println("bcode|Bus_name|Seat|booked|depart_time|arrival_time|travel_time ");
		System.out.println("----------------------------------------------------------------");
		for(Bus bus: getListBus) {
			System.out.print(bus);
			String formatted = df.format((bus.getArrivalTime()-bus.getDepartTime())); 
			System.out.println("\t"+formatted);
		}
		System.out.println("====================================================");


	}

	private static void addToTheHead() {
		Bus b=new Bus();
		validateCode(b);
		busName(b);
		busSeat(b);
		bookedSeat(b);
		departTime(b);
		arrivalTime(b);
		listBus=SaveBus.readfile(path);
		listBus.addFirst(b);
		for(Bus bus: listBus) {
			System.out.println(bus);
		}


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

	private static void busName(Bus b) {
		while(true) {
			try {
				System.out.println("Enter bus's name:");
				b.setBusName(input.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Please enter must be number!");
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
		for(Bus bus: listBus) {
			if(bus.getbCode().contains(code)) {
				System.out.println("The code is existed!");
				return true;
			}
		}
		return false;
	}


	private static void loadDataFromFile() {
		//		LinkedList<Bus> getListBus = null;

		while(true) {
			try {
			
				System.out.println("Enter file'path: (ex D:/bus.txt)");
				path=input.nextLine();
				if (!new File(path).exists()){
					throw new Exception();
				}
				listBus=SaveBus.readfile(path);
				System.out.println("====================================================");
				System.out.println("--------------------- LIST BUS ---------------------");
				System.out.println("bcode|Bus_name|Seat|booked|depart_time|arrival_time ");
				System.out.println("----------------------------------------------------");
				for(Bus bus: listBus) {
					System.out.println(bus);
				}
				System.out.println("====================================================");
				break;
			} catch (Exception e) {
				System.out.println("Please check path carefully!");
			}

		}


	}


}
