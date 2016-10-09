package statevsstrategy;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CarGameDemo extends JFrame {

	public static void main(String[] args) {
		new CarGameDemo();
	}
	
	private JButton accelBut, leftBut, rightBut,brakeBut;
	private JTextField unameText, lnameText;
	private JLabel lnameLbl, unameLbl;


	int saveCount = 0, userCount = 0;


	public CarGameDemo() {


		this.setSize(350, 480);
		this.setTitle(" Car Game ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel1 = new JPanel( new FlowLayout());
		unameLbl = new JLabel();
		unameText = new JTextField(20);
		lnameText = new JTextField(20);


		panel1.add(new JLabel(" User: "));

		panel1.add(unameLbl);
		panel1.add(unameText);
		panel1.add(lnameText);


		accelBut = new JButton("Accel");
		accelBut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
			}
		});

		leftBut = new JButton("Left");
		leftBut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
			}
		});

		rightBut = new JButton("Right");
		rightBut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		brakeBut = new JButton("Brake");
		brakeBut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		

		panel1.add(accelBut);
		panel1.add(leftBut);
		panel1.add(rightBut);
		panel1.add(brakeBut);
		
		this.add(panel1);

		this.setVisible(true);

	}
	


}
