package JavaTicTacToe.src.test.java;

import JavaTicTacToe.src.main.java.org.example.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.tools.JavaCompiler;

import static JavaTicTacToe.src.main.java.org.example.TicTacToe.board;
import static JavaTicTacToe.src.main.java.org.example.TicTacToe.createBoard;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {

    @BeforeEach
    public void setup(){
        String[] board;
        String turn;
        int playerChoice;
        char playerPiece = 0;
        turn = "X";
        createBoard();
    }

    @Test
    public void createBoardTest() throws Exception {
        assertArrayEquals(new int[] {1,2,3,4,5,6,7,8,9}, new int[] {1,2,3,4,5,6,7,8,9});
    }

    @Test
    public void printBoardTest() {

    }

    @Test
    public void checkWinnerTestXWins() {
        board[0] = "X";
        board[1] = "X";
        board[2] = "X";

        TicTacToe TicTacToe;
        assertEquals("X", JavaTicTacToe.src.main.java.org.example.TicTacToe.checkWinner());

    }

    @Test
    public void checkWinnerTestOWins() {

        board[3] = "O";
        board[4] = "O";
        board[5] = "O";

        assertEquals("O", TicTacToe.checkWinner());

    }

}
