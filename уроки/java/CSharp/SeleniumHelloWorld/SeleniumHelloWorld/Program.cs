using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium;
using OpenQA.Selenium.Edge;

namespace SeleniumHelloWorld
{
    class Program
    {
        private const string IE_DRIVER_PATH = @"C:\Program Files (x86)\Microsoft Web Driver";

        static void Main(string[] args)
        {
            IWebDriver driver = new EdgeDriver(IE_DRIVER_PATH);

            driver.Navigate().GoToUrl("http://www.bing.com");

            IWebElement searchInput = driver.FindElement(By.Id("sb_form_q"));
            searchInput.SendKeys("Hello World!");
            searchInput.SendKeys(Keys.Enter);

            driver.Close();
        }
    }
}
