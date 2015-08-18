package rmi;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {

    public static void main(String[] args) {
        // ������ ���� �������� ������������
        System.setProperty("java.security.policy","E:\\rmi.policy");
        // ��������� ������ �� ������� ��������������� ��� �������
        String name = "rmi://localhost/HelloService";
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            /* ������� RMI Registry. ���� ��� �� ���������, 
             * �� ��������� ��������� ��������. RMI Registry �������� 
             * ������� �������� ���������� � ��������� ������� 
             * �������� ������ �� ��������� ������ �� �����
             */
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            IHelloWorld hw = new HelloImpl();
            // ������������ ������ � RMI Registry
            Naming.rebind(name, hw);
            System.out.println("HelloServer bound");
        } catch (Exception e) {
            System.err.println("HelloServer Trouble: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
