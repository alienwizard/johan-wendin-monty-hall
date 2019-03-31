import {join} from 'path';

import commonConfig from './common';

const outputPath = join(__dirname, '..', '..', 'static');

export default {
  ...commonConfig,
  mode: 'production',
  output: {
    path: outputPath,
    filename: '[name].js',
    publicPath: '/'
  }
};