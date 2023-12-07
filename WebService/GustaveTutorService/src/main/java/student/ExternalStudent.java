/**
 * ExternalStudent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package student;

public interface ExternalStudent extends java.rmi.Remote {
    public java.lang.String getMdp() throws java.rmi.RemoteException;
    public student.Tutors lookTByName(java.lang.String firstname, java.lang.String lastname) throws java.rmi.RemoteException;
    public java.lang.String bookAppointement(java.lang.String mail, java.lang.String fullName, java.lang.String apt) throws java.rmi.RemoteException;
    public void giveFeedback(java.lang.String feedback, java.lang.String mail) throws java.rmi.RemoteException;
    public student.Tutors getAllTutors() throws java.rmi.RemoteException;
    public void setMdp(java.lang.String mdp) throws java.rmi.RemoteException;
    public void setFullName(java.lang.String fullName) throws java.rmi.RemoteException;
    public student.Tutors lookTByFirstName(java.lang.String firstname) throws java.rmi.RemoteException;
    public void setUniversity(java.lang.String university) throws java.rmi.RemoteException;
    public java.lang.String getUniversity() throws java.rmi.RemoteException;
    public student.Tutors lookTByLastName(java.lang.String lastname) throws java.rmi.RemoteException;
    public student.Tutors lookTBySkill(java.lang.String skill) throws java.rmi.RemoteException;
    public java.lang.String getFullName() throws java.rmi.RemoteException;
    public java.lang.String getUser() throws java.rmi.RemoteException;
    public void setUser(java.lang.String user) throws java.rmi.RemoteException;
}
