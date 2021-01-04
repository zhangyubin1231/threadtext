package threadtext;

public class Demo01 {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		
		System.out.println(Thread.activeCount());
		
		System.out.println("哈哈");
		new MyThreadDemo02().start();
		System.out.println(Thread.activeCount());
		System.out.println("呵呵");
		
	}

}

class MyThreadDemo02 extends Thread{
	
	public void run() {
		
			for(int i = 1 ; i<10 ; i++) {
				System.out.println("...");
				try {	
					Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
	}
}
