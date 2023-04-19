<template>
  <section class="volunteerlist">
    <NavBar />
    <VolunteerDir />
    <Footer />
  </section>
</template>

<script>
import NavBar from "../components/NavBar";
import Footer from "../components/Footer.vue";
import VolunteerDir from "../components/VolunteerDir.vue";

export default {
  name: "volunteerlistview",
  components: {
    NavBar,
    VolunteerDir,
    Footer,
  },
};
</script>

<style>
.volunteerlist {
  background: #a28f9d;
}
</style>