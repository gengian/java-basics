package test;

import xin.cosmos.thread.DoubleNumAlterPrint;

/**
 * DoubleNumAlterPrint Test
 * 
 * @author geng
 *
 */
public class DoubleNumAlterPrintTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(new DoubleNumAlterPrint.A());
		Thread t2 = new Thread(new DoubleNumAlterPrint.B());
		t1.start();
		t2.start();
	}

}
