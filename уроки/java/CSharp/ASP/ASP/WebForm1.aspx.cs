using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ASP
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        public string output1;

        protected void Page_Load(object sender, EventArgs e)
        {
            FileInfo info = new FileInfo("C:\\windows\\explorer.exe");
            long size = info.Length;
            string outtext = string.Format("Размер файла explorer.exe <b>{0}</b> байт", size);
            Output.Text = outtext;
            Person p = new Person("Romka", "mim.roma@mail.ru");
            Output2.Text = p.GenerateHtml();

            string filename = Server.MapPath(@"App_Data\TextFile.txt");
            output1 = File.ReadAllText(filename);
            output1 = output1.Replace("<%LOGIN%>", p.login);
            output1 = output1.Replace("<%EMAIL%>", p.email);
        }
    }
}