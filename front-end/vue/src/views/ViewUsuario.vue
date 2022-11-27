<template>
    <div class="main-container">
     <h1>Usuários do sistema</h1>
    </div>
    <ConsultaCard v-for="(card, indice) in jsonCards" :json="card" :id="card.cpf" :key="indice"/>
</template>
  
<script>
import ConsultaCard from '@/components/ConsultaCard.vue'

  export default {
    name: 'ViewUsuario',
    data() {
      return {
        pagina: 0,
        jsonCards: {}
      }
    },
    components: {
        ConsultaCard
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
  