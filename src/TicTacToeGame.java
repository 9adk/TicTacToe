import java.util.Scanner;

public class TicTacToeGame {
	Scanner scanner = new Scanner(System.in);
	static String player;
	public static String[] tictactoe = new String[10];
	String computer = "";
	public void createBoard() {
		for(int i = 1; i < 10; i++ ){
			tictactoe[i] = " ";
		}
	}

	public void computerSymbol() {
		
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
			if(i % 3 == 0 && i!=9) {
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
	public static void main(String[] args) {
		TicTacToeGame t = new TicTacToeGame();
		Scanner scan = new Scanner(System.in);
		t.createBoard();
		t.computerSymbol();
		String choice;
		do {
			System.out.println("Enter the position for move");
			int position = scan.nextInt();
			scan.nextLine();
			t.makeMove(position);
			System.out.println("Want to enter again");
			choice = scan.nextLine();
		}while(choice.equals("yes"));
		t.showBoard();
		scan.close();
		}
}
