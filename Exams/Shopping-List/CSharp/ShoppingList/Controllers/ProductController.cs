using System.Linq;
using System.Web.Mvc;
using ShoppingList.Models;

namespace ShoppingList.Controllers
{
    [ValidateInput(false)]
    public class ProductController : Controller
    {
        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            using (var db = new ShoppingListDbContext())
            {
                var products = db.Products.ToList();

                return View(products);
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
        public ActionResult Create(Product product)
        {
            if (product.Priority < 1
                || string.IsNullOrWhiteSpace(product.Name)
                || product.Quantity < 1)
            {
                return Redirect("create");
            }

            using (var db = new ShoppingListDbContext())
            {
                db.Products.Add(product);
                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }

        [HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int? id)
        {
            using (var db = new ShoppingListDbContext())
            {
                var product = db.Products.Find(id);

                if (product == null)
                {
                    return RedirectToAction("Index");
                }

                return View(product);
            }
        }

        [HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult EditConfirm(int? id, Product productModel)
        {
            using (var db = new ShoppingListDbContext())
            {
                var product = db.Products.Find(id);

                if (product == null)
                {
                    return RedirectToAction("Index");
                }

                if (productModel.Priority < 1
                    || string.IsNullOrWhiteSpace(productModel.Name)
                    || productModel.Quantity < 1)
                {
                    return RedirectToAction("Index");
                }

                product.Priority = productModel.Priority;
                product.Name = productModel.Name;
                product.Quantity = productModel.Quantity;
                product.Status = productModel.Status;

                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }
    }
}