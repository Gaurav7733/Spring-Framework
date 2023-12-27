package CRUD;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import ORM.Student;
public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	@Transactional
	public int insert(Student student) {		
		// Insert
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
		
	}
	// Get Single Data 
	public Student getStudent(int StudentId) {
		Student student = this.hibernateTemplate.get(Student.class, StudentId);
		return student;
		
	}
	//Get All Data
	public List<Student> getAllStudents(){
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
		
	}
	// Delete
	@Transactional
	public void delteStudent(int StudentId) {
		Student student = this.hibernateTemplate.get(Student.class, StudentId);
						this.hibernateTemplate.delete(student);
	}
	//Update
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
		
	}
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
