package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;

import java.awt.*;

public class Tank implements IEnemy,ICombatUnit {
    private boolean alive=true;
    public Tank(Point pos){
        this.pos.setLocation(pos.x,pos.y);
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void paintUnit(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(pos.x-25,pos.y-25,50,50);
    }

    @Override
    public void updateUnit(Combat combat) {
        this.pos.y+=1;
    }
}
