package bank;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.IBankAccount;

public class BankAccount extends UnicastRemoteObject implements IBankAccount {
	String rib;
	double fund;
	public BankAccount() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(String rib, double fund) throws RemoteException {
		super();
		this.rib = rib;
		this.fund = fund;
	}
	public String getRib() throws RemoteException{
		return rib;
	}
	public void setRib(String rib) throws RemoteException{
		this.rib = rib;
	}
	public double getFund()throws RemoteException {
		return fund;
	}
	public void setFund(double fund)throws RemoteException {
		this.fund = fund;
	}
	
}
