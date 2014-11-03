using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;

namespace WebApplication1.Account
{
    public partial class Register : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack)
            {
                SqlConnection conn = new SqlConnection("Data Source=.\\JAJA;AttachDbFilename=C:\\Users\\Samael\\Desktop\\ProjektZespolowy\\WebApplication1\\WebApplication1\\App_Data\\Database1.mdf;Integrated Security=True;User Instance=True;");
                conn.Open();
                string checkuser = "select count(*) from Uzytkownicy where imie='"+TextBox_Imie+"'";
                SqlCommand com = new SqlCommand(checkuser,conn);
                int temp = Convert.ToInt32(com.ExecuteScalar().ToString());
                if (temp == 1)
                {
                    Warningi.Text="Użutkownik istnieje !";
                }
                conn.Close();
            }

        }

        protected void Rejestruj_Click(object sender, EventArgs e)
        {
            try
            {
                Guid noweid = new Guid();
                SqlConnection conn = new SqlConnection("Data Source=.\\JAJA;AttachDbFilename=C:\\Users\\Samael\\Desktop\\ProjektZespolowy\\WebApplication1\\WebApplication1\\App_Data\\Database1.mdf;Integrated Security=True;User Instance=True;");
                conn.Open();
                string insercja = "insert into Uzytkownicy(UID,Imie,Nazwisko,Nick,Pass,Email,Telefon,OcenaIlos,OcenaSum,OcenaSred,Status)values(@_UID,@_Imie,@_Nazwisko,@_Nick,@_Pass,@_Email,@_Telefon,@_OcenaIlos,@_OcenaSum,@_OcenaSred,@_Status)";
                SqlCommand com = new SqlCommand(insercja, conn);
                com.Parameters.AddWithValue("@_UID", noweid);
                com.Parameters.AddWithValue("@_Imie",TextBox_Imie.Text);
                com.Parameters.AddWithValue("@_Nazwisko", TextBox_Nazwisko.Text);
                com.Parameters.AddWithValue("@_Email", TextBox_Email.Text);
                com.Parameters.AddWithValue("@_Telefon", TextBox_Telefon.Text);
                com.Parameters.AddWithValue("@_Nick", TextBox_Nick.Text);
                com.Parameters.AddWithValue("@_Pass", Haslo1_textfield.Text);
                com.Parameters.AddWithValue("@_OcenaIlos", "0");
                com.Parameters.AddWithValue("@_OcenaSum", "0");
                com.Parameters.AddWithValue("@_OcenaSred", "0.0");
                com.Parameters.AddWithValue("@_Status", "0");
                com.ExecuteNonQuery();
                Warningi.Text = "Zarejestrowano!";
                conn.Close();
            }catch(Exception ex){
                Warningi.Text = "Error: " + ex.ToString();
            }
        }
    }
}