using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication1.Account
{
    public partial class StronaUzytkownika : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["New"] != null)
            {
                Witajka.Text = "Witaj..." + Session["New"].ToString();
            }
            else
            {
                Response.Redirect("~/Account/Login.aspx");
            }
        }

        protected void Wyloguj_Click(object sender, EventArgs e)
        {
            Session["New"] = null;
            Response.Redirect("~/Account/Login.aspx");
        }
    }
}