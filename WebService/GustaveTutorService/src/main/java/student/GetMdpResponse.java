/**
 * GetMdpResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package student;

public class GetMdpResponse  implements java.io.Serializable {
    private java.lang.String getMdpReturn;

    public GetMdpResponse() {
    }

    public GetMdpResponse(
           java.lang.String getMdpReturn) {
           this.getMdpReturn = getMdpReturn;
    }


    /**
     * Gets the getMdpReturn value for this GetMdpResponse.
     * 
     * @return getMdpReturn
     */
    public java.lang.String getGetMdpReturn() {
        return getMdpReturn;
    }


    /**
     * Sets the getMdpReturn value for this GetMdpResponse.
     * 
     * @param getMdpReturn
     */
    public void setGetMdpReturn(java.lang.String getMdpReturn) {
        this.getMdpReturn = getMdpReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetMdpResponse)) return false;
        GetMdpResponse other = (GetMdpResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getMdpReturn==null && other.getGetMdpReturn()==null) || 
             (this.getMdpReturn!=null &&
              this.getMdpReturn.equals(other.getGetMdpReturn())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getGetMdpReturn() != null) {
            _hashCode += getGetMdpReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetMdpResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://student", ">getMdpResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getMdpReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://student", "getMdpReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
