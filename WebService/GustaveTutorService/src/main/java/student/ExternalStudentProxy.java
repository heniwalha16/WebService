package student;

public class ExternalStudentProxy implements student.ExternalStudent {
  private String _endpoint = null;
  private student.ExternalStudent externalStudent = null;
  
  public ExternalStudentProxy() {
    _initExternalStudentProxy();
  }
  
  public ExternalStudentProxy(String endpoint) {
    _endpoint = endpoint;
    _initExternalStudentProxy();
  }
  
  private void _initExternalStudentProxy() {
    try {
      externalStudent = (new student.ExternalStudentServiceLocator()).getExternalStudent();
      if (externalStudent != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)externalStudent)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)externalStudent)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (externalStudent != null)
      ((javax.xml.rpc.Stub)externalStudent)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public student.ExternalStudent getExternalStudent() {
    if (externalStudent == null)
      _initExternalStudentProxy();
    return externalStudent;
  }
  
  public java.lang.String getFullName() throws java.rmi.RemoteException{
    if (externalStudent == null)
      _initExternalStudentProxy();
    return externalStudent.getFullName();
  }
  
  public java.lang.String getUser() throws java.rmi.RemoteException{
    if (externalStudent == null)
      _initExternalStudentProxy();
    return externalStudent.getUser();
  }
  
  public void setUser(java.lang.String user) throws java.rmi.RemoteException{
    if (externalStudent == null)
      _initExternalStudentProxy();
    externalStudent.setUser(user);
  }
  
  public java.lang.String getMdp() throws java.rmi.RemoteException{
    if (externalStudent == null)
      _initExternalStudentProxy();
    return externalStudent.getMdp();
  }
  
  public student.Tutors lookTByName(java.lang.String firstname, java.lang.String lastname) throws java.rmi.RemoteException{
    if (externalStudent == null)
      _initExternalStudentProxy();
    return externalStudent.lookTByName(firstname, lastname);
  }
  
  public void setMdp(java.lang.String mdp) throws java.rmi.RemoteException{
    if (externalStudent == null)
      _initExternalStudentProxy();
    externalStudent.setMdp(mdp);
  }
  
  public java.lang.String getUniversity() throws java.rmi.RemoteException{
    if (externalStudent == null)
      _initExternalStudentProxy();
    return externalStudent.getUniversity();
  }
  
  public void setUniversity(java.lang.String university) throws java.rmi.RemoteException{
    if (externalStudent == null)
      _initExternalStudentProxy();
    externalStudent.setUniversity(university);
  }
  
  public student.Tutors getAllTutors() throws java.rmi.RemoteException{
    if (externalStudent == null)
      _initExternalStudentProxy();
    return externalStudent.getAllTutors();
  }
  
  public void bookAppointement(java.lang.String fullName, java.lang.String firstName, java.lang.String lastName, java.lang.String startt, java.lang.String endd) throws java.rmi.RemoteException{
    if (externalStudent == null)
      _initExternalStudentProxy();
    externalStudent.bookAppointement(fullName, firstName, lastName, startt, endd);
  }
  
  public student.Tutors lookTByLastName(java.lang.String lastname) throws java.rmi.RemoteException{
    if (externalStudent == null)
      _initExternalStudentProxy();
    return externalStudent.lookTByLastName(lastname);
  }
  
  public student.Tutors lookTByFirstName(java.lang.String firstname) throws java.rmi.RemoteException{
    if (externalStudent == null)
      _initExternalStudentProxy();
    return externalStudent.lookTByFirstName(firstname);
  }
  
  public student.Tutors lookTBySkill(java.lang.String skill) throws java.rmi.RemoteException{
    if (externalStudent == null)
      _initExternalStudentProxy();
    return externalStudent.lookTBySkill(skill);
  }
  
  public void setFullName(java.lang.String fullName) throws java.rmi.RemoteException{
    if (externalStudent == null)
      _initExternalStudentProxy();
    externalStudent.setFullName(fullName);
  }
  
  
}