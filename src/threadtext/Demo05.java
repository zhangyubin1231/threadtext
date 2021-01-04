package threadtext;

public class Demo05 {
	public static void main(String[] args) throws InterruptedException{
		Thread th1 = new Thread(new MyDemo06(),"a");
		Thread th2 = new Thread(new MyDemo06(),"b");
		
		th2.setPriority(1);
		th1.setPriority(10);
		
		th1.start();
		th2.start();
	}

}
 class MyDemo05 implements Runnable{
	@Override
	public void run() {
		if("a".equals(Thread.currentThread().getName())) {
			
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			
		}
		for(int i = 1 ; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+ ":"+i);
		}
	}
}