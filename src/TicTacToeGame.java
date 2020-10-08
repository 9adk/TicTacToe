import java.util.Scanner;

public class TicTacToeGame {
	Scanner scanner = new Scanner(System.in);
	public static String[] tictactoe = new String[10];
	String computer = "";
	public void createBoard() {
		for(int i = 1; i < tictactoe.length; i++ ){
			tictactoe[i] = " ";
		}
	}
	public void computerSymbol() {
		String player;
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
	public static void main(String[] args) {
		TicTacToeGame t = new TicTacToeGame();
		t.createBoard();
		t.computerSymbol();	
		}
}
