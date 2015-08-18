package rmi;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {

    public static void main(String[] args) {
        // задаем файл политики безопасности
        System.setProperty("java.security.policy","E:\\rmi.policy");
        // Указываем сервер на котором регистрируеться имя сервиса
        String name = "rmi://localhost/HelloService";
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            /* создаем RMI Registry. Если его не создавать, 
             * то требуется запускать отдельно. RMI Registry является 
             * простым сервисом именований и позволяет клиенту 
             * получить ссылку на удаленный объект по имени
             */
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            IHelloWorld hw = new HelloImpl();
            // регистрируем объект в RMI Registry
            Naming.rebind(name, hw);
            System.out.println("HelloServer bound");
        } catch (Exception e) {
            System.err.println("HelloServer Trouble: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
