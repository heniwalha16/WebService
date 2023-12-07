/**
 * Tutor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package student;

public class Tutor  implements java.io.Serializable {
    private java.lang.String[][] availability;

    private java.lang.String firstname;

    private java.lang.String lastname;

    private java.lang.String mail;

    private double rate;

    private double rating;

    private java.lang.String[] skills;

    private java.lang.String[] waitingList;

    public Tutor() {
    }

    public Tutor(
           java.lang.String[][] availability,
           java.lang.String firstname,
           java.lang.String lastname,
           java.lang.String mail,
           double rate,
           double rating,
           java.lang.String[] skills,
           java.lang.String[] waitingList) {
           this.availability = availability;
           this.firstname = firstname;
           this.lastname = lastname;
           this.mail = mail;
           this.rate = rate;
           this.rating = rating;
           this.skills = skills;
           this.waitingList = waitingList;
    }


    /**
     * Gets the availability value for this Tutor.
     * 
     * @return availability
     */
    public java.lang.String[][] getAvailability() {
        return availability;
    }


    /**
     * Sets the availability value for this Tutor.
     * 
     * @param availability
     */
    public void setAvailability(java.lang.String[][] availability) {
        this.availability = availability;
    }


    /**
     * Gets the firstname value for this Tutor.
     * 
     * @return firstname
     */
    public java.lang.String getFirstname() {
        return firstname;
    }


    /**
     * Sets the firstname value for this Tutor.
     * 
     * @param firstname
     */
    public void setFirstname(java.lang.String firstname) {
        this.firstname = firstname;
    }


    /**
     * Gets the lastname value for this Tutor.
     * 
     * @return lastname
     */
    public java.lang.String getLastname() {
        return lastname;
    }


    /**
     * Sets the lastname value for this Tutor.
     * 
     * @param lastname
     */
    public void setLastname(java.lang.String lastname) {
        this.lastname = lastname;
    }


    /**
     * Gets the mail value for this Tutor.
     * 
     * @return mail
     */
    public java.lang.String getMail() {
        return mail;
    }


    /**
     * Sets the mail value for this Tutor.
     * 
     * @param mail
     */
    public void setMail(java.lang.String mail) {
        this.mail = mail;
    }


    /**
     * Gets the rate value for this Tutor.
     * 
     * @return rate
     */
    public double getRate() {
        return rate;
    }


    /**
     * Sets the rate value for this Tutor.
     * 
     * @param rate
     */
    public void setRate(double rate) {
        this.rate = rate;
    }


    /**
     * Gets the rating value for this Tutor.
     * 
     * @return rating
     */
    public double getRating() {
        return rating;
    }


    /**
     * Sets the rating value for this Tutor.
     * 
     * @param rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }


    /**
     * Gets the skills value for this Tutor.
     * 
     * @return skills
     */
    public java.lang.String[] getSkills() {
        return skills;
    }


    /**
     * Sets the skills value for this Tutor.
     * 
     * @param skills
     */
    public void setSkills(java.lang.String[] skills) {
        this.skills = skills;
    }


    /**
     * Gets the waitingList value for this Tutor.
     * 
     * @return waitingList
     */
    public java.lang.String[] getWaitingList() {
        return waitingList;
    }


    /**
     * Sets the waitingList value for this Tutor.
     * 
     * @param waitingList
     */
    public void setWaitingList(java.lang.String[] waitingList) {
        this.waitingList = waitingList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Tutor)) return false;
        Tutor other = (Tutor) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.availability==null && other.getAvailability()==null) || 
             (this.availability!=null &&
              java.util.Arrays.equals(this.availability, other.getAvailability()))) &&
            ((this.firstname==null && other.getFirstname()==null) || 
             (this.firstname!=null &&
              this.firstname.equals(other.getFirstname()))) &&
            ((this.lastname==null && other.getLastname()==null) || 
             (this.lastname!=null &&
              this.lastname.equals(other.getLastname()))) &&
            ((this.mail==null && other.getMail()==null) || 
             (this.mail!=null &&
              this.mail.equals(other.getMail()))) &&
            this.rate == other.getRate() &&
            this.rating == other.getRating() &&
            ((this.skills==null && other.getSkills()==null) || 
             (this.skills!=null &&
              java.util.Arrays.equals(this.skills, other.getSkills()))) &&
            ((this.waitingList==null && other.getWaitingList()==null) || 
             (this.waitingList!=null &&
              java.util.Arrays.equals(this.waitingList, other.getWaitingList())));
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
        if (getAvailability() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAvailability());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAvailability(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFirstname() != null) {
            _hashCode += getFirstname().hashCode();
        }
        if (getLastname() != null) {
            _hashCode += getLastname().hashCode();
        }
        if (getMail() != null) {
            _hashCode += getMail().hashCode();
        }
        _hashCode += new Double(getRate()).hashCode();
        _hashCode += new Double(getRating()).hashCode();
        if (getSkills() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSkills());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSkills(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWaitingList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWaitingList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWaitingList(), i);
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
        new org.apache.axis.description.TypeDesc(Tutor.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://student", "Tutor"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("availability");
        elemField.setXmlName(new javax.xml.namespace.QName("http://student", "availability"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://student", "ArrayOf_xsd_string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://student", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://student", "firstname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://student", "lastname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://student", "mail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://student", "rate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rating");
        elemField.setXmlName(new javax.xml.namespace.QName("http://student", "rating"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("skills");
        elemField.setXmlName(new javax.xml.namespace.QName("http://student", "skills"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://student", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("waitingList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://student", "waitingList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
