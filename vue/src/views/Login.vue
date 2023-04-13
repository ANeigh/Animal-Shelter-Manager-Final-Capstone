<template>
  <div id="login">
    <form @submit.prevent="login">
      <nav-bar />
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit">Sign in</button>
      <p>
      <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
      <!-- <social/> -->
      <pet-carousel />
      <Footer />
    </form>
  </div>
</template>

<script>
import Footer from '../components/Footer.vue';
import NavBar from '../components/NavBar.vue';
import PetCarousel from '../components/PetCarousel.vue';
// import Social from '../components/Social.vue';
import authService from "../services/AuthService";
import HomeService from "../services/HomeService";

export default {
  name: "login",
  components: {
    NavBar,
    // Social,
    PetCarousel,
    Footer,
  },
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },methods: {
    getPic(){
      HomeService.pic().then(response => {
        const imageUrl = response.request.responseURL;
        const img = document.createElement("img");
        img.src = imageUrl;
        // document.body.appendChild(img);
      })
    }
  },
  created() {
    this.getPic();
  }
  }
};
</script>

<style scoped>
#login {
  background-image: url("https://cataas.com/cat");
  background-size: cover;
  background-position: center;
  padding:24rem;
}
.form-input-group {
  
  margin-bottom: 1rem;
  
}
label {
  margin-right: 0.5rem;
}

</style>