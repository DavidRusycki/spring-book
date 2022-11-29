<template>
  <NavBar/>
  <FooterRodape/>
  <router-view/>
</template>

<script>

import NavBar from '@/components/NavBar.vue'
import FooterRodape from '@/components/FooterRodape.vue'
export default {
  name: 'App',
  components: {
    NavBar,
    FooterRodape 
  }
}
</script>

<style>

</style>
