package HW;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUITicTacToe extends JFrame implements ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	boolean gameActive = true;
	int turnCounter = 0;
	LayoutManager layout;
	JButton[][] buttons = new JButton[3][3];
	JLabel output;
	JButton newGame;
	JButton gameMode;
	JPanel grid = new JPanel();
	String opponent = "Vs. Human";
	String current = "X";

	public GUITicTacToe() {
		super("TicTacToe");
		this.setSize(500, 450);
		layout = new BorderLayout();
		setLayout(layout);
		// Initialize grid with buttons
		createGrid();
		// New Game button
		newGame = new JButton("New Game");
		newGame.addActionListener(this);
		add(newGame, BorderLayout.WEST);
		// Gamemode button
		gameMode = new JButton(opponent);
		gameMode.addActionListener(this);
		add(gameMode, BorderLayout.EAST);
		// Output label
		output = new JLabel("Balls", JLabel.CENTER);
		add(output);
	}

	public void createGrid() {
		grid = new JPanel();
		grid.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JButton btn = new JButton("");
				btn.setPreferredSize(
						new Dimension((int) this.getSize().getWidth() / 3, (int) this.getSize().getWidth() / 4));
				btn.addActionListener(this);
				buttons[i][j] = btn;
				grid.add(btn);
			}
		}
		add(grid, BorderLayout.NORTH);
	}

	public void actionPerformed(ActionEvent event) {
		if (turnCounter % 2 == 0)
			current = "X";
		else
			current = "O";
		if (event.getActionCommand().equals("New Game")) {
			restart("New Game Started");
		} else if (event.getActionCommand().equals("")) {
			if (!gameActive)
				return;
			output.setText("Moved");
			move(event.getSource());
		} else if (event.getActionCommand().equals(opponent)) {
			changeMode();
		}
	}

	public void restart(String text) {
		output.setText(text);
		gameActive = true;
		turnCounter = 0;
		remove(grid);
		createGrid();
	}

	public void move(Object btn) {
		System.out.println(turnCounter);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (buttons[i][j] == btn) {
					buttons[i][j].setText(current);
				}
			}
		}
		if (checkWinner(buttons)) { // Checks if someone won
			if (turnCounter % 2 == 0) {
				if (opponent.equals("Vs. AI"))
					output.setText("Player wins!!!");
				else
					output.setText("Player 1 wins!!!");
				gameActive = false;
				return;
			} else {
				if (opponent.equals("Vs. Human"))
					output.setText("Player 2 wins!!!");
				else
					output.setText("Computer wins!!!");
				gameActive = false;
				return;
			}
		}
		turnCounter++;

		if (opponent.equals("Vs. AI")) {
			String place = machineTurn(buttons);
			if (place.equals("Tie")) {
				output.setText("It's a tie!!!");
				gameActive = false;
			} else {
				current = "O";
				int x = Integer.parseInt(place.substring(0, 1));
				int y = Integer.parseInt(place.substring(2));
				buttons[x][y].setText(current);
				turnCounter++;
			}
		}
		if (checkWinner(buttons)) { // Checks if someone won
			if (turnCounter % 2 == 0) {
				if (opponent.equals("Vs. AI"))
					output.setText("Computer wins!!!");
				else
					output.setText("Player wins!!!");
				gameActive = false;
				return;
			} else {
				if (opponent.equals("Vs. Human"))
					output.setText("Player 1 wins!!!");
				else
					output.setText("Player 2 wins!!!");
				gameActive = false;
				return;
			}
		}
		System.out.println(turnCounter);
	}

	public void changeMode() {
		if (opponent == "Vs. Human") {
			opponent = "Vs. AI";
			restart("Multiplayer mode started");
		} else {
			opponent = "Vs. Human";
			restart("Single-Player mode started");
		}
		gameMode.setText(opponent);
	}

	public boolean checkWinner(JButton[][] board) {
		if (checkRows(board, true, 0) || checkColumns(board, true, 0) || checkDiagonals(board, true, ""))
			return true;
		else
			return false;
	}

	public boolean checkRows(JButton[][] board, boolean all, int row) { // Checks all rows or a specific row
		boolean done = false;
		if (all) {
			for (int i = 0; i < board.length; i++) {
				String sum = "";
				for (JButton x : board[i]) {
					if (x.getText() != "")
						sum += x.getText();
				}
				if ((sum.equals("XXX")) || (sum.equals("OOO"))) {
					done = true;
					break;
				}
			}
		} else {
			String sum = "";
			for (JButton x : board[row]) {
				if (x.getText() != "")
					sum += x.getText();
			}
			if ((sum.equals("XX")) || (sum.equals("OO"))) {
				done = true;
			}
		}
		return done;
	}

	public boolean checkColumns(JButton[][] board, boolean all, int column) { // Checks all columns or a specific
																				// column
		boolean done = false;
		if (all) {
			for (int i = 0; i < board.length; i++) {
				String sum = "";
				for (int j = 0; j < board.length; j++) {
					if (board[j][i].getText() != "")
						sum += board[j][i].getText();
				}
				if ((sum.equals("XXX")) || (sum.equals("OOO"))) {
					done = true;
					break;
				}
			}
		} else {
			String sum = "";
			for (int i = 0; i < board.length; i++) {
				if (board[i][column].getText() != "")
					sum += board[i][column].getText();
			}
			if ((sum.equals("XX")) || (sum.equals("OO"))) {
				done = true;
			}
		}
		return done;
	}

	public boolean checkDiagonals(JButton[][] board, boolean all, String place) { // Checks all diagonals or one
		boolean done = false;
		if (all) {
			if (board[1][1].getText().equals(""))
				return false;
			if ((board[0][0].getText().equals(board[1][1].getText()))
					&& (board[2][2].getText().equals(board[1][1].getText()))) {
				done = true;
			}
			if ((board[0][2].getText().equals(board[1][1].getText()))
					&& (board[2][0].getText().equals(board[1][1].getText()))) {
				done = true;
			}
		} else {
			String sum = board[1][1].getText();
			String otherSum = sum;
			if ((place.equals("0.0")) || (place.equals("2.2"))) { // Checks the upper left diagonal
				sum += board[0][0].getText();
				sum += board[2][2].getText();
				if ((sum.equals("XX")) || (sum.equals("OO"))) {
					done = true;
				}
			} else if ((place.equals("2.0")) || (place.equals("0.2"))) { // Checks the upper right diagonal
				sum += board[2][0].getText();
				sum += board[0][2].getText();
				if ((sum.equals("XX")) || (sum.equals("OO"))) {
					done = true;
				}
			} else { // Checks the both diagonals (only for middle spot)
				sum += board[0][0].getText();
				sum += board[2][2].getText();
				if ((sum.equals("XX")) || (sum.equals("OO"))) {
					done = true;
				}
				otherSum += board[2][0].getText();
				otherSum += board[0][2].getText();
				if ((otherSum.equals("XX")) || (otherSum.equals("OO"))) {
					done = true;
				}
			}
		}
		return done;
	}

	public String machineTurn(JButton[][] numBoard) { // Computer's turn
		int x = 1, y = 1;
		String[] empty = getEmptySlots(numBoard);
		if (empty[0] == null) { // If there are no empty spots left
			return "Tie";
		}
		List<Object> winCounter = checkWinning(numBoard);
		if (winCounter.get(0).equals(true)) { // If there's a finishing move to counter or win with
			String winCounterMove = winCounter.get(1).toString();
			char[] coordinates = winCounterMove.toCharArray();
			x = Integer.parseInt(String.valueOf(coordinates[0]));
			y = Integer.parseInt(String.valueOf(coordinates[2]));
		} else {
			if (numBoard[1][1].getText().equals("")) { // Take the middle slot if empty
				x = 1;
				y = 1;
			} else { // Chooses a random empty spot
				int move = (int) (Math.random() * (empty.length - 1)) + 1;
				while (empty[move] == null) { // Keep trying to get a random value if there are few spots left
					move = (int) (Math.random() * (empty.length - 1)) + 1;
				}
				String randomMove = empty[move];
				char[] ranMove = randomMove.toCharArray();
				x = Integer.parseInt(String.valueOf(ranMove[0]));
				y = Integer.parseInt(String.valueOf(ranMove[2]));
			}
		}
		String coordinate = x + "." + y;
		return coordinate;
	}

	public String[] getEmptySlots(JButton[][] board) { // Finds all empty slots on the board and stores them
		String[] empty = new String[8];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][i].getText().equals("")) {
					for (int x = 0; x < empty.length; x++) {
						if (empty[x] == null) {
							empty[x] = j + "." + i;
							break;
						}
					}
				}
			}
		}
		return empty;
	}

	public List<Object> checkWinning(JButton[][] board) { // Checks if there's a winning move, returns bool,
															// string
		boolean winning = false;
		String location = "no";
		String[] empty = getEmptySlots(board);
		for (String index : empty) {
			if (index != null) {
				char[] emptyLocal = index.toCharArray();
				int x = Integer.parseInt(String.valueOf(emptyLocal[0]));
				int y = Integer.parseInt(String.valueOf(emptyLocal[2]));
				if (((x == 1) && (y != 1)) || (((x != 1) && (y == 1)))) {// If the slot isn't in a diagonal
					if (checkRows(board, false, x) || checkColumns(board, false, y)) {
						location = index;
						winning = true;
						break;
					}
				} else { // If the spot is in a diagonal
					if (checkRows(board, false, x) || checkColumns(board, false, y)
							|| checkDiagonals(board, false, index)) {
						winning = true;
						location = index;
						break;
					}
				}
			}
		}
		return Arrays.asList(winning, location); // Returns if there's a winning move and where to counter or win
	}

	public static void main(String[] args) {
		GUITicTacToe gttt = new GUITicTacToe();
		gttt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		gttt.setLocation((int) screenSize.getWidth() / 3, (int) screenSize.getHeight() / 3);
		gttt.setVisible(true);
	}
}
