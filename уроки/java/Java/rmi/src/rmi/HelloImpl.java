package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements IHelloWorld {
    /* UnicastRemoteObject предоставляет такую реализацию многих 
     * методов класса java.lang.Object (equals, hashCode, 
     * toString), подходящие для удаленных объектов
     */	
    public HelloImpl() throws RemoteException{
        super();
    }
    
    public String WorHello(String name) throws RemoteException{
        return "Hello " + name;
    }
}
