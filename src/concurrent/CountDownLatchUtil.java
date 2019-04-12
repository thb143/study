package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchUtil {
	private CountDownLatch start;
	private CountDownLatch end;
	private int poolSize = 10;

	public CountDownLatchUtil() {
		this(10);
	}

	public CountDownLatchUtil(int poolSize) {
		this.poolSize = poolSize;
		start = new CountDownLatch(1);
		end = new CountDownLatch(poolSize);
	}

	public void latch(MyFunctionalInterface mf) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
		for (int i=0;i<poolSize;i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("start await");
						start.await();
						System.out.println("mf run");
						mf.run();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						System.out.println("end countDown");
						end.countDown();
					}
				}
			};
			System.out.println("runnable submit");
			executorService.submit(runnable);
		}
		
		System.out.println("start countDown");
		start.countDown();
		System.out.println("end await");
		end.await();
		executorService.shutdown();
	}

	@FunctionalInterface
	public interface MyFunctionalInterface{
		void run();
	}
}
