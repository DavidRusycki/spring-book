import { createRouter, createWebHistory } from 'vue-router'
import ViewInicial from '../views/ViewInicial.vue'
import ViewShopping from '../views/ViewShopping.vue'
import ViewProduto from '../views/ViewProduto.vue'
import ViewUsuario from '../views/ViewUsuario.vue'
const routes = [
  {
    path: '/',
    name: 'Página Inicial',
    component: ViewInicial
  },
  {
    path: '/shopping',
    name: 'Shopping',
    component: ViewShopping
  },
  {
    path: '/produto',
    name: 'Produt',
    component: ViewProduto
  },
  {
    path: '/user',
    name: 'Usuário',
    component: ViewUsuario
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router