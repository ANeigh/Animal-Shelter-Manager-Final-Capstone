<template>
  <!-- As an admin, I want to see all pending volunteer applications and 
  have the option to approve or decline them.-->
  <!-- Approving an application should create a new volunteer user 
  (who will then be able to log in).-->
  <!-- Declining an application should remove the application from list 
of pending applications, but not remove the data from the database.-->

  <section class="appapproval">
    <h1 class="appapproval-title">Applications</h1>
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
          v-for="app in filteredList"
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
        class="button is-link is-success"
        v-bind:disabled="selectedApps.length === 0"
        v-on:click="approveApp"
      >
        Approve
      </button>
      <button
        class="button is-link is-danger"
        v-bind:disabled="selectedApps.length === 0"
        v-on:click="rejectApp"
      >
        Reject
      </button>
      <button
        class="button is-link is-warning"
        v-bind:disabled="selectedApps.length === 0"
        v-on:click="pendingApp"
      >
        Mark Pending
      </button>
      <button
        class="button is-link"
        v-bind:disabled="selectedApps.length === 0"
        v-on:click="changeRole"
      >
        Change User Role
      </button>
      <button
        class="button is-link is-outlined"
        type="reset"
        v-bind:disabled="isFilterBlank"
        v-on:click="clearFilters"
      >
        Clear filters
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
    isFilterBlank() {
      if (
        this.filter.role == "" &&
        this.filter.firstName == "" &&
        this.filter.lastName == "" &&
        this.filter.email == "" &&
        this.filter.phone == "" &&
        this.filter.username == "" &&
        this.filter.status == ""
      ) {
        return true;
      } else {
        return false;
      }
    },
    filteredList() {
      let filteredApps = this.$store.state.applications;
      if (this.filter.role != "") {
        filteredApps = filteredApps.filter(
          (app) => this.getUserRole(app.username) === this.filter.role
        );
      }
      if (this.filter.firstName != "") {
        filteredApps = filteredApps.filter((app) =>
          app.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase())
        );
      }
      if (this.filter.lastName != "") {
        filteredApps = filteredApps.filter((app) =>
          app.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }
      if (this.filter.email != "") {
        filteredApps = filteredApps.filter((app) =>
          app.email.toLowerCase().includes(this.filter.email.toLowerCase())
        );
      }
      if (this.filter.phone != "") {
        filteredApps = filteredApps.filter((app) =>
          app.phone.toLowerCase().includes(this.filter.phone.toLowerCase())
        );
      }
      if (this.filter.username != "") {
        filteredApps = filteredApps.filter((app) =>
          app.username
            .toLowerCase()
            .includes(this.filter.username.toLowerCase())
        );
      }
      if (this.filter.status != "") {
        filteredApps = filteredApps.filter(
          (app) => app.status === this.filter.status
        );
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
    changeRole() {
      this.selectedApps.forEach((appID) => {
        const appToChange = this.findAppById(appID);
        const user = this.getUserFromApp(appToChange.username);       
        this.$store.commit("CHANGE_USER_ROLE", user);
      });
      this.selectedApps = [];
    },
    findAppById(appID) {
      return this.$store.state.applications.find((app) => app.id === appID);
    },

    approveApp() {
      this.selectedApps.forEach((appID) => {
        const appToChange = this.findAppById(appID);
        appToChange.status = "Approved";
        this.$store.commit("APPROVE_APP", appToChange);
      });
      this.selectedApps = [];
    },
    rejectApp() {
      this.selectedApps.forEach((appID) => {
        const appToChange = this.findAppById(appID);
        appToChange.status = "Rejected";
        this.$store.commit("REJECT_APP", appToChange);
      });
      this.selectedApps = [];
    },
    pendingApp() {
      this.selectedApps.forEach((appID) => {
        const appToChange = this.findAppById(appID);
        appToChange.status = "Pending";
        this.$store.commit("PENDING_APP", appToChange);
      });
      this.selectedApps = [];
    },

    selectAll(event) {
      if (event.target.checked) {
        this.selectedApps = [];
        this.$store.state.applications.forEach((app) => {
          this.selectedApps.push(app.id);
        });
      } else {
        this.selectedApps = [];
      }
    },
    clearFilters() {
      this.filter = {
        firstName: "",
        lastName: "",
        email: "",
        phone: "",
        status: "",
        username: "",
        role: "",
      };
    },
  },
};
</script>

<style>
.appapproval {
   padding-top: 120px;
   height: 65vh;
   display: flex;
   flex-direction: column;
   justify-content: center;
   align-items: center;
}
tr.rejected {
  background-color: rgb(190, 190, 190);
}
tr.pending {
  background-color: 235789;
}
.appapproval-title {
  font-size: 35px;
  padding-bottom: 10px;
  text-decoration: underline;
}
</style>