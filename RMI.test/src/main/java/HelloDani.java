import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloDani extends Remote {
    String sayHelloWorld(String sName) throws RemoteException;
}
