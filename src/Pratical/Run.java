package Pratical;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;




/*
 * Nhập vào danh sách sinh viên

- Thêm một sinh viên mới

- Xoá một sinh viên khi biết số báo danh

- Sắp xếp danh sách theo thứ tự giảm dần điểm trung bình (dùng phương pháp phù hợp).

- In ra danh sách sinh viên theo từng lớp

- Lưu danh sách sinh viên vào file DSSV.txt*/

public class Run {


	private static Scanner input=new Scanner(System.in);
	private static LinkedList<Student> studentList=new LinkedList<Student>();
	private static String path="";
	public static void main(String[] args) {
		int choose=0;
		while(true) {
			System.out.println("============ Manage Student===============");
			System.out.println("1.	Load list");
			System.out.println("2.	Add student");
			System.out.println("3.	Deletion");
			System.out.println("4.	Sort");
			System.out.println("5.	Display list");
			System.out.println("6.	Save file");
			System.out.println("7.	Exit");
			System.out.println("==============================================");
			try {
				choose=Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				System.out.println("Please enter number @@!");
			}

			switch (choose) {
			case 1:
				loadFile();
				break;
			case 2:
				add();
				break;
			case 3:
				deletetion();
				break;
			case 4:
				sort();
				break;
			case 5:
				display();
				break;
			case 6:
				saveFile();
				break;
			case 7:
				System.exit(0);
			default:
				break;
			}

		}

	}
	//load file hop le trong va hien thi thong tin cua bang thong tin
	private static void loadFile() {
		while(true) {
			try {
				System.out.println("Enter file'path: (ex D:/Student.txt)");
				path=input.nextLine();
				if (!new File(path).exists()){
					throw new Exception();
				}
				studentList=SaveStudent.readfile(path);
				System.out.println("====================================================");
				System.out.println("--------------------- LIST STUDENT -----------------");
				System.out.println("             code|name|averageMark|Class            ");
				System.out.println("----------------------------------------------------");
				for(Student stu: studentList) {
					System.out.println(stu);
				}
				System.out.println("====================================================");
				break;
			} catch (Exception e) {
				System.out.println("Please check path carefully!");
			}

		}


	}
	//them student vao Studentlist
	private static void add() {
		Student s=new Student();
		validateCode(s);
		System.out.println("Enter name:");
		s.setName(input.nextLine());
		averageMark(s);
		System.out.println("Enter class's name:");
		s.setClassName(input.nextLine());
		//		studentList=SaveStudent.readfile(path);
		studentList.addFirst(s);
		for(Student stu: studentList) {
			System.out.println(stu);
		}


	}
	//check ma nhap vao da ton tai hay chua
	private static void validateCode(Student s) {
		while(true) {
			System.out.println("Enter code:");
			String code=input.nextLine();
			if(checkExist(code)) {
				continue;
			}else {
				s.setCode(code);
				break;
			}
		}

	}
	//check lieu ton tai ma chua neu co tra ve true khong tra ve false
	private static boolean checkExist(String code) {
		for(Student stu: studentList) {
			if(stu.getCode().contains(code)) {
				System.out.println("The code is existed!");
				return true;
			}
		}
		return false;
	}
	// nhap vao diem trung binh kieu double neu kieu string thi thong bao loi va nhap lai
	private static void averageMark(Student s) {
		double avg=0;
		while(true) {
			try {
				System.out.println("Enter the average mark:");
				avg=Double.parseDouble(input.nextLine());
				s.setAvgMark(avg);
				break;
			} catch (Exception e) {
				System.out.println("Please enter must be the number and that number greater than 0!");
			}
		}

	}
	//xoa student voi code nhap vao
	private static void deletetion() {
		System.out.println("Enter the code you want to delete:");
		String code=input.nextLine();

		for(int i=0; i<studentList.size(); i++) {
			if(studentList.get(i).getCode().contains(code)) {
				studentList.remove(i);
				i--;
			}
		}
		for(Student stu: studentList) {
			System.out.println(stu);
		}

	}
	//sort them
	private static void sort() {
		LinkedList<Student> listLocalStudent=SaveStudent.readfile(path);
		Collections.sort(listLocalStudent, new sortByMark().reversed());
		for(Student stu: listLocalStudent) {
			System.out.println(stu);
		}

	}
	private static void display() {
		System.out.println("====================================================");
		System.out.println("--------------------- LIST STUDENT -----------------");
		System.out.println("             code|name|averageMark|Class            ");
		System.out.println("----------------------------------------------------");
		for(Student stu: studentList) {
			System.out.println(stu);
		}
		System.out.println("====================================================");

	}
	private static void saveFile() {
		while(true) {
			try {
				System.out.println("Enter file's path:(ex D:/student.txt)");
				path=input.nextLine();	
				if (!new File(path).exists()){
					throw new Exception();
				}
				SaveStudent.savefile(studentList, path);
				System.out.println("Save file successfully!");
				break;
			} catch (Exception e) {
				System.out.println("Saved file failed");
				System.out.println("Please check file's path!");
			}
		}

	}
}
