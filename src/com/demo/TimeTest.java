package com.demo;

import java.util.Calendar;
import java.util.Date;

public class TimeTest {
	public static void main(String[] args) {
		 Calendar c = Calendar.getInstance();
		 c.setTime(new Date()); 
		 int add = c.getTime().getMinutes()%5;
		 int inc = add==0? 0: 5-add;
		 c.add(Calendar.MINUTE, inc);
		 System.out.println(c.getTime());
	}
}
