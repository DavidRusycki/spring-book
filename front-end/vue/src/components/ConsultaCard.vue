<template>
  <div>
    <div class="card meuCard" style="width: 22rem;">
      <div class="card-body">
        <h5 :id="id+'-'+'cardTittle'" class="card-title">{{json.nome}}</h5>
        
          <span class="card-text">
            <div v-for="(dado, indice) in json" :key="indice">
              <label class="titulo-data-card" for="">{{indice+":"}}</label>
              <input @change="changeInput(id+'-'+indice, indice)" :id="id+'-'+indice" type="text" class="input-data-card" :value="dado">
            </div>
          </span>
          <button @click="salvar(id)" type="submit" class="card-link btn btn-success">Salvar</button>
          <button @click="apagar(id), $emit('apagar')" type="submit" class="btn btn-danger card-link">Apagar</button>
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
    emits: ['apagar'],
    mounted() {
      console.log("montou card");
    },
    methods: {
      changeInput(id, nomeProp) {
        console.log("change não implementado");
      },
      salvar(id) {
        debugger;
        let jsonParaSalvar = {};
        for(let indice in this.getJsonOriginal()) {
          jsonParaSalvar[indice] = document.getElementById(id+'-'+indice).value;
        }

        fetch(this.getUrlUpdate(), 
          {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(jsonParaSalvar)
          }
        ).then(response => response.json())
        .then(
            (data) => {
                console.log(data);
                console.log("Deu certo!");
            }
        )
        .catch(
            (error) => {
                console.log("Deu Errado!");
                console.log(error);
            }
        );
      },
      apagar(id) {
        let url = this.getUrlDelete()+id;
        fetch(url, 
          {
            method: 'DELETE',
            headers: { 'Content-Type': 'application/json' }
          }
        ).then(response => response.json())
        .then(
          (data) => {
              console.log(data);
              console.log("Deu certo!");
          }
        )
        .catch(
          (error) => {
              console.log("Deu Errado!");
              console.log(error);
          }
        );
      },
      getJsonOriginal() {
        return null;
      },
      getUrlDelete() {
        return null;
      },
      getUrlUpdate() {
        return null
      }
    }
}
</script>

<style>

.meuCard {
  margin: 1em;
}

.card-title {
  font-size: 1.5rem;
}

.titulo-data-card {
  font-weight: bold;
}

.titulo-data-card::first-letter {
  text-transform: uppercase;
}

.input-data-card {
  border: transparent;
}

</style>