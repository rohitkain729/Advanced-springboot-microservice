package com.app.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("report")
public class ReportGenerator {

//	@Scheduled(cron = "0/20 * * * * *")
//	public void generateReport() {
//		System.out.println("---report---" + new Date());
//	}

	// 3pm task start and keep on repeat after that
//	@Scheduled(cron = "10 0/1 15 * * *")   //at 3pm after every 1 mint 10th sec task 
//	//execute at every day every year every month every weekend
//	public void generateReport() {
//		System.out.println("---report---" + new Date());
//	}
	
//	@Scheduled(cron = "10 33/1 15 * * *")   //at 3pm at  33th min  after 1m gap task keep on repeat at the  10th sec task 
//	//execute at every day every year every month every weekend
//	public void generateReport() {
//		System.out.println("---report---" + new Date());
//	}
	
	@Scheduled(cron = "0/12 1/2 16 * * *")   //at 4pm at  1st min  continue at 0 sec  
	//,12 sec gap till 4.2 hr comes and stops then continue the task at 2min gap
	// 4.3hr start at 0 sec ,12 sec 24 sec.... continueas it is.

	public void generateReport() {
		System.out.println("---report---" + new Date());
	}

}
