import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        countSeconds();
        determineLength();
        determineTheThirdDigitOnTheRight();
        determineIfNumberEven();
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
        double fathoms = inputDouble();
        System.out.println("Enter yards: ");
        double yards = inputDouble();
        System.out.println("Enter vershoks: ");
        double vershoks = inputDouble();
        double result = (fathoms * 48 + yards * 16 + vershoks) * vershokInMeters;
        System.out.println("Length in meters: " + result);
    }

    public static double inputDouble() {
        double num = 0;
        boolean isNotCorrect;
        do {
            isNotCorrect = false;
            try {
                Scanner in = new Scanner(System.in);
                num = in.nextDouble();
            } catch (Exception ex) {
                ex.printStackTrace();
                isNotCorrect = true;
            }
        }while(isNotCorrect);
        return num;
    }

    public static void determineTheThirdDigitOnTheRight(){
        System.out.println("Enter Number >=100: ");
        int number = inputNumber();
        String strNumber = Integer.toString(number);
        int len = strNumber.length();
        System.out.println("The third digit on the right: " + strNumber.charAt(len - 3));
    }

    public static int inputNumber(){
        int num = 0;
        boolean isNotCorrect;
        do {
            isNotCorrect = false;
            try {
                Scanner in = new Scanner(System.in);
                num = in.nextInt();
                if (num < 100) {
                    isNotCorrect = true;
                    throw new Exception("Number must be in range[100...]");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                isNotCorrect = true;
            }
        }while(isNotCorrect);
        return num;
    }

    public static void determineIfNumberEven(){
        System.out.println("Enter Number: ");
        int number = inputInteger();
        if (number % 2 == 1){
            System.out.println("The number is odd");
        }else{
            System.out.println("The number is even");
        }
    }

    public static int inputInteger() {
        int num = 0;
        boolean isNotCorrect;
        do {
            isNotCorrect = false;
            try {
                Scanner in = new Scanner(System.in);
                num = in.nextInt();
            } catch (Exception ex) {
                ex.printStackTrace();
                isNotCorrect = true;
            }
        }while(isNotCorrect);
        return num;
    }

}