/**
 * BankServerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package bank;

public class BankServerServiceLocator extends org.apache.axis.client.Service implements bank.BankServerService {

    public BankServerServiceLocator() {
    }


    public BankServerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BankServerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BankServer
    private java.lang.String BankServer_address = "http://localhost:8070/BankService/services/BankServer";

    public java.lang.String getBankServerAddress() {
        return BankServer_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BankServerWSDDServiceName = "BankServer";

    public java.lang.String getBankServerWSDDServiceName() {
        return BankServerWSDDServiceName;
    }

    public void setBankServerWSDDServiceName(java.lang.String name) {
        BankServerWSDDServiceName = name;
    }

    public bank.BankServer getBankServer() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BankServer_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBankServer(endpoint);
    }

    public bank.BankServer getBankServer(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            bank.BankServerSoapBindingStub _stub = new bank.BankServerSoapBindingStub(portAddress, this);
            _stub.setPortName(getBankServerWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBankServerEndpointAddress(java.lang.String address) {
        BankServer_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (bank.BankServer.class.isAssignableFrom(serviceEndpointInterface)) {
                bank.BankServerSoapBindingStub _stub = new bank.BankServerSoapBindingStub(new java.net.URL(BankServer_address), this);
                _stub.setPortName(getBankServerWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BankServer".equals(inputPortName)) {
            return getBankServer();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bank", "BankServerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://bank", "BankServer"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BankServer".equals(portName)) {
            setBankServerEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
