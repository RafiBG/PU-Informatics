using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace SampleWebApp.Migrations
{
    /// <inheritdoc />
    public partial class AddedNewColumnToCarsDateTo : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "validityDateTo",
                table: "Cars",
                type: "nvarchar(max)",
                nullable: false,
                defaultValue: "");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "validityDateTo",
                table: "Cars");
        }
    }
}
