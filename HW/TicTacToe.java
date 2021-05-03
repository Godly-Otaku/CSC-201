package HW;

import java.util.*;

public class TicTacToe {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String initboard = "";
		if (args.length < 1) { // If there are no arguments in cmd line, use scanner
			System.out.println("Please enter a board to start with");
			initboard = scnr.next();
		} else {
			initboard = args[0];
		}
		print(initboard);
		System.out.println("Let's get started!");
		while (true) { // Loop forever to alternate turns without whoseTurn, uses System.exit() to stop
			System.out.println("Enter the move you would like to make by re-entering the board");
			String userMove = scnr.next(); // Asks the user to input the board again with their move added.
			print(userMove); // Print the updated board
			if (winner(userMove) != null) { // Checks if user made winning move
				System.out.println(winner(userMove)); // Prints out "Player Wins"
				scnr.close(); // Close scanner
				System.exit(0); // Exit code
			}
			if (whoseTurn(userMove) == null) { // Checks for a tie
				System.out.println("It's a tie");
				scnr.close(); // Close scanner
				System.exit(0); // Exit code
			}
			String computerMove = move(userMove); // Computer chooses a random open spot and returns the updated board
			if (winner(computerMove) != null) { // Checks if computer made winning move
				System.out.println(winner(computerMove)); // Prints out "Computer Wins"
				scnr.close(); // Close scanner
				System.exit(0); // Exit code
			}
			if (whoseTurn(computerMove) == null) { // Checks for a tie
				System.out.println("It's a tie");
				scnr.close(); // Close scanner
				System.exit(0); // Exit code
			}
		}
	}

	public static void print(String board) {
		char[] spots = board.toUpperCase().toCharArray();
		String row1 = "";
		String row2 = "";
		String row3 = "";
		for (int i = 0; i < spots.length; i++) {
			if (i < 3)
				row1 += spots[i] + " ";
			else if ((i >= 3) && (i < 6))
				row2 += spots[i] + " ";
			else
				row3 += spots[i] + " ";
		}
		System.out.println(row1);
		System.out.println(row2);
		System.out.println(row3);
	}

	public static String winner(String board) {
		char[] spots = board.toLowerCase().toCharArray();
		String colunm1 = "", colunm2 = "", colunm3 = "";
		String diag1 = "", diag2 = "";
		for (int i = 0; i < spots.length; i++) {
			if ((i == 0) || (i == 3) || (i == 6)) {
				colunm1 += spots[i];
			} else if ((i == 0) || (i == 3) || (i == 6)) {
				colunm2 += spots[i];
			} else {
				colunm3 += spots[i];
			}
		}
		for (int i = 0; i < spots.length; i++) {
			if ((i == 0) || (i == 4) || (i == 9)) {
				diag1 += spots[i];
			} else if ((i == 2) || (i == 4) || (i == 6)) {
				diag2 += spots[i];
			}
		}
		if ((board.toLowerCase().contains("xxx")) || (colunm1.equals("xxx")) || (colunm2.equals("xxx"))
				|| (colunm3.equals("xxx")) || (diag1.equals("xxx")) || (diag2.equals("xxx")))
			return "Player Wins";
		else if ((board.toLowerCase().contains("ooo")) || (colunm1.equals("ooo")) || (colunm2.equals("ooo"))
				|| (colunm3.equals("ooo")) || (diag1.equals("ooo")) || (diag2.equals("ooo")))
			return "Computer wins";
		else
			return null;

	}

	public static int[] possibleMove(String board) {
		char[] spots = board.toCharArray();
		int emptycount = 0;

		for (char x : spots) {
			if (x == '.')
				emptycount++;
		}
		int[] moves = new int[emptycount];
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < spots.length; j++) {
				if (spots[j] == '.') {
					moves[i] = j;
					break;
				}
			}
		}
		return moves;
	}

	// .........
	// ...X......
	// ...X..0...
	public static String whoseTurn(String board) {
		char[] spots = board.toLowerCase().toCharArray();
		int xcounter = 0, ocounter = 0;
		for (char x : spots) {
			if (x == 'x')
				xcounter++;
			else if (x == 'o')
				ocounter++;
		}
		if ((xcounter == 5) || (ocounter == 5)) // If either have 5, which means over half the board is taken, there's
												// no way to win so it's a tie
			return null;
		if (xcounter == ocounter) // X should never have less than 0 because X always goes first
			return "Player";
		else
			return "Computer";
	}

	public static String move(String board) {
		int[] moves = possibleMove(board);
		Integer computer = (int) (Math.random() * moves.length);
		int finalmove = moves[computer];
		char[] spots = board.toCharArray();
		for (int i = 0; i < spots.length; i++) { // Take apart string and find the index of random spot and make O
			if (i == finalmove) {
				spots[i] = 'O';
			}
		}
		String newboard = "";
		for (char x : spots) {
			newboard += x; // Reconstruct new board
		}
		System.out.println("Computer Moves");
		print(newboard);
		return newboard;
	}
}
