export default {
    namespaced: true,
    state: {
        userinfo: {
            jobNum: '',
            name: '',
            role: 1,
            token: ''
        }
    },
    mutations: {
        setUser(state, payload) {
            state.userinfo = payload;
        },
        clearUser(state) {
            state.userinfo = {
                jobNum: '',
                name: '',
                token: '',
                role: 1
            }
        }
    },
    actions: {

    },
    getters: {

    },
}