package online_tusur.unit_online_tusur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class TestMain {
	String fName1 = "Ivan";
	String fName2 = "Piter";
	String fName3 = "Roman";
	String lName1 = "Sidorov";
	String lName2 = "Petrov";
	String lName3 = "Romanov";
	int age1 = 33;
	int age2 = 55;
	int age3 = 17;
	Student s1 = new Student();
	Student s2 = new Student();
	Student s3 = new Student();
	@Test
	void TestMain() {
		s1.setAge(age1);
		s2.setAge(age2);
		s3.setAge(age3);
		String expectedFullName = lName1+" "+fName1;
		Student[] students = {s1,s2,s3};
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		PrintStream old = System.out;
		System.setOut(new PrintStream(output));
		Main.main(new String[] {});
		assertEquals(expectedFullName+"\r\n"+"MAX="+Student.maxAge(students)+"\r\n", output.toString());
		System.setOut(old);
	}
}
