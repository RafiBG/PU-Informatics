import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainClass {
	
	static JTextField tField = new JTextField(20);
	public static void main(String[] args) {
		
		JFrame myFrame = new JFrame();
		myFrame.setVisible(true);
		
		myFrame.setSize(300, 300);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLayout(new FlowLayout());
		
		JButton button = new JButton("Click me");
		myFrame.add(button);
		button.addActionListener(new ClickButtonAction());
		
		myFrame.add(tField);

	}
	
	static class ClickButtonAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			tField.setText("buga buga");
			
		}
		
	}

}
