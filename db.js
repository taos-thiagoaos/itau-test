const { Sequelize, DataTypes } = require('sequelize');
const { Tweet } = require('./models/tweet.js');

// DB init
const sequelize = new Sequelize(
  process.env.DB_DATABASE,
  process.env.DB_USERNAME,
  process.env.DB_PASSWORD,
  {
    dialect: 'mysql',
    host: process.env.DB_HOST
  }
)

//table definition
Tweet.init({
  id: { type: Sequelize.INTEGER, autoIncrement: true, primaryKey: true },
  text: DataTypes.STRING,
  date: DataTypes.DATE,
  lang: DataTypes.STRING,
  user_id: DataTypes.BIGINT,
  user_name: DataTypes.STRING,
  user_followers: DataTypes.BIGINT
}, { sequelize, modelName: 'tweet' });

module.exports.db = sequelize;
