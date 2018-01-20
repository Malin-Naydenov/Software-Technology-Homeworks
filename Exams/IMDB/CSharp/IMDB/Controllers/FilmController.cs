using System.Linq;
using System.Net;
using System.Web.Mvc;
using IMDB.Models;

namespace IMDB.Controllers
{
    [ValidateInput(false)]
    public class FilmController : Controller
    {
        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            using (var db = new IMDBDbContext())
            {
                var films = db.Films.ToList();

                return View(films);
            }
        }

        [HttpGet]
        [Route("create")]
        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [Route("create")]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Film film)
        {
            if (string.IsNullOrWhiteSpace(film.Director)
                || string.IsNullOrWhiteSpace(film.Genre)
                || string.IsNullOrWhiteSpace(film.Name)
                || film.Year == 0)
            {
                return Redirect("create");
            }

            using (var db = new IMDBDbContext())
            {
                db.Films.Add(film);
                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }

        [HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int? id)
        {
            using (var db = new IMDBDbContext())
            {
                var film = db.Films.Find(id);

                if (film == null)
                {
                    return RedirectToAction("Index");
                }

                return View(film);
            }
        }

        [HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult EditConfirm(int? id, Film filmModel)
        {
            using (var db = new IMDBDbContext())
            {
                var film = db.Films.Find(id);

                if (film == null)
                {
                    return RedirectToAction("Index");
                }

                if (string.IsNullOrWhiteSpace(filmModel.Director)
                    || string.IsNullOrWhiteSpace(filmModel.Genre)
                    || string.IsNullOrWhiteSpace(filmModel.Name)
                    || filmModel.Year == 0)
                {
                    return RedirectToAction("Index");
                }

                film.Name = filmModel.Name;
                film.Director = filmModel.Director;
                film.Genre = filmModel.Genre;
                film.Year = filmModel.Year;

                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }

        [HttpGet]
        [Route("delete/{id}")]
        public ActionResult Delete(int? id)
        {
            using (var db = new IMDBDbContext())
            {
                var film = db.Films.Find(id);

                if (film == null)
                {
                    return RedirectToAction("Index");
                }

                return View(film);
            }
        }

        [HttpPost]
        [Route("delete/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirm(int? id, Film filmModel)
        {
            using (var db = new IMDBDbContext())
            {
                var film = db.Films.Find(id);

                if (film == null)
                {
                    return RedirectToAction("Index");
                }

                db.Films.Remove(film);
                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }
    }
}