package cn.hl.threadlearn.demo1;

/**
 * @author HULIN
 */
public class NumberPrinterThread extends Thread{

	private Printer printer;
	
	private Integer[] nums;
	
	public NumberPrinterThread(Printer printer,Integer[] nums) {
		this.printer = printer;
		this.nums = nums;
	}
	
	@Override
	public void run() {
		//设置当前线程该副本的初始值
		printer.setIndex(0);
		while(printer.getIndex()<nums.length) {
			printer.print(nums);
		}
	}
}
