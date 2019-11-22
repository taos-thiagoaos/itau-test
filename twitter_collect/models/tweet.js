const { Model } = require('sequelize');
const { Sequelize, DataTypes } = require('sequelize');
const { db } = require('../db.js');
const { User } = require('./user.js');

class Tweet extends Model {}

//table definition
Tweet.init({
  id: { type: Sequelize.INTEGER, autoIncrement: true, primaryKey: true },
  text: { type: DataTypes.STRING, allowNull: false },
  date: { type: DataTypes.DATE, allowNull: false },
  lang: { type: DataTypes.STRING, allowNull: false },
  searchTag: { type: DataTypes.STRING, allowNull: false },
}, { sequelize: db, modelName: 'tweet', charset: 'utf8mb4', });

Tweet.hasOne(User);

module.exports.Tweet = Tweet;
