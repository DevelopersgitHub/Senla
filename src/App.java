import com.senlainc.training.noc_nod.NocNod;
import com.senlainc.training.number.IntegerNumber;
import com.senlainc.training.word_in_text.Sentence;

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
                    Scanner newScanner = new Scanner(System.in);
                    try {
                        System.out.print("\n\tEnter the sentence (space separator): ");
                        String scanStr = newScanner.nextLine();
                        Sentence str = new Sentence(scanStr);
                        System.out.println(str.toString());
                    } catch (InputMismatchException e) {
                        System.out.println("\tEnter a sequence of words!\n");
                    }
                    break;
                case "4":
                    gameStep = false;
                    break;
                default:
                    System.out.println("\tThere is no such menu item!\n");
                    break;
            }
        }
    }

    private static void greeting() {
        System.out.println("\n\t1. Check on integer");
        System.out.println("\t2. NOC and NOD");
        System.out.println("\t3. Count of word in sentence");
        System.out.println("\t4. Exit\n");
        System.out.print("\tSelect a menu item: ");
    }
}
