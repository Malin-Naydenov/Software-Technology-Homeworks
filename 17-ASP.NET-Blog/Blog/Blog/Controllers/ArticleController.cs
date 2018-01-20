namespace Blog.Controllers
{
    using System.Data.Entity;
    using System.Linq;
    using System.Web.Mvc;
    using Models;
    using Microsoft.AspNet.Identity;

    public class ArticleController : Controller
    {
        public ActionResult Index()
        {
            return RedirectToAction("List");
        }

        public ActionResult List()
        {
            using (var db = new BlogDbContext())
            {
                var articles = db.Articles
                    .Include(a => a.Author)
                    .ToList();

                return View(articles);
            }
        }

        [HttpGet]
        [Authorize]
        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [Authorize]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Article article)
        {
            var db = new BlogDbContext();

            if (ModelState.IsValid)
            {
                article.AuthorId = User.Identity.GetUserId();

                db.Articles.Add(article);
                db.SaveChanges();

                return RedirectToAction("Details", new { id = article.Id });
            }
            return RedirectToAction("Create");
        }

        [HttpGet]
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return RedirectToAction("List");
            }

            using (var db = new BlogDbContext())
            {
                var article = db.Articles.Include(a => a.Author)
                    .Single(a => a.Id == id);

                if (article == null)
                {
                    return RedirectToAction("List");
                }

                return View(article);
            }
        }

        [HttpGet]
        [Authorize]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return RedirectToAction("List");
            }

            using (var db = new BlogDbContext())
            {
                var article = db.Articles.Find(id);

                if (article == null)
                {
                    return RedirectToAction("List");
                }

                if (!IsUserAuthorize(article))
                {
                    return RedirectToAction("List");
                }

                var articleViewModel = new ArticleViewModel();
                articleViewModel.Id = article.Id;
                articleViewModel.Title = article.Title;
                articleViewModel.Content = article.Content;

                return View(articleViewModel);
            }
        }

        [HttpPost]
        [Authorize]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int? id, ArticleViewModel articleViewModel)
        {
            if (id == null)
            {
                return RedirectToAction("List");
            }

            var db = new BlogDbContext();
            var article = db.Articles.Find(id);

            if (article == null)
            {
                return RedirectToAction("List");
            }

            if (!IsUserAuthorize(article))
            {
                return RedirectToAction("List");
            }

            if (ModelState.IsValid)
            {
                article.Title = articleViewModel.Title;
                article.Content = articleViewModel.Content;

                db.SaveChanges();

                return RedirectToAction("Details", new { id = article.Id });
            }

            return RedirectToAction("Edit", new {id = article.Id});
        }

        [HttpGet]
        [Authorize]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return RedirectToAction("List");
            }

            using (var db = new BlogDbContext())
            {
                var article = db.Articles.Find(id);

                if (article == null)
                {
                    return RedirectToAction("List");
                }

                if (!IsUserAuthorize(article))
                {
                    return RedirectToAction("List");
                }

                return View(article);
            }
        }

        [HttpPost]
        [Authorize]
        [ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult ConfrimDelete(int? id)
        {
            if (id == null)
            {
                return RedirectToAction("List");
            }

            using (var db = new BlogDbContext())
            {
                var article = db.Articles.Find(id);

                if (article == null)
                {
                    return RedirectToAction("List");
                }

                if (!IsUserAuthorize(article))
                {
                    return RedirectToAction("List");
                }

                db.Articles.Remove(article);
                db.SaveChanges();

                return RedirectToAction("List");
            }
        }

        public bool IsUserAuthorize(Article article)
        {
            bool isAdmin = this.User.IsInRole("Admin");
            bool isAuthor = article.AuthorId == this.User.Identity.GetUserId();

            return isAdmin || isAuthor;
        }
    }
}