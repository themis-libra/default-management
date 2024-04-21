<template>
    <el-container class="container">
        <el-aside width="200px">
            <Aside class="aside" />
        </el-aside>
        <el-main style="padding: 0">
            <el-header>
                <Header></Header>
            </el-header>
            <el-container class="main">
                <router-view />
            </el-container>
        </el-main>
    </el-container>
</template>

<script>
import Header from './components/Header.vue'
import Aside from './components/Aside.vue'

export default {
    name: 'Layout',

    components: {
        Aside: Aside,
        Header: Header,
    },
    data() {
        return {}
    },
}
</script>

<style>
.container {
    position: fixed;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
}

.el-aside {
    height: 100%;
    width: 300px;
}

.aside {
    height: 100%;
}

.el-main {
    background: #f6f6f6;
}

.main {
    padding: 12px 10px 10px 10px;
}

.el-header {
    width: 100%;
    padding: 0 !important;
    height: 300px;
}
</style>
