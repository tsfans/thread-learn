package cn.hl.threadlearn.demo1;

/**
 * 依次输出数字和字符
 * 数字为1-52,字符为A-Z
 * 输出形如:
 * 12A34B56C78D910E1112F1314G1516H1718I1920J2122K2324L2526M2728N2930O3132P3334Q3536R3738S3940T4142U4344V4546W4748X4950Y5152Z
 * @author HULIN
 */
public class ThreadTest {

	public static void main(String[] args) {
		Integer[] nums = new Integer[52];
		for(int i=0;i<52;i++) {
			nums[i] = i+1;
		}
		String[] strs = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		/**
		 * 初始化Printer后，主线程中printer的ThreadLocal变量index初始化为0
		 * 而线程t1、t2中index值未初始化，仍然为空
		 * 所以在线程中操作时应先给index赋初值
		 */
		Printer printer = new Printer(0);
		//线程1打印数字
		Thread t1 = new NumberPrinterThread(printer, nums);
		//线程2打印字符
		Thread t2 = new StringPrinterThread(printer, strs);
		t1.start();
		t2.start();
	}
}
