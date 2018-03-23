package cn.hl.threadlearn.demo2;

/**
 * @author HULIN
 */
public class CompeteThread extends Thread{

	private ParkingSimulator ps;
	
	public CompeteThread(ParkingSimulator ps,String name) {
		super(name);
		this.ps = ps;
	}
	
	@Override
	public void run() {
		System.out.println("线程"+getName()+"开始运行!");
		CarOwner owner = new CarOwner(getName());
		ps.setOwner(owner);
		int k = 1;
		for(int i=0;i<100;i++) {
			ps.parking();
			if(k%2==0) {
				ps.quit();
			}
			k++;
		}
		System.out.println("线程"+getName()+"运行结束!");
	}
}
