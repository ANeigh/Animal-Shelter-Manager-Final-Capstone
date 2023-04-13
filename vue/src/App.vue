<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'login' }" v-if="!isLoggedIn">Login</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="isLoggedIn">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>
<script>
export default {
  computed: {
    isLoggedIn() {
      return !!this.$store.state.token;
    }
  }
}
</script>



<style>
#app{
  
  background: mintcream;
}
</style>
