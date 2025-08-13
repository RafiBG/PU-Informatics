using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json.Linq;
using SampleApp.Models;
using System.Diagnostics;
using System.Net;

namespace SampleApp.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            return View();
        }

        public IActionResult BGToll(string car_id)
        {
            var url = "https://check.bgtoll.bg/check/vignette/plate/BG/";

            var client = new WebClient();

            string body = "";

            Car firstCar = new Car();

            if (car_id != null && car_id != "")
            {
                body = client.DownloadString(url + car_id);

                // JSON to JObject
                JObject data = JObject.Parse(body);

                if ((bool)data["ok"])
                {
                    ViewData["country"] = data["vignette"]["country"];
                    ViewData["vignetteNumber"] = data["vignette"]["vignetteNumber"];
                    ViewData["from"] = data["vignette"]["validityDateFromFormated"];
                    ViewData["to"] = data["vignette"]["validityDateToFormated"];

                    // JObject to JToken
                    // get JSON result object
                    JToken result = data["vignette"];

                    // JToken.ToObject is a helper method that uses JsonSerializer internally
                    firstCar = result.ToObject<Car>();

                    // db.Cars.Add(some);
                    // db.SaveChanges();


                }
                else
                {
                    ViewData["found"] = "Няма намерена винетка " + car_id;
                }

                ViewData["body"] = body;
            }
            ViewData["car"] = firstCar;

            // https://www.c-sharpcorner.com/article/asp-net-mvc-passing-data-from-controller-to-view/ 

            return View(firstCar);
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}