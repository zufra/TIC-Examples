import java.rmi.RemoteException;

public class Service implements HelloDani {

    @Override
    public String sayHelloWorld(String sName) throws RemoteException {
        return "Hello World " + sName;
    }
}
