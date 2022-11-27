<template>
    <div class="main-container">
     <h1>Usuários do sistema</h1>
    </div>
    <ConsultaPadrao :jsonCards="jsonCards" />
</template>
  
<script>
import ConsultaPadrao from '@/components/ConsultaPadrao.vue'

  export default {
    name: 'ViewUsuario',
    data() {
      return {
        pagina: 0,
        jsonCards: {}
      }
    },
    components: {
        ConsultaPadrao
    },
    methods: {
      async getJsonCards() {
        let jsonUsuario = await fetch('http://localhost:8080/users/0');
        jsonUsuario = await jsonUsuario.json();
        console.log(jsonUsuario);
        return jsonUsuario;
      }
    },
    async mounted() {
      this.jsonCards = await this.getJsonCards();
    }
  }
  
</script>
  
<style scoped>
  
</style>
  