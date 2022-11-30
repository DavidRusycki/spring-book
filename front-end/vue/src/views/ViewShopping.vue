<template>
    <div class="main-container">
     <h1>Shopping</h1>
     <router-link class="link btn btn-success" to="/new/shoping/">Adicionar</router-link>
     <div v-if="this.vazio">
       <p class="sem-registro">Não há registros</p>
     </div>
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
        jsonCards: {},
        vazio: true
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
        let contador = 0;
        for(let indice in jsonShoping) {
          jsonShoping[indice]['items'] = JSON.stringify(jsonShoping[indice]['items']);
          delete jsonShoping[indice].date;
          contador++
        }
        console.log(jsonShoping);
        if (contador > 0) {
          this.vazio = false;
        }
        return jsonShoping;
      }
    },
    async mounted() {
      this.jsonCards = await this.getJsonCards();
    }
  }
  
</script>
  
<style scoped>

p{
  text-align: center;
}

.meuContainer {
  overflow: auto;
  display: grid;
  grid-template-columns: auto auto auto auto;
  height: 61vh;
  margin: 1vh;
  justify-content: center
}

@media (max-width: 1580px) {
  .meuContainer {
    grid-template-columns: auto auto auto;
  }
  
} 

@media (max-width: 1580px) {
  /* .meuContainer {
    grid-template-columns: auto auto auto auto;
  } */
  
} 

@media (max-width: 1180px) {
  .meuContainer {
    grid-template-columns: auto auto ;
  }
}

@media (max-width: 780px) {
  .meuContainer {
    grid-template-columns: auto  ;
  }
}

</style>
  