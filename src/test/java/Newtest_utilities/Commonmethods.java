package Newtest_utilities;

import Newtest_driver.BaseDriver;

public class Commonmethods extends BaseDriver {
	
	public static void timeout() throws InterruptedException {
		Thread.sleep(0);
	}

	//method overloading
	public static void timeout(int time) throws InterruptedException {
		Thread.sleep(time);
	}

}
