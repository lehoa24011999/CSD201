package Practical2_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import Practical1_4.Customer;

public class SaveCustomer {

	public static boolean savefile(BSTCustomer dskh, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			LinkedList<CustomerNode> listLine= dskh.getListNode();


			for(CustomerNode kh : listLine) {
				String line = kh.info.getcCode()+";"+kh.info.getCusName()+";"+ kh.info.getPhone();
				bw.write(line);
				bw.newLine();
			}

			bw.close();
			osw.close();
			fos.close();
			return true;

		} catch (Exception e) {
			System.out.println("Please must be checked file's path again! ");
		}
		return false;		
	}

	public static BSTCustomer readfile (String path){
		//		LinkedList<Bus> dskh = new LinkedList<Bus>();
		BSTCustomer dskh=new BSTCustomer();
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();

			while(line!= null) {
				String arr[] = line.split(";");
				if(arr.length==3) {
					Customer kh = new Customer(arr[0], arr[1],arr[2]);
					dskh.insert(kh);
				}

				line = br.readLine();
			}
			
			br.close();
			isr.close();
			fis.close();
		} catch (Exception e) {
			System.out.println("Please must be checked file's path again or you must "
					+ "be save file before execute that function! ");
		}
		return dskh;

	}


}
