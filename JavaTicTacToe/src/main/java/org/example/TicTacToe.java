package JavaTicTacToe.src.main.java.org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class TicTacToe {

    public static String[] board;
    static String turn;

    public static void createBoard() {

        board = new String[9];
        int space = 1;

        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(space);
            space++;
        }
    }

    public static void printBoard() {
        System.out.println("_____________");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("_____________");
    }

    public static char getPlayerChoice(Scanner in){

        int playerChoice;
        char playerPiece = 0;
        turn = "X";

        //there is a bug in this while loop.  entering a letter will get a mismatch exception
        while (playerPiece == 0) {
            System.out.println("Please select 1 for X or 2 for O to begin playing");
            playerChoice = in.nextInt();
            if (playerChoice == 1) {
                playerPiece = 'X';
            } else if (playerChoice == 2) {
                playerPiece = 'O';
            } else {
                System.out.println("That is not a valid choice please try again!");
            }
        }

        if (playerPiece == 'X') {
            System.out.println("Player X goes first! You chose: " + playerPiece);
            System.out.println("You get to go first");
        } else {
            System.out.println("Player X goes first! You chose: " + playerPiece);
            System.out.println("The other person gets to go first");
        }

        return playerPiece;
    }

    public static String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = (board[0] + board[1] + board[2]);
                    break;
                case 1:
                    line = (board[3] + board[4] + board[5]);
                    break;
                case 2:
                    line = (board[6] + board[7] + board[8]);
                    break;
                case 3:
                    line = (board[0] + board[3] + board[6]);
                    break;
                case 4:
                    line = (board[1] + board[4] + board[7]);
                    break;
                case 5:
                    line = (board[2] + board[5] + board[8]);
                    break;
                case 6:
                    line = (board[0] + board[4] + board[8]);
                    break;
                case 7:
                    line = (board[2] + board[4] + board[6]);
                    break;
            }

            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
                break;
            } else if (a == 8) {
                return "draw";
            }
        }

        System.out.println("Now it is " + turn + " turn, please pick a number from the board to mark your piece");
        return null;
    }

    public static void main(String[] args) {

//        int playerChoice;
//        char playerPiece = 0;
        turn = "X";

        Scanner in = new Scanner(System.in);

        getPlayerChoice(in);

        createBoard();

        printBoard();

        int playerMove;
        String winner = null;

        System.out.println("Please pick a number from the board to mark your piece");

        //there is also a bug in this while loop. entering a letter causes a loop of invalid choice that never stops
        while (winner == null) {
            try {
                playerMove = in.nextInt();
                if (!(playerMove > 0 && playerMove <= 9)) {
                    System.out.println("Invalid choice! Please pick again");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please pick again");
                continue;
            }

            if (board[playerMove - 1].equals(String.valueOf(playerMove))) {
                board[playerMove - 1] = turn;

                if (Objects.equals(turn, "X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }

                printBoard();
                winner = checkWinner();

            } else {
                System.out.println("That number has already been selected, please pick again");
            }

        }

        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! No one wins.");
        } else {
            System.out.println("Congratulations! " + winner + " has won the game!");
        }

        in.close();
    }
}

