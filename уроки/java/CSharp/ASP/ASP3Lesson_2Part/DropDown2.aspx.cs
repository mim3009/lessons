using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ASP3Lesson_2Part
{
    public partial class DropDown2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void DropDownList1_SelectedIndexChanged(object sender, EventArgs e)
        {
            Outputlabel.Text += "<br/>Индекс выбраного елемента: " + DropDownList1.SelectedIndex + "<br/>";
            Outputlabel.Text += "Value выбраного елемента: " + DropDownList1.SelectedValue + "<br/>";
            Outputlabel.Text += "Text выбраного елемента: " + DropDownList1.SelectedItem.ToString() + "<br/>";
        }
    }
}