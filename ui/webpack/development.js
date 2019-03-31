import {join} from 'path';

import commonConfig from './common';

const outputPath = join(__dirname, '..', 'build');

export default {
  ...commonConfig,
  mode: 'development',
  target: 'web',
  resolve: {
    extensions: ['.jsx', '.js', '.json', '.scss', '.css'],
    modules: ['node_modules', 'src']
  },
  entry: {
    app: join(__dirname, '..', 'src', 'index.js')
  },
  output: {
    path: outputPath,
    filename: '[name].js',
    publicPath: '/'
  },
  devServer: {
    contentBase: join(__dirname, '..', 'dist'),
    proxy: {
      '/api': `http://localhost:${process.env.PROXY_PORT || 8080}`
    },
    port: 9000
  }
};