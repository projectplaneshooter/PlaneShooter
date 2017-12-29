package PlaneShooter.Combat;

public class CombatStat {
    public int endStat=0;
    public int bulletCount=0;
    public int damageTaken=0;
    public int damageDone=0;

    @Override
    public String toString() {
        return "CombatStat{" +
                "endStat=" + endStat +
                ", bulletCount=" + bulletCount +
                ", damageTaken=" + damageTaken +
                ", damageDone=" + damageDone +
                '}';
    }
}
