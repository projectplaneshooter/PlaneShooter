package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Enemy.Route.Route;
import PlaneShooter.Enemy.Route.RouteFactory;
import PlaneShooter.Helper.CollideType;
import PlaneShooter.Helper.ICollidable;

import java.awt.*;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * 和plane有点区别，我觉得body不能改，这样我就把enemy自带一个body
 */
public abstract class Enemy extends EnemyPart implements IEnemy {
    LinkedList<EnemyPart> components=new LinkedList<>();
    private LinkedList<Route> routes;
    public Enemy(Point pos, Point speed, int health) {
        super(pos, speed, health, null);
    }

    /**
     * 这个方法传入将一个enemy加上了改变方向的方式
     * @param routes
     * @return Enemy
     */
    public Enemy addRoute(LinkedList<Route> routes){
        this.routes=new LinkedList<>();
        for (Route route:routes)
            this.routes.add(new Route(route));
        return this;
    }

    @Override
    public void paintUnit(Graphics g, Combat combat) {
        for (EnemyPart unit:components){
            unit.paintUnit(g,combat);
        }
        g.setColor(Color.black);
        g.drawString("HP:"+String.valueOf(health),pos.x-20,pos.y+40);
    }

    public void updateUnit(Combat combat) {
        if(getPos().getX()>combat.getCombatArea().getWidth()+100 || getPos().getX()<-100||
           getPos().getY()>combat.getCombatArea().getHeight()+100 || getPos().getY()<-100) this.alive=false;
        RouteFactory.turnAround(this,routes);
        super.updateUnit(combat);
        for (ICombatUnit unit:components)
            unit.updateUnit(combat);
        Predicate<ICombatUnit> p=(u) -> !u.isAlive();//组件打掉了
        components.removeIf(p);
    }

    @Override
    public void setSpeed(Point speed) {
        this.speed = speed;
    }

    void addComponent(EnemyPart unit){
        components.add(unit);
    }

    public CollideType getCollideType() {
        return CollideType.ENEMY;
    }

    public LinkedList<EnemyPart> getComponents(){
        return components;
    }

    @Override
    public void onCollide(ICollidable object, Combat combat) {
        int dmg=object.getPower();
        this.health-=dmg;
        combat.combatStat.damageDone+=dmg;
    }
}
