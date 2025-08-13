using CoolAPI.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Threading.Tasks;

namespace CoolAPI.Controllers
{
    public class DisneyController : Controller
    {
        private readonly AppDbContext _context;

        public DisneyController(AppDbContext context)
        {
            _context = context;
        }

        public async Task<IActionResult> Index()
        {
            var characters = await _context.DisneyCharacters.ToListAsync();
            return View(characters);
        }

        public async Task<IActionResult> Details(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var character = await _context.DisneyCharacters
                .FirstOrDefaultAsync(m => m.Id == id);
            if (character == null)
            {
                return NotFound();
            }

            return View(character); 
        }

        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Name,Films,TV,Games")] DisneyChacterDB character)
        {
            if (ModelState.IsValid)
            {
                _context.Add(character);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(character);
        }

        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var character = await _context.DisneyCharacters.FindAsync(id);
            if (character == null)
            {
                return NotFound();
            }
            return View(character);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,Name,Films,TV,Games")] DisneyChacterDB character)
        {
            if (id != character.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(character);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!CharacterExists(character.Id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            return View(character);
        }

        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var character = await _context.DisneyCharacters
                .FirstOrDefaultAsync(m => m.Id == id);
            if (character == null)
            {
                return NotFound();
            }

            return View(character);
        }

        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var character = await _context.DisneyCharacters.FindAsync(id);
            _context.DisneyCharacters.Remove(character);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool CharacterExists(int id)
        {

            return _context.DisneyCharacters.Any(e => e.Id == id);
        }
    }
}
