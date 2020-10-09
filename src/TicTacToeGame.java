import java.util.Scanner;

public class TicTacToeGame {
	Scanner scanner = new Scanner(System.in);
	static String symbol1;
	public static String[] tictactoe = new String[10];
	static String computer = "";

	/**
	 * Usecase 1
	 */
	public void createBoard() {
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
	public String makeMove(int position, String whoIsPlaying, String symbol) {
		boolean check = isWinner(symbol);
		boolean tie = isTie();
		if (tictactoe[position] == " " && check == false && tie == false) {
			if (whoIsPlaying.equals("User")) {
				tictactoe[position] = symbol1;
				whoIsPlaying = "Computer";
			} else {
				tictactoe[position] = computer;
				whoIsPlaying = "User";
			}
		} else {
			System.out.println("Enter empty position");
		}
		return whoIsPlaying;
	}

	
	public int computerIsPlaying() {
		int position = (int) Math.floor((Math.random()) * 10) % 9 + 1;
		return position;
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
	 * Uscase7
	 * @return
	 */
	public boolean isTie() {
		boolean flag = true;
		for (int i = 1; i < tictactoe.length; i++) {
			if (tictactoe[i] == " ") {
				flag = false;
			}
		}
		return flag;
	}
	
	/**
	 * Usecase7
	 * @param symbol
	 * @return
	 */
	public boolean isWinner(String symbol) {
		boolean flag = false;
		if (tictactoe[1].equals(symbol) && tictactoe[2].equals(symbol) && tictactoe[3].equals(symbol)) {
			flag = true;
		} else if (tictactoe[4].equals(symbol) && tictactoe[5].equals(symbol) && tictactoe[6].equals(symbol)) {
			flag = true;
		} else if (tictactoe[7].equals(symbol) && tictactoe[8].equals(symbol) && tictactoe[9].equals(symbol)) {
			flag = true;
		} else if (tictactoe[1].equals(symbol) && tictactoe[5].equals(symbol) && tictactoe[9].equals(symbol)) {
			flag = true;
		} else if (tictactoe[3].equals(symbol) && tictactoe[5].equals(symbol) && tictactoe[7].equals(symbol)) {
			flag = true;
		} else if (tictactoe[1].equals(symbol) && tictactoe[4].equals(symbol) && tictactoe[7].equals(symbol)) {
			flag = true;
		} else if (tictactoe[2].equals(symbol) && tictactoe[5].equals(symbol) && tictactoe[8].equals(symbol)) {
			flag = true;
		} else if (tictactoe[3].equals(symbol) && tictactoe[6].equals(symbol) && tictactoe[9].equals(symbol)) {
			flag = true;
		}
		return flag;
	}

	public static void main(String[] args) {
		TicTacToeGame tictactoe = new TicTacToeGame();
		Scanner scan = new Scanner(System.in);
		tictactoe.createBoard();
		tictactoe.chooseSymbol();
		String player = tictactoe.playFirst();
		do {
			if (player.equals("Computer")) {
				int compsPosition = tictactoe.computerIsPlaying();

				player = tictactoe.makeMove(compsPosition, player, symbol1);
				tictactoe.showBoard();
			} else {
				System.out.println("Enter the position for move");
				int position = scan.nextInt();
				scan.nextLine();
				player = tictactoe.makeMove(position, player, computer);
				tictactoe.showBoard();
			}
			if (tictactoe.isWinner(symbol1) == true) {
				System.out.println("Winner is User");
				break;
			} else if (tictactoe.isWinner(computer) == true) {
				System.out.println("Winner is Computer");
				break;
			}
		} while (tictactoe.isTie() == false);
		tictactoe.showBoard();
		scan.close();
	}
}
