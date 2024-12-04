import java.util.*;

class MilStaff {
    private int uniqueID;
    private String name;
    private int birthday;

    public MilStaff(int uniqueID, String name, int birthday) {
        this.uniqueID = uniqueID;
        this.name = name;
        this.birthday = birthday;
    }

    public MilStaff() {
        this.uniqueID = new Random().nextInt(1000000) + 1; 
        this.name = generateRandomName();
        this.birthday = new Random().nextInt(365) + 1; 
    }

    public int getUniqueID() {
        return uniqueID;
    }

    private String generateRandomName() {
        String[] names = {"John", "Jane"};
        return names[new Random().nextInt(names.length)];
    }

    public void printInfo() {
        System.out.println("UniqueID: " + uniqueID + "\nName: " + name + "\nBirthday: " + birthday);
    }
}

class ArmyStaff extends MilStaff {
    private String armyID;

    public ArmyStaff() {
        super();
        this.armyID = "A" + (new Random().nextInt(1000000) + 1);
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("ArmyID: " + armyID);
    }
}

class NavyStaff extends MilStaff {
    private String navyID;

    public NavyStaff() {
        super();
        this.navyID = "N" + (new Random().nextInt(1000000) + 1);
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("NavyID: " + navyID);
    }
}

class AirForceStaff extends MilStaff {
    private String airForceID;

    public AirForceStaff() {
        super();
        this.airForceID = "F" + (new Random().nextInt(1000000) + 1);
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("AirForceID: " + airForceID);
    }
}

public class Processing {
    public static void main(String[] args) {
        MilStaff[] staffArray = new MilStaff[30];
        Random random = new Random();

        for (int i = 0; i < staffArray.length; i++) {
            int branch = random.nextInt(3);
            if (branch == 0) {
                staffArray[i] = new ArmyStaff();
            } else if (branch == 1) {
                staffArray[i] = new NavyStaff();
            } else {
                staffArray[i] = new AirForceStaff();
            }
        }

        for (int i = 0; i < staffArray.length - 1; i++){
            for (int j = i + 1; j < staffArray.length; j++){
                if (staffArray[i].getUniqueID() > staffArray[j].getUniqueID()){
                    MilStaff temp = staffArray[i];
                    staffArray[i] = staffArray[j];
                    staffArray[j] = temp;
                }
            }
        }

        System.out.println("--Military Staff ID's--");
        for (int i = 0; i < staffArray.length; i++){
            staffArray[i].printInfo();
            System.out.println();
        }
    }
}
