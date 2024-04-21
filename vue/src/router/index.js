import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '@/views/layout'

Vue.use(VueRouter)

const routes = [
    {
        path: '/main',
        component: Layout,
        redirect:'/statistics',
        children: [
            {
                path: '/apply',
                component: () => import('@/views/identifyApply/index.vue'),
            },
            {
                path: '/refresh/apply',
                component: () => import('@/views/refreshApply/index.vue'),
            },
            {
                path: '/identify/check',
                component: () => import('@/views/identifyCheck/index.vue'),
            },
            {
                path: '/refresh/check',
                component: () => import('@/views/refreshCheck/index.vue'),
            },
            {
                path: '/statistics',
                component: () => import('@/views/statistics/index.vue'),
            },
        ],
    },
    {
        path: '/',
        component: () => import('@/views/login/index.vue'),
    },
]

const router = new VueRouter({
    mode: 'hash',
    base: process.env.BASE_URL,
    routes,
})

export default router
