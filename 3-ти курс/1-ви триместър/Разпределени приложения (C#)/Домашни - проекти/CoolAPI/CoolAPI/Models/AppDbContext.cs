using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;

namespace CoolAPI.Models
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options) : base(options)
        {
        }

        public DbSet<DisneyChacterDB> DisneyCharacters { get; set; }
    }
}
