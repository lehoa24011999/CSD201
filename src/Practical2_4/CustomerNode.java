package Practical2_4;

import Practical1_4.Customer;

public class CustomerNode {
	Customer info;
	CustomerNode left,right;
	CustomerNode(Customer x) {
		info=x;left=right=null;

	}
	CustomerNode(Customer x, CustomerNode lt, CustomerNode rt){
		this.info = x; left = lt; right = rt;

	}
}
