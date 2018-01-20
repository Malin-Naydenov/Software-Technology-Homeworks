const Report = require('../models/Report');

module.exports = {
    index: (req, res) => {
        Report.find().then(reports => {
            res.render('report/index', {'reports': reports})
        });
    },
    createGet: (req, res) => {
        res.render('report/create');
    },
    createPost: (req, res) => {
        let report = req.body;

        Report.create(report).then(report => {
            res.redirect('/');
        }).catch(err => res.redirect('/create'));
    },
    detailsGet: (req, res) => {
        Report.findById(req.params.id).then(report => {
            res.render('report/details', report);
        }).catch(err => res.redirect('/'));
    },
    deleteGet: (req, res) => {
        Report.findById(req.params.id).then(report => {
            res.render('report/delete', report);
        }).catch(err => res.redirect('/'));
    },
    deletePost: (req, res) => {
        Report.findByIdAndRemove(req.params.id).then(report => res.redirect('/')).catch(err => res.redirect('/'));
    }
};