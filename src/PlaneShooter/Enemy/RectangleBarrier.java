package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;

import java.awt.*;

public class RectangleBarrier extends Enemy{
    private Polygon contour = new Polygon();
    public RectangleBarrier(Point pos, int left, int up, int right, int down){
        super(pos, new Point(0,0), 1000);
        contour.addPoint(left,up);
        contour.addPoint(right,up);
        contour.addPoint(right,down);
        contour.addPoint(left,down);
    }

    public RectangleBarrier(Point pos, int left, int up, int right, int down, int health){
        super(pos, new Point(0,0), health);
        contour.addPoint(left,up);
        contour.addPoint(right,up);
        contour.addPoint(right,down);
        contour.addPoint(left,down);
    }

    public void paintUnit(Graphics g,Combat combat) {
        // TODO: 2017/12/26 paint it
        g.drawPolygon(this.getContour());
    }
    
    @Override
    public int getPower() {
        return 2;
    }

    public int getSize(){
        return 100000;
    }

    @Override
    public Polygon getContour() {
        return contour;
    }
}
