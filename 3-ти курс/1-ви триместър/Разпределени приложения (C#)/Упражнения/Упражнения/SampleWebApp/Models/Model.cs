using Humanizer.Localisation;
using System.ComponentModel;

namespace SampleWebApp.Models
{
    public class Model
    {
        public int Id { get; set; }
        public string Name { get; set; }

        [DisplayName("Brand")]
        public int BrandId { get; set; }

        public virtual Brand? Brand { get; set; }

    }
}
