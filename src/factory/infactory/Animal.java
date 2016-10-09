package factory.infactory;


class LandAnimalFactory implements AnimalFactory  {
	@Override
	public Animal getAnimal(String name) {
		if (name.equals("dog")) {
			return new Dog();
		}
		else return new Lion();
	}
}

class SeaAnimalFactory implements AnimalFactory {
	@Override
	public Animal getAnimal(String name) {
		 return new Shark();
	}
}

interface AnimalFactory{
	public Animal getAnimal( String str );
}

public abstract class Animal {
  abstract void speak();
	
}


class Dog extends Animal{

	@Override
	void speak() {
		System.out.println("Bark");
		
	}
}

class Lion extends Animal {
	@Override
	void speak() {
		System.out.println("Roar");
		
	}	
	
}

class Shark extends Animal {
	@Override
	void speak() {
		System.out.println("Can't Speak");
		
	}	
	
}