package threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Service {
	
	ThreadPoolExecutor pool= null;
	
	public void init() {
		pool = new ThreadPoolExecutor(2, 
		    10, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3), 
		    new RejectHandler());
	}
	
	
	public class RejectHandler implements RejectedExecutionHandler{
		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			System.out.println("�����̳߳���������ܾ�����" + r.toString() );
		}
	}
	
	
	public static void main(String[] args) {
		Service service = new Service();
		service.init();
		for (int i = 0; i < 50;i++) {
			service.pool.execute(new Task(i));
		}
		
	
	}

}
