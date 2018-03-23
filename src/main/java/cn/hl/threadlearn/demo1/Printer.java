package cn.hl.threadlearn.demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author HULIN
 */
public class Printer{

	private ThreadLocal<Integer> index = new ThreadLocal<Integer>();
	
	//flag初始为true,先输出数字
	private boolean flag = true;
	
	private final Lock lock = new ReentrantLock();
	
	private final Condition con = lock.newCondition();
	
	public Printer(Integer index) {
		this.index.set(index);
	}
	
	public Integer getIndex() {
		return this.index.get();
	}
	public void setIndex(Integer index) {
		this.index.set(index);
	}
	/**
	 * 一次输出nums数组的两位数字
	 * @param nums
	 */
	public void print(Integer[] nums) {
		lock.lock();
		try {
			if(!flag) {
				con.await();
			}else {
				for(int k=0;k<2;k++) {
					System.out.print(nums[index.get()]);
					index.set(index.get()+1);
				}
				flag = false;
				con.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}
	
	/**
	 * 一次输出strs的一个字符串
	 * @param strs
	 */
	public void print(String[] strs) {
		lock.lock();
		try {
			if(flag) {
				con.await();
			}else {
				System.out.print(strs[index.get()]);
				index.set(index.get()+1);
				flag = true;
				con.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
