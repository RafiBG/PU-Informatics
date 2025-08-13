using Microsoft.AspNetCore.Mvc;
using SampleWebApp.Models;
using System.Diagnostics;

namespace SampleWebApp.Controllers
{
    public class HomeController : Controller
    {


        private readonly ILogger<HomeController> _logger;
        /*
        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }
        */

        public IActionResult Index()
        {
            return View();
        }

        // create context for the HomeController
        private readonly CarDbContext _context;

        // HomeController constructor
        public HomeController(CarDbContext context)
        {
            _context = context;
        }
        public IActionResult Privacy()
        {
            // API CALL

            Car first = new Car();
            first.vignetteNumber = "A9999BK";
            first.validityDateFrom = "01.01.2024";

            _context.Add(first);
            _context.SaveChanges();

            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    
        

    }
}