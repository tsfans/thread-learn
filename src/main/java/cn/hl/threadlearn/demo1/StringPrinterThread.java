package cn.hl.threadlearn.demo1;

/**
 * @author HULIN
 */
public class StringPrinterThread extends Thread{

	private Printer printer;
	
	private String[] strs;
	
	public StringPrinterThread(Printer printer,String[] strs) {
		this.printer = printer;
		this.strs = strs;
	}
	@Override
	public void run() {
		//设置当前线程该副本的初始值
		printer.setIndex(0);
		while(printer.getIndex()<strs.length) {
			printer.print(strs);
		}
	}
}
