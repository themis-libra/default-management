<template>
    <el-card class="card">
        <header slot="header">
            <span style="margin-left: 8px;">违约认定审核</span>
        </header>
        <el-table :data="tableData">
            <el-table-column 
                label="ID" 
                width="80" 
                style="margin-left: 10px;" 
                prop="id">
            </el-table-column>
            <el-table-column 
                label="客户名称" 
                width="150"
                prop="Dname">
            </el-table-column>
            <el-table-column 
                label="审核状态" 
                width="150"
                prop="Dcstatus">
            </el-table-column>
            <el-table-column 
                label="认定违约原因" 
                width="300"
                prop="Dano">
            </el-table-column>
            <el-table-column 
                label="备注" 
                width="150"
                prop="Danote">
            </el-table-column>
            <el-table-column  
                label="严重程度" 
                width="150"
                prop="Rgoavity">
            </el-table-column>
            <el-table-column 
                label="认定人" 
                width="150"
                prop="Dauditor">
            </el-table-column>
            <el-table-column 
                label="认定申请时间" 
                width="150"
                prop="Datime">
            </el-table-column>
            <el-table-column 
                label="认定审核时间" 
                width="150"
                prop="Dctime">
            </el-table-column>
            <el-table-column
                label="最新外部等级"
                width="150"
                prop="Dlevel">
            </el-table-column>
            <el-table-column 
                label="操作" 
                width="300">
                <template slot-scope="scope">
                    <el-button
                        @click="check(scope.row.id, true)"
                        :disabled="total < 1"
                        type="primary"
                    >
                        通过</el-button>
                    <el-button
                        @click="check(scope.row.id, false)"
                        :disabled="total < 1"
                        type="danger"
                    >
                        拒绝</el-button
                    >
                </template>
            </el-table-column>
        </el-table>
        <el-pagination style="margin-top: 20px;float: right" background layout="prev, pager, next" :page-size="pageSize"
            :total="total" :current-page.sync="currentPage" @current-change="page">
        </el-pagination>
    </el-card>
</template>

<script>
import { ApiGet, ApiPost } from '@/utils/request'

export default {
    data() {
        return {
            form: {
                target_name: '',
                risk_reason: '',
                external_level: '',
                risk_level: '',
                remark: '',
                appendix: [],
            },
            reasonList: '',
            tableData: '',
            pageSize: '5',
            total: '',
            currentPage: '',
            user:'',
            reasonValue:''
        }
    },
    methods: {
        async check(target, approve) {
            const resp = await ApiPost('/Apply/check/'+target+'/'+approve+'/'+this.user.cname)
            if (resp.data.code == '0') {
                this.$message.success('操作成功')
                const resp = await ApiGet('/Apply/list/1/'+this.pageSize)
                this.tableData = resp.data.data.data;
                this.total = resp.data.data.total
            } else {
                this.$message.error('操作失败')
            }
        },

        async page(currentPage){
            const resp = await ApiGet('Apply/list/'+currentPage+'/'+this.pageSize)
            this.tableData = resp.data.data.data;
            this.total = resp.data.data.total
        }
    },

    async created() {
        const resp = await ApiGet('/Apply/list/1/'+this.pageSize)
        this.tableData = resp.data.data.data;
        this.total = resp.data.data.total

        this.user = JSON.parse(localStorage.getItem('role'));
        console.log(this.user.cname)
    },
}
</script>

<style scoped>
header {
    display: flex;
}

.card {
    width: 100%;
}

.btn-submit {
    width: 200px;
}

.selector {
    width: 100%;
}

</style>
