<template>
  <div style="padding: 10px">
    <!--    功能区域-->
    <div style="margin: 10px 0">
      <el-button type="primary" @click="dialogVisible = true">新增</el-button>
      <!-- <el-popconfirm title="确定删除吗？" @confirm="deleteBatch">
        <template #reference>
          <el-button type="danger">批量删除</el-button>
        </template>
      </el-popconfirm> -->
    </div>
    <!--    搜索区域-->
    <!-- <div style="margin: 10px 0">
      <el-input
          v-model="search"
          clearable
          placeholder="请输入关键字"
          style="width: 20%"
      ></el-input>
      <el-button style="margin-left: 5px" type="primary" @click="load"
      >查询
      </el-button
      >
    </div> -->
    <el-table
        v-loading="loading"
        :data="tableData"
        border
        size="mini"
        stripe
        style="width: 100%"
    >
      <!--        @selection-change="handleSelectionChange"-->

      <el-table-column type="selection" width="40"></el-table-column>
      <el-table-column label="商品分类" prop="name"></el-table-column>

      <el-table-column label="操作" width="600">
        <template #default="scope">
          <el-popconfirm
              title="确定删除吗？"
              @confirm="handleDelete(scope.row.goodsCateId)"
          >
            <template #reference>
              <el-button size="mini" type="danger">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog v-model="dialogVisible" title="商品信息" width="30%">
      <el-form :model="form" label-width="120px">
        <el-form-item label="商品类别">
          <el-input v-model="form.name" style="width: 80%"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="add()">确 定</el-button>
        </span>
      </template>
    </el-dialog>
    <div style="margin: 10px 0">
      <el-pagination
          :current-page="currentPage"
          :page-size="pageSize"
          :page-sizes="[5, 10, 20]"
          :total="total"
          layout="total, sizes, prev, pager, next, jumper"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "AdminOrders.vue",
  components: {},
  data() {
    return {
      
      loading: true,
      //   form: {},
      dialogVisible: false,
      search: '',
      form:{},
      //   currentPage: 1,
      //   pageSize: 10,
      //   total: 0,
      //   tableData: [],
      // filesUploadUrl: "http://" + window.server.filesUploadUrl + ":9090/files/upload",
      //   ids: []
    };
  },
  created() {
    // let userStr = sessionStorage.getItem("user") || "{}"
    // this.user = JSON.parse(userStr)
    // // 请求服务端，确认当前登录用户的 合法信息
    // request.get("/user/" + this.user.id).then(res => {
    //   if (res.code === '0') {
    //     this.user = res.data
    //   }
    // })

    this.load();
  },
  methods: {
    //     deleteBatch() {
    //       if (!this.ids.length) {
    //         this.$message.warning("请选择数据！")
    //         return
    //       }
    //       request.post("/book/deleteBatch", this.ids).then(res => {
    //         if (res.code === '0') {
    //           this.$message.success("批量删除成功")
    //           this.load()
    //         } else {
    //           this.$message.error(res.msg)
    //         }
    //       })
    //     },
    //     handleSelectionChange(val) {
    //       this.ids = val.map(v => v.id)   // [{id,name}, {id,name}] => [id,id]
    //     },

    load() {
      this.loading = true;
      request
          .get(
              "/goodsCate/selectAllCate",
              {
                params: {
                  currentPage: this.currentPage,
                  pageSize: this.pageSize,
                  
                }
              }
          )
          .then((res) => {
            this.loading = false;
            this.tableData = res.data;
            console.log(this.tableData);
            // this.total = res.data.total
          });
    },
    add() {
    
      request.post("/goodsCate/addCate",this.form).then((res) => {
        if (res.code === 200) {
          this.dialogVisible = false;
          this.load();
          this.$message.success("添加成功！");
          
        } else {
          this.$message.error(res.msg);
        }
      });
    },

    //     handleEdit(row) {
    //       this.form = JSON.parse(JSON.stringify(row))
    //       this.dialogVisible = true
    //       this.$nextTick(() => {
    //         if (this.$refs['upload']) {
    //           this.$refs['upload'].clearFiles()  // 清除历史文件列表
    //         }
    //       })

    //     },
    handleDelete(goodsCateId) {
      console.log(goodsCateId);
      request.post("/goodsCate/deleteCate/" + goodsCateId).then((res) => {
        if (res.code === 200) {
          this.$message({
            type: "success",
            message: "删除成功",
          });
        } else {
          this.$message({
            type: "error",
            message: res.msg,
          });
        }
        this.load(); // 删除之后重新加载表格的数据
      });
    },
    // handleSizeChange(pageSize) {   // 改变当前每页的个数触发
    //   this.pageSize = pageSize
    //   this.load()
    // },
    // handleCurrentChange(pageNum) {  // 改变当前页码触发
    //   this.currentPage = pageNum
    //   this.load()
    // }
  },
};
</script>