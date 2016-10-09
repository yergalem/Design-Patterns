package mediatorvsobserver.observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ObserverDemo extends JFrame implements ActionListener {

   JTextField fname , lname;
   LblDisplay msgLbl;
    ObserverDemo() {
        JPanel p = new JPanel();
        JPanel p2 = new JPanel();
        fname = new JTextField(20);  
        fname.setText("Enter First Name");
        lname = new JTextField(20);
        lname.setText("LastName");
        msgLbl = new LblDisplay();
        p.add(new BtnAdd(this , msgLbl));
        p.add(new BtnRemove(this , msgLbl));
        p2.add(fname);
        p2.add(lname);
        getContentPane().add( msgLbl, "North");
        getContentPane().add(p2);
        getContentPane().add(p, "South");
        setSize(400, 200);
        setVisible(true);  
        setTitle("Person Database : Observer Pattern");
       
    }

    public void actionPerformed(ActionEvent ae) {
        Command comd = (Command) ae.getSource();
        comd.execute( new Person(fname.getText(), lname.getText()));
    }

    public static void main(String[] args) {
        new ObserverDemo();
    }

}