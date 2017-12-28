package PlaneShooter.Enemy.Weapon.Bullet;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Enemy.EnemyPart;
import PlaneShooter.Helper.CollideType;
import PlaneShooter.Helper.ICollidable;
import PlaneShooter.Helper.ProfileHelper;

import java.awt.*;

public class BulletEnemy extends EnemyPart implements ICollidable {
    private int power;

    public BulletEnemy(Point pos, Point speed, int power) {
        super(pos, speed ,1, null);
        this.power=power;
    }

    public int getPower() {
        double damage=(ProfileHelper.getDLevel() / 10.0 + 1) * power;
        double p=5 * Math.random() + damage - 2;
//        System.out.println(p);
        return (int) p;
    }

    @Override
    public void onCollide(ICollidable object, Combat combat) {
        if (object.getCollideType() != CollideType.PLANEBULLET)
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
    public void paintUnit(Graphics g,Combat combat) {
        g.setColor(Color.BLACK);
        g.drawRect(this.getPos().x-1,this.getPos().y-1,2,2);
    }
    public void updateUnit(Combat combat){
        super.updateUnit(combat);
        if(getPos().getX()>combat.getCombatArea().getWidth()||getPos().getX()<0||
           getPos().getY()>combat.getCombatArea().getHeight()||getPos().getY()<0) this.alive=false;
    }
    
    public CollideType getCollideType() {
        return CollideType.ENEMYBULLET;
    }
}
