import java.util.Scanner;

public class TicTacToeGame {
	Scanner scanner = new Scanner(System.in);
	static String player;
	public static String[] tictactoe = new String[10];
	String computer = "";
	/**
	 * Usecase 1 
	 */
	public void createBoard() {
		for(int i = 1; i < 10; i++ ){
			tictactoe[i] = " ";
		}
	}

	public void chooseSymbol() {
		
		do {	
			System.out.println("Enter the symbol for player from X or O");
			player = scanner.nextLine();
			if(player.equals("X")) {
				computer = "O";
				break;
			}
			else if(player.equals("O")){
				computer = "X";
				break;
			}
			else {
				System.out.println("Invalid input");
			}
		}while(player!="O" || player!="X");
	}
	public void showBoard() {
		for(int i = 1; i < 10; i++) {
			System.out.print(tictactoe[i]);
			if((2 * i) % 3 != 0) {
				System.out.print(" | ");
			}
			if(i % 3 == 0 && i != 9) {
				System.out.println("\n----------");
			}
		}
		System.out.println();
	}
	public void makeMove(int position) {	
		if(tictactoe[position] == " ") {
			tictactoe[position] = player;
		}
		else {
			System.out.println("Enter empty position");
		}
	}
	public void playFirst() {
		int chance = (int)Math.floor(Math.random()*10)%2;
		String startFirst;
		String toss;
		if(chance == 1) {
			toss = "Heads";
			startFirst = "User";
		}
		else {
			toss = "Tails";
			startFirst = "Computer";
		}
		System.out.println(toss+"..."+startFirst+" will play first");
	}
	public static void main(String[] args) {
		TicTacToeGame tictactoe = new TicTacToeGame();
		Scanner scan = new Scanner(System.in);
		tictactoe.createBoard();
		tictactoe.chooseSymbol();
		tictactoe.playFirst();
		String choice;		
		do {
			System.out.println("Enter the position for move");
			int position = scan.nextInt();
			scan.nextLine();
			tictactoe.makeMove(position);
			tictactoe.showBoard();
			System.out.println("Want to enter again");
			choice = scan.nextLine();
		}while(choice.equals("yes"));
		tictactoe.showBoard();
		scan.close();
		}
}
