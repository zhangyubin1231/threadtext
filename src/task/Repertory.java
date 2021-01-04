package task;

import java.util.LinkedList;

public class Repertory {
	public LinkedList<product> store = new LinkedList<product>();

	public LinkedList<product> getStore() {
		return store;
	}

	public void setStore(LinkedList<product> store) {
		this.store = store;
	}

	public synchronized void push(product p, String threadName) {

		while (store.size() == 10) {
			try {
				// 打印日志
				System.out.println(threadName + "报告:仓库已满--->进入等待状态--->消费");
				// 因为仓库容量已满，无法继续生产，进入等待状态，等待其他线程唤醒.
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 唤醒所有等待线程
		this.notifyAll();
		// 将产品添加到仓库中.
		store.addLast(p);
		// 打印生产日志
		System.out.println(threadName + "生产了:" + p.id + "号产品" + " " + "当前库存来:" + store.size());
		try {
			// 为了方便观察结果,每次生产完后等待0.1秒.
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/*
	 * 消费者方法 pop()方法用于存放产品. 参数含义:线程名称，用来显示是谁生产的产品. 使用synchronized关键字修饰方法的目的：
	 * 最多只能有一个线程同时访问该方法. 主要是为了防止多个线程访问该方法的时候，将参数数据进行的覆盖，从而发生出错.
	 */
	public synchronized void pop(String threadName) {
		/*
		 * 当仓库没有存货时,消费者需要进行等待.等待其他线程来唤醒 唤醒后继续循环，等到仓库的存量大于0时，跳出循环继续向下执行准备消费产品.
		 */
		while (store.size() == 0) {
			try {
				// 打印日志
				System.out.println(threadName + "下命令:仓库已空--->进入等待状态--->生产");
				// 因为仓库容量已空，无法继续消费，进入等待状态，等待其他线程唤醒.
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 唤醒所有等待线程
		this.notifyAll();
		// store.removeFirst()方法将产品从仓库中移出.
		// 打印日志
		System.out.println(threadName + "消费了:" + store.removeFirst().id + "号产品" + " " + "当前库存来:" + store.size());
		try {
			// 为了方便观察结果,每次生产完后等待1秒.
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


