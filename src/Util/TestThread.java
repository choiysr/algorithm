package Util;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestThread {


    public static void main(String[] args) throws Exception {

        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        for(int i = 0 ; i < 10; i++) {
            threadPool.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
        threadPool.shutdown();

        if (threadPool.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println(LocalTime.now() + " All jobs are terminated");
        } else {
            System.out.println(LocalTime.now() + " some jobs are not terminated");
            // 모든 Task를 강제 종료합니다.
            threadPool.shutdownNow();
        }

    }

}
