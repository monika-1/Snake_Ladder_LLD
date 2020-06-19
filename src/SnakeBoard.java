import java.util.Random;

public class SnakeBoard implements Board {
    private int[] board;
    private int winningPos;
    private final int MIN_BOARD_SIZE;
    private final int MAX_BOARD_SIZE;
    int sizeOfBoard;

    SnakeBoard() {
        MIN_BOARD_SIZE = 3;
        MAX_BOARD_SIZE = 10;

        createBoard();
    }

    @Override
    public void createBoard() {
        int range = MAX_BOARD_SIZE - MIN_BOARD_SIZE;
        sizeOfBoard = (int) ((Math.random() * range) + MIN_BOARD_SIZE);

        board = new int[ sizeOfBoard * sizeOfBoard + 1 ];
        winningPos = sizeOfBoard * sizeOfBoard;

        populateTheBoardWithSnakesAndLadders();
    }

    private void populateTheBoardWithSnakesAndLadders() {
        Random random = new Random();

        int snakesAndLadders = random.nextInt(10) + sizeOfBoard;
        for (int i=0; i<snakesAndLadders; i++) {
            int x = random.nextInt(sizeOfBoard * sizeOfBoard) + 1;
            int y = random.nextInt(sizeOfBoard * sizeOfBoard) + 1;
            board[x] = y;
        }

        System.out.println("\nPositions of snakes and ladder.");
        printBoard();
        System.out.println();
    }

    private void printBoard() {
        for (int i=1; i<board.length; i++) System.out.print(board[i] + " ");
        System.out.println();
    }

    @Override
    public int getWinningPos() {
        return winningPos;
    }

    @Override
    public int[] getBoard() {
        return board;
    }

}
