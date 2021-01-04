package threadtext;

public class Demo06 {
	public static void main(String[] args) throws InterruptedException{
		Thread th1 = new Thread(new MyDemo06(),"a");
		Thread th2 = new Thread(new MyDemo06(),"b");
		
		th2.setPriority(1);
		th1.setPriority(10);
		
		th1.start();
		th2.start();
	}

}
class MyDemo06 implements Runnable{
	@Override
	public void run() {
		if("a".equals(Thread.currentThread().getName())) {
			Thread.yield();
		}
		for(int i = 1 ; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+ ":"+i);
		}
	}
}
