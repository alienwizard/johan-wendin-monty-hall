import HTMLWebpackPlugin from 'html-webpack-plugin';
import {join} from 'path';

export default {
  target: 'web',
  resolve: {
    extensions: ['.jsx', '.js', '.json', '.scss', '.css'],
    modules: ['node_modules', 'src']
  },
  entry: {
    app: join(__dirname, '..', 'src', 'index.js')
  },
  module: {
    rules: [
      {
        test: /.jsx?$/,
        loader: 'babel-loader',
      },
      {
        test: /\.s?css$/,
        use: [
          'style-loader',
          'css-loader',
          {
            loader: 'sass-loader',
            options: {
              includePaths: ['./node_modules']
            }
          },
        ]
      }
    ]
  },
  plugins: [
    new HTMLWebpackPlugin({
      template: join(__dirname, '..', 'src', 'index.html')
    })
  ]
};
