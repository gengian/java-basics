package xin.cosmos.thread;

/**
 * A and B Thread Print numbers 1 to 100 alternately
 * 
 * Written examination questions of a financial institution
 * 
 * @author ian
 *
 */
public class DoubleNumAlterPrint {
	private final static Object LOCK = new Object();// lock
	private static Integer i = 0; // counter: 1 to 100
	private static boolean isCurPrinted = false;// current thread was printed

	/**
	 * Thread A
	 * 
	 * @author ian
	 *
	 */
	public static class A implements Runnable {
		@Override
		public void run() {
			synchronized (LOCK) {
				while (i < 100) {
					if (isCurPrinted) {
						try {
							LOCK.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("Thread-A:" + (i + 1));
						isCurPrinted = !isCurPrinted;
						++i;
						LOCK.notifyAll();
					}
				}
			}
		}
	}

	/**
	 * Thread A
	 * 
	 * @author ian
	 *
	 */
	public static class B implements Runnable {
		@Override
		public void run() {
			synchronized (LOCK) {
				while (i < 100) {
					if (!isCurPrinted) {
						try {
							LOCK.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("Thread-B:" + (i + 1));
						isCurPrinted = !isCurPrinted;
						++i;
						LOCK.notifyAll();
					}
				}
			}
		}
	}

}
