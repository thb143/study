package concurrent;

public class HelloServiceImpl implements HelloService {

	@Override
	public void sayHello(long timeMillis){
		long time =	System.currentTimeMillis() - timeMillis;
		if (time >5000){
			System.err.println("time:"+ time);
		}
		try	{
//			System.out.println("业务执行");
			//模拟业务执行时间为1s
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		HelloService helloService = new HelloServiceImpl();
		
		CountDownLatchUtil countDownLatchUtil = new CountDownLatchUtil(5);
		countDownLatchUtil.latch( ()-> {
			helloService.sayHello(System.currentTimeMillis());
		} );
	}
}
