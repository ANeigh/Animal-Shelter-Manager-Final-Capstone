<template>
  <section class="list-section">
    <h1 class="header">Pets Available For Adoption</h1>
    <div class="animal-container">
      <animal-card
        v-bind:animal="animal"
        v-for="animal in filteredAnimals"
        v-bind:key="animal.animalId"
      />
    </div>
    <nav class="pagination is-centered page-nav" role="navigation" aria-label="pagination">
      <a class="pagination-previous previous-button" @click="previousPage" :disabled="currentPage === 1">Previous</a>
      <a class="pagination-next next-button" @click="nextPage" :disabled="currentPage === totalPages">Next</a>
      <ul class="pagination-list">
        <li v-for="page in totalPages" :key="page">
          <a class="pagination-link" @click="goToPage(page)" :class="{ 'is-current': page === currentPage }">{{ page }}</a>
        </li>
      </ul>
    </nav>
  </section>
</template>

<script>
import AnimalCard from './AnimalCard.vue';

export default {
  name: 'animal-list',
  components: {
    AnimalCard
  },
  data() {
    return {
      currentPage: 1, 
      pageSize: 20,
    };
  },
  computed: {
    filteredAnimals() {
        const animals = this.$store.state.animals;
        const filteredAniamls = animals.filter(animal => !animal.adopted);
        const perPage = 20;
        const currentPage = this.currentPage;
        const startIndex = (currentPage - 1) * perPage;
        const endIndex = startIndex + perPage;
        return filteredAniamls.slice(startIndex, endIndex);
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
    }
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
    background:#F4FFF8;
    margin-bottom: 20px;
}
.previous-button {
    margin-left: 50px;
}
.next-button {
    margin-right: 50px;
}
.header {
  font-size: 50px;
  color: #235789
}
.page-nav {
  margin-bottom: 10px;
}

</style>
