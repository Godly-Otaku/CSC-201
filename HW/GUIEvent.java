package HW;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUIEvent extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final LayoutManager layout;

	private JTextArea textArea;
	JTextField textField;
	private String output = "";

	public GUIEvent() {
		super("Live Text");
		layout = new BorderLayout();
		setLayout(layout);
		textArea = new JTextArea("TextArea");
		add(new JScrollPane(textArea));
		textArea.getDocument().addDocumentListener(new MyDocumentListener());
		textField = new JTextField("TextArea");
		add(textField, BorderLayout.SOUTH);
	}

	class MyDocumentListener implements DocumentListener {

		public void insertUpdate(DocumentEvent e) {
			output = textArea.getText();
			textField.setText(output);
		}

		public void removeUpdate(DocumentEvent e) {
			output = textArea.getText();
			textField.setText(output);
		}

		public void changedUpdate(DocumentEvent e) {
			// Plain text components do not fire these events
		}
	}

	public static void main(String[] args) {
		GUIEvent gEvents = new GUIEvent();
		gEvents.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gEvents.setSize(500, 500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		gEvents.setLocation((int) screenSize.getWidth() / 3, (int) screenSize.getHeight() / 3);
		gEvents.setVisible(true);
	}
}