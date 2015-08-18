/**
 * StudentInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ua.cn.stu.www.StudentService;

public class StudentInfo  implements java.io.Serializable {
    private java.lang.String name;

    private java.lang.String sex;

    private boolean boss;

    public StudentInfo() {
    }

    public StudentInfo(
           java.lang.String name,
           java.lang.String sex,
           boolean boss) {
           this.name = name;
           this.sex = sex;
           this.boss = boss;
    }


    /**
     * Gets the name value for this StudentInfo.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this StudentInfo.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the sex value for this StudentInfo.
     * 
     * @return sex
     */
    public java.lang.String getSex() {
        return sex;
    }


    /**
     * Sets the sex value for this StudentInfo.
     * 
     * @param sex
     */
    public void setSex(java.lang.String sex) {
        this.sex = sex;
    }


    /**
     * Gets the boss value for this StudentInfo.
     * 
     * @return boss
     */
    public boolean isBoss() {
        return boss;
    }


    /**
     * Sets the boss value for this StudentInfo.
     * 
     * @param boss
     */
    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof StudentInfo)) return false;
        StudentInfo other = (StudentInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.sex==null && other.getSex()==null) || 
             (this.sex!=null &&
              this.sex.equals(other.getSex()))) &&
            this.boss == other.isBoss();
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getSex() != null) {
            _hashCode += getSex().hashCode();
        }
        _hashCode += (isBoss() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StudentInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.stu.cn.ua/StudentService/", "StudentInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sex");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Sex"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("boss");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Boss"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
