<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="ASP.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Серверный тэг</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <%
                for (int i = 0; i < 10; i++)
                {
                    Response.Write("Hello World!<br/>");
                }     
            %>
            Сегодня
            <%Response.Write(DateTime.Now.ToLocalTime()); %>
            <br />
            Сегодня
            <%= DateTime.Now.ToLocalTime() %>
            <%--Комментарий на стороне сервера--%>
            <br />
            <asp:Label ID="Output" runat="server"/>
            <br />
            <asp:Label ID="Output2" runat="server"/>
            <br />
            <%= output1 %>
        </div>
    </form>
</body>
</html>
