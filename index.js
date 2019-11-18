require('dotenv').config()
const { db } = require('./db.js')
const { api } = require('./api.js')
var argv = require('minimist')(process.argv.slice(2));

db.sync();
api.getTweetsByTag(argv.tag);




