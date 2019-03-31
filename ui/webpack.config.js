require('@babel/register');

const developmentConfig = require('./webpack/development');
const productionConfig = require('./webpack/production');

function config(env = {}) {
  if (env.development) {
    return developmentConfig;
  }
  return productionConfig;
}

module.exports = config;
