namespace BGToll2.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Cars", "vignetteNumber", c => c.String());
            AddColumn("dbo.Cars", "validityDateToFormated", c => c.String());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Cars", "validityDateToFormated");
            DropColumn("dbo.Cars", "vignetteNumber");
        }
    }
}
