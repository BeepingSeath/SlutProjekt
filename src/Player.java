public class Player {
    int Attack = 5;
    int HP = 11;

    public static void main(String[] args) {
        Player p1 = new Player();
        Player p2 = new Player();
        System.out.println(p2.HP - p1.Attack);
    }
}
