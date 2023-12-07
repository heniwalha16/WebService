package common;

import student.Student;

public interface ISServicetudents {
	public String login(String mail, String mdp) ;
	public String register(String mail, String mdp,String fullName,String Uni);
	public Student retrieveElementt(String mail);
}
