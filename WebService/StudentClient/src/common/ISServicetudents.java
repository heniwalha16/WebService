package common;
public interface ISServicetudents {
	public String login(String mail, String mdp) ;
	public String register(String mail, String mdp,String fullName,String Uni);
	public IStudent retrieveElement(String mail);
}
