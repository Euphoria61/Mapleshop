<template>
  <div
      style="
      height: 25px;
      line-height: 25px;
      display: flex;
      background-color: rgb(245, 245, 245);
    "
  >
    <div style="width: 200px; padding-left: 50px">
      <el-link
          :underline="false"
          style="font-size: 4px"
          @click="$router.push('/login')"
      >{{ userEmail == "" ? "欢迎您，请先登录" : userEmail }}
      </el-link
      >
    </div>

    <div>
      <el-link
          :underline="false"
          style="color: red; font-size: 4px"
          @click="$router.push('/register')"
      >注册
      </el-link
      >
    </div>
    <div style="width: 200px; padding-left: 50px">
      <el-link :underline="false" style="font-size: 4px" @click="$router.push('/shoppingCart')">购物车</el-link>
    </div>

    <div style="width: 200px; padding-left: 50px">
      <el-link
          :underline="false"
          style="font-size: 4px"
          @click="$router.push('/collections')"
      >收藏夹
      </el-link
      >
    </div>

    <div style="width: 200px; padding-left: 50px">
      <el-link
          :underline="false"
          style="font-size: 4px"
          @click="$router.push('/myOrders')"
      >我的订单
      </el-link
      >
    </div>
  </div>
</template>
<script>
export default {
  name: "Header.vue",
  data() {
    return {
      userEmail: "",

    };
  },
  methods: {
    load() {
      if (JSON.parse(sessionStorage.getItem("user")) != null) this.userEmail = JSON.parse(sessionStorage.getItem("user")).userEmail

    },
  },
  created() {
    this.load();
  },
};
</script>

<style scoped>
</style>