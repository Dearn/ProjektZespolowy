using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;

namespace Proba
{
    public partial class Index : System.Web.UI.Page
    {
        int licznik=2;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Page.IsPostBack == true)
            {
                Label3.Text =( "Wczytano !");
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            try {
            SqlConnection conn = new SqlConnection("Data Source=(LocalDB)\v11.0;AttachDbFilename=C:\\Users\\Samael\\Desktop\\Proba\\Proba\\App_Data\\Ludzie.mdf;Integrated Security=True;Connect Timeout=30");
            SqlCommand com = new SqlCommand("Insert into Table(Id,Imie,Nazwisko) Values (@Id,@Imie,@Nazwisko)",conn);
            com.Parameters.AddWithValue("@Id",licznik);
            com.Parameters.AddWithValue("@Imie", Imie_Login.Text);
            com.Parameters.AddWithValue("@Nazwisko", Nazwisko_Haslo.Text);
            conn.Open();
            com.ExecuteNonQuery();
            conn.Close();
            licznik++;
            }
            catch (SqlException ex) { Label3.Text = ("Error :"+ex); }

            if(IsPostBack)
            {
                Imie_Login.Text="";
                Nazwisko_Haslo.Text="";
            }
        }
    }
}