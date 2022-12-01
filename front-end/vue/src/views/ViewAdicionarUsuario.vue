<template>
    <div class="main-container">
        <h1>Adicionar Usuário</h1>

        <table>
                <tr v-for="(valor, indice) in jsonCampos" :key="indice">
                    <td>
                        <label class="label-add" :for="indice">{{indice+':'}}</label>
                    </td>
                    <td>
                        <input :id="indice" :type="valor">
                    </td>
                </tr>
        </table>
        <button class="btn btn-success" @click="salvar()">Salvar</button>
        <div class="alert alert-success" role="alert" v-if="this.mensagem" id="mensagem">
            Usuário adicionado com sucesso!
        </div>
    </div>
</template>
  
<script>

  export default {
    name: 'ViewAdicionarUsuario',
    data() {
        return {
            jsonCampos: {},
            mensagem: false
        }
    },
    methods: {
        adicionarCampos() {
            let json =  {
                "cpf": "text",
                "email": "text",
                "endereco": "text",
                "nome": "text",
                "telefone": "text"
            }
            this.jsonCampos = json;
        },
        async salvar() {
            let salvar = {};
            for(let indice in this.jsonCampos) {
                salvar[indice] = document.getElementById(indice).value;
                document.getElementById(indice).value = '';
            }
            salvar["dataCadastro"] = "0";
            salvar["id"] = 0;

            fetch("http://localhost:8080/user/",
                {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(salvar)
                }
                ).then(response => response.json())
                .then(
                    (data) => {
                        this.mensagem = true;
                        let time = setTimeout(() => {
                            this.mensagem = false;
                            clearTimeout(time);
                        }, 2000);
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
#mensagem {
    width: 20em;
}
.label-add::first-letter {
  text-transform: uppercase;
}
</style>
  