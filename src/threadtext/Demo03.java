package threadtext;

public class Demo03 {
	public static void main(String[] args) {
		Thread th1 = new Thread(new MyrunnableDemo01(), "线程一");
		th1.start();
		
		Thread th2 = new Thread(new MyrunnableDemo01(), "线程一");
		th2.start();
	}

}

class MyrunnableDemo01 implements Runnable {
	public void run() {
		for (int i = 1; i < 10; i++) {
			System.out.println(Thread.currentThread() + ":" + i);

			try {
				Thread.sleep(500);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}