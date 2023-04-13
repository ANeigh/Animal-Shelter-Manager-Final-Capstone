<template>
  <section class="nav">

    <router-link to="{name: ''}">Account Page</router-link>&nbsp;|
    <router-link to="/list">Animal List</router-link>&nbsp;|
    <router-link to="{name: ''}">Animal Details</router-link>

  </section>
</template>

<script>
export default {
  name: 'nav-bar'

}
</script>

<style>
.nav {
    display: block;
    text-align: center;
}
</style>