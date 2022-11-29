<template>
    <div class="main-container">
     <h1>Produto a venda</h1>
      <router-link class="link btn btn-success" to="/new/produto/">Adicionar</router-link>
        <div class="meuContainer">
          <ConsultaCardProduto @apagar="apagar(card.id)" v-for="(card, indice) in jsonCards" :json="card" :id="card.id" :key="indice"/>
        </div>
        <div v-if="this.vazio">
          <p>Não há registros</p>
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
  
</style>
  