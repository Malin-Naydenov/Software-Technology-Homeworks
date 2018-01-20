const Product = require('../models/Product');

module.exports = {
    index: (req, res) => {
        Product.find().then(product => {
            res.render('product/index', {'entries': product});
        })
    },
    createGet: (req, res) => {
        res.render('product/create');
    },
    createPost: (req, res) => {
        let product = req.body;

        if (!product.priority
            || !product.name
            || !product.quantity) {
            res.redirect('create/');
            return;
        }

        Product.create(product).then(product => {
            res.redirect('/');
        })
    },
    editGet: (req, res) => {
        let id = req.params.id;

        Product.findById(id).then(product => {
            res.render('product/edit', product)
        }).catch(err => {
            res.redirect('/');
            return;
        });
    },
    editPost: (req, res) => {
        let id = req.params.id;
        let product = req.body;

        if (!product.priority
            || !product.name
            || !product.quantity) {
            res.redirect('/');
            return;
        }

        Product.findByIdAndUpdate(id, product).then(product => {
            res.redirect('/');
        }).catch(err => {
            res.redirect('/');
            return;
        });
    }
};