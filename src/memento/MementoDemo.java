package memento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
/**
 * The originator sets the value of user, creates a new memento with a new user, and
 * gets the article stored in the current memento
 * 
 *  CareTaker stores ArrayList of users t. It can add and retrieve users from the ArrayList
 *  
 *  @author Yergalem
 *  Lab - 9-2
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MementoDemo extends JFrame {
	
	private JButton saveBut, undoBut, redoBut;

    private JTextArea theProfile = new JTextArea(15, 20);
	private JTextField unameText, lnameText;
	private JLabel lnameLbl, unameLbl;


    Originator originator = new Originator();
	Caretaker caretaker = new Caretaker();
	

	int saveCount = 0, userCount = 0;


	public MementoDemo() {


		this.setSize(750, 780);
		this.setTitle(" UserProfile Registration ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel1 = new JPanel( new FlowLayout());
		unameLbl = new JLabel();
		lnameLbl = new JLabel();
		unameText = new JTextField(20);
		lnameText = new JTextField(20);


		panel1.add(new JLabel(" User: "));

		panel1.add(unameLbl);
		panel1.add(unameText);
		panel1.add(lnameLbl);
		panel1.add(lnameText);
		panel1.add(theProfile);


		saveBut = new JButton("Save");
		saveBut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				User user = new User();
				     user.setFirstName(unameText.getText());
				     user.setLastName( lnameText.getText());


				originator.set( user );

				caretaker.addMemento(originator.storeInMemento());

				saveCount++;
				userCount++;

				theProfile.setText("\n\n"+user.getFirstName() +"\n"+user.getLastName());
				System.out.println("Saved : " + saveCount);

				undoBut.setEnabled(true);

			}
		});

		undoBut = new JButton("Undo");
		undoBut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (userCount >= 1) {
					userCount--;

					User user = originator.restoreFromMemento(caretaker.getMemento(userCount));

					theProfile.setText(user.getFirstName() +"\n"+user.getLastName());

					redoBut.setEnabled(true);

				} else {

					undoBut.setEnabled(false);

				}
			}
		});

		redoBut = new JButton("Redo");
		redoBut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if ((saveCount - 1) > userCount) {

					userCount++;


					User user = originator.restoreFromMemento(caretaker.getMemento(userCount));

					theProfile.setText( user.getFirstName() +"\n"+user.getLastName());

					undoBut.setEnabled(true);

				} else {

					redoBut.setEnabled(false);

				}
			}
		});

		panel1.add(saveBut);
		panel1.add(undoBut);
		panel1.add(redoBut);
		
		this.add(panel1);

		this.setVisible(true);

	}
	
	public static void main(String[] args) {

		new MementoDemo();

	}


}