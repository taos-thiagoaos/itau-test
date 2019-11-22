require('dotenv').config()
const { db } = require('./db.js')
const { service } = require('./service.js')
var argv = require('minimist')(process.argv.slice(2));

const defaultTags = ['openbanking', 'apifirst', 'devops', 'cloudfirst', 'microservices', 'apigateway', 'oauth', 'swagger', 'raml', 'openapis'];
const tags = (argv.tag) ? [argv.tag] : defaultTags;

db.sync({ force: true }).then(async () => {

  tags.map((tag) => '#' + tag).forEach(await service.collectTweetsByTag);

});
