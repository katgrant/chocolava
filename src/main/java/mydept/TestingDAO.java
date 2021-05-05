package mydept;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dept.Department;
import dept.DepartmentDAOImpl;



public class TestingDAO {
DepartmentDAOImpl daoObj = new DepartmentDAOImpl();
Department dept =new Department();
@Test
public void createTest() {
	
	dept.setDepartmentNumber(5);
	dept.setDepartmentName("yoga");
	dept.setDepartmentLocation("paris");
	try {
		daoObj.addDepartment(dept);
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		
	}
	dept=daoObj.findDepartment(55);
	assertEquals("CODING",dept.getDepartmentName());
	assertEquals("New Delhi",dept.getDepartmentLocation());
	assertEquals(55,dept.getDepartmentNumber());
}@Test
public void findTest() {
	dept=daoObj.findDepartment(55);
	assertEquals("CODING",dept.getDepartmentName());
	assertEquals("New Delhi",dept.getDepartmentLocation());
	assertEquals(55,dept.getDepartmentNumber());	
}
}