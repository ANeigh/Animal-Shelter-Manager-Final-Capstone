import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    animals: [],
    users: [
      {
        username: "Email@",
        role: "Admin"
      },
      {
        username: "email@mail.com",
        role: "Volunteer"
      },
      {
        username: "ourqueen@thebest.com",
        role: "Volunteer"
      }
    ],
    applications: [
      {
        id: 1,
        firstName: "first",
        lastName: "last",
        email: "email@mail.com",
        phone: "number",
        status: "Rejected",
        username: "email@mail.com",
        password: "noneshallpass"
      },
      {
        id: 2,
        firstName: "FName",
        lastName: "LName",
        email: "Email@",
        phone: "123-456-7890",
        status: "Approved",
        username: "Email@",
        password: "assword"
      },
      {
        id: 3,
        firstName: "Dolly",
        lastName: "Parton",
        email: "ourqueen@thebest.com",
        phone: "#1",
        status: "Pending",
        username: "ourqueen@thebest.com",
        password: "jolene"
      }
    ],
    imgs: [],
    token: currentToken || '',
    user: currentUser || {}
  },
  mutations: {
    
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    ADD_NEW_APP(state, newApp) {
      state.applications.push(newApp);
    },
    APPROVE_APP(state, app) {
      app.status = "Approved";
    },
    REJECT_APP(state, app) {
      app.status = "Rejected";
    },
    PENDING_APP(state, app) {
      app.status = "Pending";
    },
    ADD_NEW_USER(state, newUser) {
state.users.push(newUser);
    },
    CHANGE_USER_ROLE(state, user) {
      user.role = user.role === "Admin" ? "Volunteer": "Admin";
    },
    SET_ANIMALS(state, animals) {
      state.animals = animals;
    },
    SET_IMGS(state, imgs) {
      state.imgs = imgs;
    },
    ADD_ANIMAL(state, animal) {
      state.animals.push(animal);
    },
    ADD_IMG(state, img) {
      state.imgs.push(img);
    },
    UPDATE_ANIMAL(state, animal) {
      const newAnimal = state.animals.find(a => a.animalId === animal.animalId);
      if (newAnimal) {
        Object.assign(newAnimal, animal.data);
      }
    }
  }
})
