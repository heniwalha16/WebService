/**
 * ExternalStudentService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package student;

public interface ExternalStudentService extends javax.xml.rpc.Service {
    public java.lang.String getExternalStudentAddress();

    public student.ExternalStudent getExternalStudent() throws javax.xml.rpc.ServiceException;

    public student.ExternalStudent getExternalStudent(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
