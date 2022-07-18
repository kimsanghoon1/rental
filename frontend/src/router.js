
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import RepairManager from "./components/listers/RepairCards"
import RepairDetail from "./components/listers/RepairDetail"

import CompanyManager from "./components/listers/CompanyCards"
import CompanyDetail from "./components/listers/CompanyDetail"


import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/repairs',
                name: 'RepairManager',
                component: RepairManager
            },
            {
                path: '/repairs/:id',
                name: 'RepairDetail',
                component: RepairDetail
            },

            {
                path: '/companies',
                name: 'CompanyManager',
                component: CompanyManager
            },
            {
                path: '/companies/:id',
                name: 'CompanyDetail',
                component: CompanyDetail
            },


            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },



    ]
})
