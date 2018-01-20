using System.Data.Entity.Migrations;

namespace Blog.Migrations
{
    public sealed class Configuration : DbMigrationsConfiguration<Blog.Models.BlogDbContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = true;
            AutomaticMigrationDataLossAllowed = true;
        }


        protected override void Seed(Blog.Models.BlogDbContext context)
        {

        }
    }
}
