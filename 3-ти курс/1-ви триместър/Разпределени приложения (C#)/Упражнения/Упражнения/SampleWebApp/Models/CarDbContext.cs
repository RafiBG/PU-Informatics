using Microsoft.EntityFrameworkCore;

namespace SampleWebApp.Models
{
    public class CarDbContext : DbContext
    {
        public DbSet<Car> Cars { get; set; }
        public DbSet<Brand> Brands { get; set; }
        public DbSet<Model> Models { get; set; }

        public CarDbContext(DbContextOptions<CarDbContext> options) : base(options) { }

    }
}
