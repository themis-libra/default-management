<template>
    <el-menu
        class="menu"
        @open="handleOpen"
        @close="handleClose"
        background-color=" #222E3C"
        text-color="#fff"
        active-text-color="#fff"
        :default-active="$route.path"
        router
        
        
    >
        
        <h1 class="text-white texth1">违约客户管理系统</h1>
        <hr class="boder">
        <template v-if="this.role.ccharacter == '客户'">
        <el-menu-item index="/apply">
            <i class="el-icon-document"></i>
            <span slot="title" >违约认定申请</span>
        </el-menu-item>
        <el-menu-item index="/refresh/apply">
            <i class="el-icon-setting"></i>
            <span slot="title" >重生认定申请</span>
        </el-menu-item>
        </template>
        <template v-if="this.role.ccharacter == '审核员'">
            <el-menu-item index="/identify/check">
                <i class="el-icon-setting"></i>
                <span slot="title">违约认定审核</span>
            </el-menu-item>
            <el-menu-item index="/refresh/check">
                <i class="el-icon-setting"></i>
                <span slot="title">重生认定审核</span>
            </el-menu-item>
            
        </template>
        <el-menu-item index="/statistics">
            <i class="el-icon-setting"></i>
            <span slot="title">违约统计</span>
        </el-menu-item>
    </el-menu>
</template>

<script>
export default {
    data() {
        return {
            role: {},
        }
    },

    methods: {
        handleOpen(key, keyPath) {
            console.log(key, keyPath)
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath)
        },
    },

    created() {
        this.role = JSON.parse(localStorage.getItem('role'))
    },
}
</script>

<style>
.tac {
    height: 100%;
}

.el-menu-item {
    padding-left: 0px !important;
}
.el-menu-item:hover {
    background-color: rgb(48, 69, 102) !important;
}
.el-menu-item:focus {
    background-color: rgb(48, 69, 102) !important;
}

.boder {
    color: rgb(246, 246, 246);
}

.texth1 {
    line-height: 30px;
    font-size: 16px;
}

</style>
