package mediatorvsobserver.observer;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

interface Command {
	PersonData pdata = new PersonData();
	DataListener listener = new DataListener(pdata);
	void execute(Person person);
}

public class Action extends JButton {

	Action(String lableName) {
		super(lableName);

	}

}

class LblDisplay extends JLabel {

	LblDisplay() {
		super(" Start Adding Person...");
		setFont(new Font("Arial", Font.BOLD, 24));
	}

}

class BtnAdd extends JButton implements Command {
	
	BtnAdd(ActionListener al, LblDisplay msgLbl ) {
		super("Add Person");
		addActionListener(al);
		listener.registerMessage(msgLbl);
	}

	public void execute(Person person) {
		pdata.addPerson(person);
	}

}

class BtnRemove extends JButton implements Command {
	
	BtnRemove(ActionListener al, LblDisplay msgLbl ) {
		super("Remove Person");
		addActionListener(al);
		listener.registerMessage(msgLbl);
	}

	public void execute(Person person) {		
		pdata.removePerson(person);
	}

}