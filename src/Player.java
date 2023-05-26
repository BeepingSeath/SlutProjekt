import javax.swing.*;
import java.sql.*;

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
        env env = new env();
        try{
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://db.umea-ntig.se/te20",env.getUser(),env.getPassword());
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from srbEvents");
            rs.next();
            System.out.println(rs.getString("ChoiceA"));
        }catch(Exception e){ System.out.println(e);}
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