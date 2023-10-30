import { getAllProducts } from "../service/products.js"

//instancias de elementos

const contenedorHacer = document.getElementById("contenedor-hacer")
const contenedorProduccion = document.getElementById("contenedor-produccion")
const contenedorTestear = document.getElementById("contenedor-testear")
const contenedorCompletado = document.getElementById("contenedor-Completado")


const fillProducts = async () => {

    const products = await getAllProducts()
    products.forEach(product => {
        const category = product.category
        let container;

        if (product.state === "Estado Actual: Por hacer") {
            container = contenedorHacer
        } else if (product.state === "Estado Actual: En producción") {
            container = contenedorProduccion
        } else if (product.state === "Estado Actual: Por testear") {
            container = contenedorTestear
        } else if (product.state === "Estado Actual: Finalizado") {
            container = contenedorCompletado
        }
        //crear elemento en la categoria
        container.innerHTML += `
        <div class="row col-4"
        style="border: solid 3px black; margin:auto; padding: auto; max-width: 33%; height: 350px;overflow: auto; ">
        <div class="col-md-4">
          <img src="${product.img}" alt="..." style="height: 350px;width: 150px;">
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <h1 class="card-title">${product.title}</h1>
            <h2>${product.author}</h2>
            <h4>
            ${product.description}</h4>
            <h4>
            ${product.time}</h4>
            <h4>
            ${product.description}</h4>
            <h4>
            ${product.state}</h4>
            <a href="#" class="btn btn-primary">Ir a la tarea</a>
          </div>
        </div>
      </div>
        `

    });
}

fillProducts()