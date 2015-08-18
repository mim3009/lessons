<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleStudentServiceProxyid" scope="session" class="ua.cn.stu.www.StudentService.StudentServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleStudentServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleStudentServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleStudentServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        ua.cn.stu.www.StudentService.StudentService_PortType getStudentService_PortType10mtemp = sampleStudentServiceProxyid.getStudentService_PortType();
if(getStudentService_PortType10mtemp == null){
%>
<%=getStudentService_PortType10mtemp %>
<%
}else{
        if(getStudentService_PortType10mtemp!= null){
        String tempreturnp11 = getStudentService_PortType10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String newOperationRequest_1id=  request.getParameter("newOperationRequest22");
            java.lang.String newOperationRequest_1idTemp = null;
        if(!newOperationRequest_1id.equals("")){
         newOperationRequest_1idTemp  = newOperationRequest_1id;
        }
        ua.cn.stu.www.StudentService.StudentInfo newOperation13mtemp = sampleStudentServiceProxyid.newOperation(newOperationRequest_1idTemp);
if(newOperation13mtemp == null){
%>
<%=newOperation13mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">boss:</TD>
<TD>
<%
if(newOperation13mtemp != null){
%>
<%=newOperation13mtemp.isBoss()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">name:</TD>
<TD>
<%
if(newOperation13mtemp != null){
java.lang.String typename18 = newOperation13mtemp.getName();
        String tempResultname18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typename18));
        %>
        <%= tempResultname18 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">sex:</TD>
<TD>
<%
if(newOperation13mtemp != null){
java.lang.String typesex20 = newOperation13mtemp.getSex();
        String tempResultsex20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typesex20));
        %>
        <%= tempResultsex20 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>