package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
	private static AtomicInteger race = new AtomicInteger(0);
	
	public static void increase() {
		race.incrementAndGet();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread [] threads = new Thread[20];
		
		for (int i=0;i<20;i++) {
			threads[i] = new Thread(new Runnable() {
				
				public void run() {
					for (int a=0;a<1000;a++) {
						increase();
					}
				}
			});
			threads[i].start();
			threads[i].join();
		}
		
//		while (Thread.activeCount() > 1) {
//			Thread.yield();
//		}
		
		System.err.println(race);
		
		System.out.println(0%8);
		System.out.println(7%8);
		
		System.out.println(0%16);
		System.out.println(7%16);
	}
}
