<script>
import ConsultaCard from "@/components/ConsultaCard.vue"

export default {
    name: 'ConsultaCardProduto',
    extends: ConsultaCard,
    methods: {
      changeInput(id, nomeProp) {
        let idnumero = id.split('-')[0];
        if (nomeProp = 'nome') {
            let idtitle = idnumero+'-cardTittle';
            document.getElementById(idtitle).innerHTML = document.getElementById(id).value;
        }
      },
      getJsonOriginal() {
        return {
          "categoryId": null,
          "descricao": null,
          "id": null,
          "nome": null,
          "preco": null,
          "productIdentifier": null
        }
      },
      getUrlDelete() {
        return "http://localhost:8081/product/";
      },
      getUrlUpdate() {
        return "http://localhost:8081/product/update"
      },
      salvar(id) {
        let jsonParaSalvar = {};
        for(let indice in this.getJsonOriginal()) {
          jsonParaSalvar[indice] = document.getElementById(id+'-'+indice).value;
        }

        jsonParaSalvar['categoryDTO'] = {id:jsonParaSalvar['categoryId'], nome:''};
        delete jsonParaSalvar['categoryId'];

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
    }
}
</script>

<style>

</style>