package PlaneShooter.Plane.Weapon.Projector;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.ICollidable;
import PlaneShooter.Plane.Weapon.Cannon;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/14.
 */
public class CannonBall implements ICombatUnit,ICollidable {
    Point pos;
    ICombatUnit parent;
    public Combat combat;
    int speedX,speedY;

    public CannonBall(Cannon parent,Combat combat,int speedX,int speedY){
        this.pos=new Point(parent.getPos());
        this.speedX=speedX;
        this.speedY=speedY;
        this.combat=combat;
    }

    @Override
    public boolean isAlive() {
        return pos.x>=0&&pos.x<=1000&&pos.y>=0&&pos.y<=600;
    }

    @Override
    public void setPos(Point pos) {
        this.pos.setLocation(pos);
    }

    @Override
    public Point getPos() {
        return pos;
    }

    @Override
    public void paintUnit(Graphics g, Combat combat) {
        g.setColor(Color.darkGray);
        g.drawRect(pos.x-1,pos.y-1,2,2);
    }

    @Override
    public void updateUnit(Combat combat) {
        pos.translate(speedX,speedY);
    }
}
