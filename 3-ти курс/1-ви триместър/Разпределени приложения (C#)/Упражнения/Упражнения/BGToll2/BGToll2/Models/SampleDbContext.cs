using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace BGToll2.Models
{
    public class SampleDbContext : DbContext
    {
        public DbSet<Car> Cars { get; set; }
    }
}