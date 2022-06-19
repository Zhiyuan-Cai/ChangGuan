import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '../views/Layout/index.vue'
import Login from '../views/Login/Login.vue'
import Home from '../views/Home/Home.vue'

const Person = () => import('../views/Person/Person.vue')
const Grid = () => import('../views/Grid/Grid.vue')
const Control = () => import('../views/Control/Control.vue')
const Scene = () => import('../views/Scene/Scene.vue')
const Device = () => import('../views/Device/Device.vue')
const Content = () => import('../views/Content/Content.vue')
const Category = () => import('../views/Device/Category.vue')
const Manage = () => import('../views/Device/Manage.vue')

const AddPerson = () => import('../views/Person/AddPerson.vue')


Vue.use(VueRouter)

const routes = [
  {
    path: '',
    component: Layout,
    meta: {
      isLogin: true,
    },
    children: [
      {
        path: '/',
        name: 'Home',
        component: Home
      },
      {
        path: '/person',
        name: 'Person',
        component: Person
      },
      {
        path: '/add-person',
        name: 'AddPerson',
        component: AddPerson
      },
      {
        path: '/grid',
        name: 'Grid',
        component: Grid
      },
      {
        path: '/control',
        name: 'Control',
        component: Control
      },
      {
        path: '/device',
        name: 'Device',
        component: Device,
        redirect: '/device/category',
        children: [
          {
            path: 'device-manage',
            component: Manage
          },
          {
            path: 'category',
            component: Category
          }
        ]
      },
      {
        path: '/scene',
        name: 'Scene',
        component: Scene
      },
      {
        path: '/content',
        name: 'Content',
        component: Content
      }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})



export default router
