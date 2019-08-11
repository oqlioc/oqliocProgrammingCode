const Router = require('koa-router');
const posts = require('./posts');

const api = new Router();

api.use('/posts', posts.routes());  // posts 라우트를 api 라우터에 연결

// 라우터를 내보낸다.
module.exports = api;