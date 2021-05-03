package HW;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIEvents extends JFrame implements KeyListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final LayoutManager layout;

	private JTextArea textArea;
	JTextField textField;
	private String output = "";

	public GUIEvents() {
		super("Live Text");
		layout = new BorderLayout();
		setLayout(layout);
		textArea = new JTextArea("TextArea");
		add(new JScrollPane(textArea));
		textArea.addKeyListener(this);
		textField = new JTextField("TextArea");
		add(textField, BorderLayout.SOUTH);
	}

	public void keyPressed(KeyEvent event) {

	}

	public void keyReleased(KeyEvent event) {

	}

	public void keyTyped(KeyEvent event) {
		output = textArea.getText();
		textField.setText(output);
	}

	public static void main(String[] args) {
		GUIEvents gEvents = new GUIEvents();
		gEvents.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gEvents.setSize(500, 500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		gEvents.setLocation((int) screenSize.getWidth() / 3, (int) screenSize.getHeight() / 3);
		gEvents.setVisible(true);
	}
}