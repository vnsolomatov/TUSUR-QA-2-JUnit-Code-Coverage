package online_tusur.unit_online_tusur;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class StudentTest {
	
	private Student s = new Student();	 	 /*объект тестового класса  Student*/  
	private Student[] sAr = {
			new Student("Alexandr", "Ivanov", 20), 
			new Student("Vladimir", "Petrov", 18),
			new Student("Aleksey", "Alekseev", 35)
			};
	    
	  @Test									
	  void testSetAgeAndGetAge() {
		int[] ages = {16,26,50};
		for (int i = 0; i < ages.length; i++) {
			s.setAge(ages[i]);
			int actualsAge=s.getAge();
	    assertEquals(ages[i] > 17 && ages[i] < 50 ? ages[i] : 18, actualsAge);	
		}
	  }
	  
	  @Test 												
	  void testFirstNames() {		  
		  String [] fN = {"i","Iv","iVa","IvAn"};
		  for (int i = 0; i < fN.length; i++) {
			  s.setFirstName(fN[i]);
			  char [] fNA = s.getFirstName().toCharArray();	
			  assertTrue(fNA[0] >= 'A' && fNA[0] <= 'Z');
			  if (fNA.length > 1) 
				  for (int j = 1; j < fNA.length; j++) {
					  assertTrue(fNA[j] >= 'a' && fNA[j] <= 'z');
				  }
		  }
	  }
	  
	  @Test 												
	  void testFirstName1() {		  
		  for (char ch = 'a'; ch <= 'z'; ch++) {
			    StringBuilder sb = new StringBuilder();
				s.setFirstName(sb.append(ch).toString());
				String fN = s.getFirstName();
				assertTrue(fN.charAt(0) >= 'A' && fN.charAt(0) <= 'Z' && fN.length() == 1);
		  }
	  }
	  
	  @Test 												
	  void testFirstName2() {		  
		  for (char ch = 'A'; ch <= 'Z'; ch++) {
			    StringBuilder sb = new StringBuilder("a");
				s.setFirstName(sb.append(ch).toString());
				String fN = s.getFirstName();
				assertTrue(fN.charAt(1) >= 'a' && fN.charAt(1) <= 'z' && fN.length() > 1);
		  }
	  }
	  
	  @Test 										//Character.toUpperCase(lastName.charAt(0))		
	  void testLastName1() {		  
		  for (char ch = 'a'; ch <= 'z'; ch++) {
			    StringBuilder sb = new StringBuilder();
				s.setLastName(sb.append(ch).toString());
				String lN = s.getLastName();
				assertTrue(Character.toUpperCase(lN.charAt(0)) >= 'A' && Character.toUpperCase(lN.charAt(0)) <= 'Z' && lN.length() == 1);
		  }
	  }
	  
	  @Test 												
	  void testLastName2() {		  
		  for (char ch = 'A'; ch <= 'Z'; ch++) {
			    StringBuilder sb = new StringBuilder("a");
				s.setLastName(sb.append(ch).toString());
				String lN = s.getLastName();
				assertTrue(lN.charAt(1) >= 'a' && lN.charAt(1) <= 'z' && lN.length() > 1);
		  }
	  }
	  
	  @Test									
	  void testGetFullName() {
	    assertTrue((s.getLastName()+" "+s.getFirstName()).equals(s.getFullName()));	
	  }
	  
	  @Test 												
	  void testAvgAge() { 
		  Student[] sA = sAr;
		  int sumAge = 0;
		  for (int i = 0; i < sA.length; i++) {
			  sumAge += sA[i].getAge();
		  }	
		  assertEquals(sumAge/sA.length, Student.avgAge(sA)); 		  
	  }
	  
	  @Test 												
	  void testMaxAge() { 
		  Student[] sA = sAr;
		  int maxAge = 0;
		  for (int i = 0; i < sA.length; i++) {
			  if (sA[i].getAge() > maxAge) maxAge = sA[i].getAge();
		  }	
		  assertEquals(maxAge, Student.maxAge(sA)); 		  
	  }
	  
	  @Test 												
	  void testMinAge() { 
		  Student[] sA = sAr;
		  int minAge = 100;
		  for (int i = 0; i < sA.length; i++) {
			  if (sA[i].getAge() < minAge) minAge = sA[i].getAge();
		  }	
		  assertEquals(minAge, Student.minAge(sA)); 		  
	  }
	  
}