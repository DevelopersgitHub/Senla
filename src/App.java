import com.senlainc.training.noc_nod.NocNod;
import com.senlainc.training.number.IntegerNumber;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        boolean gameStep = true;
        System.out.println("\n\t\t\t***Let's check the tasks***\n");

        while (gameStep) {
            App.greeting();
            Scanner scanner = new Scanner(System.in);
            String task = scanner.next();
            switch (task) {
                case "1":
                    try {
                        IntegerNumber number;
                        System.out.print("\n\tEnter the integer: ");
                        int num = scanner.nextInt();
                        number = new IntegerNumber(num);
                        System.out.println("\tNumber: " + number.toString());
                    } catch (InputMismatchException e) {
                        System.out.println("\tEnter an integer!\n");
                    }
                    break;
                case "2":
                    try {
                        System.out.print("\n\tEnter the first integer: ");
                        int num = scanner.nextInt();
                        System.out.print("\tEnter the second integer: ");
                        int num1 = scanner.nextInt();
                        NocNod numberNN = new NocNod(num, num1);
                        System.out.println(numberNN.toString());
                    } catch (InputMismatchException e) {
                        System.out.println("\tEnter an integer!\n");
                    }
                    break;
                case "3":
                    gameStep = false;
                    break;
                default:
                    System.out.println("\tThere is no such menu item!\n");
                    break;
            }
        }
    }

    private static void greeting() {
        System.out.println("\t1. Check on integer");
        System.out.println("\t2. Exit\n");
        System.out.print("\tSelect a menu item: ");
    }
}
