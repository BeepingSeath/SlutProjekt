public class Player {
    int Attack = 2;
    int HP;

    public Player() {
        this.HP = 5 + (int)(Math.random() * (( 15 - 5 ) + 1));
    }

    public static void main(String[] args) {
        Player p1 = new Player();
        Player p2 = new Player();
        while (p1.HP > 0 && p2.HP > 0) {
            p2.HP -= p1.Attack;
            p1.HP -= p2.Attack;
            System.out.println("Player 1 HP = " + p1.HP + "     Player 2 Hp = " + p2.HP);
        }
        if (p1.HP > p2.HP) {
            System.out.println("P1 Wins!");
        }
        else if (p1.HP < p2.HP) {
            System.out.println("P2 Wins!");
        }
        else {
            System.out.println("It's a draw, you both die");
        }
    }
}
