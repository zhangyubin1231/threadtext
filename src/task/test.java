package task;

public class test {
	public static void main(String[] args) {
	    //定义一个仓库,消费者和生产者都使用这一个仓库
	    Repertory repertory=new Repertory();
	    //定义三个生产者(p1,p2,p3)
	    Producer p1=new Producer(repertory);
	    Producer p2=new Producer(repertory);
	    Producer p3=new Producer(repertory);
	    //定义两个消费者(c1,c2)
	    consumer c1=new consumer(repertory);
	    consumer c2=new consumer(repertory);
	    //定义5个线程(t1,t2,t3,t4,t5)
	    Thread t1=new Thread(p1,"甲");
	    Thread t2=new Thread(p2,"已");
	    Thread t3=new Thread(p3,"丙");
	    Thread t4=new Thread(c1,"丁");
	    Thread t5=new Thread(c2,"戊");
	    
	    t2.setPriority(10);
	    t3.setPriority(10);
	    //启动线程
	    t1.start();
	    t2.start();
	    t3.start();
	    t4.start();
	    t5.start();
	    
	  }
	
}
