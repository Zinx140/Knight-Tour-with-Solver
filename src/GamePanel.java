import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.JFrame;

public class GamePanel extends JFrame implements MouseListener {
    
    Scanner getInt = new Scanner(System.in);
    Scanner getString = new Scanner(System.in);

    int[][] chessBoard;

    ArrayList<int[][]> solutions = new ArrayList<>();

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

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
                // draw(chesstemp);
                solve(chesstemp, temp, level + 1);
            } 
            if (knight.canMove(2, chess)) {
                Knight temp = knight.clone();
                copyArr(chesstemp, chess);
                temp.move(2, chesstemp, level);
                // draw(chesstemp);
                solve(chesstemp, temp, level + 1);
            } 
            if (knight.canMove(3, chess)) {
                Knight temp = knight.clone();
                copyArr(chesstemp, chess);
                temp.move(3, chesstemp, level);
                // draw(chesstemp);
                solve(chesstemp, temp, level + 1);
            } 
            if (knight.canMove(4, chess)) {
                Knight temp = knight.clone();
                copyArr(chesstemp, chess);
                temp.move(4, chesstemp, level);
                // draw(chesstemp);
                solve(chesstemp, temp, level + 1);
            } 
            if (knight.canMove(5, chess)) {
                Knight temp = knight.clone();
                copyArr(chesstemp, chess);
                temp.move(5, chesstemp, level);
                // draw(chesstemp);
                solve(chesstemp, temp, level + 1);
            } 
            if (knight.canMove(6, chess)) {
                Knight temp = knight.clone();
                copyArr(chesstemp, chess);
                temp.move(6, chesstemp, level);
                // draw(chesstemp);
                solve(chesstemp, temp, level + 1);
            } 
            if (knight.canMove(7, chess)) {
                Knight temp = knight.clone();
                copyArr(chesstemp, chess);
                temp.move(7, chesstemp, level);
                // draw(chesstemp);
                solve(chesstemp, temp, level + 1);
            } 
            if (knight.canMove(8, chess)) {
                Knight temp = knight.clone();
                copyArr(chesstemp, chess);
                temp.move(8, chesstemp, level);
                // draw(chesstemp);
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
        int option = 0;
        Knight knight = new Knight();
        chess[knight.y][knight.x] = -10;
        // for (int i = 0; i < chess.length * chess.length; i++) {
            draw(chess);
            // do {
            //     System.out.print("Choose option to move (0 - 8): ");
            //     option = getInt.nextInt();
            // } while (!knight.canMove(option, chess) && option != 9);
            solve(chess, knight, 0);
            for (int[][] arr : solutions) {
                System.out.println("solutions : ");
                draw(arr);
            }
            
            // knight.move(option, chess, i);

            if (!knight.canMove(1, chess) && !knight.canMove(2, chess) && !knight.canMove(3, chess) 
                && !knight.canMove(4, chess) && !knight.canMove(5, chess) && !knight.canMove(6, chess) 
                && !knight.canMove(7, chess) && !knight.canMove(8, chess)) {
                System.out.println("Game Over");
            }
        // }
    }

}
