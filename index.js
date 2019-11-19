require('dotenv').config()
const { db } = require('./db.js')
const { service } = require('./service.js')
var argv = require('minimist')(process.argv.slice(2));

db.sync(() => {

  service.collectTweetsByTag(argv.tag);

});





