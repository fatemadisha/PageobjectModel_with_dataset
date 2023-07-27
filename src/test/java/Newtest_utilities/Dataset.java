package Newtest_utilities;

import org.testng.annotations.DataProvider;

public class Dataset {
	
	@DataProvider(name = "InvalidCredentials")
	public static Object invalidData() {
		Object [][] object = {{"admin2", "admin123"}, {"admin","admin12"}, {"admin34","admin67" }};
		
		return object;

}
}


//Use to run methods in a test suite
//<methods><include name ="loginTestwithInvalid"></include></methods>