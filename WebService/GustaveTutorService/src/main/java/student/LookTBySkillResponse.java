/**
 * LookTBySkillResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package student;

public class LookTBySkillResponse  implements java.io.Serializable {
    private java.lang.Object[] lookTBySkillReturn;

    public LookTBySkillResponse() {
    }

    public LookTBySkillResponse(
           java.lang.Object[] lookTBySkillReturn) {
           this.lookTBySkillReturn = lookTBySkillReturn;
    }


    /**
     * Gets the lookTBySkillReturn value for this LookTBySkillResponse.
     * 
     * @return lookTBySkillReturn
     */
    public java.lang.Object[] getLookTBySkillReturn() {
        return lookTBySkillReturn;
    }


    /**
     * Sets the lookTBySkillReturn value for this LookTBySkillResponse.
     * 
     * @param lookTBySkillReturn
     */
    public void setLookTBySkillReturn(java.lang.Object[] lookTBySkillReturn) {
        this.lookTBySkillReturn = lookTBySkillReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LookTBySkillResponse)) return false;
        LookTBySkillResponse other = (LookTBySkillResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.lookTBySkillReturn==null && other.getLookTBySkillReturn()==null) || 
             (this.lookTBySkillReturn!=null &&
              java.util.Arrays.equals(this.lookTBySkillReturn, other.getLookTBySkillReturn())));
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
        if (getLookTBySkillReturn() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLookTBySkillReturn());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLookTBySkillReturn(), i);
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
        new org.apache.axis.description.TypeDesc(LookTBySkillResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://student", ">lookTBySkillResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lookTBySkillReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://student", "lookTBySkillReturn"));
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
