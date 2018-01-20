const Task = require('../models/Task');

module.exports = {
    index: (req, res) => {
        Task.find().then(task => {
            res.render('task/index', {'tasks': task});
        })
    },
    createGet: (req, res) => {
        res.render('task/create');
    },
    createPost: (req, res) => {
        let taskArgs = req.body;

        if (!taskArgs.title || !taskArgs.comments) {
            res.render('task/create');
            return;
        }

        Task.create(taskArgs).then(task => {
            res.redirect('/');
        });
    },
    deleteGet: (req, res) => {
        let id = req.params.id;
        Task.findById(id).then(task => {
            res.render('task/delete', task)
        }).catch(err => {
            res.redirect('/');
        });
    },
    deletePost: (req, res) => {
        let id = req.params.id;

        Task.findByIdAndRemove(id).then(task => {
            res.redirect('/');
        }).catch(err => {
            res.redirect('/');
        });
    }
};