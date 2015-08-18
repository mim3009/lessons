using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ASP2Lesson_2Part
{
    public partial class ViewState : System.Web.UI.Page
    {

        protected void Button1_Click(object sender, EventArgs e)
        {
            int counter = 0;
            object obj = ViewState["counter"];
            if (obj != null)
            {
                counter = (int)obj;
            }
            counter += 1;
            ViewState["counter"] = counter;
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            int counter = 0;
            object obj = ViewState["counter"];
            if (obj != null)
            {
                counter = (int)obj;
            }
            counter += 2;
            ViewState["counter"] = counter;
        }


        protected void Page_LoadComplete(object sender, EventArgs e)
        {
            Label1.Text = Convert.ToString(ViewState["counter"]);
        }

    }
}