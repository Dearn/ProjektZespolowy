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
    public partial class Login : System.Web.UI.Page
    {
        string connStr;
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Zaloguj_Click(object sender, EventArgs e)
        {
            try
            {
                connStr = ConfigurationManager.ConnectionStrings["myConnectionString"].ConnectionString;
                SqlConnection conn = new SqlConnection(connStr);
                conn.Open();
                string checkuser = "SELECT count(*) FROM Uzytkownicy WHERE Nick='" + TextBox_login.Text + "'";
                SqlCommand com = new SqlCommand(checkuser, conn);
                int temp = Convert.ToInt32(com.ExecuteScalar().ToString());
                conn.Close();
                if (temp == 1)
                {
                    conn.Open();
                    string sprawdzanieh = "SELECT Pass FROM Uzytkownicy WHERE Nick='" + TextBox_login.Text + "'";
                    SqlCommand passchecking = new SqlCommand(sprawdzanieh, conn);
                    string password = passchecking.ExecuteScalar().ToString();
                    if (password == TextBox_password.Text)
                    {
                        Session["New"] = TextBox_login.Text;
                        Warningi.Text = "Hasło prawidłowe!";
                        Server.Transfer("StronaUzytkownika.aspx",true);
                    }
                    else
                    {
                        Warningi.Text = "Hasło nieprawidłowe!";
                    }
                }
                else
                {
                    Warningi.Text = "Nick nieprawidłowy!";
                }
            }
            catch (Exception ex) { Warningi.Text = "" + ex; }
        }
    }
}