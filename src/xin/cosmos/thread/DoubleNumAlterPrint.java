/*
 * Copyright 2021 gengian
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
