using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Web;
using System.Web.Mvc;

namespace BGToll2.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }

        public ActionResult BGToll(string car_id)
        {
            var url = "https://check.bgtoll.bg/check/vignette/plate/BG/";

            var client = new WebClient();

            var body = "";

            if(car_id != null && car_id != "")
            {
                body = client.DownloadString(url + car_id);
                JObject data = JObject.Parse(body);

                if ((bool)data["ok"])
                {
                    ViewData["country"] = data["vignette"]["country"];
                    ViewData["vignetteNumber"] = data["vignette"]["vignetteNumber"];
                    ViewData["from"] = data["vignette"]["validityDateFromFormated"];
                    ViewData["to"] = data["vignette"]["validityDateToFormated"];
                } else
                {
                    ViewData["found"] = "Няма намерена винетка " + car_id;
                }

                ViewData["body"] = body;
            }



            return View();
        }

        public ActionResult Nasa()
        {
            var apiKey = "T7lPpBbIxAwr9GABoU6PQYrDHjgznoikS8GYM5zW";

            // var url = "https://api.nasa.gov/planetary/apod?api_key="+apiKey;


            var date = "2002-04-14";
            var url = "https://api.nasa.gov/planetary/apod?api_key=" + apiKey + "&date=" + date;

            using (var client = new HttpClient())
            {
                // Add an Accept header for JSON format.
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
                client.BaseAddress = new Uri(url);
                var response = client.GetAsync("").Result;
                if (response.IsSuccessStatusCode)
                {
                    Console.Write("Success");
                    var body = response.Content.ReadAsStringAsync().Result;
                    JObject data = JObject.Parse(body);
                    ViewData["title"] = data["title"]+"AWEAWDAW";
                    ViewData["explanation"] = data["explanation"];
                    ViewData["image"] = data["hdurl"];
                    ViewData["date"] = data["date"];
                    ViewData["copyright"] = data["copyright"];
                }
                else
                { 
                    Console.Write("Error");
                    ViewData["title"] = "There is an error!";
                }
            }

            return View();
        }
    }
}