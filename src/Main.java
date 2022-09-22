import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int chosenTask;
        boolean isContinue = true;
        do{
            System.out.println("#1 Calculate the time in seconds since the beginning of the day\n" +
                    "#2 Determine the length of the segment in metres\n" +
                    "#3 Define the third digit on the right of this number\n" +
                    "#4 Determine whether a given number is even\n" +
                    "#5 Output a number obtained from a given permutation of digits in reverse order\n" +
                    "#6 Determine train time en route in minutes\n" +
                    "# Any number to end execution");
            chosenTask = inputInteger();
            switch(chosenTask) {
                case (1):
                    countSeconds();
                    break;
                case (2):
                    determineLength();
                    break;
                case (3):
                    determineTheThirdDigitOnTheRight();
                    break;
                case (4):
                    determineIfNumberEven();
                    break;
                case (5):
                    rearrangementReverse();
                    break;
                case (6):
                    DetermineTrainTimeOnTheWay();
                    break;
                default:
                    isContinue = false;
                    break;
            }
        }while(isContinue);
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

    public static void rearrangementReverse(){
        System.out.println("Enter Number: ");
        int number = inputThreeDigitInt();
        System.out.println("Initial number: " + number);
        String strNumber = Integer.toString(number);
        char firstDigit = strNumber.charAt(0);
        char[] charArray = strNumber.toCharArray();
        charArray[0] = charArray[2];
        charArray[2] = firstDigit;
        strNumber = String.valueOf(charArray);
        System.out.println("New number:" + strNumber);
    }

    public static int inputThreeDigitInt() {
        int num = 0;
        boolean isNotCorrect;
        do {
            isNotCorrect = false;
            try {
                Scanner in = new Scanner(System.in);
                num = in.nextInt();
                if (num < 100 || num > 999) {
                    isNotCorrect = true;
                    throw new Exception("Number must be in range[100...999]");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                isNotCorrect = true;
            }
        }while(isNotCorrect);
        return num;
    }

    public static void DetermineTrainTimeOnTheWay(){
        System.out.println("Enter departure hours: ");
        byte hours1 = inputHours();
        System.out.println("Enter departure minutes: ");
        byte minutes1 = inputMinutesOrSeconds();
        byte hours2;
        boolean isNotCorrect;
        do{
            isNotCorrect = false;
            System.out.println("Enter arrival hours: ");
            hours2 = inputHours();
            if (hours2 < hours1){
                isNotCorrect = true;
                System.out.println("Wrong input! departure hours must be less than arrival hours.");
            }
        }while(isNotCorrect);
        System.out.println("Enter arrival minutes: ");
        byte minutes2 = inputMinutesOrSeconds();
        int result = (hours2 - hours1 - 1) * 60 + (60 - minutes1) + minutes2;
        System.out.println("Train time on the way in minutes: " + result);
    }

}