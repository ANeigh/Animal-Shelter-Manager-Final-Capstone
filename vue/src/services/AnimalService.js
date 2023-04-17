import axios from "axios";

export default {
    getAllAnimals() {
        return axios.get("/animals");
    },

    getAnimalsByType(animalType) {
        return axios.get("/animals/" + animalType);
    },

    createAnimal(animal) {
        return axios.post("/animals", animal);
    
    },

    updateAnimal(animalID, animal) {
        return axios.put("/animals/" + animalID, animal);
    },

    deleteAnimal(animalID) {
        return axios.delete("/animals/" + animalID);
    }

}