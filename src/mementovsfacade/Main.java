package mementovsfacade;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("JDialog Demo");
       // final JButton btnLogin = new JButton("Click to login");
 
//        btnLogin.addActionListener(
//                new ActionListener(){
//                    public void actionPerformed(ActionEvent e) {
//                        Memento loginDlg = new Memento(frame);
//                        loginDlg.setVisible(true);
//                        // if logon successfully
//                        if(loginDlg.isSucceeded()){
//                            btnLogin.setText("Hi " + loginDlg.getUsername() + "!");
//                        }
//                    }
//                });
 
        Memento loginDlg = new Memento(frame);
        loginDlg.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(new FlowLayout());
        //frame.getContentPane().add(btnLogin);
        frame.setVisible(true);
    }
}