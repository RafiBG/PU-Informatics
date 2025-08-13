using Microsoft.Extensions.Hosting;
using System.ComponentModel.DataAnnotations;

namespace SampleWebApp.Models
{
    public class Brand
    {
        public int Id { get; set; }

        [StringLength(30)]
        [Required(ErrorMessage = "You must enter Brand Name!")]
        public string Name { get; set; }
        public string Country { get; set; }
        public DateTime CreatedOn { get; set; }

        // public virtual List<Model> Models { get; set; }
        public ICollection<Model> Models { get; } = new List<Model>();
    }
}
