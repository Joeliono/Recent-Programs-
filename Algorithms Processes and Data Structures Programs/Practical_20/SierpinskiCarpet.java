package Practical_20;

// import java.io.PrintWriter; // Step 1
public class SierpinskiCarpet {
    static int  dimensionSize = 729;
    static char[][] board = new char[dimensionSize][dimensionSize];



    public static boolean carpetFunction(int x, int y) {

    do {

            if (x == 0 && y == 0) {
                return true;
            }
            // if both the length and height  of the board % 3 are 1 return false
            if (x % 3 == 1 && y % 3 == 1) {
                return false;
            }

        carpetFunction(x/=3,y/=3); //recursively divide both values by 3 or else we'll get a stack overflow error
      } while (true);


    }

    public static void makeBoard()
    {

        for (int i = 0; i < dimensionSize; i++) {
            for (int j = 0; j < dimensionSize; j++) {
                if (carpetFunction(i,j)) board[i][j] =('*'); //if  i and j % 3 are 0 then put at that subarray * on the board
                else board[i][j]=(' '); //if  i and j % 3 are 1 then put at that subarray ' ' on the board
            }
        }
    }

    public static void main(String[] args) {

         makeBoard();

        for (int i = 0; i < dimensionSize; i++) {
            for (int j = 0; j < dimensionSize; j++) {
                System.out.print((board[i][j]) + " ");

            }
            System.out.println(); //prints the board
        }

    }
}


