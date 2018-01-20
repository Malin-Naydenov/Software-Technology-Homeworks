using System.Data.Entity;
using System.Linq;
using System.Web.Mvc;
using BookLibrary.Models;
using Microsoft.AspNet.Identity;

namespace BookLibrary.Controllers
{
    public class BooksController : Controller
    {
        [HttpGet]
        [Authorize]
        public ActionResult Index()
        {
            using (var db = new ApplicationDbContext())
            {
                var books = db.Books.Include(b => b.Author).ToList();

                return View(books);
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
        public ActionResult Create(Book book)
        {
            if (string.IsNullOrWhiteSpace(book.Title)
                || string.IsNullOrWhiteSpace(book.Description))
            {
                return Redirect("create");
            }

            using (var db = new ApplicationDbContext())
            {
                if (ModelState.IsValid)
                {
                    book.AuthorId = User.Identity.GetUserId();
                    db.Books.Add(book);
                    db.SaveChanges();

                    return RedirectToAction("Index");
                }
            }

            return View(book);
        }

        [HttpGet]
        public ActionResult Details(int? id)
        {
            using (var db = new ApplicationDbContext())
            {
                var book = db.Books.Include(b => b.Author).SingleOrDefault(b => b.Id == id);

                if (book == null)
                {
                    return RedirectToAction("Index");
                }

                return View(book);
            }
        }

        [HttpGet]
        [Authorize]
        public ActionResult Edit(int? id)
        {
            using (var db = new ApplicationDbContext())
            {
                var book = db.Books.Find(id);

                if (book == null)
                {
                    return RedirectToAction("Index");
                }

                var currentUser = User.Identity.GetUserId();
                if (book.AuthorId != currentUser)
                {
                    return RedirectToAction("Index");
                }

                return View(book);
            }
        }

        [HttpPost]
        [Authorize]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int? id, Book bookModel)
        {
            using (var db = new ApplicationDbContext())
            {
                var book = db.Books.Find(id);

                if (book == null)
                {
                    return RedirectToAction("Index");
                }

                var currentUser = User.Identity.GetUserId();
                if (book.AuthorId != currentUser)
                {
                    return RedirectToAction("Index");
                }

                book.Title = bookModel.Title;
                book.Description = bookModel.Description;

                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }

        [HttpGet]
        [Authorize]
        public ActionResult Delete(int? id)
        {
            using (var db = new ApplicationDbContext())
            {
                var book = db.Books.Find(id);

                if (book == null)
                {
                    return RedirectToAction("Index");
                }

                var currentUser = User.Identity.GetUserId();
                if (book.AuthorId != currentUser)
                {
                    return RedirectToAction("Index");
                }

                return View(book);
            }
        }

        [HttpPost]
        [Authorize]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int? id, Book bookModel)
        {
            using (var db = new ApplicationDbContext())
            {
                var book = db.Books.Find(id);

                if (book == null)
                {
                    return RedirectToAction("Index");
                }

                var currentUser = User.Identity.GetUserId();
                if (book.AuthorId != currentUser)
                {
                    return RedirectToAction("Index");
                }

                db.Books.Remove(book);
                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }
    }
}