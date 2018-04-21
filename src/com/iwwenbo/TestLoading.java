package com.iwwenbo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestLoading {

	private ExecutorService threadPool;
	private List<Callable<Boolean>> loadTasks;
	private List<Future<Boolean>> loadResults;
	private int numberOfTasks;
	 
	
	public static void main(String[] args) throws InterruptedException
	{
		TestLoading tt = new TestLoading();
		tt.load();
		while(true)
		{
			Thread.sleep(100);
			System.out.println(tt.getLoadPercent());
		}
	}
	public void load() {
	    threadPool = Executors.newFixedThreadPool(1);
	    loadTasks = new ArrayList<Callable<Boolean>>();
	    //
	    for(int i =0 ; i<10 ;i++)
	    {
		    loadTasks.add( new Callable<Boolean>() {
		        public Boolean call() throws Exception {
		        	Thread.sleep(1000l);
					return true;
		            //add one task
		        }
		    });
	    }

	    //add some other tasks
	     
	    loadResults = new ArrayList<Future<Boolean>>();
	    for( Callable<Boolean> task : loadTasks ) {
	        loadResults.add( threadPool.submit( task ) );
	    }
	    numberOfTasks = loadResults.size();  
	}
	 
	public float getLoadPercent() {
	    Iterator<Future<Boolean>> it = loadResults.iterator();
	    while (it.hasNext()) {
	        Future<Boolean> next = it.next();
	        if (next.isDone()) {
	            try {
	                if (next.get()) {
	                    it.remove();
	                }
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
	     
	    float percent = (numberOfTasks - loadResults.size()) / (float) numberOfTasks;
	    return percent * 100;
	}
}
