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
        String eventFight = "";
        try{
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://db.umea-ntig.se/te20",env.getUser(),env.getPassword());
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from srbEvents");
            rs.next();
            JFrame frame = new JFrame();
            String[] options = new String[2];
            options[0] = new String(rs.getString("ChoiceA"));
            options[1] = new String(rs.getString("ChoiceB"));
            int event = JOptionPane.showOptionDialog(frame.getContentPane(), "What do you want to fight?", "Choose", 0,JOptionPane.INFORMATION_MESSAGE, null, options, null);
            if (event == 0) {
                eventFight = rs.getString("ChoiceAFight");
            } else {
                eventFight = rs.getString("ChoiceBFight");
            }
            System.out.println(eventFight);
        }catch(Exception e){ System.out.println(e);}
    Player player = new Player();
        Slime enemy = new Slime();

        System.out.println(player.XP);
        int NEnemies = (int)eventFight.charAt(0)-'0';
        System.out.println(NEnemies);
        String PlayingQuestion;
        while (NEnemies > 0) {
            while (player.HP > 0 && enemy.getHP() > 0) {
                enemy.TakeDamage(player.DMG);
                player.TakeDamage(enemy.getDMG());
                System.out.println("Player HP = " + player.HP + "     Enemy Hp = " + enemy.getHP());
            }
            System.out.println("\nSecond Fight\n");
            enemy.ResetHP(enemy.getMHP());
            NEnemies--;
        }
            if (player.HP > 0) {
                System.out.println("You Win!");
                player.XP += enemy.getXP();
                System.out.println(player.XP);
            } else if (player.HP <= 0) {
                System.out.println("You Lose");
            } else {
                System.out.println("It's a draw, you both die");
            }

    }
}