package String;

import javax.swing.JOptionPane;

public class StringReverse {

	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("Enter a String:");
		String s2 = null;
		s2 = reverse(s);

		String output = null;
		boolean isOk = true;
		/*for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == s2.charAt(i)) {
				i++;
			} else {

				isOk = false;
				break;
			}
		}*/
		
		if (s.equalsIgnoreCase(s2))
			output = "Yes";
		else
			output = "Not";

		JOptionPane.showMessageDialog(null, output);
	}

	public static String reverse(String s) {
		String resStr = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			char cha = s.charAt(i);
			resStr = resStr + cha;
		}

		return resStr;

	}
}