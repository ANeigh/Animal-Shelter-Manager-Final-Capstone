<template>
  <!-- As a volunteer, I want a listing of other volunteers and admins with contact info.-->
  <section class="volunteerdirectory">
    <h1 class="vd-title">Volunteer Directory</h1>
    <ul style="list-style-type:none">
      <!-- <li>Volunteer test dummy</li> -->
      <!-- <li v-for="user in $store.state.users" v-bind:key="user.username"> -->
      <li v-for="user in listApplicationUsers" v-bind:key="user.userID">
        <b>Name: {{ user.firstName }} {{ user.lastName }}</b
        ><br />
        Role : {{ user.role }}<br />
        Email: {{ user.email }}<br />
        Phone: {{ user.phone }}
      </li>
    </ul>
  </section>
</template>

<script>
export default {
  components: {},
  // data() {

  // },
  computed: {
    // listUsers() {
    //   const users = this.$store.state.users;
    //   return users.filter((user) => {
    //     return this.getAppFromUser(user.username).status === "Approved";
    //   });
    // },

    listApplicationUsers() {
      const users = this.$store.state.users;
      return users
      .filter((user) => {
        return this.getAppFromUser(user.username).status === "Approved";
      })
      .map((user) => {
          const app = this.getAppFromUser(user.username);
          return { ...user, ...app };
      })
    },
  },
  methods: {
    getAppFromUser(username) {
      const thisApp = this.$store.state.applications.find(
        (app) => app.username == username
      );
      return thisApp;            // add logic to make sure this is found
    },
    getUserEmail(username) {
      return this.getAppFromUser(username).email;
    },
    getUserPhone(username) {
      return this.getAppFromUser(username).phone;
    },
  },
};
</script>

<style>
.volunteerdirectory {
   display: flex;
   flex-direction: column;
   justify-content: space-around;
   align-items: center; 
   font-size: 25px;
   font-family: "sans-serif";
   height: 70vh;
}

.vd-title {
  font-size: 30px;
  text-decoration: underline;
}

ul {
  text-align: center;
  display: flex;
  justify-content: space-evenly;
}
.volunteerdirectory li {
  margin: 30px;
}


</style>