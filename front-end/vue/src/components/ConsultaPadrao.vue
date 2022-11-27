<template>
  
    <div class="container">

        <div class="areaSuperior">
            <button>Grid</button>
        </div>
        <div>            
            <ConsultaCard v-for="(card, indice) in jsonCards" :json="card" :id="card.id" :key="indice"/>
        </div>
    </div>

</template>

<script>
import ConsultaCard from "@/components/ConsultaCard.vue"

export default {
    name: 'ConsultaPadrao',
    props: {
        jsonParam: Object,
    },
    data () {
        return {
            jsonCards: {},
            jsonGrid: {}
        }
    },
    components: {
        ConsultaCard
    },
    mounted() {
        this.jsonCards = this.jsonParam;
        console.log("JSON CARDS:")
        console.log(this.jsonCards);
    }
}
</script>

<style>

</style>