package ThreadAssignment;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadWrite extends Thread {
	
	private int counter;
	
	public ThreadWrite(int counter)	{
		super("Thread" + counter);
		this.counter = counter;
	}
	/*thread life cycle:
		Thread starts with the counter number
		Thread runs by printing the string + thread name
		Thread ends
	 */	
	public void run() {
		counter++ ;
		if(counter <= 100) {
			ThreadWrite thr = new ThreadWrite(counter);
			thr.start();
			try {
				thr.join();
				String data = "I will write this String to File in Java";		
				writeUsingOutputStream(data + getName());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	} 			
	
	public static void main (String args[])	{
		ThreadWrite th1 = new ThreadWrite(1);
		th1.start();
	}	
	
	private void writeUsingOutputStream(String data) {
		try {
			FileWriter fstream = new FileWriter("C:/Users/willy/Google Drive/Optimus/GitHub/JavaAssignments/test.txt",true);
			BufferedWriter fbw = new BufferedWriter(fstream);
			fbw.write(data);
			fbw.newLine();
			fbw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
