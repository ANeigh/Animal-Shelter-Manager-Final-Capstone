<template>
  <section>
    <form @submit.prevent="saveApp">
      <!-- Bulma form layout -->
      <div class="field">
        <label class="label" for="first_name">First Name</label>
        <div class="control">
          <input
            class="input"
            type="text"
            id="first_name"
            name="first_name"
            v-model="newApp.firstName"
            placeholder="First name"
          />
        </div>
      </div>

      <div class="field">
        <label class="label" for="last_name">Last Name</label>
        <div class="control">
          <input
            class="input"
            type="text"
            id="last_name"
            name="last_name"
            v-model="newApp.lastName"
            placeholder="Last name"
          />
        </div>
      </div>

      <div class="field">
        <label class="label">Email</label>
        <div class="control has-icons-left">
          <input
            class="input"
            type="email"
            id="email"
            name="email"
            v-model="newApp.email"
            placeholder="Email input"
            value="hello@"
          />
          <span class="icon is-small is-left">
            <i class="fas fa-envelope"></i>
          </span>
        </div>
      </div>

      <div class="field">
        <label class="label" for="phone">Phone Number</label>
        <div class="control has-icons-left">
          <input
            class="input"
            type="text"
            id="phone"
            name="phone"
            v-model="newApp.phone"
            placeholder="(412)867-5309"
          />
          <span class="icon is-small is-left">
            <i class="fas fa-phone"></i>
          </span>
        </div>
      </div>

      <div class="field is-grouped">
        <div class="control">
          <button class="button is-link" type="submit">Submit</button>
        </div>
        <div class="control">
          <button class="button is-link is-light" v-on:click="resetForm">
            Cancel
          </button>
        </div>
      </div>
    </form>
  </section>
</template>

<script>
export default {
  data() {
    return {
      newApp: {
        firstName: "",
        lastName: "",
        email: "",
        phone: "",
        status: "Pending",
        username: "",
        password: "",
      },
    };
  },
  computed: {
    setUsername() {
      return this.newApp.email;
    },
    setPassword() {
      /* Function to generate random password */
      var pass = "";
      var str =
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
        "abcdefghijklmnopqrstuvwxyz0123456789@#$";
      for (let i = 1; i <= 8; i++) {
        var char = Math.floor(Math.random() * str.length + 1);
        pass += str.charAt(char);
      }
      return pass;
    },
  },
  methods: {
    saveApp() {
      this.newApp.username = this.setUsername;
      this.newApp.password = this.setPassword;
      this.$store.commit("ADD_NEW_APP", this.newApp);
      this.newApp = {
        firstName: "",
        lastName: "",
        email: "",
        phone: "",
        status: "Pending",
        username: "",
        password: "",
      };
    },
    resetForm() {
      this.newApp = {
        firstName: "",
        lastName: "",
        email: "",
        phone: "",
        status: "Pending",
        username: "",
        password: "",
      };
    },
  },
};
</script>

<style>
</style>