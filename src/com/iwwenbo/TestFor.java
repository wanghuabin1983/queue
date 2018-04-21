package com.iwwenbo;


public class TestFor {
    public static int num = 10;
	public static void main(String[] args) throws InterruptedException {
		try {
			
			System.out.println(Thread.currentThread());
			// FutureTest();
			new Thread(new ModifyVarThread()).start();
			for(int i = 0;i<num;i++)
			{
				System.out.println(num);
				Thread.sleep(3000);
				
			
				System.out.println("num :" + num);

				System.out.println("i :" + i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static class ModifyVarThread implements Runnable
	{

		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread());
				Thread.sleep(3000);
				num =23;
				Thread.sleep(12000);
				System.out.println("slepp 12000");
				System.out.println("num before" + num);
				num = 2;
				System.out.println("num after" + num);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			TestFor.num = 22;
		}
		
	}
}
