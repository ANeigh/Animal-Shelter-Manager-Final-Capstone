<template>
  
  <section class="volunteer-view" id="volunteer">
    <NavBar />
    <RandomCatPic
      mission="Become a Volunteer"
      description="Restful Retreat Shelter welcomes you to volunteer with us at the shelter for a fulfilling, hands-on 
      experience with our animals. Help us walk, play with, clean, and care for our furry and feathery friends!
      Whether you have space for one visit a month, or one every day, we'd love to meet you!!"
      linkText="Apply Below"/>
    
    <div>
    <ApplicationForm />
    </div>
    <div class="directory-container">
      <!-- <VolunteerDir /> -->
    </div>
    <div class="app-approval-container">
      <ApplicationApproval />
    </div>
    <Footer />
  </section>
</template>

<script>
import NavBar from "../components/NavBar";
import ApplicationForm from "../components/ApplicationForm.vue";
// import VolunteerDir from "../components/VolunteerDir.vue";
import ApplicationApproval from "../components/ApplicationApproval.vue"
import Footer from "../components/Footer.vue";
import RandomCatPic from "../components/RandomCatPic.vue";

export default {
  name: "volunteer",
  components: {
    NavBar,
    RandomCatPic,
    ApplicationForm,
    // VolunteerDir,
    ApplicationApproval,
    Footer
  },
  
};
</script>

<style>
.volunteer-view { 
  background: #a28f9d;
  font-family: "sans-serif";
  font-size: 20px;
}

.volunteer-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  text-transform: uppercase;
}
.directory-container {
  display: flex;
}
.app-approval-container {
  display: flex;
}
</style>