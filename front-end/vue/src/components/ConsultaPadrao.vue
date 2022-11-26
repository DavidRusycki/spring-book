<template>
  
    <div class="container">

        <div class="areaSuperior">
            <button>Grid</button>
        </div>
        <div>
            
            <ConsultaCard/ v-for="(card, indice) in jsonCards" :key="indice">
            
        </div>
    </div>

</template>

<script>
import ConsultaCard from "@/components/ConsultaCard.vue"

export default {
    name: 'ConsultaPadrao',
    props: {
        jsonCards: Object
    },
    components: {
        ConsultaCard
    }
}
</script>

<style>

</style>