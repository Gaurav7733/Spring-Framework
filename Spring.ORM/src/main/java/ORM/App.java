package ORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import CRUD.StudentDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
      StudentDao studentDao = context.getBean("Studentdao" , StudentDao.class);
      //Scanner sc = new Scanner(System.in);
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      
      boolean go = true;
      while (go) {
		System.out.println("Press 1. Enter Data ");
		System.out.println("Press 2.  Show Data ");
		System.out.println("Press 3.  Show All Data ");
		System.out.println("Press 4.  Update Data ");
		System.out.println("Press 5.  Delete Data ");
		System.out.println("Press 6.  For Exit  ");	
		System.out.println("Enter Key "
				+ "Here: ");
		try {
			
			int Input = Integer.parseInt(br.readLine());
			
			switch (Input) {
			case 1:
				//Enter Data 
				System.out.println(" ");
				System.out.print("Enter ID : ");
				int sId = Integer.parseInt(br.readLine());
				System.out.print("Enter Name : ");
				String UName = br.readLine();
				System.out.print("Enter City : ");
				String Ucity = br.readLine();
				
				Student s = new Student();
				s.setId(sId);
				s.setName(UName);
				s.setAge(Ucity);
				
				int r = studentDao.insert(s);
				System.out.println(r+" is Added ");
				System.out.println(" ");
				System.out.println();
				break;
			case 2:
				//Show the Single Data
				System.out.println("Enter Id : ");
				int userId = Integer.parseInt(br.readLine());
				Student student = studentDao.getStudent(userId);
				System.out.println("Id : "+student.getId());
				System.out.println("Name : "+student.getName());
				System.out.println("City : "+student.getAge());
				System.out.println("________________________");
				
				break;
			case 3:
				//Get All Data 
				System.out.println("_____________________________________");
				List<Student> students = studentDao.getAllStudents();
				for(Student st: students) {
					System.out.println("Id : "+st.getId());
					System.out.println("Name : "+st.getName());
					System.out.println("City : "+st.getAge());
					System.out.println("_______________________________________");
				}
				break;
			
			case 4:
				// Update Data
				System.out.println(" ");
				System.out.print("Enter ID : ");
				int stuId = Integer.parseInt(br.readLine());
				System.out.print("Enter Name : ");
				String stName = br.readLine();
				System.out.print("Enter City : ");
				String stcity = br.readLine();
				Student student2 = studentDao.getStudent(stuId);						
				student2.setName(stName);
				student2.setAge(stcity);
				studentDao.updateStudent(student2);
				System.out.println(stuId+" is update ");
				System.out.println(" ");
				System.out.println();
				
				
				
				break;
			case 5:
				// Delete Data
				System.out.println("Enter Id: ");
				int Uid = Integer.parseInt(br.readLine());
				studentDao.delteStudent(Uid);
				System.out.println(Uid+"  Data Deleted ");
				
				
				break;
			case 6:
				//Exit
				go = false;
				break;
			}
			
		} catch (Exception e) {
			System.out.println("Invalid Input !! ");
			System.out.println("Please Try Again !!");
			System.out.println(e.getMessage());
		}
      }
    }
}
