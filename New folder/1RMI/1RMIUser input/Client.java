import java.rmi.*;
import java.util.Scanner;

public class Client extends Thread {
    private Scanner scanner;

    public Client() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        try {
            Add obj = (Add) Naming.lookup("rmi://localhost/guru");

            // Take user input for operands
            System.out.println(Thread.currentThread().getName() + " Enter two numbers:");
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            System.out.println(Thread.currentThread().getName() + " Addition is: " + obj.add(num1, num2));
            System.out.println(Thread.currentThread().getName() + " Subtraction is: " + obj.sub(num1, num2));
            System.out.println(Thread.currentThread().getName() + " Multiplication is: " + obj.mul(num1, num2));
            System.out.println(Thread.currentThread().getName() + " Division is: " + obj.div(num1, num2));
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            scanner.close(); // Close the scanner to avoid resource leak
        }
    }

    public static void main(String args[]) {

        Client c1 = new Client();
        c1.setName("Thread 1");
        c1.start();

        Client c2 = new Client();
        c2.setName("Thread 2");
        c2.start();
    }
}
