package com.app.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("report")
public class ReportGenerator {

	/*@Scheduled(cron = "15 * * * * *")  // every minute 15th sec
	public void generateReport1() { 
	
		System.out.println("sale report 1-------" + new Date() + "-------------");
	}*/
	
//	*  means every
	@Scheduled(cron = "* * * * * *")  // every minute 15th sec   8am :6 min : 30 sec  : every day :every month :every year :every weekend
	public void generateReport1() { 

		System.out.println("sale report 1-------" + new Date() + "-------------");
	}
	
	@Scheduled(cron = "30 6 8 * * *")  // every minute 15th sec   8am :6 min : 30 sec  : every day :every month :every year :every weekend
	public void generateReport2() { 

		System.out.println("sale report 2-------" + new Date() + "-------------");
	}
	
	

	@Scheduled(cron = "* 18 8 * * *")  // every minute 15th sec   8am :18 min : eevry sec  : every day :every month :every year :every weekend
	public void generateReport3() { 

		System.out.println("sale report 2-------" + new Date() + "-------------");
	}

}
