<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Register.aspx.cs" Inherits="WebApplication1.Account.Register" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
    <style type="text/css">
        .style1
        {
            color: #FF0000;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
<table>
<tr>
<td><asp:Label ID="Label1" runat="server" Text="Imię:"></asp:Label></td>	<td><asp:TextBox ID="TextBox_Imie" runat="server"></asp:TextBox></td>
<td>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
        ErrorMessage="Wpisz imie!" ControlToValidate="TextBox_Imie" 
        CssClass="style1"></asp:RequiredFieldValidator>
    </td>
</tr>
<tr>
<td><asp:Label ID="Label2" runat="server" Text="Nazwisko:"></asp:Label></td>	<td><asp:TextBox ID="TextBox_Nazwisko" runat="server"></asp:TextBox></td>
<td>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
        ErrorMessage="Wpisz nazwisko!" ControlToValidate="TextBox_Nazwisko" 
        CssClass="style1"></asp:RequiredFieldValidator>
    </td>
</tr>
<tr>
<td><asp:Label ID="Label3" runat="server" Text="Email:"></asp:Label></td>	<td><asp:TextBox ID="TextBox_Email" runat="server"></asp:TextBox></td>
<td>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" 
        ErrorMessage="Wpisz email!" ControlToValidate="TextBox_Email" 
        CssClass="style1"></asp:RequiredFieldValidator><br/>
    <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" 
        ErrorMessage="Niepoprawny email!" ControlToValidate="TextBox_Email" 
        style="color: #FF0000" 
        ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"></asp:RegularExpressionValidator>
    </td>
</tr>
<tr>
<td><asp:Label ID="Label4" runat="server" Text="Telefon:"></asp:Label></td>	<td><asp:TextBox ID="TextBox_Talefon" runat="server"></asp:TextBox></td>
<td>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" 
        ErrorMessage="Wpisz telefon!" ControlToValidate="TextBox_Talefon" 
        CssClass="style1"></asp:RequiredFieldValidator>
    </td>
</tr>
<tr>
<td><asp:Label ID="Label7" runat="server" Text="Nick:"></asp:Label></td>	<td><asp:TextBox ID="TextBox_Nick" runat="server"></asp:TextBox></td>
<td>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" 
        ErrorMessage="Wpisz nick!" ControlToValidate="TextBox_Nick" 
        CssClass="style1"></asp:RequiredFieldValidator>
    </td>
</tr>
<tr>
<td><asp:Label ID="Label5" runat="server" Text="Hasło:"></asp:Label></td>	<td>
    <asp:TextBox ID="Haslo1_textfield" runat="server" TextMode="Password"></asp:TextBox>
    </td>
<td>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator6" runat="server" 
        ErrorMessage="Wpisz haslo!" ControlToValidate="Haslo1_textfield" 
        style="color: #FF0000"></asp:RequiredFieldValidator>
    </td>
</tr>
<tr>
<td><asp:Label ID="Label6" runat="server" Text="Powtórz hasło:"></asp:Label></td>	<td>
    <asp:TextBox ID="Haslo2_textfield" runat="server" TextMode="Password"></asp:TextBox>
    </td>
    <td>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator7" runat="server" 
        ErrorMessage="Wpisz haslo!" ControlToValidate="Haslo2_textfield" 
        CssClass="style1"></asp:RequiredFieldValidator><br/>
        <asp:CompareValidator ID="CompareValidator1" runat="server" 
            ControlToCompare="Haslo1_textfield" ControlToValidate="Haslo2_textfield" 
            ErrorMessage="Wpisz to samo co u góry!" style="color: #FF0000"></asp:CompareValidator>
    </td>
</tr>
</table>
    <asp:Button ID="Rejestruj" runat="server" Text="Zarejestruj" 
        onclick="Rejestruj_Click" />
</asp:Content>
