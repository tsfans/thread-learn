package cn.hl.threadlearn.demo2;

/**
 * 多线程模拟用户抢车位
 * @author HULIN
 */
public class ParkingTest {

	public static void main(String[] args) {
		ParkingSimulator ps = new ParkingSimulator();
		Thread t1,t2,t3,t4,t5,t6,t7,t8,t9;
		t1 = new CompeteThread(ps,"t1");
		t2 = new CompeteThread(ps,"t2");
		t3 = new CompeteThread(ps,"t3");
		t4 = new CompeteThread(ps,"t4");
		t5 = new CompeteThread(ps,"t5");
		t6 = new CompeteThread(ps,"t6");
		t7 = new CompeteThread(ps,"t7");
		t8 = new CompeteThread(ps,"t8");
		t9 = new CompeteThread(ps,"t9");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		System.out.println("线程"+Thread.currentThread().getName()+"运行结束!");
	}

}
