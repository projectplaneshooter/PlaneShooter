package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;

import java.awt.*;

/*障碍物(碰了扣血那种)，可设置血量, */
public class RoundBarrier extends Enemy{
    private int size;
    public RoundBarrier(Point pos, int size){
        super(pos, new Point(0,0),1000);
        this.size = size;
    }

    public RoundBarrier(Point pos, int health, int size) {
        super(pos, new Point(0,0), health);
        this.size = size;
    }

    public void paintUnit(Graphics g,Combat combat) {
        // TODO: 2017/12/26 paint it
        g.drawOval(this.getPos().x,this.getPos().y,this.size * 2,this.size * 2);
    }

    @Override
    public int getPower() {
        return 2;
    }

    public int getSize(){
        return this.size;
    }

    @Override
    public Polygon getContour() {
        Polygon contour = new Polygon();
        contour.addPoint(this.pos.x - this.size,this.pos.y - this.size);
        contour.addPoint(this.pos.x - this.size,this.pos.y + this.size);
        contour.addPoint(this.pos.x + this.size,this.pos.y + this.size);
        contour.addPoint(this.pos.x + this.size,this.pos.y - this.size);
        return contour;
    }
}
