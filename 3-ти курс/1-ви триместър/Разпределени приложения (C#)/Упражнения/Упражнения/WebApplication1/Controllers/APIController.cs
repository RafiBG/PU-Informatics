using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json.Linq;
using System.Net;

namespace WebApplication1.Controllers
{
    public class APIController : Controller
    {
        public IActionResult Index(string carNumber)
        {
            string data = "You have entered: " + carNumber;

            ViewData["data"] = data;

            // 1. Prepare request
            var url = "https://check.bgtoll.bg/check/vignette/plate/BG/A9999BK";

            // 2. Send request
            var client = new WebClient();

            var response = "";
            response = client.DownloadString(url);

            // 3. Receive response

            // 4. Process response
            JObject json = JObject.Parse(response);

            ViewData["valid_until"] = json["vignette"]["validityDateTo"];
            ViewData["data"] = response;

            return View();
        }
    }
}
