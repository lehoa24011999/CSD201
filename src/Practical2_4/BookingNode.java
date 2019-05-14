package Practical2_4;

import Practical1_4.Booking;

public class BookingNode {
	Booking info;
	BookingNode left,right;
	BookingNode(Booking x) {
		info=x;left=right=null;

	}
	BookingNode(Booking x, BookingNode lt, BookingNode rt){
		this.info = x; left = lt; right = rt;

	}
}
