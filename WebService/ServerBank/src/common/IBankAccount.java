package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBankAccount extends Remote{
	public void setFund(double fund)throws RemoteException;
	public double getFund()throws RemoteException;
	public void setRib(String rib) throws RemoteException;
	public String getRib() throws RemoteException;
}
