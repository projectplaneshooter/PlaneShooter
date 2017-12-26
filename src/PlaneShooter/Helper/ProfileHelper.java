package PlaneShooter.Helper;

import PlaneShooter.Combat.CombatStat;
import PlaneShooter.Plane.Plane;

import java.io.*;

public class ProfileHelper implements Serializable {
    private static ProfileHelper INSTANCE=new ProfileHelper();

    private int credits=1000;

    public static void load(){
        try {
            FileInputStream fs=new FileInputStream("Profile.sav");
            ObjectInputStream os=new ObjectInputStream(fs);
            INSTANCE=(ProfileHelper) os.readObject();
            os.close();
        }catch (Exception ex){
            INSTANCE.credits=1000;
        }
    }

    public static void save(){
        try{
            FileOutputStream fs = new FileOutputStream("Profile.sav");
            ObjectOutputStream os =  new ObjectOutputStream(fs);
            os.writeObject(INSTANCE);
            os.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static int getCredits(){
        return INSTANCE.credits;
    }

    public static void addCredit(int sum){
        INSTANCE.credits+=sum;
    }

    public static void processResult(CombatStat combatStat){
        //todo add this
        if(combatStat.endStat==1)addCredit(500);
        else addCredit(100);
        System.out.println("now credit: "+getCredits());
        save();
    }
}
