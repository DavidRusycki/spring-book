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
  align-content: center;
  align-items: center;
  margin-top: 0;
  margin-top: 2vh;
}

.link {
  padding: 0 30px;
  font-family: 'Pt Sans', 'Helvetica';
  text-decoration: none;
  color: black;
  font-size: 1.5em;
}

.link:hover {
  color: #BC1E05;
  transition: 250ms;
}

.router-link-active {
  text-decoration: underline;
  color: #BC1E05;
}
</style>
