package PlaneShooter.Enemy.Weapon;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Enemy.Enemy;
import PlaneShooter.Enemy.EnemyPart;
import PlaneShooter.Enemy.Weapon.Bullet.BulletEnemy;
import PlaneShooter.Helper.CollideType;
import PlaneShooter.Helper.ICollidable;

import java.awt.*;

class GunEnemy extends EnemyPart implements IWeapon, ICollidable{
    int power=1;//默认战五渣
    public GunEnemy(Point pos, int power, Enemy parent) {
        super(pos,new Point(),1, parent);
        this.power=power;
    }

    public GunEnemy(Point pos, int health, int power, Enemy parent) {
        super(pos,new Point(),health, parent);
        this.power=power;
    }

    public GunEnemy(Point pos, Point speed, int power, Enemy parent) {
        super(pos, speed,1, parent);
        this.power=power;
    }

    public GunEnemy(Point pos, Point speed, int health, int power, Enemy parent) {
        super(pos, speed, health, parent);
        this.power=power;
    }

    @Override
    public void paintUnit(Graphics g,Combat combat) {
        g.setColor(Color.BLACK);
        Point parentPos=parent.getPos();
        Point parentSpeed=parent.getSpeed();
//        g.drawLine(parentPos.x,parentPos.y,parentPos.x+parentSpeed.x*5,parentPos.y+parentSpeed.y*5);
        g.drawPolygon(this.getContour());
    }

    public Point getPos(){
        Point pos;
        if (parent==null) pos=new Point();
        else pos=parent.getPos();
        pos.translate(this.getSpeed().x,this.getSpeed().y);
        return pos;
    }

    @Override
    public void setSpeed(Point speed) {
        this.speed=speed;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void onCollide(ICollidable object) {
        this.alive=false;
    }

    @Override
    public int getSize(){
        return 20;
    }

    @Override
    public Polygon getContour() {

        Polygon contour=new Polygon();
        double len = parent.getSpeed().distance(0,0);
        double XAddx,XAddy,YAddx,YAddy;
        if (len == 0) {
            XAddx = 1;
            XAddy = 0;
            YAddx = 0;
            YAddy = 1;
        } else{
            XAddx=parent.getSpeed().x / len / Math.sqrt(2);
            XAddy=parent.getSpeed().y / len / Math.sqrt(2);
            YAddx=-XAddy;
            YAddy=XAddx;
        }
        contour.addPoint((int) (this.getPos().x + 10 * XAddx),(int) (this.getPos().y + 10 * XAddy));
        contour.addPoint((int) (this.getPos().x + 5 * XAddx + 2 * YAddx),(int) (this.getPos().y + 5 * XAddy + 2 * YAddy));
        contour.addPoint((int) (this.getPos().x + 2 * YAddx),(int) (this.getPos().y + 2 * YAddy));
        contour.addPoint((int) (this.getPos().x - 2 * YAddx),(int) (this.getPos().y - 2 * YAddy));
        contour.addPoint((int) (this.getPos().x + 5 * XAddx - 2 * YAddx),(int) (this.getPos().y + 5 * XAddy - 2 * YAddy));
        return contour;
    }

    @Override
    public CollideType getCollideType() {
        return CollideType.ENEMYPART;
    }
}
