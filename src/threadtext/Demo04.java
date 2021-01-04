package threadtext;

public class Demo04 {
	public static void main(String[] args) throws InterruptedException {
		BoilThread boil = new BoilThread();
		WashThread wash = new WashThread();
		boil.start();
		wash.start();
		
		wash.join();
		boil.join();
		
		
		System.out.println("开始泡茶");
		
	}
	
	
	
}
class BoilThread extends Thread{
	public void run() {
		
		System.err.println("开始烧水");
		try {
		Thread.sleep(15000);
		
		
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		System.err.println("水烧好了");
}
}

class WashThread extends Thread {
	@Override
	public void run() {
		try {
		    for (int i = 1; i < 10; i++) {
			    System.out.println("开始洗第"+ i + "个杯子");
			    Thread.sleep(1000);
			    System.out.println("第"+ i + "个杯子洗干净了");
			    }
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
	 }
}
