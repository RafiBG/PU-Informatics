using System.ComponentModel.DataAnnotations;

namespace CoolAPI.Models
{
    public class DisneyChacterDB
    {
        [Key]
        public int Id { get; set; }
        public string Name { get; set; }
        public string Games { get; set; }
        public string Films { get; set; }
        public string TV { get; set; }
    }
}
