/**
 * LookTByLastNameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package student;

public class LookTByLastNameResponse  implements java.io.Serializable {
    private java.lang.Object[] lookTByLastNameReturn;

    public LookTByLastNameResponse() {
    }

    public LookTByLastNameResponse(
           java.lang.Object[] lookTByLastNameReturn) {
           this.lookTByLastNameReturn = lookTByLastNameReturn;
    }


    /**
     * Gets the lookTByLastNameReturn value for this LookTByLastNameResponse.
     * 
     * @return lookTByLastNameReturn
     */
    public java.lang.Object[] getLookTByLastNameReturn() {
        return lookTByLastNameReturn;
    }


    /**
     * Sets the lookTByLastNameReturn value for this LookTByLastNameResponse.
     * 
     * @param lookTByLastNameReturn
     */
    public void setLookTByLastNameReturn(java.lang.Object[] lookTByLastNameReturn) {
        this.lookTByLastNameReturn = lookTByLastNameReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LookTByLastNameResponse)) return false;
        LookTByLastNameResponse other = (LookTByLastNameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.lookTByLastNameReturn==null && other.getLookTByLastNameReturn()==null) || 
             (this.lookTByLastNameReturn!=null &&
              java.util.Arrays.equals(this.lookTByLastNameReturn, other.getLookTByLastNameReturn())));
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
        if (getLookTByLastNameReturn() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLookTByLastNameReturn());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLookTByLastNameReturn(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LookTByLastNameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://student", ">lookTByLastNameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lookTByLastNameReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://student", "lookTByLastNameReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://student", "item"));
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
