package threadpool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("start");
		int task = 5;
		//创建一个线程池
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		List<Future> futureList = new ArrayList<Future>();
		for (int i = 0;i < task;i++){
			Callable callable = new Test().new MyCallable(i);
			Future future = executorService.submit(callable);
			futureList.add(future);
		}
		
		executorService.shutdown();
		
		for (Future<Object> future : futureList){
			System.out.println(future.get().toString());
		}
		System.out.println("end");
	}
	
	/**
	 * 带返回结果的任务执行
	 * @author kevin
	 *
	 */
    private class MyCallable implements Callable<Object> {

		private int taskNum;
		public MyCallable(int taskNum) {
			this.taskNum = taskNum;
		}
		
		@Override
		public Object call() throws Exception {
			Date date1 = new Date();
			System.out.println(taskNum + " 任务启动");
			Thread.sleep(1000);
			Date date2 = new Date();
			System.out.println(taskNum + " 任务结束");
			String res = taskNum +"　任务执行时间：" + (date2.getTime()-date1.getTime());
			return res;
		}
		
	}

}
