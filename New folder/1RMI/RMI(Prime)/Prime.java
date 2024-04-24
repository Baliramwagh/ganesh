import java.rmi.*;
public interface Prime extends Remote{

public boolean isprime(int x)throws RemoteException;
}
