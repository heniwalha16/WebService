/**
 * LookTByNameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package student;

public class LookTByNameResponse  implements java.io.Serializable {
    private java.lang.Object[] lookTByNameReturn;

    public LookTByNameResponse() {
    }

    public LookTByNameResponse(
           java.lang.Object[] lookTByNameReturn) {
           this.lookTByNameReturn = lookTByNameReturn;
    }


    /**
     * Gets the lookTByNameReturn value for this LookTByNameResponse.
     * 
     * @return lookTByNameReturn
     */
    public java.lang.Object[] getLookTByNameReturn() {
        return lookTByNameReturn;
    }


    /**
     * Sets the lookTByNameReturn value for this LookTByNameResponse.
     * 
     * @param lookTByNameReturn
     */
    public void setLookTByNameReturn(java.lang.Object[] lookTByNameReturn) {
        this.lookTByNameReturn = lookTByNameReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LookTByNameResponse)) return false;
        LookTByNameResponse other = (LookTByNameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.lookTByNameReturn==null && other.getLookTByNameReturn()==null) || 
             (this.lookTByNameReturn!=null &&
              java.util.Arrays.equals(this.lookTByNameReturn, other.getLookTByNameReturn())));
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
        if (getLookTByNameReturn() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLookTByNameReturn());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLookTByNameReturn(), i);
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
        new org.apache.axis.description.TypeDesc(LookTByNameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://student", ">lookTByNameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lookTByNameReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://student", "lookTByNameReturn"));
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
