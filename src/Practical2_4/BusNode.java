package Practical2_4;

import Practical1_4.Bus;

public class BusNode {
	Bus info;
	BusNode left,right;
	BusNode(Bus x) {
		info=x;left=right=null;

	}
	BusNode(Bus x, BusNode lt, BusNode rt){
		this.info = x; left = lt; right = rt;

	}
}
