import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteDani {

    public static void main(String[] args) throws RemoteException {

        String sObjectService = "HelloWorldService";

        Registry oRegitry = LocateRegistry.getRegistry(3399);
        HelloDani oHelloWorld = null;
        try {
            oHelloWorld = (HelloDani) oRegitry.lookup(sObjectService);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        String sReturn = oHelloWorld.sayHelloWorld("Daniel");
        System.out.println(sReturn);


    }



}
