<template>
  <div id="app">
  
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
