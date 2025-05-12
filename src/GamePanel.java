import java.util.Scanner;

public class GamePanel {
    
    Scanner getInt = new Scanner(System.in);
    Scanner getString = new Scanner(System.in);

    int[][] chessBoard;

    public void copyArr(int[][] currchess, int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                currchess[i][j] = chess[i][j];
            }
        }
    }

    public void draw(int[][] chess) {
        System.out.print(" =");
        for (int i = 0; i < chess.length * 3 + chess.length; i++) {
            System.out.print("=");
        }
        System.out.println();
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                if (chess[i][j] == 0) {
                    System.out.print(" | " + " ");
                } else if (chess[i][j] == -10) {
                    System.out.print(" | K");
                } else {
                    System.out.print(" | " + chess[i][j]);
                }

            }
            System.out.println(" |");
            System.out.print(" =");
            for (int j = 0; j < chess.length * 3 + chess.length; j++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }

    public void setup() {
        int size = 0;
        System.out.println("Welcome to Knight Tour! ");
        do {
            System.out.print("Enter the size of the chessboard: ");
            size = getInt.nextInt();
        } while (size <= 1 );
        System.out.println("The size of the chessboard is: " + size + "x" + size);
        chessBoard = new int[size][size];
        startGame(chessBoard);
    }

    public void startGame(int[][] chess) {
        System.out.println("The game has started!");
        System.out.println("You can choose the starting position of the knight.");
        int option = 0;
        Knight knight = new Knight();
        chess[knight.y][knight.x] = -10;
        for (int i = 0; i < chess.length * chess.length; i++) {
            int tempX = knight.x; 
            int tempY = knight.y;
            draw(chess);
            do {
                System.out.print("Choose option to move (0 - 8): ");
                option = getInt.nextInt();
            } while (!knight.canMove(option, chess));
            chess[tempY][tempX] = (i + 1);
            knight.move(option, chess, i);

            if (!knight.canMove(1, chess) && !knight.canMove(2, chess) && !knight.canMove(3, chess) 
                && !knight.canMove(4, chess) && !knight.canMove(5, chess) && !knight.canMove(6, chess) 
                && !knight.canMove(7, chess) && !knight.canMove(8, chess)) {
                System.out.println("Game Over");
                break;
            }
        }
    }

}
