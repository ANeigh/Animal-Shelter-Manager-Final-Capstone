package com.techelevator.model;

public class Animal {

    private int animalId;
    private int addedBy = 1;
    private String name;
    private String type;
    private String description;
    private int age;
    private String gender;
    private boolean adopted;
    private String breed;
    private String color;
    private String tags;


    public Animal () {}

    public Animal(int animal_id, String name, String type, String description, int age, String gender, boolean adopted,
                  String breed, String color, int addedBy, String tags) {
        this.animalId = animal_id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.age = age;
        this.gender = gender;
        this.adopted = adopted;
        this.breed = breed;
        this.color = color;
        this.addedBy = addedBy;
        this.tags = tags;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(int addedBy) {
        this.addedBy = addedBy;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + animalId +
                "name=" + name +
                "type=" + type +
                "breed" + breed +
                "description=" + description +
                "age=" + age +
                "gender=" + gender +
                "adopted" + adopted +
                "color" + color +
                "added_by" + addedBy +
                '}';
    }
}
