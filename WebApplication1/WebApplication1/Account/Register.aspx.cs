using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Configuration;

namespace WebApplication1.Account
{
    public partial class Register : System.Web.UI.Page
    {
        string connStr;
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Rejestruj_Click(object sender, EventArgs e)
        {
            connStr = ConfigurationManager.ConnectionStrings["myConnectionString"].ConnectionString;
            SqlConnection conn = new SqlConnection(connStr); 
            conn.Open();
            string checkuser = "SELECT count(*) FROM Uzytkownicy WHERE Nick='" + TextBox_Nick.Text + "'";
            SqlCommand com = new SqlCommand(checkuser, conn);
            int temp = Convert.ToInt32(com.ExecuteScalar().ToString());
            conn.Close();
            if (temp == 0)
            {
                try
                {
                    Guid noweid = new Guid();
                    conn.Open();
                    string insercja = "insert into Uzytkownicy(UID,Imie,Nazwisko,Nick,Pass,Email,Telefon,OcenaIlos,OcenaSum,OcenaSred,Status)values(@_UID,@_Imie,@_Nazwisko,@_Nick,@_Pass,@_Email,@_Telefon,@_OcenaIlos,@_OcenaSum,@_OcenaSred,@_Status)";
                    SqlCommand ins = new SqlCommand(insercja, conn);
                    ins.Parameters.AddWithValue("@_UID", noweid);
                    ins.Parameters.AddWithValue("@_Imie", TextBox_Imie.Text);
                    ins.Parameters.AddWithValue("@_Nazwisko", TextBox_Nazwisko.Text);
                    ins.Parameters.AddWithValue("@_Email", TextBox_Email.Text);
                    ins.Parameters.AddWithValue("@_Telefon", TextBox_Telefon.Text);
                    ins.Parameters.AddWithValue("@_Nick", TextBox_Nick.Text);
                    ins.Parameters.AddWithValue("@_Pass", Haslo1_textfield.Text);
                    ins.Parameters.AddWithValue("@_OcenaIlos", "0");
                    ins.Parameters.AddWithValue("@_OcenaSum", "0");
                    ins.Parameters.AddWithValue("@_OcenaSred", "0.0");
                    ins.Parameters.AddWithValue("@_Status", "0");
                    ins.ExecuteNonQuery();
                    Warningi.Text = "Zarejestrowano!";
                    conn.Close();
                }
                catch (Exception ex)
                {
                    Warningi.Text = "Error: " + ex.ToString();
                }
            }
            if(temp<=1)
            {
                Warningi.Text="Użytkownik istnieje !";
            }
        }
    }
}