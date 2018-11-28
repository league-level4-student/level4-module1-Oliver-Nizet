package _03_Switch_Statement_Practice;

import javax.swing.JOptionPane;

public class CustomButtonOptionPanes {
	public static void main(String[] args) {
		String[] options = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		int input = JOptionPane.showOptionDialog(null, "Choose a day of the week", "Custom Buttons", 0, -1, null,
				options, 0);

		String choice = options[input];

		// use a switch statement to do something cool for each option
		switch (choice) {
		case "Sunday":
			JOptionPane.showMessageDialog(null, "You have no purpose in life");
			break;
		case "Monday":
			JOptionPane.showMessageDialog(null, "You have no friends");
			break;
		case "Tuesday":
			JOptionPane.showMessageDialog(null, "Your family doesnt love you");
			break;
		case "Wednesday":
			JOptionPane.showMessageDialog(null, "You are bad at sports");
			break;
		case "Thursday":
			JOptionPane.showMessageDialog(null, "You are dumb");
			break;
		case "Friday":
			JOptionPane.showMessageDialog(null, "Nobody cares about you");
			break;
		case "Saturday":
			JOptionPane.showMessageDialog(null, "You chose the best day of the week! You are awesome!");
			break;
		}
	}
}