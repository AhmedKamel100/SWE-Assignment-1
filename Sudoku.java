import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Sudoku {

    static int [][] board= new int [9][9];

     public static void main(String[] args){
        generateBoard();
        int [][] newboard =gameBoard(30);
        Scanner in= new Scanner(System.in);

        while (!win(newboard)) {
            printGame(newboard);
            int row ,col ,num ;
            System.out.println("enter row and column and number");
            row=in.nextInt()-1;
            col=in.nextInt()-1;
            num=in.nextInt();
            if(num< 1|| num>9){
                System.out.println("enter number between 1 and 9");
                continue;
            }
            if(isValid(newboard,row, col, num) && newboard[row][col]==0){
                   newboard[row][col]=num;
            }
            else{
                System.out.println("wrong cell");
            }
               
                      
        }
        System.out.println("you win !!");
        
     }
     
      static boolean isValid(int[][]a ,int row,int col,int num){
        //cheak valid row
        for(int i=0;i<9;i++){
                if(a[row][i] ==num )
                    return false;
            }
        // cheak valid column
        for(int j=0 ;j<9;j++){
            if (a[j][col]==num)
                return false;
        }
        // cheak box 3*3   if row =2 -> (2-2%3)= 0 cheak from index 0
        for(int k=(row-row%3) ;k<(row-row%3)+3;k++){
            for(int z=(col-col%3);z<(col-col%3)+3;z++){
                if(a[k][z]==num){
                    return false;
                }
            }
        }             
        return true;
      }
  // generate new board 
  static boolean generateBoard(){
          for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    Vector<Integer> numbers =new Vector<>();
                    for(int z=1;z<=9;z++){
                        numbers.add(z);
                    }
                    Collections.shuffle(numbers);

                    for(int num:numbers){
                        if(isValid(board,i, j, num)){
                            board[i][j]=num;
                          if(generateBoard()){
                            return true;
                          }
                           board[i][j]=0;
                        }
                    }
                    return false;
                } 
                     
            }
          }
        
          return true;
  }
   // function to remove some cells rondmly 
  static int[][] gameBoard(int empty_cells_number){

    int[][] gameboard =new int[9][9];
    for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                gameboard[i][j]=board[i][j];
            }
        }
     for (int x=0 ;x<empty_cells_number;x++){
        int i= (int)(Math.random() * 9); 
        int j= (int)(Math.random() * 9);
        
        if(gameboard[i][j]!=0){
            gameboard[i][j]=0;
        }
    
     }
     return gameboard;
  }

  static void printGame(int[][] sudoku){
      for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
             if(sudoku[i][j]==0){
                System.out.print(".   ");
             }
             else{
                System.out.print(sudoku[i][j] +"   ");
             }
             
            }
            System.out.println();
             System.out.println("_________________________________");
        }
  }
  static boolean win(int[][] sudoku){
         for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(sudoku[i][j]==0){
                    return false;
                }
            }
        }
        return true;
  }


}
