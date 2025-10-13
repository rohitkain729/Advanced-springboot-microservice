package com.app.java;

import java.util.Date;
import java.util.Timer;

public class SchedulingDemo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.out.println("SchedulingDemo.main()" + new Date());

		Timer timer = new Timer();
		// 2 sec , gap betw 2 succesive delay 3 sec
//		timer.schedule(new Task1(), 2000, 3000);
//		12-10-2022  :5:49:10
		
		timer.schedule(new Task1(), new Date(125, 9, 12, 17, 49, 10), 3000);  // point of time

		System.out.println("End  :: SchedulingDemo.main()" + new Date());

	}
}
 