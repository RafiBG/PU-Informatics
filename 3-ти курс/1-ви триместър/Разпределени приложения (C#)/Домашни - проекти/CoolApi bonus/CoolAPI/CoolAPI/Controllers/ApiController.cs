using CoolAPI.Models;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System.Diagnostics.Eventing.Reader;
using System.Net;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace CoolAPI.Controllers
{
    public class ApiController : Controller
    {
        private readonly HttpClient _httpClient;

        public ApiController(HttpClient httpClient)
        {
            _httpClient = httpClient;
        }

        // GET
        public async Task<IActionResult> CatFact()
        {
            var url = "https://catfact.ninja/fact";

            var response = await _httpClient.GetAsync(url);
            if (response.IsSuccessStatusCode)
            {
                var body = await response.Content.ReadAsStringAsync();
                JObject data = JObject.Parse(body);

                ViewData["fact"] = data["fact"].ToString();
                //ViewData["result"] = "Успешно намерен факт за котка!";
            }
            else
            {
                ViewData["result"] = "Не може да намерим факт за котка.";
                ViewData["fact"] = "";
            }

            return View();
        }

        public IActionResult QrCode()
        {
            return View();
        }

        // POST: /Api/QrCode
        [HttpPost]
        public IActionResult QrCode(string url)
        {
            if (!string.IsNullOrWhiteSpace(url))
            {
                var qrCodeUrl = $"https://qrtag.net/api/qr_12.svg?url=" + url;
                ViewData["QrCodeImage"] = qrCodeUrl;
            }
            else
            {
                ViewData["QrCodeImage"] = null;
            }

            return View();
        }

        // GET: /Api/DisneyCharacter
        public ActionResult DisneyCharacter(string characterId)
        {
            var url = "https://api.disneyapi.dev/character/" + characterId;

            var client = new WebClient();
            var body = "";

            if (!string.IsNullOrEmpty(characterId))
            {
                try
                {
                    body = client.DownloadString(url);
                    JObject data = JObject.Parse(body);

                    if (data["data"] != null && data["data"].Count() > 0)
                    {
                        
                        string characterName = data["data"]["name"].ToString();
                        string characterFilms = data["data"]["films"].ToString();
                        string characterTV = data["data"]["tvShows"].ToString();
                        string characterGames = data["data"]["videoGames"].ToString();
                        string characterImage = data["data"]["imageUrl"].ToString();

                       
                        ViewData["result"] = "Character found: " + characterName;
                        ViewData["CharacterName"] = characterName;
                        ViewData["CharacterFilms"] = characterFilms;
                        ViewData["CharacterTV"] = characterTV;
                        ViewData["CharacterGames"] = characterGames;
                        ViewData["CharacterImage"] = characterImage;
                    }
                    else
                    {
                        ViewData["result"] = "Character not found for ID: " + characterId;
                    }
                }
                catch (WebException ex)
                {
                    ViewData["result"] = "Error fetching data: " + ex.Message;
                }
            }
            else
            {
                ViewData["result"] = "Please enter a valid character ID.";
            }

            ViewData["body"] = body;
            return View();
        }

        public async Task<IActionResult> Weather()
        {
            string apiKey = "8e77caa75b4098a09c90c737dc51b018"; //Знам че  ключа не трябва да се оставя при споделяне.

            var url = $"https://api.openweathermap.org/geo/1.0/direct?q=Bulgaria&limit=5&appid={apiKey}";
            var response = await _httpClient.GetAsync(url);

            if (!response.IsSuccessStatusCode)
            {
                ViewData["result"] = "Unable to retrieve geolocation data.";
                return View();
            }

            var geoBody = await response.Content.ReadAsStringAsync();
            JArray geoData = JArray.Parse(geoBody);
            var latitude = geoData[0]["lat"]?.ToString();
            var longitude = geoData[0]["lon"]?.ToString();
            var country = geoData[0]["country"]?.ToString();

            ViewData["latitude"] = latitude;
            ViewData["longitude"] = longitude;
            ViewData["country"] = country;
            ViewData["result"] = "Weather information retrieved successfully!";

            return View();
        }
    }
}
