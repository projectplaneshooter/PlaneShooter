package PlaneShooter.Helper;

import PlaneShooter.Combat.CombatStat;
import PlaneShooter.Plane.Plane;

import java.io.*;

public class ProfileHelper implements Serializable {
    private static ProfileHelper INSTANCE=new ProfileHelper();

    private int credits=1000;
    private int dLevel=0;

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
        if(combatStat.endStat==1){
            addCredit(300);
            addDLevel(1);
        }
        else {
            addCredit(10);
            addDLevel(-2);
        }
        save();
    }

    public static int getDLevel(){
        return INSTANCE.dLevel;
    }

    public static void addDLevel(int sum){
        INSTANCE.dLevel+=sum;
        if(INSTANCE.dLevel<0)INSTANCE.dLevel=0;
    }
}
