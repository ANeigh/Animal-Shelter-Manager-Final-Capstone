<template>
  <section class="content" id="volunteer">
    <div>
      <h2>
      Become a Volunteer
    </h2>
    <p>
      Restful Retreat Shelter welcomes you to volunteer with us at the shelter for a fulfilling, hands-on 
      experience with our animals. Help us walk, play with, clean, and care for our furry and feathery friends!
      Whether you have space for one visit a month, or one every day, we'd love to meet you!
    </p>
    </div>
    <div>
    <h3>Apply Below</h3>
    
    <ApplicationForm />
    </div>
    <div class="directory-container">
      <VolunteerDir />
    </div>
    <div class="app-approval-container">
      <ApplicationApproval />
    </div>
  </section>
</template>

<script>
import ApplicationForm from "../components/ApplicationForm.vue";
import VolunteerDir from "../components/VolunteerDir.vue";
import ApplicationApproval from "../components/ApplicationApproval.vue"

export default {
  name: "volunteer",
  components: {
    ApplicationForm,
    VolunteerDir,
    ApplicationApproval
  },
  
};
</script>

<style>
.directory-container {
  display: flex;
}
.app-approval-container {
  display: flex;
}
</style>