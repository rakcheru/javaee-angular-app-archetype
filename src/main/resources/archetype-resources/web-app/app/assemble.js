'use strict';
(function () {

  var path = require('path');
  var webpack = require("webpack");
  var webpackConfig = require("./webpack.config");

  module.exports = {

    bundle : function() {
      webpack(webpackConfig).run((err, stats) => {
        if (err || stats.hasErrors()) {
        console.error("------------------------------------------------------------------------");
        console.error("FAILURE");
        console.error("------------------------------------------------------------------------");
        throw stats.toJson().errors;
      }
      console.log(stats.toString());
    });
    }
  };

})();