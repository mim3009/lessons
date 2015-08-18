/**
 * StudentServiceSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ua.cn.stu.www.StudentService;

public class StudentServiceSOAPImpl implements
		ua.cn.stu.www.StudentService.StudentService_PortType {
	public ua.cn.stu.www.StudentService.StudentInfo newOperation(
			java.lang.String newOperationRequest)
			throws java.rmi.RemoteException {
		StudentInfo si = new StudentInfo();
		if (newOperationRequest.equals("4")) {
			si.setName("Yuschenko");
			si.setSex("w");
			si.setBoss(false);
		} else {
			si.setName("Doroshenko");
			si.setSex("m");
			si.setBoss(true);
		}
		return si;
	}
}
