<template>
    <div class="main-container">
     <h1>Usuários do sistema</h1>
    </div>
    <ConsultaPadrao :jsonCards="this.getJsonCards()" />
</template>
  
<script>
import ConsultaPadrao from '@/components/ConsultaPadrao.vue'

  export default {
    name: 'ViewUsuario',
    components: {
        ConsultaPadrao
    },
    methods: {
      getJsonCards() {
        
      }
    }
  }
  
</script>
  
<style scoped>
  
</style>
  