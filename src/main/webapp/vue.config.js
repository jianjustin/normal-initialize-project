module.exports = {
	baseUrl: '/',
    outputDir : '../resources/static',
    devServer: {
        proxy: {
            '/api': {
                target: 'http://192.168.31.197:18125',
                changeOrigin: true,
                ws: true,
                pathRewrite: {
                  '^/api': ''
                }
            }
        }
    }
}