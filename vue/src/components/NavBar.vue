<template>
  <section class="nav">
    <nav
      class="navbar is-fixed-top"
      role="navigation"
      aria-label="main navigation"
    >
      <div class="navbar-brand">
        <a class="navbar-item" href="/">
          <img src="../assets/Job-AnimalShelter.png" width="112" height="56" />
          <h1 class="PicText" style="font-size: 1.5rem">
            Restful Retreat Shelter
          </h1>
        </a>

        <a
          role="button"
          class="navbar-burger"
          aria-label="menu"
          aria-expanded="false"
          data-target="navbarBasicExample"
        >
          <span aria-hidden="true"></span>
          <span aria-hidden="true"></span>
          <span aria-hidden="true"></span>
        </a>
      </div>

      <div id="navbarBasicExample" class="navbar-menu">
        <div class="navbar-start">
          <a class="navbar-item">
            <router-link class="navButtons" v-bind:to="{name: 'about'}">About Us</router-link>
          </a>

          <a class="navbar-item">
            <router-link class="navButtons" v-bind:to="{name: 'animallistview'}"
              >Animal List</router-link
            >
          </a>

          <a class="navbar-item">
            <router-link class="navButtons" v-bind:to="{name: 'adoptedlist'}"
              >Adopted List</router-link
            >
          </a>

          <a class="navbar-item">
            <router-link
              class="navButtons"
              v-bind:to="{name: 'volunteerlist'}"
              v-if="isLoggedIn"
              >Volunteer Directory</router-link
            >
          </a>
          <a class="navbar-item">
            <router-link
              class="navButtons"
              v-bind:to="{name: 'appapproval'}"
              v-if="showApplicationListLink"
              >Application List</router-link
            >
          </a>
        </div>
      </div>

      <div class="navbar-end">
        <div class="navbar-item">
          <div class="buttons">
            <a class="button is-primary">
              <strong>
                <router-link class="signupbutton" v-bind:to="{name: 'volunteer'}"
                  >Sign up to be a Volunteer</router-link
                >
              </strong>
            </a>
            <a class="button is-light">
              <router-link
                class="loginbutton"
                v-bind:to="{ name: 'login' }"
                v-if="!isLoggedIn"
                >Login</router-link
              >
              <router-link
                class="loginbutton"
                v-bind:to="{ name: 'logout' }"
                v-if="isLoggedIn"
                >Logout</router-link
              >
            </a>
          </div>
        </div>
      </div>
    </nav>
  </section>
</template>

<script>
export default {
  name: "nav-bar",
  computed: {
    isLoggedIn() {
      return !!this.$store.state.token;
    },
    showApplicationListLink() {
      return this.isLoggedIn && this.$store.state.user.authorities.some(auth => auth.name === 'ROLE_ADMIN');
    }
  },
};
</script>

<style>
.navbar {
  font-size: 25px;
  position: fixed;
  top: 0;
  width: 100%;
  z-index: 1;
  background: #7c909e;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.2);
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  justify-content: space-around;
}

.navbar-brand {
  margin-left: 20px;
  margin-right: 20px;
}

.navButtons {
  margin: 0 10px;
} 

.navButtons:hover {
  background-color: #f0f0f0;
  color: #235789;
  text-decoration: none;
}

.PicText {
  color: #2f0a28;
  font-weight: bold;
  margin: 0;
  padding: 20px;
}

.navbar-brand img {
  height: 100%;
  max-height: 80px;
}
.signupbutton {
  font-size: 20px;
}

.loginbutton {
  font-size: 20px;
}

.loginbutton:hover {
  background-color: #f0f0f0;
  color: #235789;
  text-decoration: none;
}

.signupbutton:hover {
  color: #235789;
  text-decoration: none;
}
</style>