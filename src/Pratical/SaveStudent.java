package Pratical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class SaveStudent {

	public static boolean savefile(LinkedList<Student>dskh, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for(Student kh : dskh) {
				String line = kh.getCode()+";"+kh.getName()+";"+ kh.getAvgMark()+";"
						+ kh.getClassName();
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
	public static LinkedList<Student> readfile (String path){
		LinkedList<Student> dskh = new LinkedList<Student>();
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();

			while(line!= null) {
				String arr[] = line.split(";");
				double c=Double.valueOf(arr[2]);
				if(arr.length==4) {
					Student kh = new Student(arr[0], arr[1], c, arr[3]);
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
