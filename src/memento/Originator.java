package memento;

public class Originator{
	
	private User user;

	public void set(User newUser) { 
		System.out.println("Originator: Current User\n"+newUser+ "\n");
	    this.user = newUser; 
	}

	
	public Memento storeInMemento() { 
	    System.out.println("Originator: Saving to Memento");
	    return new Memento(user); 
	}
	   
	
	public User restoreFromMemento(Memento memento) {
		   
		user = memento.getSavedUser(); 
	       
		System.out.println("Originator: Undone from Memento\n"+user + "\n");
		
		return user;
	   
	}
	
}