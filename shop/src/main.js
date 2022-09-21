import {createApp} from 'vue'
import App from './App.vue'
import router from "./router"
import ElementPlus from 'element-plus'
import zhCn from 'element-plus/es/locale/lang/zh-cn'
import 'element-plus/dist/index.css'
import '@/assets/css/global.css'
import * as echarts from 'echarts'

const app = createApp(App);
app.use(router).use(ElementPlus, {locale: zhCn}).mount('#app')

Vue.prototype.$echarts = echarts

