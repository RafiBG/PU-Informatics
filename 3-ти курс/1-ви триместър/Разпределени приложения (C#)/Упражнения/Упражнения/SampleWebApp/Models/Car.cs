using System.ComponentModel;

namespace SampleWebApp.Models
{
    public class Car
    {
        public int Id { get; set; }
        public string vignetteNumber { get; set; }
        public string validityDateFrom { get; set; }
        public string validityDateTo { get; set; }

        [DisplayName("Brand")]
        public int? BrandId { get; set; }
        [DisplayName("Model")]
        public int? ModelId { get; set; }



        public virtual Brand? Brand { get; set; }
        public virtual Model? Model { get; set; }
    }
}
