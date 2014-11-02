<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="StronaUzytkownika.aspx.cs" Inherits="WebApplication1.Account.StronaUzytkownika" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <asp:Label ID="Witajka" runat="server" Text=""></asp:Label><br/>
    <asp:Button ID="Wyloguj" runat="server" Text="Wylogowanie" 
        onclick="Wyloguj_Click" />

</asp:Content>
