package com.app.report;

import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("report")
public class ReportGenerator {

	/*@Scheduled(initialDelay = 2000,fixedDelay = 5000)
	public void generateReport() {
		System.out.println("sales report of ::" + new Date());
		
	}*/

	/*@Scheduled(fixedDelay = 3000)
	public void generateReport() {
		System.out.println("sales report of ::" + new Date());
	
	}*/

	/*@Scheduled
	public void generateReport() {
		
		System.out.println("sales report of ::" + new Date());
	
	}*/

	/*@Scheduled(initialDelay = 2000, fixedDelay = 3000)
	public void generateReport() {
	
		System.out.println("inital time ::" + new Date());
	
		try {
			Thread.sleep(4000);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		System.out.println("sales report  ::" + new Date());
	// total gap of 7sec  , initial gap of 2 sec
	
	}*/

	/*@Scheduled(fixedRate = 1000)
	public void generateReport() {
		System.out.println("inital time ::" + new Date());
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("sales report  ::" + new Date());
	}*/

	@Scheduled(initialDelay = 4000,fixedDelay  = 3000,fixedRate = 2000)
	public void generateReport() {
		System.out.println("inital time ::" + new Date());
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("sales report  ::" + new Date());
	}
}
