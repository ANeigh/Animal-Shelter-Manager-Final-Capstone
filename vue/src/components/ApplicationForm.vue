<template>
  <div>
    <h3>Apply Below</h3>
    <form @submit.prevent="newApp">
      <label for="first_name">First Name</label>
      <input type="text" id="first_name" name="first_name" />
      <label for="last_name">Last Name</label>
      <input type="text" id="last_name" name="last_name" /><br />
      <label for="email">Email</label>
      <input type="email" id="email" name="email" /><br />
      <label for="phone">Phone Number</label>
      <input type="text" id="phone" name="phone" />
      <input type="submit" value="Submit" />
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      app: {
        firstName: "",
        lastName: "",
        email: "",
        phone: "",
      },
    };
  },
};
</script>

<style>
</style>