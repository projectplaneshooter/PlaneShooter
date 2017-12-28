package PlaneShooter.Plane.Weapon.Projector;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.CollideType;
import PlaneShooter.Helper.ICollidable;
import PlaneShooter.Plane.Weapon.Cannon;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/14.
 * modified by zlc1114
 */
public class CannonBall implements ICombatUnit,ICollidable{
    Point pos;
    boolean alive;
    ICombatUnit parent;
    double speedX,speedY;

    public CannonBall(Cannon parent,double speedX,double speedY){
        this.pos=new Point(parent.getPos());
        this.speedX=speedX;
        this.speedY=speedY;
        this.alive=true;
    }

    @Override
    public boolean isAlive() {
        return alive;
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
    public int getPower() {
        return (int)(8+Math.random()*4);
    }

    @Override
    public void onCollide(ICollidable object, Combat combat) {
        if (object.getCollideType() != CollideType.ENEMYBULLET)
            this.alive=false;
    }

    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public Polygon getContour() {
        Polygon contour=new Polygon();
        contour.addPoint(this.getPos().x - 1,this.getPos().y - 1);
        contour.addPoint(this.getPos().x - 1,this.getPos().y + 1);
        contour.addPoint(this.getPos().x + 1,this.getPos().y + 1);
        contour.addPoint(this.getPos().x + 1,this.getPos().y - 1);
        return contour;
    }

    @Override
    public void paintUnit(Graphics g, Combat combat) {
        g.setColor(Color.darkGray);
        g.drawRect(pos.x-1,pos.y-1,2,2);
//        g.drawPolygon(this.getContour());
    }

    @Override
    public void updateUnit(Combat combat) {
        pos.translate((int)(speedX*combat.getWorldTick())-(int)(speedX*(combat.getWorldTick()-1)),(int)(speedY*combat.getWorldTick())-(int)(speedY*(combat.getWorldTick()-1)));
        if(getPos().getX()>combat.getCombatArea().getWidth()||getPos().getX()<0||
            getPos().getY()>combat.getCombatArea().getHeight()||getPos().getY()<0)this.alive=false;
    }

    public CollideType getCollideType() {
        return CollideType.PLANEBULLET;
    }
}
