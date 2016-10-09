package mediatorvsobserver.observer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PersonData implements Subject {
	private List<Person> persons;
	private List<Observer> observers;

	private final Object MUTEX = new Object();

	public PersonData() {
	    persons = new ArrayList<>();
		observers = new ArrayList<Observer>();
	}

	@Override
	public void attach(Observer observer) {
		synchronized (MUTEX) {
			if (!observers.contains(observer))
				observers.add(observer);
		}
	}

	@Override
	public void detach(Observer observer) {
		synchronized (MUTEX) {
			int i = observers.indexOf(observer);
			if (i >= 0)
				observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		synchronized (MUTEX) {
			int n = observers.size();
			for (int i = 0; i < n; ++i) {
				Observer observer = (Observer) observers.get(i);
				observer.update(persons);
			}
		}
	}

	public void sendPersonData() {
		notifyObservers();
	}

	public void removePerson( Person person ) {
		
		if( this.persons.contains(person) ) 
			persons.remove(person);
		
		sendPersonData();
	}
	
	public void addPerson( Person person ) {
		
		if( !this.persons.contains(person) )
			persons.add(person);
		
		sendPersonData();
	}
	
	

}
