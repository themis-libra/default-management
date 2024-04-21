<template>
    <div class="header">
        <div class="info">
            <div class="nickname">{{ user.cname }}</div>
        </div>
        <div class="logout">
            <a
                @click="$router.push('/')"
                class="text-blue-900 text-sm pr-3 cursor-pointer"
                >退出
            </a>
        </div>
    </div>
</template>

<script>

export default {
    name: 'Header',
    data() {
        return {
            user: '',
        }
    },
    async created() {
        let user = JSON.parse(localStorage.getItem('role'));
        this.user = user
    },
}
</script>

<style>
.header {
    background: #fff;
    width: 100%;
    padding: 0;
    height: 63px;
    display: flex;
    align-items: center;
}

.info {
    margin-left: auto;
    justify-self: flex-end;
    display: flex;
    align-items: center;
    margin-right: 20px;
}

.avatar {
    margin-right: 30px;
}
.pr-3 {
    padding-right: 1.75rem !important;
}

</style>
