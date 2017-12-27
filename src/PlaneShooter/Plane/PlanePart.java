package PlaneShooter.Plane;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.CollideType;
import PlaneShooter.Helper.ICollidable;

import java.awt.*;
import java.io.Serializable;

/**
 * 这个类是所有可作为飞机元件的组件（武器、机身）的父类。
 * 需要注意的是，出于打包和恢复时的可靠性的考虑，PlanePart不直接持有它自己在Combat上的绝对位置，
 * 而是持有它和它的父元素的相对位置（dpos）。
 * 在getPos方法中，使用其父元素的位置和相对位置来推出它自己在Combat上的绝对位置并返回。
 */
public abstract class PlanePart implements Serializable,IPlane {
    protected Point dpos;
    protected ICombatUnit parent;

    public abstract String getName();

    public PlanePart(){
        this(new Point(0,0),null);
    }
    public PlanePart(Point dpos, ICombatUnit parent){
        this.dpos=dpos;
        this.parent=parent;
    }
    @Override
    public boolean isAlive() {
        return parent.isAlive();
    }

    @Override
    public void setPos(Point pos) {
        this.dpos.setLocation(pos);
    }

    /**
     * 在这里调用了父元素的getPos方法，计算出这个元素相对Combat的位置。
     * @return
     */
    @Override
    public Point getPos() {
        Point pos;
        if(parent!=null) pos=new Point(parent.getPos());else pos=new Point(0,0);
        pos.translate(dpos.x,dpos.y);
        return pos;
    }

    @Override
    public void onCollide(ICollidable object, Combat combat) {
        if (this.parent instanceof ICollidable)
            ((ICollidable) this.parent).onCollide(object, combat);
    }

    public void setParent(ICombatUnit parent){
        this.parent=parent;
    }

    public CollideType getCollideType() {
        return CollideType.PLANEPART;
    }

    /**
     * 用于在这个组件被安装到飞机上以后更新飞机的属性。
     * 例如，一个矩形机身可以给飞机增加40点最大生命值。
     * @param planeStat
     * @return
     */
    public abstract PlaneStat calculateStats(PlaneStat planeStat);

    public abstract int getPrice();

    public PlanePart getMirroredPart(){
        try {
            return this.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
