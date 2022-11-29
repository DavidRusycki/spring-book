<template>
    <div class="main-container">
        <h1>Adicionar Produto</h1>

        <table>
                <tr v-for="(valor, indice) in jsonCampos" :key="indice">
                    <td>
                        <label :for="indice">{{indice+':'}}</label>
                    </td>
                    <td>
                        <input :id="indice" :type="valor">
                    </td>
                </tr>
        </table>
        <button @click="salvar()">Salvar</button>
    </div>
</template>
  
<script>

  export default {
    name: 'ViewAdicionarShoping',
    data() {
        return {
            jsonCampos: {}
        }
    },
    methods: {
        adicionarCampos() {
            let json =  {
                "userIdentifier": 'text',
                "total": 'numeric',
                "items": 'text'
            }
            this.jsonCampos = json;
        },
        async salvar() {
            let salvar = {};
            for(let indice in this.jsonCampos) {
                salvar[indice] = document.getElementById(indice).value;
                document.getElementById(indice).value = '';
            }
            salvar["items"] = JSON.parse(salvar["items"]);
            salvar["date"] = "2022-11-28T02:35:47.015Z";
            salvar["id"] = 0;

            fetch("http://localhost:8082/shopping/",
                {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(salvar)
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
            this.jsonCampos = {};
            this.adicionarCampos();
        }
    },
    mounted() {
        this.adicionarCampos();
    }
  }
  
</script>
  
<style scoped>
  
</style>
  