using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace BGToll2.Models
{
    public class Car
    {
        [Key]
        public int Id { get; set; }
        public string licensePlateNumber { get; set; }
        public string vignetteNumber { get; set; }
        public string validityDateToFormated { get; set; }

    }
}