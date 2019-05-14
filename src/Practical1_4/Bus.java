package Practical1_4;

import java.util.Comparator;

class SortbyCode implements Comparator<Bus> {

	@Override
	public int compare(Bus o1, Bus o2) {
		// TODO Auto-generated method stub
		return o1.getbCode().compareTo(o2.getbCode());
	} 
  
} 

public class Bus{
	
/*
 * 	
	1.	bcode (string): the code of the bus (this should be unique for the bus).
	2.	bus_name (string): the name of the bus.
	3.	seat (integer): the number of  seats in the bus (seat > 0).
	4.	booked (integer): the number of  booked seats in the bus (booked >= 0 and booked ≤ seat). 
	5.	depart_time (double): The depature time of the bus (depart_time >= 0).
	6.	arrival_time (double): The arrival time of the bus (arrival_time > depart_time).*/
	
	private String bCode;
	private String busName;
	private int seat;
	private int booked;
	private double departTime;
	private double arrivalTime;
	
	public Bus() {
		super();
	}
	public Bus(String bCode, String busName, int seat, int booked, double departTime, double arrivalTime) {
		super();
		this.bCode = bCode;
		this.busName = busName;
		this.seat = seat;
		this.booked = booked;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
	}
	public String getbCode() {
		return bCode;
	}
	public void setbCode(String bCode) {
		this.bCode = bCode;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public int getBooked() {
		return booked;
	}
	public void setBooked(int booked) {
		this.booked = booked;
	}
	public double getDepartTime() {
		return departTime;
	}
	public void setDepartTime(double departTime) {
		this.departTime = departTime;
	}
	public double getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(double arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.bCode+"\t"+ this.busName+"\t"+ this.seat+"\t"+ 
					this.booked+"\t" + this.departTime+"\t" + this.arrivalTime;
		}


}
