package ua.cn.stu.www.StudentService;

public class StudentServiceProxy implements ua.cn.stu.www.StudentService.StudentService_PortType {
  private String _endpoint = null;
  private ua.cn.stu.www.StudentService.StudentService_PortType studentService_PortType = null;
  
  public StudentServiceProxy() {
    _initStudentServiceProxy();
  }
  
  public StudentServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initStudentServiceProxy();
  }
  
  private void _initStudentServiceProxy() {
    try {
      studentService_PortType = (new ua.cn.stu.www.StudentService.StudentService_ServiceLocator()).getStudentServiceSOAP();
      if (studentService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)studentService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)studentService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (studentService_PortType != null)
      ((javax.xml.rpc.Stub)studentService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ua.cn.stu.www.StudentService.StudentService_PortType getStudentService_PortType() {
    if (studentService_PortType == null)
      _initStudentServiceProxy();
    return studentService_PortType;
  }
  
  public ua.cn.stu.www.StudentService.StudentInfo newOperation(java.lang.String newOperationRequest) throws java.rmi.RemoteException{
    if (studentService_PortType == null)
      _initStudentServiceProxy();
    return studentService_PortType.newOperation(newOperationRequest);
  }
  
  
}