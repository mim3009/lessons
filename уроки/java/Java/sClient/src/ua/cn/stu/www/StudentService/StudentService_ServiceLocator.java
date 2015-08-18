/**
 * StudentService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ua.cn.stu.www.StudentService;

public class StudentService_ServiceLocator extends org.apache.axis.client.Service implements ua.cn.stu.www.StudentService.StudentService_Service {

    public StudentService_ServiceLocator() {
    }


    public StudentService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StudentService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StudentServiceSOAP
    private java.lang.String StudentServiceSOAP_address = "http://localhost:8080/lw6/services/StudentServiceSOAP";

    public java.lang.String getStudentServiceSOAPAddress() {
        return StudentServiceSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StudentServiceSOAPWSDDServiceName = "StudentServiceSOAP";

    public java.lang.String getStudentServiceSOAPWSDDServiceName() {
        return StudentServiceSOAPWSDDServiceName;
    }

    public void setStudentServiceSOAPWSDDServiceName(java.lang.String name) {
        StudentServiceSOAPWSDDServiceName = name;
    }

    public ua.cn.stu.www.StudentService.StudentService_PortType getStudentServiceSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StudentServiceSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStudentServiceSOAP(endpoint);
    }

    public ua.cn.stu.www.StudentService.StudentService_PortType getStudentServiceSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ua.cn.stu.www.StudentService.StudentServiceSOAPStub _stub = new ua.cn.stu.www.StudentService.StudentServiceSOAPStub(portAddress, this);
            _stub.setPortName(getStudentServiceSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStudentServiceSOAPEndpointAddress(java.lang.String address) {
        StudentServiceSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ua.cn.stu.www.StudentService.StudentService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                ua.cn.stu.www.StudentService.StudentServiceSOAPStub _stub = new ua.cn.stu.www.StudentService.StudentServiceSOAPStub(new java.net.URL(StudentServiceSOAP_address), this);
                _stub.setPortName(getStudentServiceSOAPWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("StudentServiceSOAP".equals(inputPortName)) {
            return getStudentServiceSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.stu.cn.ua/StudentService/", "StudentService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.stu.cn.ua/StudentService/", "StudentServiceSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StudentServiceSOAP".equals(portName)) {
            setStudentServiceSOAPEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
