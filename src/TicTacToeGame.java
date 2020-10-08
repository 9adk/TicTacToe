
public class TicTacToeGame {
	public static char[] tictactoe = new char[10];
	static String s = " ";
	public static void main(String[] args) {
		for(int i = 1; i < tictactoe.length; i++ ){
				tictactoe[i] = s.charAt(0);
				System.out.println(i+" is "+tictactoe[i]);
			}
	}
}
