package serverApp;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
import java.util.Map;

import common.ITutor;
import common.IService;

public class Service extends UnicastRemoteObject implements IService{
	 List <Tutor> Tutors;
	 
	public Service(List<Tutor> tutors) throws RemoteException  {
		super();
		Tutors = tutors;
	}

	public Service() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void register(String user, String mdp,String firstname, String lastname) throws RemoteException {
		// TODO Auto-generated method stub	
		boolean b=false;
		for(Tutor t : Tutors) {
		 if (t.getUser().equals(user)&& t.getMdp().equals(mdp)) {
			 System.out.println("This account is already existed");
		 	b=true;
		 	break;
		} }
		if (b==false) {
			Tutor tut = new Tutor( user,  mdp, firstname,  lastname);
			Tutors.add(tut);
			System.out.println("Registred succefuly");
		}
		
			
	}

	@Override
	public List<ITutor> lookTByName(String firstname, String lastname) throws RemoteException {
		// TODO Auto-generated method stub
		List TutorsList = new ArrayList<Tutor>();
		for(Tutor t : Tutors) {
		 if (t.getFirstname().equals(firstname)&& t.getLastname().equals(lastname))
			 TutorsList.add(t);
		} 
		if (TutorsList.isEmpty()) {System.out.println("There isn't a tutor with this name");}
		return TutorsList;
	}
	@Override
	public List<ITutor> lookTByFirstName(String firstname) throws RemoteException {
		// TODO Auto-generated method stub
		List TutorsList = new ArrayList<Tutor>();
		for(Tutor t : Tutors) {
		 if (t.getFirstname().equals(firstname))
			 TutorsList.add(t);
		} 
		if (TutorsList.isEmpty()) {System.out.println("There isn't a tutor with this first name");}
		return TutorsList;
	}
	@Override
	public List<ITutor> lookTByLastName(String lastname) throws RemoteException {
		// TODO Auto-generated method stub
		List TutorsList = new ArrayList<Tutor>();
		for(Tutor t : Tutors) {
		 if (t.getLastname().equals(lastname))
			 TutorsList.add(t);
		} 
		if (TutorsList.isEmpty()) {System.out.println("There isn't a tutor with this last name");}
		return TutorsList;
	}

	public List<ITutor> getAllTutors() throws RemoteException {
		List TutorsList = new ArrayList<Tutor>();
		TutorsList=Tutors;
		return TutorsList;
	}

	@Override
	public List<ITutor> lookTBySkill(String skill) throws RemoteException {
		// TODO Auto-generated method stub
		List TutorsList = new ArrayList<Tutor>();
		for(Tutor t : Tutors) {
			for(String s : t.getSkills()) {
				 if (s.equals(skill))
					 TutorsList.add(t);
				} 
		}
		if (TutorsList.isEmpty()) {System.out.println("There isn't a tutor with this skill");}
		return TutorsList;
	}

	@Override
	public void login(String user, String mdp) throws RemoteException {
		// TODO Auto-generated method stub
		boolean b=false;
		for(Tutor t : Tutors) {
		 if (t.getUser().equals(user)&& t.getMdp().equals(mdp)) {
			System.out.println("Login Succesful");
		 	b=true;
		 	break;
		} }
		if (b==false) {
			System.out.println("User Not Found");
		}
		
	}
	public Tutor retrieveElement(String firstName, String lastName) throws RemoteException {
		for(Tutor t : Tutors) {
			 if (t.getFirstname().equals(firstName)&& t.getLastname().equals(lastName))
				 return t;
			} 
		Tutor tut=new Tutor();
		return tut ;
	}
	@Override
	public void bookAppointment(String fullName, String firstName, String lastName, String apt) throws RemoteException {
	    // TODO: Implement lookTByName method


	    if (!lookTByName(firstName,lastName).isEmpty()) {
	    	
	    	HashMap< String,String > av = retrieveElement(firstName,lastName).getAvailibality();
	    	/*Iterator<Map.Entry< String,String >> iterator = av.entrySet().iterator();
	    	System.out.println(av.toString());
	    	if (iterator.hasNext()) {
	            // Get the first entry
	            Map.Entry< String,String > entry = iterator.next();

	            // Get the key
	            String firstKey = entry.getKey();

	            System.out.println("First Key: " + firstKey);
	        }
	    	System.out.println(av.containsKey(apt));*/
	    	// retrieveElement(firstName,lastName)

	        if (av.containsKey(apt)) {
	    		//System.out.println("hiha33");
	            String studentName = av.get(apt);
	    		//System.out.println("hiha33");
	            if (studentName.equals("")) {
	                // If the student name is empty, remove the entry with an empty student name and add a new one
	                av.remove(apt);
	                av.put(apt, fullName);
	                retrieveElement(firstName,lastName).setAvailibality(av);
	                //System.out.println(retrieveElement(firstName,lastName).getAvailibality().toString());
	                System.out.println("Appointement Booked.");
	            } else {
	                List<String> waitingList = retrieveElement(firstName,lastName).getWaitingList();
	                waitingList.add(fullName);
	                retrieveElement(firstName,lastName).setWaitingList(waitingList);
	                System.out.println("You are on the waiting list.");
	            }
	        } else {
	            List<String> waitingList = retrieveElement(firstName,lastName).getWaitingList();
	            ///System.out.println("hihaaaaaaaa33");
	            waitingList.add(fullName);
	            //System.out.println("hihaaaaaaaa33");
	            retrieveElement(firstName,lastName).setWaitingList(waitingList);
	            System.out.println("You are on the waiting list.");
	        }
	    } else {
	        System.out.println("Tutor not found.");
	    }
	}


}
