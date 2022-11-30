<template>
    <nav>
      <router-link class="link" to="/">Home</router-link>
      <router-link class="link" to="/shopping">Shopping</router-link>
      <router-link class="link" to="/produto">Produto</router-link>
      <router-link class="link" to="/user">Usuário</router-link>
  </nav>
</template>

<script>

export default {
  name: 'NavBar'
}

</script>

<style scoped>

nav {
  display: flex;
  align-items: center;
  justify-content: center;
  background: linear-gradient(90deg, rgb(29, 29, 29) 0%, rgb(83, 83, 83) 80%) !important;
  height: 6rem;
}

.link {
  padding: 1rem;
  font-family: 'Pt Sans', 'Helvetica';
  text-decoration: none;
  color: #ffffff;
  font-size: 1.5em;
}
.link:hover {
  /* color: #BC1E05; */
  transition: 250ms;
}

.router-link-active {
  text-decoration: underline;
  font-size: 1.8rem;
  /* color: #BC1E05; */
}
</style>
