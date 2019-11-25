const { Model } = require('sequelize');
const { Sequelize, DataTypes } = require('sequelize');
const { db } = require('../db.js')

class User extends Model {}

//table definition
User.init({
  id: { type: DataTypes.BIGINT, primaryKey: true },
  name: { type: DataTypes.STRING, allowNull: false },
  followers: { type: DataTypes.BIGINT, allowNull: false }
}, { sequelize: db, modelName: 'user', charset: 'utf8mb4', });

module.exports.User = User;
