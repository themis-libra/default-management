<template>
    <el-card class="card">
        <!--对于之前认定为违约的客户，现在由于一些原因，可以进行重生。
            查询列表展示字段：违约客户、审核状态、认定违约原因、严重程度、认定人 、认定申请时间、认定 审核时间、最新外部等级信息。
            违约重生界面展示：违约客户、 认定违约原因、严重程度、认定人 、认定申请时间、最新外部等级、选择重生原因。-->
        <header slot="header">
            <span style="margin-left: 8px;">重生认定审核</span>
        </header>
        <el-table :data="tableData">
            <el-table-column 
                label="ID" 
                width="80" 
                style="margin-left: 10px;" 
                prop="id">
            </el-table-column>
            <el-table-column 
                label="违约客户" 
                width="150"
                prop="Rcname">
            </el-table-column>
            <el-table-column 
                label="审核状态" 
                width="150"
                prop="Rcstatus">
            </el-table-column>
            <el-table-column 
                label="认定违约原因" 
                width="300"
                prop="Rano">
            </el-table-column>
            <el-table-column 
                label="严重程度" 
                width="150"
                prop="RRgoavity">
            </el-table-column>
            <el-table-column 
                label="认定人" 
                width="150"
                prop="Rauditor">
            </el-table-column>
            <el-table-column 
                label="重生原因" 
                width="150"
                prop="Rreson">
            </el-table-column>
            <el-table-column 
                label="认定申请时间" 
                width="150"
                prop="Ratime">
            </el-table-column>
            <el-table-column  
                label="认定审核时间" 
                width="150"
                prop="Rctime">
            </el-table-column>
            <el-table-column 
                label="最新外部等级" 
                width="150"
                prop="Rlevel">
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
                        通过</el-button
                    >
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
            tableData: '',
            pageSize: '5',
            total: '',
            currentPage: '',
            user:'',
            reasonList:'',
        
        }
    },
    methods: {
        async check(target, approve) {
            const result = await ApiPost('/renewApply/check/'+target+'/'+approve+'/'+this.user.cname)
            if (result.data.code == '0') {
                this.$message.success('操作成功')
                const resp = await ApiGet('/renewApply/list/1/'+this.pageSize)
                this.tableData = resp.data.data.data;
                this.total = resp.data.data.total
            } else {
                this.$message.error('操作失败')
            }
        },

        
        async page(currentPage){
            const resp = await ApiGet('renewApply/list/'+currentPage+'/'+this.pageSize)
            this.tableData = resp.data.data.data;
            this.total = resp.data.data.total
        }

    },

    async created() {

        this.user = JSON.parse(localStorage.getItem('role'));
  
        const resp1 = await ApiGet('/renewApply/list/1/'+this.pageSize)
        this.tableData = resp1.data.data.data;
        this.total = resp1.data.data.total


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
