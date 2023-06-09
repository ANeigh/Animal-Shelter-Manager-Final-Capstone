import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
// import Register from '../views/Register.vue'
import store from '../store/index'
import Volunteer from '../views/Volunteer.vue'
import About from '../views/About.vue'
import AnimalListView from '../views/AnimalListView'
import AdoptedList from '../views/AdoptedList'
import VolunteerList from '../views/VolunteerListView'
import AnimalDetails from '../views/AnimalDetails'
import ApplicationApproval from '../views/ApplicationApprovalView'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    // {
    //   path: "/register",
    //   name: "register",
    //   component: Register,
    //   meta: {
    //     requiresAuth: false
    //   }
    // },
    {
      path: "/volunteer",
      name: "volunteer",
      component: Volunteer,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/about",
      name: "about",
      component: About,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/animallist",
      name: "animallistview",
      component: AnimalListView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/adoptedlist",
      name: "adoptedlist",
      component: AdoptedList,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/volunteerlist",
      name: "volunteerlist",
      component: VolunteerList,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/animaldetails/:animalId",
      name: "animaldetails",
      component: AnimalDetails,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/appapproval",
      name: "appapproval",
      component: ApplicationApproval,
      meta: {
        requiresAuth: true
      }
    }

  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
