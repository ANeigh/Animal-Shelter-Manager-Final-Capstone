<template>
  <div id="register" class="text-center">
    <form @submit.prevent="register">
      <div class="form-input-group">
        <h1>Create Account</h1>
        <div role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
        <label for="username">Username</label>
        <input
          type="text"
          id="username"
          v-model="user.username"
          required
          autofocus
        />
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
        <label for="confirmPassword">Confirm Password</label>
        <input
          type="password"
          id="confirmPassword"
          v-model="user.confirmPassword"
          required
        />
        <button type="submit">Create Account</button>
        <p>
          <router-link :to="{ name: 'login' }"
            >Already have an account? Log in.</router-link
          >
        </p>
      </div>
    </form>
    <NavBar />
    <!-- <PetCarousel /> -->
    <Footer />
  </div>
</template>

<script>
import NavBar from "../components/NavBar.vue";
import authService from "../services/AuthService";
import Footer from "../components/Footer.vue";
// import PetCarousel from "../components/PetCarousel.vue";

export default {
  components: {
    NavBar,
    Footer,
    // PetCarousel,
  },
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
.form-input-group {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  height: 70vh;
  background: #a28f9d;
  font-family: "sans-serif";
  font-size: 20px;
}
label {
  margin-right: 0.5rem;
}
</style>
