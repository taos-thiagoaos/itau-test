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
    params.append('count', process.env.TOTAL_TWEETS_BY_TAG);

    return fetch('https://api.twitter.com/1.1/search/tweets.json?' + params, {
      method: 'GET',
      headers
    }).then(res => res.json()).then(data => data.statuses)
  }
}
