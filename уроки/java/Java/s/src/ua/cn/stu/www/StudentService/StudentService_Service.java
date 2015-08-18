/**
 * StudentService_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ua.cn.stu.www.StudentService;

public interface StudentService_Service extends javax.xml.rpc.Service {
    public java.lang.String getStudentServiceSOAPAddress();

    public ua.cn.stu.www.StudentService.StudentService_PortType getStudentServiceSOAP() throws javax.xml.rpc.ServiceException;

    public ua.cn.stu.www.StudentService.StudentService_PortType getStudentServiceSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
