<template>
    <div class="main-container">
      <h1>Criadores</h1>
      <div class="photos">
        <div class="perfil">
          <img src="../image/david.png" style="width: 320px; height: 390px">
          <a href="https://github.com/DavidRusycki" title="GitHub David"><img src="../image/icon_git.png" class="icon_git">GitHub David</a>
        </div>
        <div class="perfil">
          <img src="../image/samuel.png" style="width: 320px; height: 390px">
          <a href="https://github.com/Samuca23" title="GitHub Samuel"><img src="../image/icon_git.png" class="icon_git">GitHub Samuel</a>
        </div>
      </div>
    </div>
</template>

<script>

export default {
  name: 'ViewInicial'
}

</script>

<style scoped>
  .main-container {
    display: flex;
    justify-content: center;
    height: 79vh;
    align-items: center;
    flex-direction: column;
  }

  .photos {
    display: flex;
  }

  .perfil {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  
  a{
    text-decoration: none;
    color: #000000;
    font-size: 1.5rem;
    font-weight: 500;
    border: 1px solid #000000;
    border-radius: 3%;
    width: 18rem;
    transition: all 200ms;
  }

  a:hover{
    font-size: 1.8rem;
    transition-timing-function: linear;
  }

  .icon_git{
    width: 40px;
    height: 40px;
    object-fit: cover;
  }

  img{
    margin: 1rem;
    object-fit: cover;
    border-radius: 3%;
  }
</style>
  