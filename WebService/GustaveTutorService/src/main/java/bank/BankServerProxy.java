package bank;

public class BankServerProxy implements bank.BankServer {
  private String _endpoint = null;
  private bank.BankServer bankServer = null;
  
  public BankServerProxy() {
    _initBankServerProxy();
  }
  
  public BankServerProxy(String endpoint) {
    _endpoint = endpoint;
    _initBankServerProxy();
  }
  
  private void _initBankServerProxy() {
    try {
      bankServer = (new bank.BankServerServiceLocator()).getBankServer();
      if (bankServer != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bankServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bankServer)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bankServer != null)
      ((javax.xml.rpc.Stub)bankServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public bank.BankServer getBankServer() {
    if (bankServer == null)
      _initBankServerProxy();
    return bankServer;
  }
  
  public java.lang.String pay(java.lang.String rib, double rate) throws java.rmi.RemoteException{
    if (bankServer == null)
      _initBankServerProxy();
    return bankServer.pay(rib, rate);
  }
  
  
}