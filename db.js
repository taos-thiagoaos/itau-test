const { Sequelize } = require('sequelize');

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

module.exports.db = sequelize;
