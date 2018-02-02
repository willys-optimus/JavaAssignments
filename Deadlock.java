package ThreadAssignment;
public class Deadlock {
	public static Object Lock1 = new Object();
	public static Object Lock2 = new Object();
	public static void main(String args[]) {
		ResourceOne T1 = new ResourceOne();
		ResourceTwo T2 = new ResourceTwo();
		T1.start();
		T2.start();
	}
	private static class ResourceOne extends Thread {
		public void run() {
			synchronized (Lock1) {
				System.out.println("Thread 1: Holding lock 1...");
	            		
				try { Thread.sleep(10); }
				catch (InterruptedException e) {}
				System.out.println("Thread 1: Waiting for lock 2...");
				
				synchronized (Lock2) {
					System.out.println("Thread 1: Holding lock 1 & 2...");
				}
			}
		}
	}
	private static class ResourceTwo extends Thread {
		public void run() {
			synchronized (Lock2) {
				System.out.println("Thread 2: Holding lock 2...");
            
	            try { Thread.sleep(10); }
	            catch (InterruptedException e) {}
	            System.out.println("Thread 2: Waiting for lock 1...");
	            
	            synchronized (Lock1) {
	               System.out.println("Thread 2: Holding lock 1 & 2...");
	            }
	         }
	      }
	   }
}
