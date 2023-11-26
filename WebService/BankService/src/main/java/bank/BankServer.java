package bank;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import common.IBankService;

public class BankServer {
	String fullName;
	String rib;
	double fund;
	public BankServer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String pay(String rib,double rate) throws MalformedURLException, RemoteException, NotBoundException {
		IBankService bs=(IBankService) Naming.lookup("rmi://localhost:1098/BankAccountService");
		return bs.pay(rib, rate);
		
	}
	
}
