package PlaneShooter.Helper;

import PlaneShooter.Plane.Plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

/**
 * 这里有一些关于文件读写的函数。
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

    public static Image loadImageFromFile(String pathname){
        File src=new File(pathname);
        try {
            return ImageIO.read(src);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
