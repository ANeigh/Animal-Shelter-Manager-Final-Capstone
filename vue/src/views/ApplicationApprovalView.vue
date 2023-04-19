<template>
  <section class="appapprovalview">
      <NavBar />
      <ApplicationApproval />
      <Footer/>
  </section>
</template>

<script>
import NavBar from "../components/NavBar";
import Footer from "../components/Footer.vue";
import ApplicationApproval from "../components/ApplicationApproval.vue";

export default {
    name: "appapprovalview",
    components: {
        NavBar,
        ApplicationApproval,
        Footer       
    },
}
</script>

<style>
.appapprovalview{
    background: #a28f9d;
}
</style>