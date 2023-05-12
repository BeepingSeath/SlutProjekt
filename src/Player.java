import javax.swing.*;

public class Player {
    int DMG;
    int HP;
    int XP;
    public Player() {
        this.DMG = 2;
        this.HP = 10;
        this.XP = 0;
    }

    public void TakeDamage(int DMG){
        this.HP -= DMG;
    }

    public static void main(String[] args) {
        Player player = new Player();
        Slime enemy = new Slime();
        System.out.println(player.XP);
        String PlayingQuestion;
            while (player.HP > 0 && enemy.getHP() > 0) {
                enemy.TakeDamage(player.DMG);
                player.TakeDamage(enemy.getDMG());
                System.out.println("Player HP = " + player.HP + "     Enemy Hp = " + enemy.getHP());
            }
            if (player.HP > enemy.getHP()) {
                System.out.println("You Win!");
                player.XP += enemy.getXP();
                System.out.println(player.XP);
            } else if (player.HP < enemy.getHP()) {
                System.out.println("You Lose");
            } else {
                System.out.println("It's a draw, you both die");
            }

    }
}
