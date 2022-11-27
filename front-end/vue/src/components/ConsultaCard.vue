<template>
  <div>
    
    <div class="card card-consulta">
      <div class="dados-card">
        <h1 class="titulo-card">{{json.nome}}</h1>
        <div class="dados-card" >
          <div v-for="(dado, indice) in json" :key="indice">
            <label class="titulo-data-card" for="">{{indice}}</label>
            <input :id="id+indice" type="text" class="input-data-card" :value="dado">
          </div>
        </div>
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

</style>