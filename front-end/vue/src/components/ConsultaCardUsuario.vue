<script>
import ConsultaCard from "@/components/ConsultaCard.vue"

export default {
    name: 'ConsultaCardUsuario',
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
            "cpf": null,
            "dataCadastro": null,
            "email": null,
            "endereco": null,
            "id": null,
            "nome": null,
            "telefone": null
        }
      },
      getUrlDelete() {
        return "http://localhost:8080/user/";
      },
      getUrlUpdate() {
        return "http://localhost:8080/user/update"
      }
    }
}
</script>

<style>

</style>