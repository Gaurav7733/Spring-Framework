package ORM;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Student_Hibernet")
public class Student {
	@javax.persistence.Id
	private int Id;
	private String Name;
	private String Age;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public Student(int id, String name, String age) {
		super();
		Id = id;
		Name = name;
		Age = age;
	}	
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", Name=" + Name + ", Age=" + Age + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
}
