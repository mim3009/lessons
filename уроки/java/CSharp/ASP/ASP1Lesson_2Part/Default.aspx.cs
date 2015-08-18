using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ASP1Lesson_2Part
{
    public partial class Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void GetResult_Click(object sender, EventArgs e)
        {
            string result = Name.Text + ", привет!";
            Result.Text = result;
        }
    }
}