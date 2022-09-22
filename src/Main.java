import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        countSeconds();
        determineLength();
    }
    public static void countSeconds(){
        System.out.println("Enter hours: ");
        byte hours = inputHours();
        System.out.println("Enter minutes: ");
        byte minutes = inputMinutesOrSeconds();
        System.out.println("Enter seconds: ");
        byte seconds = inputMinutesOrSeconds();
        int result = hours * 3600 + minutes * 60 + seconds;
        System.out.println("Time in seconds since the beginning of the day: " + result);
    }
    public static byte inputHours() {
        byte hours = 0;
        boolean isNotCorrect;
        do {
            isNotCorrect = false;
            try {
                Scanner in = new Scanner(System.in);
                hours = in.nextByte();
                if (hours > 24 || hours < 0) {
                    isNotCorrect = true;
                    throw new Exception("Number must be in range[0..24]");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                isNotCorrect = true;
            }
        }while(isNotCorrect);
        return hours;
    }
    public static byte inputMinutesOrSeconds(){
        byte num = 0;
        boolean isNotCorrect;
        do {
            isNotCorrect = false;
            try {
                Scanner in = new Scanner(System.in);
                num = in.nextByte();
                if (num > 60 || num < 0) {
                    isNotCorrect = true;
                    throw new Exception("Number must be in range[0..24]");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                isNotCorrect = true;
            }
        }while(isNotCorrect);
        return num;
    }

    public static void determineLength(){
        final double vershokInMeters = 0.04445;
        System.out.println("Enter fathoms: ");
        double fathoms = inputNum();
        System.out.println("Enter yards: ");
        double yards = inputNum();
        System.out.println("Enter vershoks: ");
        double vershoks = inputNum();
        double result = (fathoms * 48 + yards * 16 + vershoks) * vershokInMeters;
        System.out.println("Length in meters: " + result);
    }

    public static double inputNum() {
        double num = 0;
        boolean isNotCorrect;
        do {
            isNotCorrect = false;
            try {
                Scanner in = new Scanner(System.in);
                num = in.nextByte();
            } catch (Exception ex) {
                ex.printStackTrace();
                isNotCorrect = true;
            }
        }while(isNotCorrect);
        return num;
    }


}