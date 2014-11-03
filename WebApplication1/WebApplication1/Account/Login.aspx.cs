using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;

namespace WebApplication1.Account
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Zaloguj_Click(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection("Data Source=.\\JAJA;AttachDbFilename=C:\\Users\\Samael\\Desktop\\ProjektZespolowy\\WebApplication1\\WebApplication1\\App_Data\\Database1.mdf;Integrated Security=True;User Instance=True;");
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
                    //Response.Redirect("StronaUzytkownika.aspx");
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
    }
}