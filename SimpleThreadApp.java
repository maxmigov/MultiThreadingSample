package main;

public class SimpleThreadApp {
	
	public static void main (String[] args) throws InterruptedException{
		
		Printer p1 = new Printer("Canon", 100);
		Printer p2 = new Printer("HP", 3);
		p1.start();
		p2.start();
		p1.join();
		//p2.join();
		System.out.println("------- END -------");

	}

	

}

//class Printer implements Runnable
class Printer extends Thread{
	private String name;
	private Integer quantity;

	public Printer(String name, Integer quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}
	
	public void printForever() {
		int n = 1;
		while (n <= quantity) {
			System.out.println(name + ": " + n);
			n++;
		}
	}

	@Override
	public void run() {
		this.printForever();
		super.run();
	}
	
	
}