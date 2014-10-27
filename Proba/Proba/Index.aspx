<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Index.aspx.cs" Inherits="Proba.Index" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
         <asp:Label ID="Label3" runat="server" Text=""></asp:Label><br/>
            <asp:Label ID="Label1" runat="server" Text="Login:"></asp:Label>
        <asp:TextBox ID="Imie_Login" runat="server"></asp:TextBox>
           
            <br/>
        <asp:Label ID="Label2" runat="server" Text="Hasło:"></asp:Label>
        <asp:TextBox ID="Nazwisko_Haslo" runat="server"></asp:TextBox><br/>
        <asp:Button ID="Button1" runat="server" Text="Zapisz" OnClick="Button1_Click" />
     
    </div>
    </form>
</body>
</html>
