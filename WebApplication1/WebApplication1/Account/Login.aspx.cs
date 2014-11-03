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
            connStr = ConfigurationManager.ConnectionStrings["myConnectionString"].ConnectionString;
            SqlConnection conn = new SqlConnection(connStr);
            conn.Open();
            string checkuser = "select count(*) from Uzytkownicy where imie='" + TextBox_login + "'";
            SqlCommand com = new SqlCommand(checkuser, conn);
            int temp = Convert.ToInt32(com.ExecuteScalar().ToString());
            conn.Close();
            if (temp == 1)
            {
                conn.Open();
                string sprawdzanieh = "select Pass from Uzytkownicy where Nick='" + TextBox_login + "'";
                SqlCommand passchecking = new SqlCommand(sprawdzanieh, conn);
                string password = passchecking.ExecuteScalar().ToString().Replace(" ",""); ;
                if (password == TextBox_password.Text)
                {
                    Session["New"] = TextBox_login.Text;
                    Warningi.Text = "Hasło prawidłowe!";
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