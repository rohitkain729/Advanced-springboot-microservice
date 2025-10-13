package com.app.java;

import java.util.Date;
import java.util.TimerTask;

public class Task1 extends TimerTask {

	@Override
	public void run() {
		System.out.println("sales report on new data ::" + new Date());

	}

}
