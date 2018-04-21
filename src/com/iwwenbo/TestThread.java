package com.iwwenbo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread {
	public static void main(String[] args) throws InterruptedException
	{
		ExecutorService es = Executors.newFixedThreadPool(3);
		for(int i=0 ;i<10;i++)
		{
			CalThread cal = new CalThread();
			es.submit(cal);
		}
		//es.shutdown();
	}
	
}
