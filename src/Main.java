import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the no. of players: ");
        int noOfPlayers = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter the names of the players: ");
        Player[] players = new Player[noOfPlayers];
        for (int i=0; i<noOfPlayers; i++) {
            String name = br.readLine();
            players[i] = new Player(name);
        }

        Game game = new Game();
        game.startGame(noOfPlayers, players);

    }
}

/* Example
Enter the no. of players: 3
Enter the names of the players:
MK
VK
CKB
 */

