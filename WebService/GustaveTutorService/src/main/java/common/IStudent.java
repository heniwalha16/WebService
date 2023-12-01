package common;
import java.rmi.*;
import java.time.Instant;
import java.util.HashMap;
public interface IStudent extends Remote{
	public String getMail() throws RemoteException;
	public void setMail(String mail) throws RemoteException;
	public String getMdp() throws RemoteException;
	public void setMdp(String mdp) throws RemoteException;
	public void setUniversity(String university)throws RemoteException;
	public String getUniversity() throws RemoteException;
	public void setFullName(String fullName)throws RemoteException;
	public String getFullName()throws RemoteException;
}
