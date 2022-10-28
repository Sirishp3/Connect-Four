import javax.xml.stream.FactoryConfigurationError;
import java.security.PublicKey;
import java.util.Scanner;

public class ConnectFourGame {
    public int[][] board = new int[7][6];
    public int status = PLAYING;
    public static final int PLAYING = 0;
    public static final int RED_WINS = 1;
    public static final int BLACK_WINS = 2;
    public static final int DRAW = 3;
    public static final int RED = 4;
    public static final int BLACK = 5;
    public static final int EMPTY = 6;

    public ConnectFourGame()
    {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = EMPTY;
            }
        }
    }
    public boolean dropPiece(int column, int player) {
        if (columnFull(column)==false && (0<=column && column<=6) && (player==RED||player==BLACK))
        {
            int lowestRowInColumn = 7;
            for (int r = 7; r > 0; r--) {
                if (board[r-1][column] == EMPTY) {
                    lowestRowInColumn--;
                } else if (board[r-1][column] == EMPTY) {
                    lowestRowInColumn = r;
                    break;
                }
            }
            if (player == RED) {
                board[lowestRowInColumn][column] = RED;
                return true;
            }
            else if (player == BLACK) {
                board[lowestRowInColumn][column] = BLACK;
                return true;
            }
        }
        else
        {
            return false;
        }
        return true;
    }
    public int status()
    {
        return status;
    }
    public boolean columnFull(int column)
    {
        int TotalFilled = 0;
        for (int r = 0; r < board.length; r++) {
            if(board[r][column]==BLACK || board[r][column]==RED)
            {
                TotalFilled++;
            }
        }
        if (TotalFilled==7)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void draw()
    {
        String row1 = "";
        String row2 = "";
        String row3 = "";
        String row4 = "";
        String row5 = "";
        String row6 = "";
        String row7 = "";
        for (int r = 7; r>0; r--)
        {
            for (int c = 0; c < board[0].length; c++)
            {
                if(r==1)
                {
                    if(board[r-1][c]==EMPTY)
                    {
                        row1+="|   |";
                    }
                    else
                    {
                        row1+="| "+ board[r-1][c]+" |";
                    }
                }
                if(r==2)
                {
                    if(board[r-1][c]==EMPTY)
                    {
                        row2+="|   |";
                    }
                    else
                    {
                        row2+="| "+ board[r-1][c]+" |";
                    }
                }
                if(r==3)
                {
                    if(board[r-1][c]==EMPTY)
                    {
                        row3+="|   |";
                    }
                    else
                    {
                        row3+="| "+ board[r-1][c]+" |";
                    }
                }
                if(r==4)
                {
                    if(board[r-1][c]==EMPTY)
                    {
                        row4+="|   |";
                    }
                    else
                    {
                        row4+="| "+ board[r-1][c]+" |";
                    }
                }
                if(r==5)
                {
                    if(board[r-1][c]==EMPTY)
                    {
                        row5+="|   |";
                    }
                    else
                    {
                        row5+="| "+ board[r-1][c]+" |";
                    }
                }
                if(r==6)
                {
                    if(board[r-1][c]==EMPTY)
                    {
                        row6+="|   |";
                    }
                    else
                    {
                        row6+="| "+ board[r-1][c]+" |";
                    }
                }
                if(r==7)
                {
                    if(board[r-1][c]==EMPTY)
                    {
                        row7+="|   |";
                    }
                    else
                    {
                        row7+="| "+ board[r-1][c]+" |";
                    }
                }
            }
        }
        System.out.println(row7);
        System.out.println(row6);
        System.out.println(row5);
        System.out.println(row4);
        System.out.println(row3);
        System.out.println(row2);
        System.out.println(row1);

    }
    public boolean win()
    {
        //hor RED
        for (int r = 0; r < board.length; r++) {
            int count = 0;
            for (int c = 0; c < board[0].length; c++)
            {
                if(board[r][c]==RED)
                {
                    count++;
                }
                else
                {
                    continue;
                }
            }
            if(count==4)
            {
                status = RED_WINS;
                System.out.println("Red H wins");
                return true;

            }
        }
        //hor BLACK
        for (int r = 0; r < board.length; r++) {
            int count = 0;
            for (int c = 0; c < board[0].length;c++)
            {
                if(board[r][c]==BLACK)
                {
                    count++;
                }
                else
                {
                    continue;
                }
            }
            if(count>=4)
            {
                status = BLACK_WINS;
                System.out.println("Black H Wins");
                return true;

            }
        }
        //vertical Red
        for (int c = 0; c < board[0].length; c++) {
            int count=0;
            for (int r = 0; r < board.length; r++) {
                if(board[r][c]==RED)
                {
                    count++;
                }
            }
          if(count>=4)
          {
            status=RED_WINS;
            System.out.println("Red V Wins!");
            return true;
          }
        }

        //vertical Black
        for (int c = 0; c < board[0].length; c++) {
            int count=0;
            for (int r = 0; r < board.length; r++) {
                if(board[r][c]==BLACK)
                {
                    count++;
                }
            }
            if(count>=4)
            {
                status=BLACK_WINS;
                System.out.println("Black V Wins!");
                return true;
            }
        }
        //boardDone
        int count =0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if(board[r][c]==BLACK || board[r][c]==RED)
                {
                    count++;
                }
            }

        }
        if(count == board.length* board[0].length)
        {
            status=DRAW;
            System.out.println("Its a draw!");
            return true;

        }
        return false;
    }
    public int getSpot(int col, int row)
    {
        if((col<0 || col>=6) || (row<0 || row>=7))
        {
            return -1;
        }
        return board[row][col];
    }
    public void PlayGame()
    {
        int player = RED;
        while (status == PLAYING) {

            Scanner scanner = new Scanner(System.in);
            if (player == RED) {
                System.out.println("Where does Red want to place his token, Type a number from 0-5:");
                System.out.println("---------------------------------------------------");
                draw();
                int dropColumn = scanner.nextInt();
                System.out.println("---------------------------------------------------");
                dropPiece(dropColumn, RED);
                draw();
                win();
                player = BLACK;
            }
            if (player == BLACK)
            {
                System.out.println("Where does Black want to place his token, Type a number from 0-5:");
                System.out.println("---------------------------------------------------");
                draw();
                int dropColumn = scanner.nextInt();
                System.out.println("---------------------------------------------------");
                dropPiece(dropColumn, BLACK);
                draw();
                win();
                player = RED;
            }
        }

    }

}
