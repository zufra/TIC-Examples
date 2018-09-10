import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloWorldRemoteService {

    public static void main(String[] args) throws RemoteException {


        String name = "HelloWorldService";
        HelloDani oHelloWorldService = new Service();
        HelloDani oStub = (HelloDani) UnicastRemoteObject.exportObject(oHelloWorldService, 0);

        Registry oRegistry = LocateRegistry.createRegistry(3399);
        oRegistry.rebind(name, oStub);

        System.out.println("Levanto");

//        try {
//            oStub = (HelloDani)
//                    UnicastRemoteObject.exportObject(oHelloWorldService,
//                            0);
//            Registry oRegistry;
//            oRegistry = LocateRegistry.createRegistry(3399);
//            oRegistry.rebind(name, oStub);
//
//            System.out.println("Levanto");
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }



    }
}
