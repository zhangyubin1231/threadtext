package threadtext;

public class Demo09 implements Runnable{
	public int flag = 1;
	//注意这个地方必须是静态的
	public static Object obj1 = new Object();
	public static Object obj2 = new Object();
	
	public static void main(String[] args) {
		Demo09 demo01 = new Demo09();
		demo01.flag=1;
		Demo09 demo02 = new Demo09();
		demo02.flag = 2;
		
		Thread th1 = new Thread(demo01);
		Thread th2 = new Thread(demo02);
		
		th1.start();
		th2.start();
	
	}
	
	@Override
	public void run() {
		if(flag == 1) {
			synchronized (obj1) {
				try {
					Thread.sleep(1000);//等待另一个线程去锁定obj2
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
				synchronized (obj2) {
					System.out.println(1);
				}
			}
		}else {
			synchronized (obj2) {
				try {
					Thread.sleep(1000);//等待另一个线程去锁定obj1
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
				synchronized (obj1) {
					System.out.println(2);
				}
			}
		}
		
	}

}
