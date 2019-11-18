require('dotenv').config()
const fetch = require('node-fetch');
const { URLSearchParams } = require('url');


var argv = require('minimist')(process.argv.slice(2));

const headers = {
  'Content-Type': 'application/json',
  'Authorization': 'Bearer ' + process.env.TWITTER_BEARER_TOKEN
};

const params = new URLSearchParams();
params.append('q', argv.tag);
params.append('result_type', 'recent');
params.append('include_entities', true);
params.append('count', 100);

fetch('https://api.twitter.com/1.1/search/tweets.json?' + params,
  {
    method: 'GET',
    headers
  })
  .then(res => res.json())
  .then(json => console.log(json));
