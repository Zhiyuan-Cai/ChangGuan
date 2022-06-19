import store from '../store/index'

let user = localStorage.getItem('user')
if (user) {
    user = JSON.parse(user);
    store.commit('loginModule/setUser', user);
}