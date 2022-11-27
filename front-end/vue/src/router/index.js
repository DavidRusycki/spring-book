import { createRouter, createWebHistory } from 'vue-router'
import ViewInicial from '../views/ViewInicial.vue'
import ViewShopping from '../views/ViewShopping.vue'
import ViewProduto from '../views/ViewProduto.vue'
import ViewUsuario from '../views/ViewUsuario.vue'
import ViewAdicionarUsuario from '../views/ViewAdicionarUsuario.vue'
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
  },
  {
    path: '/new/user',
    name: 'Adicionar Usuário',
    component: ViewAdicionarUsuario
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router