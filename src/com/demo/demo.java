package com.demo;

import java.util.Date;

class MyThread implements Runnable {
	public void run() {
		for (int i = 0; i < 40; i++) {
			try {
				System.out
						.println(Thread.currentThread().getName() + "休眠0.5秒!");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out
					.println("当前运行的线程名称： " + Thread.currentThread().getName());
		}

	}
}

public class demo {
	public static void main(String[] args) {
		 System.out.println(new Date());
		MyThread mt1 = new MyThread();
		
		Thread th = new Thread(mt1, "线程A");
		System.out.println("\n Thread is starting");
		th.start();
		 System.out.println(new Date());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		 System.out.println(new Date());
		System.out.println("\n主线程已经休眠 " + Thread.currentThread().getName());
	}

}