import java.util.Scanner;

public class TicTacToeGame {
	Scanner scanner = new Scanner(System.in);
	static int countMoves = 0;
	static String symbol1;
	public static String[] tictactoe;
	static String computer;

	/**
	 * Usecase1
	 */
	public void createBoard() {
		tictactoe = new String[10];
		for (int i = 1; i < 10; i++) {
			tictactoe[i] = " ";
		}
	}

	/**
	 * Usecase2
	 */
	public void chooseSymbol() {

		do {
			System.out.println("Enter the symbol for player from X or O");
			symbol1 = scanner.nextLine();
			if (symbol1.equals("X")) {
				computer = "O";
				break;
			} else if (symbol1.equals("O")) {
				computer = "X";
				break;
			} else {
				System.out.println("Invalid input");
			}
		} while (symbol1 != "O" || symbol1 != "X");
	}

	/**
	 * Uecase3
	 */
	public void showBoard() {
		for (int i = 1; i < 10; i++) {
			System.out.print(tictactoe[i]);
			if ((2 * i) % 3 != 0) {
				System.out.print(" | ");
			}
			if (i % 3 == 0 && i != 9) {
				System.out.println("\n----------");
			}
		}
		System.out.println();
	}

	/**
	 * Usecase4 and Usecase5
	 * 
	 * @param position
	 * @param whoIsPlaying
	 * @return
	 */
	public String makeMove(int position) {
		String play = "User";
		if (position < 1 || position > 9) {
			System.out.println("Invalid position");
		} else if (tictactoe[position].equals(" ")) {
			tictactoe[position] = symbol1;
			System.out.println("User played the move");
			play = "Computer";
			countMoves++;
		} else {
			System.out.println("Enter an empty position");
			showBoard();
		}
		return play;
	}

	/**
	 * Usecase6
	 * 
	 * @return
	 */
	public String playFirst() {
		int chance = (int) Math.floor(Math.random() * 10) % 2;
		String startFirst;
		String toss;
		if (chance == 1) {
			toss = "Heads";
			startFirst = "User";
		} else {
			toss = "Tails";
			startFirst = "Computer";
		}
		System.out.println(toss + "..." + startFirst + " will play first");
		return startFirst;
	}

	/**
	 * Usecase7
	 * 
	 * @param symbol
	 * @return
	 */
	public int isWinner(String[] board, String symbol) {
		if (board[1].equals(symbol) && board[2].equals(symbol) && board[3].equals(symbol)) {
			return 1;
		} else if (board[4].equals(symbol) && board[5].equals(symbol) && board[6].equals(symbol)) {
			return 1;
		} else if (board[7].equals(symbol) && board[8].equals(symbol) && board[9].equals(symbol)) {
			return 1;
		} else if (board[1].equals(symbol) && board[5].equals(symbol) && board[9].equals(symbol)) {
			return 1;
		} else if (board[3].equals(symbol) && board[5].equals(symbol) && board[7].equals(symbol)) {
			return 1;
		} else if (board[1].equals(symbol) && board[4].equals(symbol) && board[7].equals(symbol)) {
			return 1;
		} else if (board[2].equals(symbol) && board[5].equals(symbol) && board[8].equals(symbol)) {
			return 1;
		} else if (board[3].equals(symbol) && board[6].equals(symbol) && board[9].equals(symbol)) {
			return 1;
		}
		if (countMoves == 9) {
			return 2;
		}
		return 0;
	}

	/**
	 * Usecase8
	 * 
	 * @return
	 */
	public int winPosition() {
		String[] copyOfBoard = tictactoe.clone();
		for (int i = 1; i < copyOfBoard.length; i++) {
			if (copyOfBoard[i].equals(" ")) {
				copyOfBoard[i] = computer;
				if (isWinner(copyOfBoard, computer) == 1) {
					return i;
				} else {
					copyOfBoard[i] = " ";
				}
			}
		}
		return 0;
	}

	/**
	 * Usecase9
	 * 
	 * @return
	 */
	public int blockUsersWin() {
		String[] copyOfBoard = tictactoe.clone();
		for (int i = 1; i < copyOfBoard.length; i++) {
			if (copyOfBoard[i].equals(" ")) {
				copyOfBoard[i] = symbol1;
				if (isWinner(copyOfBoard, symbol1) == 1) {
					return i;
				} else {
					copyOfBoard[i] = " ";
				}
			}
		}
		return 0;
	}
	/**Usecase11
	 * @return
	 */
	public int checkCorners() {
		int[] corners = {1,3,7,9};
		int position;
		int choice = (int) Math.floor(Math.random() *10 ) % 4;
		position = corners[choice];
		for(int i = 0; i < 4; i++) {
			if(tictactoe[position].equals(" ")) {
				return position;
			}
			else {
				choice = (int) Math.floor(Math.random() *10 ) % 4;
				position = corners[choice];
			}
		}
		return 10;
	}
	/**Usecase11
	 * @return
	 */
	public int checkSides() {
		int[] sides = {2,4,6,8};
		int position;
		int choice = (int) Math.floor(Math.random() *10 ) % 4;
		position = sides[choice];
		for(int i = 0; i < 4; i++) {
			if(tictactoe[position].equals(" ")) {
				return position;
			}
			else {
				choice = (int) Math.floor(Math.random() *10 ) % 4;
				position = sides[choice];
			}
		}
		return 10;
	}
	/**
	 * Usecase8, Usecase9, Usecase10 modified for Usecase11
	 * 
	 * @return
	 */
	public String compMove() {
		String play = "Computer";
		int winPosition = winPosition();
		int blockPosition = blockUsersWin();
		int position = (int) Math.floor(Math.random() * 10) % 9 + 1;
		if (winPosition != 0) {
			position = winPosition;
		} else if (winPosition == 0 && blockPosition != 0) {
			position = blockPosition;
		}
		else if(winPosition == 0 && blockPosition == 0) {
			if(checkCorners() == 10) {
				if(tictactoe[5].equals(" ")) {	
					position = 5;
				}
				else {
					position = checkSides();
				}
			}
			else {
				position = checkCorners();
			}
		}
		if (tictactoe[position].equals(" ")) {
			tictactoe[position] = computer;
			System.out.println("Computer played the move");
			play = "User";
			showBoard();
			countMoves++;
		}
		return play;
	}

	public static void main(String[] args) {
		TicTacToeGame tictac = new TicTacToeGame();
		Scanner scan = new Scanner(System.in);
		String choice;
		do {
			tictac.createBoard();
			tictac.chooseSymbol();
			String player = tictac.playFirst();
			while (true) {
				if (player.equals("Computer")) {
					player = tictac.compMove();
					if (tictac.isWinner(tictactoe, computer) == 1) {
						System.out.println("Winner is Computer");
						break;
					} else if (tictac.isWinner(tictactoe, computer) == 2) {
						System.out.println("Game Over !!");
						break;
					}
				} else {
					System.out.println("Enter the position for move");
					int position = scan.nextInt();
					scan.nextLine();
					player = tictac.makeMove(position);
					tictac.showBoard();
					if (tictac.isWinner(tictactoe, symbol1) == 1) {
						System.out.println("Winner is User");
						break;
					} else if (tictac.isWinner(tictactoe, symbol1) == 2) {
						System.out.println("Game Over !!");
						break;
					}
				}
			}
			System.out.println("Do you want to play another game");
			choice = scan.nextLine();
		}while(choice.equals("yes"));
		scan.close();
	}
}
