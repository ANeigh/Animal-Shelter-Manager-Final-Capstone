<template>
  <section class="list-section" v-bind:class="{'list-section-margin':!this.$store.state.token}">
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
        v-for="(animal, index) in displayedAnimals"
        v-bind:key="index"
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
      const filteredAnimals = animals.filter((animal) => !animal.adopted);
      return filteredAnimals
        .filter((animal) => {
          if (
            this.animalFilter.type &&
            animal.type !== this.animalFilter.type
          ) {
            return false;
          }
          if (this.animalFilter.age && animal.age != this.animalFilter.age) {
            return false;
          }
          if (
            this.animalFilter.gender &&
            animal.gender !== this.animalFilter.gender
          ) {
            return false;
          }
          return true;
        });
    },
    totalPages() {
      const filteredAnimals = this.filteredAnimals;
      if (filteredAnimals.length === 0) {
        return 1
      }
      return Math.ceil(filteredAnimals.length / this.pageSize);
    },
    displayedAnimals() {
      const startIndex = (this.currentPage - 1) * this.pageSize;
      const endIndex = startIndex + this.pageSize;
      return this.filteredAnimals.slice(startIndex, endIndex);
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
  watch: {
    filteredAnimals() {
      this.currentPage = 1;
    }
  }
};
</script>

<style scoped>
.animal-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  padding-top: 20px;
  margin-bottom: 20px;
  background: #F2F3F5;
}
.list-section {
  background: #F2F3F5;
  margin-bottom: 20px;
  margin-top: -20px;
}

.list-section-margin {
      margin-top: 100px;

}

.previous-button {
  margin-left: 50px;
}
.next-button {
  margin-right: 50px;
}
.header {
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
