package com.iwwenbo;

public class CalThread implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this.getClass());
		try {
			Thread.sleep(10000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end");
		
	}
	
}