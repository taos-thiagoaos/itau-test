const { api } = require('./api.js')
const { Tweet } = require('./models/tweet.js');
const { User } = require('./models/user.js');

global.addedUsersId = [];

const createTweet = (userId, tweetData, tag) => {
  return Tweet.create({
    text: tweetData.text,
    lang: tweetData.lang,
    date: tweetData.created_at,
    searchTag: tag,
    userId: userId,
  });
}

module.exports.service = {
  collectTweetsByTag: async (tag) => {
    // get all tweets by tag
    const tweets = await api.getTweetsByTag(tag);

    return tweets.forEach(tweetData => {
      let userPromiseId = null;

      // control already added users
      if(addedUsersId[tweetData.user.id]) {
        userPromiseId = User.update(
          { followers: tweetData.user.followers_count },
          { where: { id: tweetData.user.id } }
        ).then(() => tweetData.user.id);
      } else {
        addedUsersId[tweetData.user.id] = tweetData.user.id;

        userPromiseId = User.create({
          id: tweetData.user.id,
          name: tweetData.user.name,
          followers: tweetData.user.followers_count
        }).then(user => user.id);
      }

      return userPromiseId
        .then((userId) => {
          return createTweet(userId, tweetData, tag)
        })
        .catch(console.log)
    });
  }
}
