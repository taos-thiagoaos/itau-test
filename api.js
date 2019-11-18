const fetch = require('node-fetch');
const { URLSearchParams } = require('url');

const headers = {
  'Content-Type': 'application/json',
  'Authorization': 'Bearer ' + process.env.TWITTER_BEARER_TOKEN
};

module.exports.api = {
  getTweetsByTag: (tag) => {
    const params = new URLSearchParams();
    params.append('q', tag);
    params.append('result_type', 'recent');
    params.append('include_entities', true);
    params.append('count', 100);

    return fetch('https://api.twitter.com/1.1/search/tweets.json?' + params,
    {
      method: 'GET',
      headers
    })
    .then(res => res.json())
    .then(json => console.log(json));
  }
}
