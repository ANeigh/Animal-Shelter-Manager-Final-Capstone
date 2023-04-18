<template>
  <!-- As an admin, I want to see all pending volunteer applications and 
  have the option to approve or decline them.-->
  <!-- Approving an application should create a new volunteer user 
  (who will then be able to log in).-->
  <!-- Declining an application should remove the application from list 
of pending applications, but not remove the data from the database.-->

  <section>
    <h1>Applications</h1>
    <table class="table is-hover">
      <thead>
        <tr>
          <th>&nbsp;</th>
          <th>User Role</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Phone Number</th>
          <th>Username</th>
          <th>Status</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>
            <input
              type="checkbox"
              id="selectAll"
              v-bind:checked="
                selectedApps.length === $store.state.applications.length
              "
              v-on:change="selectAll($event)"
            />
          </td>
          <td>
            <select id="roleFilter" v-model="filter.role">
              <option value>Show All</option>
              <option value="Admin">Admin</option>
              <option value="Volunteer">Volunteer</option>
            </select>
          </td>
          <td>
            <input
              type="text"
              id="firstNameFilter"
              v-model="filter.firstName"
            />
          </td>
          <td>
            <input type="text" id="lastNameFilter" v-model="filter.lastName" />
          </td>
          <td>
            <input type="text" id="emailFilter" v-model="filter.email" />
          </td>
          <td>
            <input type="text" id="phoneFilter" v-model="filter.phone" />
          </td>
          <td>
            <input type="text" id="usernameFilter" v-model="filter.username" />
          </td>

          <td>
            <select id="statusFilter" v-model="filter.status">
              <option value>Show All</option>
              <option value="Approved">Approved</option>
              <option value="Pending">Pending</option>
              <option value="Rejected">Rejected</option>
            </select>
          </td>
        </tr>
        <tr
          v-for="app in filteredApps"
          v-bind:key="app.id"
          v-bind:class="{ rejected: app.status === 'Rejected' }"
        >
          <td>
            <input
              type="checkbox"
              v-bind:value="app.id"
              v-model="selectedApps"
            />
          </td>
          <td>{{ getUserRole(app.username) }}</td>
          <td>{{ app.firstName }}</td>
          <td>{{ app.lastName }}</td>
          <td>{{ app.email }}</td>
          <td>{{ app.phone }}</td>
          <td>{{ app.username }}</td>
          <td>{{ app.status }}</td>
        </tr>
      </tbody>
    </table>
    <div class="all-actions">
      <button
        v-bind:disabled="selectedApps.length === 0"
        v-on:click="approveApp"
      >
        Approve
      </button>
      <button
        v-bind:disabled="selectedApps.length === 0"
        v-on:click="rejectApp"
      >
        Reject
      </button>
      <button
        v-bind:disabled="selectedApps.length === 0"
        v-on:click="pendingApp"
      >
        Mark Pending
      </button>
    </div>
  </section>
</template>

<script>
export default {
  name: "app-list",
  data() {
    return {
      selectedApps: [],
      filter: {
        firstName: "",
        lastName: "",
        email: "",
        phone: "",
        status: "",
        username: "",
        role: "",
      },
    };
  },
  computed: {
    filteredList() {
      let filteredApps = this.$store.state.applications;
      if (this.filter.role != "") {
        filteredApps = filteredApps.filter(
          (user) => user.role === this.filter.role
        );
        if (this.filter.firstName != "") {
          filteredApps = filteredApps.filter((user) =>
            user.firstName
              .toLowerCase()
              .includes(this.filter.firstName.toLowerCase())
          );
        }
        if (this.filter.lastName != "") {
          filteredApps = filteredApps.filter((user) =>
            user.lastName
              .toLowerCase()
              .includes(this.filter.lastName.toLowerCase())
          );
        }
        if (this.filter.email != "") {
          filteredApps = filteredApps.filter((user) =>
            user.emailAddress
              .toLowerCase()
              .includes(this.filter.emailAddress.toLowerCase())
          );
        }
        if (this.filter.phone != "") {
          filteredApps = filteredApps.filter((user) =>
            user.phone.toLowerCase().includes(this.filter.phone.toLowerCase())
          );
        }
        if (this.filter.username != "") {
          filteredApps = filteredApps.filter((user) =>
            user.username
              .toLowerCase()
              .includes(this.filter.username.toLowerCase())
          );
        }
        if (this.filter.status != "") {
          filteredApps = filteredApps.filter(
            (user) => user.status === this.filter.status
          );
        }
      }
      return filteredApps;
    },
  },
  methods: {
    getUserFromApp(username) {
      const thisUser = this.$store.state.users.find(
        (user) => user.username == username
      );
      return thisUser; // add logic to make sure this is found
    },
    getUserRole(username) {
      return this.getUserFromApp(username).role;
    },
    // changeStatus(username) {
    //     const app = this.findAppByUsername(username);
    //     if (app.status === ""
    // },
    approveApp() {
      this.selectedApps.forEach((userID) => {
        this.findUserById(userID).status = "Approve";
      });
      this.selectedApps = [];
    },
    rejectApp() {
      this.selectedApps.forEach((userID) => {
        this.findUserById(userID).status = "Rejected";
      });
      this.selectedApps = [];
    },
    pendingApp() {
      this.selectedApps.forEach((userID) => {
        this.findUserById(userID).status = "Pending";
      });
      this.selectedApps = [];
    },
    selectAll(event) {
      if (event.target.checked) {
        this.selectedApps = [];
        this.users.forEach((user) => {
          this.selectedApps.push(user.id);
        });
      } else {
        this.selectedApps = [];
      }
    },
  },
};
</script>

<style>
tr.rejected {
  background-color: rgb(190, 190, 190);
}
tr.pending {
  background-color: 235789;
}
</style>