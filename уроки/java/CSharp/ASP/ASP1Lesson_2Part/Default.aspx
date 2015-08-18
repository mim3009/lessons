<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="ASP1Lesson_2Part.Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        
        Введите имя:
        <asp:TextBox ID="Name" runat="server"></asp:TextBox>
        <br />
        <asp:Button ID="GetResult" runat="server" Text="Отправить" Width="247px" ForeColor="#990000" OnClick="GetResult_Click" />
        <br />
        <asp:Label ID="Result" runat="server" Text=""></asp:Label>
        
    </div>
    </form>
</body>
</html>
