<template>
    <div class="main-container">
     <h1>Shopping</h1>
     <router-link class="link btn btn-success" to="/new/shoping/">Adicionar</router-link>
        <div class="meuContainer">
          <ConsultaCardShoping @apagar="apagar(card.id)" v-for="(card, indice) in jsonCards" :json="card" :id="card.id" :key="indice"/>
        </div>
    </div>
</template>
  

<script>
import ConsultaCardShoping from '@/components/ConsultaCardShoping.vue'
import ConsultaCard from '@/components/ConsultaCard.vue'

  export default {
    name: 'ViewShopping',
    data() {
      return {
        jsonCards: {}
      }
    },
    components: {
      ConsultaCardShoping,
      ConsultaCard
    },
    methods: {
      async apagar(id) {
        let jsonNew = await this.getJsonCards();
        for(let indice in jsonNew) {
          if (jsonNew[indice].id == id) {
            jsonNew.splice(indice, 1);
          }
        }
        this.jsonCards = jsonNew;
      },
      async getJsonCards() {  
        let jsonShoping = await fetch('http://localhost:8082/shopping/');
        jsonShoping = await jsonShoping.json();
        for(let indice in jsonShoping) {
          jsonShoping[indice]['items'] = JSON.stringify(jsonShoping[indice]['items']);
          delete jsonShoping[indice].date;
        }
        console.log(jsonShoping);
        return jsonShoping;
      }
    },
    async mounted() {
      this.jsonCards = await this.getJsonCards();
    }
  }
  
</script>
  
<style scoped>
  
</style>
  