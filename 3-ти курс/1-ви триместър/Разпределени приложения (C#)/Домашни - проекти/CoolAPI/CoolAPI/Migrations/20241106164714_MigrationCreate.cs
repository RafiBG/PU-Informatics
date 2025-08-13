using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace CoolAPI.Migrations
{
    /// <inheritdoc />
    public partial class MigrationCreate : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "DisneyCharacters",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Name = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Games = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Films = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    TV = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_DisneyCharacters", x => x.Id);
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "DisneyCharacters");
        }
    }
}
