<template>
  <div>
    <div class="card meuCard" style="width: 22rem;">
      <div class="card-body">
        <h5 class="card-title">{{json.nome}}</h5>
        
          <p class="card-text">
            <div v-for="(dado, indice) in json" :key="indice">
              <label class="titulo-data-card" for="">{{indice+":"}}</label>
              <input :id="id+indice" type="text" class="input-data-card" :value="dado">
            </div>
          </p>
        
          <a href="#" class="card-link">Salvar</a>
          <a href="#" class="card-link">Apagar</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
    name: 'ConsultaCard',
    props: {
        id: Number,
        json: Object
    },
    mounted() {
      console.log("montou card");
      console.log(this.json);
    }
}
</script>

<style>

.meuCard {
  margin: 1em;
}

.input-data-card {
  border: transparent;
}

</style>