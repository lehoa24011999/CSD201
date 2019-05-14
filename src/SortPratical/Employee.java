package SortPratical;

public class Employee implements Comparable<Employee>{
	private String id;
	private String name;
	private Short level;
	
	public Employee() {
		super();
	}
	public Employee(String id, String name, short level) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public short getLevel() {
		return level;
	}
	public void setLevel(short level) {
		this.level = level;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+"\t"+this.name+"\t"+this.level;
	}
	@Override
	public int compareTo(Employee o) {
		
		return this.id.compareToIgnoreCase(o.id);
	}
//	Sort the list in ascending and descending order by ID using different sort algorithms (insertion, selection, bubble).
	//ascending
	//1.insertion

	
	
}
