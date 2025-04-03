package Programm;

import javax.swing.*;
import java.awt.*;

public class GUI {
	JFrame myWindow = new JFrame();
	JPanel chalkboard = new JPanel();

	BorderLayout bLayout = new BorderLayout();
	JButton openBtn = new JButton();

	JLabel lbl1 = new JLabel();

	public void go(){

		chalkboard.add(openBtn);
		chalkboard.setLayout(bLayout);


		myWindow.setSize(new Dimension(500,500));
		myWindow.setVisible(true);
		myWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
