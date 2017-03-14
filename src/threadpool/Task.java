package threadpool;

public class Task implements Runnable {
	int i ;
	public Task(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread() + "["+i+"]" +" is running");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + i;
	}

}
