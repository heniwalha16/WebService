/**
 * Tutors.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package student;

public class Tutors  implements java.io.Serializable {
    private student.Tutor[] t;

    public Tutors() {
    }

    public Tutors(
           student.Tutor[] t) {
           this.t = t;
    }


    /**
     * Gets the t value for this Tutors.
     * 
     * @return t
     */
    public student.Tutor[] getT() {
        return t;
    }


    /**
     * Sets the t value for this Tutors.
     * 
     * @param t
     */
    public void setT(student.Tutor[] t) {
        this.t = t;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Tutors)) return false;
        Tutors other = (Tutors) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.t==null && other.getT()==null) || 
             (this.t!=null &&
              java.util.Arrays.equals(this.t, other.getT())));
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
        if (getT() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getT());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getT(), i);
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
        new org.apache.axis.description.TypeDesc(Tutors.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://student", "Tutors"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("t");
        elemField.setXmlName(new javax.xml.namespace.QName("http://student", "t"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://student", "Tutor"));
        elemField.setNillable(true);
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
