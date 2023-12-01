package common;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ISServicetudents extends Remote{
	public String login(String mail, String mdp) throws RemoteException;
	public String register(String mail, String mdp,String fullName,String Uni) throws RemoteException;
	public IStudent retrieveElement(String mail) throws RemoteException;
}
