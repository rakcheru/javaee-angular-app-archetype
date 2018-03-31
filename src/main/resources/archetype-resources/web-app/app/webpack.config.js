var path = require('path');

var webpack = require('webpack');

// index.html
var HtmlWebpackPlugin = require('html-webpack-plugin');
var indexHtml = new HtmlWebpackPlugin({
  template: 'src/main/webapp/index.html',
  filename: './index.html',
  inject : true,
  chunksSortMode: "manual",
  chunks:[
    "inline",
    "polyfills",
    "vendor",
    "main",
    "ng1"
  ]
});

// CSS
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var extractCss = new ExtractTextPlugin('css/css.css');

// Vendor chunk
const fs = require("fs");
const projectRoot = path.resolve(__dirname);    // TODO : make relative to absolute
const nodeModules = path.resolve(projectRoot, 'node_modules');
const realNodeModules = fs.realpathSync(nodeModules);
const appRoot = path.resolve(projectRoot, 'src'); // Needed ? TODO
const genDirNodeModules = path.resolve(appRoot, '$$_gendir', 'node_modules'); // Needed ? TODO

module.exports = {

  resolve : {
    extensions: [ ".ts", ".js" ]
  },

  entry: {
    "vendor" : ["angular"],
    "main": "./src/main/webapp/main.ts",
    "polyfills": "./src/main/webapp/polyfills.ts",
    "ng1" : "./src/main/webapp/ng1/ng1.js"
  },

  output: {
    filename: "[name].bundle.js",
    path: path.resolve(__dirname, "./target/app-1.0")
  },

  module: {
    rules: [
      {
        test: /\.css$/,
        exclude: [
          path.resolve(__dirname, "src", "app"),
          path.resolve(__dirname, "node_modules"),
        ],
        use: ExtractTextPlugin.extract({
          fallback: 'style-loader',
          use: [ 'css-loader' ]
        })
      },
      {
        test: /\.css$/,
        include: path.resolve(__dirname, "src", "app"),
        use: "raw-loader"
      },
      {
        test: /\.html$/,
        use: 'html-loader',
        exclude: path.resolve(__dirname, "node_modules")
      },
      {
        test: /\.ts?$/,
        use: 'ts-loader',
        exclude: path.resolve(__dirname, "node_modules")
      }
    ]
  },

  plugins: [
    // index.html
    indexHtml,

    // CSS
    extractCss,

    // Angular warning fix : https://github.com/angular/angular/issues/20357
    new webpack.ContextReplacementPlugin(
      /angular(\\|\/)core/,
      path.resolve(__dirname, './src')
    ),
    new webpack.optimize.CommonsChunkPlugin({
      name: "inline",
      "minChunks": null,
    }),
    new webpack.optimize.CommonsChunkPlugin({
      name: 'vendor',
      chunks: ['main'],
      minChunks: (module) => {
        return module.resource
          && (module.resource.startsWith(nodeModules)
            || module.resource.startsWith(genDirNodeModules)
            || module.resource.startsWith(realNodeModules));
      }
    })
  ]

};
