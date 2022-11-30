<template>
  <div>
    <div class="main-container">
      <h1>Usuários do sistema</h1>
      <router-link class="link btn btn-success" to="/new/user/">Adicionar</router-link>
      <div class="meuContainer">
        <ConsultaCardUsuario @apagar="apagar(card.id)" v-for="(card, indice) in jsonCards" :json="card" :id="card.id" :key="indice"/>
      </div>
    </div> 
    <div v-if="this.vazio">
          <p>Não há registros</p>
    </div>
    <div>
      <div >
        <button class="botaozainho btn btn-warning" @click="onClickMudaPagina(valor)" v-for="(valor, indice) in arrayPaginas" :valor="valor" :id="valor" :key="indice">{{valor}}</button>
      </div>
    </div>
  </div>
</template>
  
<script>
import ConsultaCardUsuario from '@/components/ConsultaCardUsuario.vue'
import ConsultaCard from '@/components/ConsultaCard.vue'

  export default {
    name: 'ViewUsuario',
    data() {
      return {
        pagina: 0,
        jsonCards: {},
        quantidadePaginas: 0,
        arrayPaginas: {},
        vazio: true
      }
    },
    components: {
      ConsultaCardUsuario,
      ConsultaCard
    },
    methods: {
      async apagar(id) {
        let jsonNew = await this.getJsonCards();
        debugger;
        for(let indice in jsonNew) {
          if (jsonNew[indice].id == id) {
            jsonNew.splice(indice, 1);
          }
        }
        this.jsonCards = jsonNew;
      },
      async getJsonCards() {
        let jsonUsuario = await fetch('http://localhost:8080/users/'+this.pagina);
        jsonUsuario = await jsonUsuario.json();
        if (jsonUsuario.length > 0) {
          this.vazio = false;
        }
        console.log(jsonUsuario);
        return jsonUsuario;
      },
      async onClickMudaPagina(valor) {
        this.pagina = valor-1;
        this.jsonCards = await this.getJsonCards();
      }
    },
    async mounted() {
      this.jsonCards = await this.getJsonCards();
      let quantidadePaginas = await fetch('http://localhost:8080/user/pages');
      this.quantidadePaginas = await quantidadePaginas.json();
      let arrayPaginas = {};
      for (let index = 0; index < this.quantidadePaginas; index++) {
        arrayPaginas[index+1] = index+1;
      }
      this.arrayPaginas = arrayPaginas;
    }
  }
  
</script>
  
<style scoped>
  
.botaozainho {
  margin: 0.2em;
}

.meuContainer {
  display: flex;
}

</style>
  