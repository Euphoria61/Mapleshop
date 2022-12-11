<template>
  <div style="padding: 10px">
    <!--    功能区域-->
    <div style="margin: 10px 0">
      <el-button type="primary" @click="dialogVisible2 = true">新增</el-button>
      <el-popconfirm title="确定删除吗？" @confirm="deleteBatch">
        <template #reference>
          <el-button type="danger">批量删除</el-button>
        </template>
      </el-popconfirm>
    </div>
    <!--    搜索区域-->
    <div style="margin: 10px 0">
      <el-input
          v-model="search"
          placeholder="请输入关键字"
          style="width: 20%"
      ></el-input>
      <el-button style="margin-left: 5px" type="primary" @click="select()"
      >查询
      </el-button
      >
    </div>
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
      <el-table-column disabled label="商品ID" prop="goodsId"></el-table-column>
      <el-table-column label="商品名称" prop="name"></el-table-column>
      <el-table-column label="商品图片">
        <template #default="scope">
          <img
              :src="'/api/files/' + scope.row.picture"
              class="image"
              style="width: 100px; height: 100px; text-align: center"
          />
        </template>
      </el-table-column>
      <el-table-column label="原价" prop="priceOld" width="80">
      </el-table-column>
      <el-table-column label="现价" prop="priceNew" width="80">
      </el-table-column>
      <!-- <el-table-column label="商品分类" prop="gtName"></el-table-column> -->
      <el-table-column label="库存" prop="store" width="85"></el-table-column>
      <el-table-column label="商品详情" prop="details"></el-table-column>
      <el-table-column label="是否上架" prop="isShelf" width="85">
      </el-table-column>

      <el-table-column label="操作" width="240">
        <template #default="scope">
          <el-button
              v-if="scope.row.isShelf == 0"
              size="mini"
              type="primary"
              @click="onShelf(scope.row.goodsId)"
          >上架
          </el-button
          >
          <el-button
              v-if="scope.row.isShelf == 1"
              size="mini"
              type="primary"
              @click="offShelf(scope.row.gid)"
          >下架
          </el-button
          >
          <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm
              v-if="scope.row.isShelf == 0"
              title="确定删除吗？"
              @confirm="handleDelete(scope.row.gid)"
          >
            <template #reference>
              <el-button size="mini" type="danger">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 10px 100px">
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
      <!-- 编辑弹窗 -->
      <el-dialog v-model="dialogVisible1" title="编辑商品" width="30%">
        <el-form :model="form" label-width="120px">
<el-form-item label="商品ID">
            <el-input disabled  v-model="form.goodsId" style="width: 80%"></el-input>
          </el-form-item>

          <el-form-item label="商品名称">
            <el-input v-model="form.name" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="原价">
            <el-input v-model="form.priceOld" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="现价">
            <el-input v-model="form.priceNew" style="width: 80%"></el-input>
          </el-form-item>

          <el-form-item label="库存">
            <el-input v-model="form.store" style="width: 80%"></el-input>
          </el-form-item>


          <el-form-item label="商品详情">
            <el-input
                v-model="form.details"
                style="width: 80%"
                type="textarea"
            ></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible1 = false">取 消</el-button>
            <el-button type="primary" @click="save">修改</el-button>
          </span>
        </template>
      </el-dialog>

      <!-- 添加弹窗 -->
      <el-dialog v-model="dialogVisible2" title="新增商品" width="30%">
        <el-form :model="form2" enctype="multipart/form-data" label-width="120px">
          <el-form-item label="商品名称">
            <el-input v-model="form2.name" style="width: 80%"></el-input>
          </el-form-item>

          <!-- <el-form-item label="商品分类">
            <el-select
                v-model="form2.gtId"
                :loading="loading"
                :remote-method="remoteMethod"
                filterable
                remote
                reserve-keyword
            >
              <el-option
                  v-for="item in options"
                  :key="item.gtId"
                  :label="item.gtName"
                  :value="item.gtId"
              />
            </el-select>
          </el-form-item> -->
<!-- 

            <el-form-item label="商品分类">
            <el-select
                v-model="form2.gtId"
                :loading="loading"
                :remote-method="remoteMethod"
                filterable
                remote
                reserve-keyword
            >
              <el-option
                  v-for="item in options"
                  :key="item.gtId"
                  :label="item.gtName"
                  :value="item.gtId"
              />
            </el-select>
          </el-form-item> -->

          <el-form-item label="原价">
            <el-input v-model="form2.priceOld" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="现价">
            <el-input v-model="form2.priceNew" style="width: 80%"></el-input>
          </el-form-item>

          <el-form-item label="库存">
            <el-input v-model="form2.store" style="width: 80%"></el-input>
          </el-form-item>

          <el-form-item label="商品图片">
            <el-input
                id="file"
                v-model="form2.picture"
                style="width: 80%"
                type="file"
            ></el-input>
          </el-form-item>

          <el-form-item label="商品详情">
            <el-input
                v-model="form2.details"
                style="width: 80%"
                type="textarea"
            ></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible2 = false">取 消</el-button>
            <el-button type="primary" @click="add">添加</el-button>
          </span>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "AdminGoods.vue",
  components: {},
  data() {
    return {
      loading: true,
      form: {},
      form2: {},
      // formData:{},
      dialogVisible1: false,
      dialogVisible2: false,
      search: "",
      currentPage: 1,
      pageSize: 20,
      total: 43,

      tableData: [],
      selectType: "",
      file: "",
      options: "",

    };
  },
  created() {
    this.load();
  },
  methods: {
    remoteMethod(selectType) {
      request.get("/admin/allGoodsType").then((res) => {
        
        this.options = res.data.filter((item) => {
          return item.gtName.includes(selectType);
        });
      });
    },

    select() {
      request
          .post("/goods/selectGoodsById/" + this.search)
          .then((res) => {
            
            this.tableData = res.data;
            this.load()
           
          });
    },

    offShelf(gId) {
      request.put("/admin/offShelf/" + gId).then((res) => {
        if (res.code === "0") {
          this.$message.success("下架成功！");
          this.load();
        } else {
          this.$message.error(res.msg);
        }
      });
    },

    onShelf(gId) {
      request.put("/admin/onShelf/" + gId).then((res) => {
        if (res.code === "0") {
          this.$message.success("上架成功！");
          this.load();
        } else {
          this.$message.error(res.msg);
        }
      });
    },
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
    //      filesUploadSuccess(res) {
    //       console.log(res)
    //       this.form.cover = res.data
    //     },
    load() {
      this.loading = true;
      request
          .get("/goods/selectGoods", {
            params: {
              currentPage: this.currentPage,
              pageSize: this.pageSize,
            },
          })
          .then((res) => {
            console.log(res);
            
            this.loading = false;
            this.tableData = res.data.goodsList;
            this.total = res.data.total 
            
            
          });
    },
    add() {
      let forms = new FormData();
      //文件部分
      forms.append("picture", document.querySelector('input[type=file]').files[0]);
      forms.append("details", this.form2.details);
      forms.append("name", this.form2.name);
      // forms.append("goodsCateId", this.form2.gtId);
      forms.append("store", this.form2.store);
      forms.append("priceNew", this.form2.priceNew);
      forms.append("priceOld", this.form2.priceOld);
      request
          .post(
              "/goods/addGoods", forms
          )
          .then((res) => {
            this.dialogVisible2 = false
            if (res.code === 200) {
              this.$message({
                type: "success",
                message: "添加成功！",
              });
            } else {
              this.$message({
                type: "error",
                message: res.message,
              });
            }
          });
    },
    save() {
       let forms = new FormData();
      //文件部分
       forms.append("goodsId", this.form.goodsId);
      forms.append("details", this.form.details);
      forms.append("name", this.form.name);
      // forms.append("goodsCateId", this.form2.gtId);
      forms.append("store", this.form.store);
      forms.append("priceNew", this.form.priceNew);
      forms.append("priceOld", this.form.priceOld);
      console.log(this.forms);
      request.post("/goods/addGoods", forms).then((res) => {
        console.log(res);
        if (res.code === 200) {
          this.$message({
            type: "success",
            message: "更新成功!"  ,
          });
        } else {
          this.$message({
            type: "error",
            message: "更新错误！",
          });
        }
        this.load(); // 刷新表格的数据
        this.dialogVisible1 = false; // 关闭弹窗
      });
    },

    handleEdit(row) {
      this.form = JSON.parse(JSON.stringify(row));
      this.dialogVisible1 = true;
      this.$nextTick(() => {
        if (this.$refs["upload"]) {
          this.$refs["upload"].clearFiles(); // 清除历史文件列表
        }
      });
    },

    handleSizeChange(pageSize) {
      // 改变当前每页的个数触发
      this.pageSize = pageSize;
      this.load();
    },
    handleCurrentChange(currentPage) {
      // 改变当前页码触发
      this.currentPage = currentPage;
      this.load();
    },
  },
};
</script>