const { api } = require('./api.js')
const { Tweet } = require('./models/tweet.js');

module.exports.service = {
  collectTweetsByTag: (tag) => {
    const tweets = await api.getTweetsByTag(tag);

    // id: { type: Sequelize.INTEGER, autoIncrement: true, primaryKey: true },
    // text: DataTypes.STRING,
    // date: DataTypes.DATE,
    // lang: DataTypes.STRING,
    // user_id: DataTypes.BIGINT,
    // user_name: DataTypes.STRING,
    // user_followers: DataTypes.BIGINT

    tweets.forEach(tweet => {
      Tweet.create({
        username: 'janedoe',
        birthday: new Date(1980, 6, 20)
      });
    });
  }
}
