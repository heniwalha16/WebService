package bank;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainService {
	 public static void main(String[] args) {
	        try {
	            // Create the registry at default port 1099
	            LocateRegistry.createRegistry(1098);
	            List BankAccount = new ArrayList<BankAccount>();
	            // Create an instance of the server
	            BankAccountService BankAccountServices = new BankAccountService(BankAccount);
	            BankAccountServices.register("Mariam123",5000 );
	            BankAccountServices.register("Heni123", 5);
	            BankAccountServices.register("Feryel123", 300.5);

		  
	            Naming.rebind("rmi://localhost:1098/BankAccountService", BankAccountServices);

	            System.out.println("BankAccount Server is running...");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
