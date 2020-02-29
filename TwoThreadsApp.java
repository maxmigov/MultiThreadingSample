package main;

public class TwoThreadsApp {

	public static void main(String[] args) throws InterruptedException {
		
		Plate commonPlate = new Plate(1000);
		Cat cat1 = new Cat("Murka", commonPlate);
		Dog dog1 = new Dog("Bobik", commonPlate);
		System.out.println("START " + commonPlate);
		
		cat1.start();
		dog1.start();
		cat1.join();
		dog1.join();
		System.out.println("---------------------END " + commonPlate);


	}

}

class Cat extends Thread {
	private String name;
	private Plate plate;

	public Cat(String name, Plate plate) {
		super();
		this.name = name;
		this.plate = plate;
	}
	
	public void eat() {
		while (plate.getFood() > 0) {
				System.out.println("Cat is eating");
				plate.setFood(plate.getFood() - 1);
				System.out.println(plate.getFood());
		}
	}

	@Override
	public void run() {
		super.run();
		this.eat();
	}
	
	
}

class Dog extends Thread {
	private String name;
	private Plate plate;
	
	public Dog(String name, Plate plate) {
		super();
		this.name = name;
		this.plate = plate;
	}
	
	public Plate getPlate() {
		return plate;
	}
	public void setPlate(Plate plate) {
		this.plate = plate;
	}
	
	public void eat() {
		while (plate.getFood() > 2) {
			System.out.println("Dog is eating");
			plate.setFood(plate.getFood() - 2);
			System.out.println(plate.getFood());
		}
	}
	
	@Override
	public void run() {
		super.run();
		this.eat();
	}
	
}

class Plate {
	private int food;

	@Override
	public String toString() {
		return "Plate [food=" + getFood() + "]";
	}

	public Plate(int food) {
		super();
		this.setFood(food);
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}
	
}




