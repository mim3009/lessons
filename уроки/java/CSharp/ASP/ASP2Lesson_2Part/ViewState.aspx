<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ViewState.aspx.cs" Inherits="ASP2Lesson_2Part.ViewState" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
        <br />
        <asp:Button ID="Button1" runat="server" Text="+1" OnClick="Button1_Click" />
        &nbsp;&nbsp;
        <asp:Button ID="Button2" runat="server" Text="+2" OnClick="Button2_Click" />
    
    </div>
    </form>
</body>
</html>
