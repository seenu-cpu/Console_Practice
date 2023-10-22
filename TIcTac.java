package ConsolePractice;

import java.util.Scanner;

public class TIcTac {
    public static void main(String[] args) {
        char[][] gameBoard = { {' ', '|',' ','|',' '},{'_','_','_','_','_'},
                {' ', '|',' ','|',' '},{'_','_','_','_','_'},
                {' ', '|',' ','|',' '}};
        Scanner in = new Scanner(System.in);
        int[] mark = new int[9];
        String s ="Moves left";
        int player =0;
        while(s.equals("Moves left")){
            System.out.println("Enter the position ");
            int pos = in.nextInt();
            placePosition(gameBoard,pos,player++,mark);
            s=result(gameBoard,mark);
            printgameBoard(gameBoard);
        }
        if(s.equals("one") || s.equals("two")){
            System.out.println(s + " Won the game");
        }else{
            System.out.println("Game is Tied");
        }

    }
    public static void printgameBoard(char[][] gameBoard){
        for (char[] chars : gameBoard) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
    public static void placePosition(char[][] gameBoard , int pos , int player,int[] mark){
        char symbol;
        if(player%2==0){
            symbol='X';
        }else{
            symbol='O';
        }
        switch (pos) {
            case 1 :
                gameBoard[0][0] = symbol;
                mark[0] = 1;
                break;

            case 2 :
                gameBoard[0][2] = symbol;
                mark[1] = 1;
                break;

            case 3 :
                gameBoard[0][4] = symbol;
                mark[2] = 1;
                break;

            case 4 :
                gameBoard[2][0] = symbol;
                mark[3] = 1;
                break;

            case 5 :
                gameBoard[2][2] = symbol;
                mark[4] = 1;
                break;

            case 6 :
                gameBoard[2][4] = symbol;
                mark[5] = 1;
                break;

            case 7 :
                gameBoard[4][0] = symbol;
                mark[6] = 1;
                break;

            case 8 :
                gameBoard[4][2] = symbol;
                mark[7] = 1;
                break;
            case 9 :
                gameBoard[4][4] = symbol;
                mark[8] = 1;
                break;
            default :
            break;
        }
    }

    public static String result(char[][] gameBoard,int[] mark){
        for (int i = 0; i < 5; i+=2) {
            if((gameBoard[i][0]!=' ')&&gameBoard[i][0]==gameBoard[i][2] && gameBoard[i][2]==gameBoard[i][4]){
                return gameBoard[i][0]=='X'?"one":"two";
            }
           else if((gameBoard[0][i]!=' ')&&gameBoard[0][i]==gameBoard[2][i] && gameBoard[2][i]==gameBoard[4][i]){
                return gameBoard[0][i]=='X'?"one":"two";
            }
           else if( ( (gameBoard[0][0]!=' ')&&(gameBoard[0][0]==gameBoard[2][2]&&gameBoard[2][2]==gameBoard[4][4]) )|| ((gameBoard[0][4]!=' ')&&(gameBoard[0][4]==gameBoard[2][2]&&gameBoard[2][2]==gameBoard[4][0]))){
                return gameBoard[0][0]=='X'?"one":"two";
            }
        }
         int c =0;
        for (int j : mark) {
            if (j == 0) {
                c++;
            }
        }
        return c==0?"Tie":"Moves left";
    }

}
