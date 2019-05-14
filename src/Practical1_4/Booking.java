package Practical1_4;

import java.util.Comparator;

class SortbyCodeBus implements Comparator<Booking> {

	@Override
	public int compare(Booking o1, Booking o2) {
		// TODO Auto-generated method stub
		return o1.getbCode().compareTo(o2.getbCode());
	} 
  
} 
class SortbyCodeCustomer implements Comparator<Booking> {

	@Override
	public int compare(Booking o1, Booking o2) {
		// TODO Auto-generated method stub
		return o1.getcCode().compareTo(o2.getcCode());
	} 
  
} 
public class Booking {

	/*
	 * 1.	bcode (string): the code of the bus to be booked.
2.	ccode (string): the code of the customer.
3.	seat (integer): the number of  seats to be booked on the bus.
	 */
	
	private String bCode;
	private String cCode;
	private int seat;
	
	public Booking() {
		super();
	}
	public Booking(String bCode, String cCode, int seat) {
		super();
		this.bCode = bCode;
		this.cCode = cCode;
		this.seat = seat;
	}
	public String getbCode() {
		return bCode;
	}
	public void setbCode(String bCode) {
		this.bCode = bCode;
	}
	public String getcCode() {
		return cCode;
	}
	public void setcCode(String cCode) {
		this.cCode = cCode;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.bCode+"\t"+ this.cCode+"\t"+this.seat;
	}
	
	
	

}
