const Anime = require('../models/Anime');

module.exports = {
    index: (req, res) => {
        Anime.find().then(anime => {
            res.render('anime/index', {'animes': anime});
        })
    },
    createGet: (req, res) => {
        res.render('anime/create');
    },
    createPost: (req, res) => {
        let anime = req.body;

        if (!anime.rating
            || !anime.name
            || anime.description === "...") {
            res.redirect('/create');
            return;
        }

        Anime.create(anime).then(anime => {
            res.redirect('/');
        })
    },
    deleteGet: (req, res) => {
        let id = req.params.id;

        Anime.findById(id).then(anime => {
            res.render('anime/delete', anime)
        }).catch(err => {
            res.redirect('/');
        });
    },
    deletePost: (req, res) => {
        let id = req.params.id;

        Anime.findByIdAndRemove(id).then(anime => {
            res.redirect('/');
        }).catch(err => {
            res.redirect('/');
            return;
        });
    }
};