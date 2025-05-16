import java.util.ArrayList;
import java.util.Scanner;

public class GamePanel  {
    
    Scanner getInt = new Scanner(System.in);
    Scanner getString = new Scanner(System.in);

    int[][] chessBoard;

    ArrayList<int[][]> solutions = new ArrayList<>();

    public void copyArr(int[][] currchess, int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                currchess[i][j] = chess[i][j];
            }
        }
    }

    public void solve(int[][] chess, Knight knight, int level) {
        int [][] chesstemp = new int[chess.length][chess.length];
        if (level == chess.length * chess.length - 1) {
            solutions.add(chess);
            draw(chess);
        } else {
            if (knight.canMove(1, chess)) {
                Knight temp = knight.clone();
                copyArr(chesstemp, chess);
                temp.move(1, chesstemp, level);
                solve(chesstemp, temp, level + 1);
            } 
            if (knight.canMove(2, chess)) {
                Knight temp = knight.clone();
                copyArr(chesstemp, chess);
                temp.move(2, chesstemp, level);
                solve(chesstemp, temp, level + 1);
            } 
            if (knight.canMove(3, chess)) {
                Knight temp = knight.clone();
                copyArr(chesstemp, chess);
                temp.move(3, chesstemp, level);
                solve(chesstemp, temp, level + 1);
            } 
            if (knight.canMove(4, chess)) {
                Knight temp = knight.clone();
                copyArr(chesstemp, chess);
                temp.move(4, chesstemp, level);
                solve(chesstemp, temp, level + 1);
            } 
            if (knight.canMove(5, chess)) {
                Knight temp = knight.clone();
                copyArr(chesstemp, chess);
                temp.move(5, chesstemp, level);
                solve(chesstemp, temp, level + 1);
            }
            if (knight.canMove(6, chess)) {
                Knight temp = knight.clone();
                copyArr(chesstemp, chess);
                temp.move(6, chesstemp, level);
                solve(chesstemp, temp, level + 1);
            } 
            if (knight.canMove(7, chess)) {
                Knight temp = knight.clone();
                copyArr(chesstemp, chess);
                temp.move(7, chesstemp, level);
                solve(chesstemp, temp, level + 1);
            } 
            if (knight.canMove(8, chess)) {
                Knight temp = knight.clone();
                copyArr(chesstemp, chess);
                temp.move(8, chesstemp, level);
                solve(chesstemp, temp, level + 1);
            }
        }
    }

    public void draw(int[][] chess) {
        System.out.print(" =");
        for (int i = 0; i < chess.length * 4 + chess.length; i++) {
            System.out.print("=");
        }
        System.out.println();
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                if (chess[i][j] == 0) {
                    System.out.print(" | " + "  ");
                } else if (chess[i][j] == -10) {
                    System.out.print(" | K ");
                } else {
                    if (chess[i][j] < 10) {
                        System.out.print(" | " + chess[i][j] + " ");
                    } else {
                        System.out.print(" | " + chess[i][j]);
                    }
                }
            }
            System.out.println(" |");
            System.out.print(" =");
            for (int j = 0; j < chess.length * 4 + chess.length; j++) {
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
        int option = 0, x = 0, y = 0;
        draw(chess);
        System.out.println("Select start position: ");
        do {
            System.out.print("select posX: "); 
            x = getInt.nextInt();
        } while (x < 0 || x > chess.length - 1);
        do {
            System.out.print("select posY: "); 
            y = getInt.nextInt();
        } while (y < 0 || y > chess.length - 1);
        Knight knight = new Knight(x, y);
        chess[knight.y][knight.x] = -10;
        for (int i = 0; i < chess.length * chess.length; i++) {
            draw(chess);
            System.out.println("Select 9 to Autosolve!");
            do {
                System.out.print("Choose option to move (0 - 8): ");
                option = getInt.nextInt();
            } while (!knight.canMove(option, chess) && option != 9);
            if (option != 9) {
                knight.move(option, chess, i);
            } else {
                solve(chess, knight, i);
                break;
            }
            
            if (!knight.canMove(1, chess) && !knight.canMove(2, chess) && !knight.canMove(3, chess) 
            && !knight.canMove(4, chess) && !knight.canMove(5, chess) && !knight.canMove(6, chess) 
            && !knight.canMove(7, chess) && !knight.canMove(8, chess)) {
                System.out.println("Game Over");
            }
        }
        System.out.println("Banyak solusi: " + solutions.size());
    }

}
