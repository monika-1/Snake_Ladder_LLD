public class Game {

    Board board;

    Game() {
        board = new SnakeBoard();
    }

    public void startGame(int noOfPlayers, Player[] players) {
        for (int i=0; i<noOfPlayers; i++) System.out.print(players[i].getName() + "      ");
        System.out.println();
        positionOfPlayers(players);

        Dice dice = new Dice();
        int playerWon = -1;
        int turn = 0;

        while (true) {
            int pos = players[turn].getPos() + dice.rollDice();
            if (pos == board.getWinningPos()) {
                playerWon = turn;
                break;
            } else if (pos < board.getWinningPos()) {
                int isSnakeLadderPos = board.getBoard()[pos];
                if (isSnakeLadderPos == 0) players[turn].setPos(pos);
                else {
                    if (isSnakeLadderPos < pos) System.out.println("Player " + players[turn].getName() + " bitten by Snake. " + pos + " <-- " + isSnakeLadderPos);
                    else System.out.println("Player " + players[turn].getName() + " got Ladder. " + pos + " --> " + isSnakeLadderPos);

                    players[turn].setPos(isSnakeLadderPos);
                }
            }

            positionOfPlayers(players);
            turn = (turn + 1) % noOfPlayers;
        }

        System.out.println("Player won: " + players[playerWon].getName());
    }

    static private void positionOfPlayers(Player[] players) {
        for (Player player: players) {
            System.out.print(player.getPos() + "        ");
        }
        System.out.println();
    }

}
