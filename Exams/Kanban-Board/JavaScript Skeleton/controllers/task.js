const Task = require('../models/Task');

module.exports = {
    index: (req, res) => {
        Task.find().then(tasks => {
            res.render('task/index', {
                'openTasks': tasks.filter(t => t.status === "Open"),
                'inProgressTasks': tasks.filter(t => t.status === "In Progress"),
                'finishedTasks': tasks.filter(t => t.status === "Finished")
            });
        });
    },
    createGet: (req, res) => {
        res.render('task/create');
    },
    createPost: (req, res) => {
        let taskArgs = req.body;

        if (!taskArgs.title) {
            res.render('task/create');
            return;
        }

        Task.create(taskArgs).then(task => {
            res.redirect('/');
        })
    },
    editGet: (req, res) => {
        let id = req.params.id;

        Task.findById(id).then(task => {
            res.render('task/edit', task)
        }).catch(err => {
            res.redirect('/');
        });
    },
    editPost: (req, res) => {
        let id = req.params.id;
        let task = req.body;

        if (!task.title) {
            res.redirect('/');
            return;
        }

        Task.findByIdAndUpdate(id, task).then(task => [
            res.redirect('/')
        ]).catch(err => {
            res.redirect('/');
        });
    }
};