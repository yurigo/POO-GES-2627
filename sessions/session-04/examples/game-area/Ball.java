public class Ball {
    private int x;
    private int y;
    private int vx;
    private int vy;

    private int force;

    public Ball(int x, int y, int vx, int vy, int force) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.force = force;
    }

    public boolean isOn(int x, int y) {
        return this.x == x && this.y == y;
    }
}
