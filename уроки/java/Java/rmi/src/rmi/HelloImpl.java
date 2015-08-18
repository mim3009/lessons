package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements IHelloWorld {
    /* UnicastRemoteObject ������������� ����� ���������� ������ 
     * ������� ������ java.lang.Object (equals, hashCode, 
     * toString), ���������� ��� ��������� ��������
     */	
    public HelloImpl() throws RemoteException{
        super();
    }
    
    public String WorHello(String name) throws RemoteException{
        return "Hello " + name;
    }
}
