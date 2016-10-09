package memento;

import java.util.ArrayList;

class Caretaker {

	ArrayList<Memento> savedUsers = new ArrayList<Memento>();

	public void addMemento(Memento m) { savedUsers.add(m); }

	public Memento getMemento(int index) { return savedUsers.get(index); }
} 