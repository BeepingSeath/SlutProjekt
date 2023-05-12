public class Player {
    int DMG = 2;
    int HP;
    public void TakeDamage(int DMG){
        this.HP -= DMG;
    }

    public Player() {
        this.HP = 5 + (int)(Math.random() * (( 15 - 5 ) + 1));
    }

    public static void main(String[] args) {
        Player p1 = new Player();
        Slime slime = new Slime();
        while (p1.HP > 0 && slime.getHP() > 0) {
            slime.TakeDamage(p1.DMG);
            p1.TakeDamage(slime.getDMG());
            System.out.println("Player HP = " + p1.HP + "     Enemy Hp = " + slime.getHP());
        }
        if (p1.HP > slime.getHP()) {
            System.out.println("You Win!");
        }
        else if (p1.HP < slime.getHP()) {
            System.out.println("You Lose");
        }
        else {
            System.out.println("It's a draw, you both die");
        }
    }
}
