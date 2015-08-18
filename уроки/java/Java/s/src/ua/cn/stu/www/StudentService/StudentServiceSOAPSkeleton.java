/**
 * StudentServiceSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ua.cn.stu.www.StudentService;

public class StudentServiceSOAPSkeleton implements ua.cn.stu.www.StudentService.StudentService_PortType, org.apache.axis.wsdl.Skeleton {
    private ua.cn.stu.www.StudentService.StudentService_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.stu.cn.ua/StudentService/", "NewOperationRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("newOperation", _params, new javax.xml.namespace.QName("http://www.stu.cn.ua/StudentService/", "NewOperationResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.stu.cn.ua/StudentService/", "StudentInfo"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "NewOperation"));
        _oper.setSoapAction("http://www.stu.cn.ua/StudentService/NewOperation");
        _myOperationsList.add(_oper);
        if (_myOperations.get("newOperation") == null) {
            _myOperations.put("newOperation", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("newOperation")).add(_oper);
    }

    public StudentServiceSOAPSkeleton() {
        this.impl = new ua.cn.stu.www.StudentService.StudentServiceSOAPImpl();
    }

    public StudentServiceSOAPSkeleton(ua.cn.stu.www.StudentService.StudentService_PortType impl) {
        this.impl = impl;
    }
    public ua.cn.stu.www.StudentService.StudentInfo newOperation(java.lang.String newOperationRequest) throws java.rmi.RemoteException
    {
        ua.cn.stu.www.StudentService.StudentInfo ret = impl.newOperation(newOperationRequest);
        return ret;
    }

}
