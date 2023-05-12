public class Enemy {
    private int DMG;
    private int HP;
    private int XP;

    public void setDMG(int DMG) {
        this.DMG = DMG;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public int getDMG() {
        return DMG;
    }

    public int getHP() {
        return HP;
    }

    public int getXP() { return XP; }

    public void TakeDamage(int DMG){
        this.HP -= DMG;
    }
}
