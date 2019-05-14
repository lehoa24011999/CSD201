package Practical1_4;

public class Customer {
	
//	1.	ccode (string): the code of the customer (this should be unique for the customer).
//	2.	cus_name (string): the name of the customer.
//	3.	phone (string): The phone number of the customer (must contain digits only).
	private String cCode;
	private String cusName;
	private String phone;
	
	public Customer() {
		super();
	}
	public Customer(String cCode, String cusName, String phone) {
		super();
		this.cCode = cCode;
		this.cusName = cusName;
		this.phone = phone;
	}
	public String getcCode() {
		return cCode;
	}
	public void setcCode(String cCode) {
		this.cCode = cCode;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.cCode+"\t"+ this.cusName+"\t"+this.phone;
		}
	
	


}
