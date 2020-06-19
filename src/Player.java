public class Player {
    private int pos;
    private String name;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) { this.pos = pos; }

    public String getName() { return name; }

    Player(String name) {
        this.name = name;
        pos = 0;
    }
}
