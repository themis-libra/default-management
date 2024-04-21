import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'
import './main.css'

Vue.use(ElementUI)
Vue.config.productionTip = false

new Vue({
    router,
    render: (h) => h(App),
    store,
}).$mount('#app')
