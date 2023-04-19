<template>
  <section class="list-section">
    <h1 class="header">Pets Available For Adoption</h1>

    <div class="select-filter">
      <div class="control">
        <label class="label">Type</label>
        <div class="select">
          <select v-model="animalFilter.type">
            <option disabled value="">Select</option>
            <option value="">All</option>
            <option value="Cat">Cat</option>
            <option value="Dog">Dog</option>
            <option value="Rabbit">Rabbit</option>
            <option value="Bird">Bird</option>
          </select>
        </div>
      </div>
      <div class="control">
        <label class="label">Age</label>
        <div class="select">
          <select v-model="animalFilter.age">
            <option disabled value="">Select</option>
            <option value="">All</option>
            <option value="Baby">Baby</option>
            <option value="Young">Young</option>
            <option value="Adult">Adult</option>
            <option value="Senior">Senior</option>
          </select>
        </div>
      </div>
      <div class="control">
        <label class="label">Gender</label>
        <div class="select">
          <select v-model="animalFilter.gender">
            <option disabled value="">Select</option>
            <option value="">All</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
          </select>
        </div>
      </div>
    </div>

    <div class="animal-container">
      <animal-card
        v-bind:animal="animal"
        v-for="animal in filteredAnimals"
        v-bind:key="animal.animalId"
      />
    </div>
    <nav
      class="pagination is-centered page-nav"
      role="navigation"
      aria-label="pagination"
    >
      <a
        class="pagination-previous previous-button"
        @click="previousPage"
        :disabled="currentPage === 1"
        >Previous</a
      >
      <a
        class="pagination-next next-button"
        @click="nextPage"
        :disabled="currentPage === totalPages"
        >Next</a
      >
      <ul class="pagination-list">
        <li v-for="page in totalPages" :key="page">
          <a
            class="pagination-link"
            @click="goToPage(page)"
            :class="{ 'is-current': page === currentPage }"
            >{{ page }}</a
          >
        </li>
      </ul>
    </nav>
  </section>
</template>

<script>
import AnimalCard from "./AnimalCard.vue";

export default {
  name: "animal-list",
  components: {
    AnimalCard,
  },
  data() {
    return {
      currentPage: 1,
      pageSize: 20,
      animalFilter: {
        type: "",
        age: "",
        gender: "",
      },
    };
  },
  computed: {
    filteredAnimals() {
      const animals = this.$store.state.animals;
      // let filteredAnimals;
      // if ()
      const filteredAnimals = animals.filter((animal) => !animal.adopted);
      const perPage = 20;
      const currentPage = this.currentPage;
      const startIndex = (currentPage - 1) * perPage;
      const endIndex = startIndex + perPage;
      return filteredAnimals.slice(startIndex, endIndex);
    },
    totalPages() {
      return Math.ceil(this.$store.state.animals.length / this.pageSize);
    },
    displayedAnimals() {
      const startIndex = (this.currentPage - 1) * this.pageSize;
      const endIndex = startIndex + this.pageSize;
      return this.$store.state.animals.slice(startIndex, endIndex);
    },
  },
  methods: {
    previousPage() {
      if (this.currentPage > 1) {
        this.currentPage--;
      }
    },
    nextPage() {
      if (this.currentPage < this.totalPages) {
        this.currentPage++;
      }
    },
    goToPage(page) {
      if (page > 0 && page <= this.totalPages) {
        this.currentPage = page;
        this.goToTop();
      }
    },
    goToTop() {
      window.scrollTo(0, 0);
    },
  },
};
</script>

<style scoped>
.animal-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  padding-top: 20px;
  margin-bottom: 20px;
}
.list-section {
  background: #f4fff8;
  margin-bottom: 20px;
}
.previous-button {
  margin-left: 50px;
}
.next-button {
  margin-right: 50px;
}
.header {
  margin-top: 100px;
  font-size: 50px;
  color: #235789;
}
.page-nav {
  margin-bottom: 10px;
}
.select-filter {
  display: flex;
  margin-top: 20px;
  margin-bottom: 5px;
  margin-left: 10px;
}
</style>
