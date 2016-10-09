package memento;

// Used to store state of object at point in time relevant for undo and redo purpose

public class Memento {
	
	
	private User user;
	
	public Memento(User userSave) { user = userSave; }	
	
	public User getSavedUser() { return user; }
	
}