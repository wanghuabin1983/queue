package com.iwwenbo;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class ScheduleThreadDemo {
    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(
                2);
        ScheduledFuture future1 = executor.schedule(new Task1(), 5,
                TimeUnit.SECONDS);
        ScheduledFuture future2 = executor.schedule(new LongTask(), 3,
                TimeUnit.SECONDS);

        BlockingQueue<ScheduledFuture> blockingQueue = new ArrayBlockingQueue<ScheduledFuture>(
                2, true);
        // ��BlockingQueue�д�Ŷ�������������ɣ�����true�������׳��쳣
        blockingQueue.add(future2);
        blockingQueue.add(future1);

        System.out.println(new Date());
        // ���BlockingQueue��Ϊ��
        while (!blockingQueue.isEmpty()) {
            // ȡ��BlockingQueue��������λ�Ķ���ȡ��������null
            ScheduledFuture future = blockingQueue.poll();
            // ���û��ִ��
            if (!future.isDone()) {
//            	System.out.println("blockingQueue.size() :" + blockingQueue.size());
                // �������ٴμ������
                blockingQueue.add(future);
//                System.out.println("blockingQueue.size2() :" + blockingQueue.size());
            } else {
                // ����ִ���ˣ�����ִ�н��
                System.out.println(future.get());
            }
        }
        System.out.println(new Date());
        //executor.shutdown();
    }
}