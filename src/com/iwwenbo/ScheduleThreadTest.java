package com.iwwenbo;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadTest {
	static boolean isRunning = false;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		ScheduledThreadPoolExecutor executor1 = new ScheduledThreadPoolExecutor(
				1);
		ScheduledThreadPoolExecutor executor2 = new ScheduledThreadPoolExecutor(
				1);
		executor1.scheduleAtFixedRate(new task1(), 20, 30, TimeUnit.MINUTES);
		System.out.println("main: 666666666");
		 Calendar c = Calendar.getInstance();
		 c.setTime(new Date());
		 int add = c.getTime().getMinutes()%5;
		 int inc = add==0? 0: 5-add;
		 System.out.println("main inc:" + inc);
		executor2.scheduleAtFixedRate(new task2(), inc, 5, TimeUnit.MINUTES);

	}

	static class task1 implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			isRunning = true;
			System.out.println("task1: 1213");
			 // 打印系统时间
			try {
				 System.out.println(new Date());
				 Thread.sleep(1000*60*12);
				 System.out.println("task1: 442222");
				 System.out.println(new Date());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("task1: 77777");
			isRunning = false;
		}
	}

	static class task2 implements Runnable{

		public void run() {
			System.out.println(new Date());
			System.out.println("task2: 999");
			if (!isRunning) {
				// TODO Auto-generated method stub
				System.out.println(new Date());
				System.out.println("task2: 444444");
			} else {
				return;
			}
		}
	}
}
