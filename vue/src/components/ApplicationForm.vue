<template>
  <section class="appform">
    <form @submit.prevent="saveApp">
      <!-- Bulma form layout -->
      <div class="field">
        <label class="label" for="first_name">First Name</label>
        <div class="control has-text-centered">
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
        <div class="control has-text-centered">
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
        <div class="control has-text-centered">
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
        <div class="control has-text-centered">
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

      <div class="control has-text-centered">
        <div class="control has-text-centered">
          <button class="button is-link" type="submit">Submit</button>
        </div>
        <div class="control has-text-centered" style="margin-top: 10px">
          <button class="button is-link is-light" v-on:click="resetForm">
            Cancel
          </button>
        </div>
      </div>
    </form>
  </section>
</template>

<script>
import applicationService from "../services/ApplicationService";

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
      },
      newUser: {
        username: "",
        password: "",
        role: "Volunteer",
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
    addNewApplication() {
      ApplicationService
      .createNewApp(this.newApplication)
      .then((response) => {
        if (response.status === 201) {
          const application = {
            firstName: this.newApplication.firstName,
            lastName: this.newApplication.lastName,
            email: this.newApplication.email,
            phone: this.newApplication.phone,
            status: '',
            username: this.newApplication.username,
            role: '',
      };
      this.$store.commit('ADD_APPLICATION', application);
        }
      })
    },
    saveApp() {
      this.newApp.username = this.setUsername;
      this.newUser.username = this.setUsername;
      this.newUser.password = this.setPassword;
      applicationService
        .createApp(this.newApp)
        .then((response) => {
          if (response.status === 201) {
            this.$store.commit("ADD_NEW_APP", this.newApp);
            this.$store.commit("ADD_NEW_USER", this.newUser);
          }
        })
        .catch((error) => {
          this.handleErrorResponse(error, "Error adding new application.");
        });
      this.newApp = {
        firstName: "",
        lastName: "",
        email: "",
        phone: "",
        status: "Pending",
        username: "",
        password: "",
      };
      this.newUser = {
        username: "",
        password: "",
        role: "Volunteer",
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
.appform {
  padding: 20px;
}

.label {
  text-align: center;
  text-transform: uppercase;
}

.input {
  width: 30%;
}
</style>