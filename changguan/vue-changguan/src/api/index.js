/**
 * 请求的方法
 */

import axios from 'axios'
import base from './base'
//node>js 
// const qs = require('querystring')
//导入二次封装的axios文件
// import axios from '../utils/request'

//axios接口配置基础地址
// axios.defaults.baseURL = process.env.VUE_APP_BASE_URL;
//http://localhost:8989 

const api = {
    /**
     * 登录接口
     */
    getLogin(params) {//params={username:'',password:''}
        return axios.post(base.login, params)
    },

    getAdminList(params) {//{page:xx}
        return axios.post(base.adminList, params)
    },
    getSearchAdmin(params) {
        return axios.post(base.search, params)
    },
    addPerson(params) {
        return axios.post(base.addPerson, params)
    },
    deletePerson(params) {
        return axios.post(base.deletePerson, params)
    },
    updatePerson(params) {
        return axios.post(base.updatePerson, params)
    },

    /**
     * 网格
     */
    getGridList(params) {//{page:xx}
        return axios.post(base.gridList, params)
    },
    getSearchGrid(params) {
        return axios.post(base.searchGrid, params)
    },
    addGrid(params) {
        return axios.post(base.addGrid, params)
    },
    deleteGrid(params) {
        return axios.post(base.deleteGrid, params)
    },
    updateGrid(params) {
        return axios.post(base.updateGrid, params)
    },
    getGridOptions() {
        return axios.get(base.getGridOptions)
    },
    /**
     * 控制室
     */
    getControlList(params) {//{page:xx}
        return axios.post(base.controlList, params)
    },
    getSearchControl(params) {
        return axios.post(base.searchControl, params)
    },
    addControl(params) {
        return axios.post(base.addControl, params)
    },
    deleteControl(params) {
        return axios.post(base.deleteControl, params)
    },
    updateControl(params) {
        return axios.post(base.updateControl, params)
    },
    getControlOptions() {
        return axios.get(base.getControlOptions)
    },
    /**
     * 场景
     */
    getSceneList(params) {//{page:xx}
        return axios.post(base.sceneList, params)
    },
    getSearchScene(params) {
        return axios.post(base.searchScene, params)
    },
    addScene(params) {
        return axios.post(base.addScene, params)
    },
    deleteScene(params) {
        return axios.post(base.deleteScene, params)
    },
    updateScene(params) {
        return axios.post(base.updateScene, params)
    },
    getSceneOptions() {
        return axios.get(base.getSceneOptions)
    },
    /**
     * 设备类别
     */
    getCategoryList(params) {//{page:xx}
        return axios.post(base.categoryList, params)
    },
    getSearchCategory(params) {
        return axios.post(base.searchCategory, params)
    },
    addCategory(params) {
        return axios.post(base.addCategory, params)
    },
    deleteCategory(params) {
        return axios.post(base.deleteCategory, params)
    },
    updateCategory(params) {
        return axios.post(base.updateCategory, params)
    },
    getCategoryOptions() {
        return axios.get(base.getCategoryOptions)
    },
    /**
     * 设备
     */
    getDeviceList(params) {//{page:xx}
        return axios.post(base.deviceList, params)
    },
    getSearchDevice(params) {
        return axios.post(base.searchDevice, params)
    },
    addDevice(params) {
        return axios.post(base.addDevice, params)
    },
    deleteDevice(params) {
        return axios.post(base.deleteDevice, params)
    },
    updateDevice(params) {
        return axios.post(base.updateDevice, params)
    },
    // /**
    //  * 商品列表
    //  */
    // getGoodsList(params) {//{page:xx}
    //     return axios.get(base.goodsList, {
    //         params
    //     })
    // },
    // /**
    //  * 搜索商品数据
    //  * search
    //  */
    // getSearch(params) {//{search:xx}
    //     return axios.get(base.search, { params })
    // },
    // /**
    //  * 获取类目选择
    //  * {id：cid}
    //  */
    // getSelectCategory(params) {
    //     return axios.get(base.selectCategory, { params })
    // },
    // /**
    //  * 添加商品
    //  * 参数： title cid  category sellPoint price num desc paramsInfo image
    //  */
    // addGoods(params) {//={}
    //     return axios.get(base.addGoods, {
    //         params
    //     })
    // },
    // /**
    //  * 删除商品 id
    //  */
    // deleteGoods(params) {
    //     return axios.get(base.deleteGoods, { params })
    // },
    // /**
    //  * 编辑商品id
    //  */
    // updateGoods(params) {
    //     return axios.get(base.updateGoods, { params })
    // },
    // /**
    // * 统计数据
    // */
    // getStatistical() {
    //     return axios.get(base.statistical)
    // },
    // /**
    //  * 销量对比
    //  */
    // getSellTotal() {
    //     return axios.get(base.sellTotal)
    // },
    // /**
    //  * 规格参数获取列表 
    //  * page：xx
    //  */
    // getParams(params) {
    //     return axios.get(base.params, { params })
    // },
    // /**
    //  * 获取订单数据
    //  * currPage:xx
    //  */
    // orderList(params) {
    //     return axios.get(base.orderList, { params })
    // },
    // /**
    //  * 规格参数新增
    //  *  参数：itemCatId,content,specsName
    //  */
    // insertItemParam(params) {
    //     return axios.get(base.insertItemParam, { params })
    // },
    // /**
    //  * 商品列表---获取类目规格配置
    //  * cid
    //  */
    // categoryData(params) {
    //     return axios.get(base.categoryData, { params })
    // }



}

export default api
