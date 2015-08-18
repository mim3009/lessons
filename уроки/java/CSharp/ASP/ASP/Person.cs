using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ASP
{
    public class Person
    {
        public string login { get; set; }
        public string email { get; set; }
       
        public Person(string login, string email)
        {
            this.login = login;
            this.email = email;
        }

        public string GenerateHtml()
        {
            return string.Format("Login: {0} <br/> Email: {1}", login, email);
        }
    }
}