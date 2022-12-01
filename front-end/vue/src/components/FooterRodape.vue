<template>
  <footer id="footer">
    <div class="content-footer">
      <div class="content-copy">
        <p class="copy">&copy; 2022 - Todos os direitos reservados | By David ASM Rusicky and Samuel S Chiodini.</p>
      </div>
    </div>
  </footer>
</template>

<script>

export default {
  name: 'FooterRodape'
}

</script>

<style scoped>
#footer{
  background: linear-gradient(90deg, rgb(83, 83, 83) 0%, rgb(29, 29, 29) 50%) !important;
  width: 100%;
  height: 70px;
  position: absolute;
  right: 0;
  bottom: 0;
  left: 0;
}

.content-footer{
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 80% 20%;
  align-content: center;
  justify-items: center;
  height: 100%;
}

.content-logo{
  width: 100%;
  display: flex;
  justify-content: flex-end;
  align-items: center;
}

.title-pizza-float{
  font-size: 2em;
  font-family: 'Pt Sans', 'Helvetica';
}

.content-copy{
  grid-row-start: 2;
  grid-row-end: 3;
  grid-column-start: 1;
  grid-column-end: 3;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 100%;
}

.copy{
  font-size: 0.8em;
  font-family: 'Pt Sans', 'Helvetica';
  color: rgb(255, 255, 255) ;
}

</style>
