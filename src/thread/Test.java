package thread;

import java.util.Map;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) {
		
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		for (Entry<Thread, StackTraceElement[]> entry:map.entrySet()) {
			Thread thread = entry.getKey();
			if (thread.equals(Thread.currentThread())) {
				continue;
			}
			System.out.println("Ïß³Ì£º" + thread.getName());
			for (StackTraceElement ele : entry.getValue()) {
				System.out.println("element:" + ele);
			}
		}
	}
}
