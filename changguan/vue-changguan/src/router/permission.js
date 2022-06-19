import router from './index';

import store from '../store/index'

router.beforeEach((to, from, next) => {
    // console.log("---to---", to);
    if (to.matched.some(ele => ele.meta.isLogin)) {
        let token = store.state.loginModule.userinfo.token;
        // console.log("token", token);
        if (token) {
            next()
        } else {
            next('/login')
        }
    } else {
        next();
    }
})