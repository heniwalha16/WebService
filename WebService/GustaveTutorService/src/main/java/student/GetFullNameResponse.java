/**
 * GetFullNameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package student;

public class GetFullNameResponse  implements java.io.Serializable {
    private java.lang.String getFullNameReturn;

    public GetFullNameResponse() {
    }

    public GetFullNameResponse(
           java.lang.String getFullNameReturn) {
           this.getFullNameReturn = getFullNameReturn;
    }


    /**
     * Gets the getFullNameReturn value for this GetFullNameResponse.
     * 
     * @return getFullNameReturn
     */
    public java.lang.String getGetFullNameReturn() {
        return getFullNameReturn;
    }


    /**
     * Sets the getFullNameReturn value for this GetFullNameResponse.
     * 
     * @param getFullNameReturn
     */
    public void setGetFullNameReturn(java.lang.String getFullNameReturn) {
        this.getFullNameReturn = getFullNameReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetFullNameResponse)) return false;
        GetFullNameResponse other = (GetFullNameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getFullNameReturn==null && other.getGetFullNameReturn()==null) || 
             (this.getFullNameReturn!=null &&
              this.getFullNameReturn.equals(other.getGetFullNameReturn())));
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
        if (getGetFullNameReturn() != null) {
            _hashCode += getGetFullNameReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetFullNameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://student", ">getFullNameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getFullNameReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://student", "getFullNameReturn"));
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
