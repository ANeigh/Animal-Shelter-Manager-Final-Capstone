<template>
  <section class="Footer">
    <h1>Location of Shelter and Contact Info</h1>
    <p>
      Address: 123 Main Street, Pittsburgh, PA 15220 Phone: (555) 555-5555
      Email: info@restfulretreatshelter.org Website:
      www.restfulretreatshelter.org
    </p>
  </section>
</template>

<script>
export default {
  name: "footer",
};
</script>

<style>
.Footer {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  position: relative;
  bottom: 0; 
  left: 0;
  right: 0;
  background-color: #a28f9d;
  border: 15px solid #2F0A28;
  border-radius: 10px;
  font-size: 20px;
  text-transform: uppercase;
  color: #235789;
  padding: 20px;  
}

h1 {
  margin: 0;
}

</style>