<script>
import ConsultaCard from "@/components/ConsultaCard.vue"

export default {
    name: 'ConsultaCardShoping',
    extends: ConsultaCard,
    methods: {
      getJsonOriginal() {
        return {
          "id": null,
          "userIdentifier": null,
          "total": null,
          "items": null
        }
      },
      getUrlDelete() {
        return "http://localhost:8082/shopping/";
      },
      getUrlUpdate() {
        return "http://localhost:8082/shopping/update"
      },
      salvar(id) {
        let jsonParaSalvar = {};
        for(let indice in this.getJsonOriginal()) {
          jsonParaSalvar[indice] = document.getElementById(id+'-'+indice).value;
        }
        jsonParaSalvar['items'] = JSON.parse(jsonParaSalvar['items']);
        jsonParaSalvar['date'] = '';

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