<template>
  <section id="volunteer">
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
    <h3>Apply Below</h3>
    <div>
    <ApplicationForm />
    </div>
  </section>
</template>

<script>
import ApplicationForm from "../components/ApplicationForm.vue";

export default {
  name: "volunteer",
  components: {
    ApplicationForm,
  },
  
};
</script>

<style>
</style>