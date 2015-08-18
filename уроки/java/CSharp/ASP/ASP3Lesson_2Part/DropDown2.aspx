<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="DropDown2.aspx.cs" Inherits="ASP3Lesson_2Part.DropDown2" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
         <asp:DropDownList ID="DropDownList1" runat="server" AutoPostBack="true" OnSelectedIndexChanged="DropDownList1_SelectedIndexChanged">
            <asp:ListItem Text="IE" Value="1" />
            <asp:ListItem Text="Firefox" Value="2" />
            <asp:ListItem Text="Opera" Value="3"/>
            <asp:ListItem Text="Chrome" Value="4"/>
            <asp:ListItem Text="Safari" Value="5"/>
        </asp:DropDownList>
        <br />
        <asp:Label ID="Outputlabel" runat="server" EnableViewState="false" />
    </div>
    </form>
</body>
</html>
