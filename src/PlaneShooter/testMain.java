package PlaneShooter;

import PlaneShooter.Plane.Plane;
import PlaneShooter.Plane.TestPlane;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by yuyuyzl on 2017/12/14.
 */
public class testMain {
    public static void main(String[] args) {
        Plane testPlane=new TestPlane(new Point(700,100));
        try{
            FileOutputStream fs = new FileOutputStream("testplane.sav");
            ObjectOutputStream os =  new ObjectOutputStream(fs);
            os.writeObject(testPlane);
            os.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
