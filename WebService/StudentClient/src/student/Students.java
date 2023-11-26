package student;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Students extends UnicastRemoteObject{
	 List <Student> students;
	 public Students(List<Student> students) throws RemoteException{
		super();
		this.students = students;
	}
	public String register(String mail, String mdp,String fullName,String Uni) throws RemoteException {
			// TODO Auto-generated method stub	
			boolean b=false;
			for(Student st : students) {
			 if (st.getMail().equals(mail)&& st.getMdp().equals(mdp)) {
			 	b=true;
			 	return "This account is already existed";
			} }
			if (b==false) {
				Student std = new Student( mail,  mdp, fullName,Uni);
				students.add(std);
				return "Registred succefuly";
			}
			return "";
				
		}
	 public String login(String mail, String mdp) throws RemoteException {
			// TODO Auto-generated method stub
			boolean b=false;
			for(Student st : students) {
			 if (st.getMail().equals(mail)) {
			 	b=true;
			 	return "Login Succesful";
			} }
			if (b==false) {
				return "User Not Found";
			}
			return "";
			
		}
	 public Student retrieveElement(String mail) throws RemoteException {
			for(Student st : students) {
				 if (st.getMail().equals(mail))
					 return st;
				} 
			Student tut=new Student();
			return tut ;
		}
}
