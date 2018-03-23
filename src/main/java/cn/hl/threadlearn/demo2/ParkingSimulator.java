package cn.hl.threadlearn.demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author HULIN
 */
public class ParkingSimulator {

	//初始化三个停车场,true代表车位为空
	private boolean[] parkingLot = {true,true,true,true,true};
	
	private ThreadLocal<CarOwner> owner = new ThreadLocal<CarOwner>();
	
	private final Lock lock = new ReentrantLock();
	
	private final Condition con = lock.newCondition();
	
	/**
	 * 抢占车位
	 */
	public void parking() {
		lock.lock();
		try {
		if(owner.get().isFlag()) {
				con.awaitNanos(1000000);
		}else {
			for(int i=0;i<parkingLot.length;i++) {
				if(parkingLot[i]) {
					System.out.print("用户 ["+owner.get().getName()+"] 抢到了"+(i+1)+"号车位!");
					parkingLot[i] = false;
					System.out.println("  当前车位状态: ["+parkingLot[0]+","+parkingLot[1]+","+parkingLot[2]+","+parkingLot[3]+","+parkingLot[4]+"]");
					owner.get().setFlag(true);
					owner.get().setIndex(i+1);
					con.signalAll();
					break;
				}
			}
		}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	/**
	 * 让出车位
	 */
	public void quit() {
		lock.lock();
		if(owner.get().isFlag()) {
			System.out.print("用户 ["+owner.get().getName()+"] 让出"+owner.get().getIndex()+"号车位!");
			parkingLot[owner.get().getIndex()-1] = true;
			System.out.println("  当前车位状态: ["+parkingLot[0]+","+parkingLot[1]+","+parkingLot[2]+","+parkingLot[3]+","+parkingLot[4]+"]");
			owner.get().setFlag(false);
			con.signalAll();
		}
		lock.unlock();
	}

	public CarOwner getOwner() {
		return owner.get();
	}

	public void setOwner(CarOwner owner) {
		this.owner.set(owner);;
	}
	
}
