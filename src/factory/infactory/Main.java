package factory.infactory;

public class Main {

	public static void main(String[] args) {
		AnimalFactory factory = new LandAnimalFactory();
		
		Animal animal = factory.getAnimal("dog");
		
		animal.speak();
		
	}
}
