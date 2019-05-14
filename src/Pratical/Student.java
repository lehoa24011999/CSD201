package Pratical;

import java.util.Comparator;


// tao ra 1 lop sort ke thua tu comparator 
class sortByMark implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getAvgMark()>o2.getAvgMark()) return 1;
		else if(o1.getAvgMark()< o2.getAvgMark()) return -1;
		else return 0;
	}
	
}
public class Student {

	//Họ và tên, Số báo danh, điểm trung bình, tên lớp,
	private String code;
	private String name;
	private double avgMark;
	private String className;
	
	public Student() {
		super();
	}
	public Student(String code, String name, double avgMark, String className) {
		super();
		this.code = code;
		this.name = name;
		this.avgMark = avgMark;
		this.className = className;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAvgMark() {
		return avgMark;
	}
	public void setAvgMark(double avgMark) {
		this.avgMark = avgMark;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.code+"\t"+this.name+"\t"+this.avgMark+"\t"+this.className;
	}
	

}
