import java.rmi.*;
import java.rmi.server.*;

public class PrimeRemote extends UnicastRemoteObject implements Prime {

    PrimeRemote() throws RemoteException {
        super();
    }

    public String checkPrime(int num) {
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return "The number " + num + " is prime.";
        } else {
            return "The number " + num + " is not prime.";
        }
    }
}
