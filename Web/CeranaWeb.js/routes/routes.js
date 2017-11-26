var express = require('express');
var router = express.Router();

var controllers = require('.././controllers');

/* GET home page. */
router.get('/', controllers.login_controller.login);

router.get('/', function(req, res, next) {
   res.render('index', { title: 'Crud node js' });
});
module.exports = router;
