package Lab0;

import java.util.*;

public class TicTacToe {
	public static int turnCounter = 0; // Used to determine who won

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		char[][] board = initBoard(3, 3); // Initializes the board with X's and O's
		int[][] numBoard = new int[3][3]; // Initializes the board with 1's and 10's
		System.out.println("Let's Begin!");
		gameBoard(board); // Prints the current board
		while (true) { // Infinitely runs the game until someone wins or a tie
			yourTurn(scnr, board, numBoard);
			machineTurn(board, numBoard);
		}
	}

	public static char[][] initBoard(int row, int column) { // Makes the XO board
		char[][] values = new char[row][column];
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[i].length; j++) {
				values[i][j] = ' ';
			}
		}
		return values;
	}

	public static void gameBoard(char[][] board) { // Displays the current XO board
		for (int i = 0; i < board.length; i++) {
			for (char x : board[i]) {
				System.out.print("|" + x);
			}
			System.out.println("|");
		}
		System.out.println();
	}

	public static boolean checkWinner(int[][] board) {
		if (checkRows(board, true, 0) || checkColumns(board, true, 0) || checkDiagonals(board, true, ""))
			return true;
		else
			return false;
	}

	public static boolean checkRows(int[][] board, boolean all, int row) { // Checks all rows or a specific row
		boolean done = false;
		if (all) {
			for (int i = 0; i < board.length; i++) {
				int sum = 0;
				for (int x : board[i]) {
					if (x != 0)
						sum += x;
				}
				if ((sum == 3) || (sum == 30)) {
					done = true;
					break;
				}
			}
		} else {
			int sum = 0;
			for (int x : board[row]) {
				if (x != 0)
					sum += x;
			}
			if ((sum == 2) || (sum == 20)) {
				done = true;
			}
		}
		return done;
	}

	public static boolean checkColumns(int[][] board, boolean all, int column) { // Checks all columns or a specific
																					// column
		boolean done = false;
		if (all) {
			for (int i = 0; i < board.length; i++) {
				int sum = 0;
				for (int j = 0; j < board.length; j++) {
					if (board[j][i] != 0)
						sum += board[j][i];
				}
				if ((sum == 3) || (sum == 30)) {
					done = true;
					break;
				}
			}
		} else {
			int sum = 0;
			for (int i = 0; i < board.length; i++) {
				if (board[i][column] != 0)
					sum += board[i][column];
			}
			if ((sum == 2) || (sum == 20)) {
				done = true;
			}
		}
		return done;
	}

	public static boolean checkDiagonals(int[][] board, boolean all, String place) { // Checks all diagonals or one
		boolean done = false;
		if (all) {
			if (board[1][1] == 0)
				return false;
			if ((board[0][0] == board[1][1]) && (board[2][2] == board[1][1])) {
				done = true;
			}
			if ((board[0][2] == board[1][1]) && (board[2][0] == board[1][1])) {
				done = true;
			}
		} else {
			int sum = board[1][1];
			int otherSum = sum;
			if ((place.equals("0.0")) || (place.equals("2.2"))) { // Checks the upper left diagonal
				sum += board[0][0];
				sum += board[2][2];
				if ((sum == 2) || (sum == 20)) {
					done = true;
				}
			} else if ((place.equals("2.0")) || (place.equals("0.2"))) { // Checks the upper right diagonal
				sum += board[2][0];
				sum += board[0][2];
				if ((sum == 2) || (sum == 20)) {
					done = true;
				}
			} else { // Checks the both diagonals (only for middle spot)
				sum += board[0][0];
				sum += board[2][2];
				if ((sum == 2) || (sum == 20)) {
					done = true;
				}
				otherSum += board[2][0];
				otherSum += board[0][2];
				if ((otherSum == 2) || (otherSum == 20)) {
					done = true;
				}
			}
		}
		return done;
	}

	public static void yourTurn(Scanner scnr, char[][] board, int[][] numBoard) { // Player's turn
		String[] empty = getEmptySlots(numBoard);
		if (empty[0] == null) { // If there are no empty spots left
			System.out.println("It's a tie!!");
			System.exit(0);
		}
		System.out.println("Please enter the coordinates of your location (x):");
		String move = scnr.next();
		while ((move.equals("")) || (move.trim().isEmpty()) || (move.toCharArray().length != 3)
				|| (move.toCharArray()[1] != ',') || (Integer.parseInt(String.valueOf(move.toCharArray()[0])) < 0)
				|| (Integer.parseInt(String.valueOf(move.toCharArray()[0])) > 2)
				|| (Integer.parseInt(String.valueOf(move.toCharArray()[2])) < 0)
				|| (Integer.parseInt(String.valueOf(move.toCharArray()[2])) > 2)) { // If the enter incorrectly
			System.out.println("Please enter coordinates between 0-1 and in this format: 1,1");
			move = scnr.next();
		}
		while (numBoard[(Integer.parseInt(String.valueOf(move.toCharArray()[0])))][(Integer
				.parseInt(String.valueOf(move.toCharArray()[2])))] != 0) { // If they choose a spot that's already taken
			System.out.println("That spot is taken! Please choose an empty spot");
			move = scnr.next();
		}
		char[] letters = move.toCharArray();
		int x = Integer.parseInt(String.valueOf(letters[0])); // Gets the vertical coordinate of player's move
		int y = Integer.parseInt(String.valueOf(letters[2])); // Gets the horizontal coordinate of player's move
		board[x][y] = 'X'; // Update the XO board
		numBoard[x][y] = 1; // Update the number board
		turnCounter++; // Switches turns
		gameBoard(board); // Displays the board
		if (checkWinner(numBoard)) { // Checks if someone won
			if (turnCounter % 2 == 0) {
				System.out.println("Computer wins!!!");
				gameBoard(board);
				System.exit(0);
			} else {
				System.out.println("You win!!!");
				gameBoard(board);
				System.exit(0);
			}
		}
	}

	public static void machineTurn(char[][] board, int[][] numBoard) { // Computer's turn
		int x = 1, y = 1;
		String[] empty = getEmptySlots(numBoard);
		if (empty[0] == null) { // If there are no empty spots left
			System.out.println("It's a tie!!");
			System.exit(0);
		}
		List<Object> winCounter = checkWinning(numBoard);
		if (winCounter.get(0).equals(true)) { // If there's a finishing move to counter or win with
			String winCounterMove = winCounter.get(1).toString();
			char[] coordinates = winCounterMove.toCharArray();
			x = Integer.parseInt(String.valueOf(coordinates[0]));
			y = Integer.parseInt(String.valueOf(coordinates[2]));
		} else {
			if (numBoard[1][1] == 0) { // Take the middle slot if empty
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
		board[x][y] = 'O'; // Update the XO board
		numBoard[x][y] = 10; // Update the number board
		System.out.println("Computer moves to: " + x + "," + y);
		turnCounter++; // Switches turns
		gameBoard(board); // Displays the board
		if (checkWinner(numBoard)) { // Checks if someone won
			if (turnCounter % 2 == 0) {
				System.out.println("Computer wins!!!");
				gameBoard(board);
				System.exit(0);
			} else {
				System.out.println("You win!!!");
				gameBoard(board);
				System.exit(0);
			}
		}
	}

	public static String[] getEmptySlots(int[][] board) { // Finds all empty slots on the board and stores them
		String[] empty = new String[8];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] == 0) {
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

	public static List<Object> checkWinning(int[][] board) { // Checks if there's a winning move, returns bool, string
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
}