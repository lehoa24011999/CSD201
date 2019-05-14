package Practical1_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;


public class SaveCustomer {
	
	public static boolean savefile(LinkedList<Customer>dskh, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for(Customer kh : dskh) {
				String line = kh.getcCode()+";"+kh.getCusName()+";"+ kh.getPhone();
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
	public static LinkedList<Customer> readfile (String path){
		LinkedList<Customer> dskh = new LinkedList<Customer>();
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();

			while(line!= null) {
				String arr[] = line.split(";");
//				int a=Integer.valueOf(arr[2]);
//				int b=Integer.valueOf(arr[3]);
//				double c=Double.valueOf(arr[4]);
//				double d=Double.valueOf(arr[5]);
				if(arr.length==3) {
					Customer kh = new Customer(arr[0], arr[1], arr[2]);
					dskh.add(kh);
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
