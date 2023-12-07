package student;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.ITutor;

public class Tutors  implements Serializable{
	List<ITutor> tutors=new ArrayList<>();
	Tutor[] t;
	public Tutors(List<ITutor> tutors) throws RemoteException {
		super();
		this.tutors = tutors;
		System.out.println(tutors);
		this.t = new Tutor[tutors.size()];
		for (int i = 0; i < tutors.size(); i++) {

            ITutor tut = tutors.get(i);
            this.t[i]=new Tutor();
            this.t[i].Availability= convertHashMapToArray(tut.getAvailability());
            this.t[i].Firstname=tut.getFirstname();
            this.t[i].Lastname=tut.getLastname();
            this.t[i].Mail=tut.getMail();
            this.t[i].rate=tut.getRate();
            this.t[i].rating=tut.getRating();
            this.t[i].Skills=tut.getSkills().toArray(new String[0]);
            this.t[i].WaitingList=tut.getWaitingList().toArray(new String[0]);            
        }
		System.out.println(this.t);
		
	}
	public static String[][] convertHashMapToArray(Map<String, String> hashMap) {
        String[][] resultArray = new String[hashMap.size()][2];

        int index = 0;
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            resultArray[index][0] = entry.getKey();
            resultArray[index][1] = entry.getValue();
            index++;
        }

        return resultArray;
    }
		public Tutors() {
		super();
		// TODO Auto-generated constructor stub
	}
		public Tutor[] getT() {
			return t;
		}
		public void setT(Tutor[] t) {
			this.t = t;
		}


}
