package bank;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import common.IBankService;


public class BankAccountService extends UnicastRemoteObject implements IBankService {
	List<BankAccount> Accounts;
	public BankAccountService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void register(String RIB, double fund) throws RemoteException {
		// TODO Auto-generated method stub	
		boolean b=false;
		for(BankAccount ac : Accounts) {
		 if (ac.getRib().equals(RIB)) {
			 System.out.println("This account is already existed");
		 	b=true;
		 	break;
		} }
		if (b==false) {
			BankAccount acc = new BankAccount( RIB,fund);
			Accounts.add(acc);
			System.out.println("Registred succefuly");
		}
		
			
	}
	public BankAccountService(List<BankAccount> accounts) throws RemoteException {
		super();
		Accounts = accounts;
	}
	public BankAccount retreiveElement(String rib) throws RemoteException {
		for(BankAccount ac : Accounts) {
			 if (ac.getRib().equals(rib)) {
				 return ac;
			} }
		BankAccount acc=new BankAccount();
		return acc;
	}
	public String pay(String Rib,double rate) throws RemoteException {
		if(retreiveElement(Rib).getFund()< rate) {
			return "Funds are not available";
		}
		else {
			retreiveElement(Rib).setFund(retreiveElement(Rib).getFund()-rate);
			return "Payement Done.";
		}
		
	}

	
}
