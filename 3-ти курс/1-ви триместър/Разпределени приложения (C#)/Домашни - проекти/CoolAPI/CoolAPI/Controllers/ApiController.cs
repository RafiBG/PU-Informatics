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
        private readonly AppDbContext _context;

        public ApiController(HttpClient httpClient, AppDbContext context)
        {
            _httpClient = httpClient;
            _context = context;
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


        public IActionResult DisneyApi()
        {
            return View();
        }

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

                        var character = new DisneyChacterDB
                        {
                            Name = characterName,
                            Films = characterFilms,
                            TV = characterTV,
                            Games = characterGames
                        };

                        _context.DisneyCharacters.Add(character);
                        _context.SaveChanges();

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
    }
}
