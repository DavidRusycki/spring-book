<template>
    <div class="main-container">
     <h1>Produto a venda</h1>
      <router-link class="link btn btn-success" to="/new/produto/">Adicionar</router-link>
        <div class="meuContainer">
          <ConsultaCardProduto @apagar="apagar(card.id)" v-for="(card, indice) in jsonCards" :json="card" :id="card.id" :key="indice"/>
        </div>
        <div v-if="this.vazio">
          <p class="sem-registro">Não há registros</p>
          <p>¯\_(ツ)_/¯</p>
        </div>
    </div>
</template>

<script>
import ConsultaCardProduto from '@/components/ConsultaCardProduto.vue'
import ConsultaCard from '@/components/ConsultaCard.vue'

  export default {
    name: 'ViewProduto',
    data() {
      return {
        jsonCards: {},
        vazio: true
      }
    },
    components: {
      ConsultaCardProduto,
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
        let jsonProduto = await fetch('http://localhost:8081/product/');
        jsonProduto = await jsonProduto.json();
        console.log(jsonProduto);
        let contador = 0;
        for(let indice in jsonProduto) {
          jsonProduto[indice]['categoryId'] = jsonProduto[indice]['categoryDTO'].id
          delete jsonProduto[indice]['categoryDTO']
          contador++;
        }
        if (contador > 0) {
          this.vazio = false;
        }
        return jsonProduto;
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
  font-size: 3rem;
  font-weight: 500;
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
  