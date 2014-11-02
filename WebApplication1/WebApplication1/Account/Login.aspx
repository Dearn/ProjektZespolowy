<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="WebApplication1.Account.Login" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
<asp:Label ID="Warningi" runat="server" Text=""></asp:Label>
<table>
<tr>
<td><asp:Label ID="Label1" runat="server" Text="Nick:"></asp:Label></td>	<td><asp:TextBox ID="TextBox_login" runat="server"></asp:TextBox></td>
<td>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
        ErrorMessage="Wpisz nick!" ControlToValidate="TextBox_login" 
        style="color: #FF0000"></asp:RequiredFieldValidator>
</td>
</tr>
<tr>
<td><asp:Label ID="Label2" runat="server" Text="Hasło:"></asp:Label></td>	<td>
    <asp:TextBox ID="TextBox_password" runat="server" TextMode="Password"></asp:TextBox></td>
<td>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
        ErrorMessage="Wpisz haslo!" ControlToValidate="TextBox_password" 
        style="color: #FF0000"></asp:RequiredFieldValidator>
</td>
</tr>

<td></td><td><asp:Button ID="Zaloguj" runat="server" Text="Zaloguj" onclick="Zaloguj_Click" /></td>
   <td> <asp:HyperLink ID="HyperLink1" runat="server" 
        NavigateUrl="~/Account/Register.aspx">Jaśli jesteś nowy zarejestruj się.</asp:HyperLink></td>
</table>
</asp:Content>
