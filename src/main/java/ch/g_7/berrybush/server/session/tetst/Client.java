package ch.g_7.berrybush.server.session.tetst;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {


    private static final String DOMAIN = "rmi://localhost:1109/";

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        IGetPlayerPositionService iGetPlayerPositionService = (IGetPlayerPositionService) Naming.lookup(DOMAIN + "playerPosition");
        System.out.println(iGetPlayerPositionService.getPositionOfPlayer("Peter"));

    }
}
