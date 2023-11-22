package student;
import java.io.Serializable;
import java.util.List;

import common.ITutor;
public class Tutors implements Serializable {
	List<ITutor> tutors;

	public Tutors(List<ITutor> tutors) {
		super();
		this.tutors = tutors;
	}

	public Tutors() {
		super();
		// TODO Auto-generated constructor stub
	}
}
