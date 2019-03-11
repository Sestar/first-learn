var path = require('path')
var utils = require('./utils')
var webpack = require('webpack')
var config = require('../config/index')
var merge = require('webpack-merge')
var baseWebpackConfig = require('./webpack.base.conf')
var CopyWebpackPlugin = require('copy-webpack-plugin')
var HtmlWebpackPlugin = require('html-webpack-plugin')
var ExtractTextPlugin = require('extract-text-webpack-plugin')
var OptimizeCSSPlugin = require('optimize-css-assets-webpack-plugin')

var entries =  utils.getMultiEntry('./src/'+config.moduleName+'/**/*.js'); // 获得入口js文件
var chunks = Object.keys(entries);


var env = process.env.NODE_ENV === 'testing'
  ? require('../config/test.env')
  : config.build.env
  
var webpackConfig = merge(baseWebpackConfig, {
  module: {
    rules: utils.styleLoaders({
      sourceMap: config.build.productionSourceMap,
      extract: true
    })
  },
  //devtool: config.build.productionSourceMap ? '#source-map' : false,
  output: {
    path: config.build.assetsRoot,
    filename: utils.assetsPath('js/[name].[hash].js'),
    chunkFilename: utils.assetsPath('js/[id].[hash].js')
  },
  plugins: [
    // http://vuejs.github.io/vue-loader/en/workflow/production.html
    new webpack.DefinePlugin({
      'process.env': env
    }),
    new webpack.optimize.UglifyJsPlugin({
      compress: {
        warnings: false
      },
      sourceMap: config.build.productionSourceMap
    }),
    // extract css into its own file
    new ExtractTextPlugin({
      filename: utils.assetsPath('css/[name].[hash].css'),
      ignoreOrder:true
    }),
    // Compress extracted CSS. We are using this plugin so that possible
    // duplicated CSS from different components can be deduped.
    new OptimizeCSSPlugin(),
    
    // split lib js into its own file
    new webpack.optimize.CommonsChunkPlugin({
      name: 'lib',
      minChunks: function (module, count) {
        // any required modules inside node_modules are extracted to vendor
        return (
          module.resource &&
          /\.js$/.test(module.resource) &&
          module.context && module.context.indexOf('node_modules') !== -1
        )
      }
    }),

    // // seperate webpack manifest file to avoid tainting lib file contents
    // new webpack.optimize.CommonsChunkPlugin({
    //   name: 'index',
    //   minChunks: Infinity,
    // })



    // // copy custom static assets
    // new CopyWebpackPlugin([
    //   {
    //     from: path.resolve(__dirname, '../static'),
    //     to: config.build.assetsSubDirectory,
    //     ignore: ['.*']
    //   }
    // ])
  ]
})

if (config.build.productionGzip) {
  var CompressionWebpackPlugin = require('compression-webpack-plugin')

  webpackConfig.plugins.push(
    new CompressionWebpackPlugin({
      asset: '[path].gz[query]',
      algorithm: 'gzip',
      test: new RegExp(
        '\\.(' +
        config.build.productionGzipExtensions.join('|') +
        ')$'
      ),
      threshold: 10240,
      minRatio: 0.8
    })
  )
}

if (config.build.bundleAnalyzerReport) {
  var BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin
  webpackConfig.plugins.push(new BundleAnalyzerPlugin())
}

//构建生成多页面的HtmlWebpackPlugin配置，主要是循环生成
var pages =  utils.getMultiEntry('./src/'+config.moduleName+'/**/*.html');
for (var pathname in pages) {
  var pathUrl = pathname.split('/');
  var conf = {
    filename: pathUrl[0]+ '/' + pathUrl[1] + '/' + pathUrl[2] +'.html',
    template: pages[pathname], // 模板路径
    chunks:pathUrl[2] !='clear' ? ['lib','index',pathname] : [], // 每个html引用的js模块
    inject: true,              // js插入位置
    minify: {
        minifyJS:true,
        removeAttributeQuotes: true // 移除属性的引号
    },
    // necessary to consistently work with multiple chunks via CommonsChunkPlugin
    chunksSortMode: 'dependency'
  };
 
  webpackConfig.plugins.push(new HtmlWebpackPlugin(conf));
}

module.exports = webpackConfig
