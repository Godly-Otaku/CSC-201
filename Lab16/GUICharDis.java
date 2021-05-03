package Lab16;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUICharDis extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final LayoutManager layout;

	JTextArea input;
	JTextArea output;
	int[] chars = new int[26];

	public GUICharDis() {
		super("Counting each Character");
		layout = new BorderLayout();
		setLayout(layout);
		input = new JTextArea("TextArea", 6, 20);
		input.setLineWrap(true);
		add(input, BorderLayout.WEST);
		input.getDocument().addDocumentListener(new MyDocumentListener());
		output = new JTextArea(printOutput(), 6, 20);
		output.setEditable(false);
		add(new JScrollPane(output), BorderLayout.EAST);
	}

	class MyDocumentListener implements DocumentListener {

		public void insertUpdate(DocumentEvent e) {
			chars = new int[26];
			String text = input.getText().toUpperCase();
			for (int i = 0; i < text.length(); i++) {
				if (text.charAt(i) <= 90 && text.charAt(i) >= 65)
					chars[text.charAt(i) - 65]++;
			}
			output.setText(printOutput());
		}

		public void removeUpdate(DocumentEvent e) {
			chars = new int[26];
			String text = input.getText().toUpperCase();
			for (int i = 0; i < text.length(); i++) {
				if (text.charAt(i) <= 90 && text.charAt(i) >= 65)
					chars[text.charAt(i) - 65]++;
			}
			output.setText(printOutput());
		}

		public void changedUpdate(DocumentEvent e) {
			// Plain text components do not fire these events
		}
	}

	public String printOutput() {
		String value = "";
		for (int i = 0; i < 26; i++) {
			value += "[" + (char) (i + 65) + "]" + " = " + chars[i] + " \n";
		}
		return value;
	}

	public static void main(String[] args) {
		GUICharDis charDis = new GUICharDis();
		charDis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		charDis.setSize(500, 500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		charDis.setLocation((int) screenSize.getWidth() / 3, (int) screenSize.getHeight() / 3);
		charDis.setVisible(true);
	}
}
