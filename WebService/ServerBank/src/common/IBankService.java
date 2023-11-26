package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBankService extends Remote{

	void register(String RIB, double fund) throws RemoteException;
	public String pay(String Rib,double rate) throws RemoteException;
}
