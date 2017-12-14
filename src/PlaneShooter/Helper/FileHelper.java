package PlaneShooter.Helper;

import PlaneShooter.Plane.Plane;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by yuyuyzl on 2017/12/14.
 */
public class FileHelper {
    public static Plane importPlane(String filename){
        Plane plane=null;
        try {
            FileInputStream fs=new FileInputStream(filename);
            ObjectInputStream os=new ObjectInputStream(fs);
            plane=(Plane) os.readObject();
            os.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return plane;
    }
    public static boolean exportPlane(String filename,Plane plane){
        try{
            FileOutputStream fs = new FileOutputStream(filename);
            ObjectOutputStream os =  new ObjectOutputStream(fs);
            os.writeObject(plane);
            os.close();
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
