import { getAllProducts } from "../service/products.js"

//instancias de elementos

const contenedorHacer = document.getElementById("contenedor-hacer")
const contenedorProduccion = document.getElementById("contenedor-produccion")
const contenedorTestear = document.getElementById("contenedor-testear")
const contenedorCompletado = document.getElementById("contenedor-completado")


console.log(contenedorHacer)

const fillProducts = async () => {

    const products = await getAllProducts()

    products.forEach(product => {
        const category = product.category
        let container;

        if (category === "men's clothing") {
            container = contenedorHacer
        } else if (category === "electronics") {
            container = contenedorProduccion
        } else if (category === "jewelery") {
            container = contenedorTestear
        } else if (category === "women's clothing") {
            container = contenedorCompletado
        }
        console.log(container)
        //crear elemento en la categoria
        container.innerHTML += `
        <div class="row col-4"
        style="border: solid 3px black; margin:auto; padding: auto; max-width: 33%; height: 350px;overflow: auto; ">
        <div class="col-md-4">
          <img src="${product.image}" alt="..." style="height: 350px;width: 150px;">
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <h1 class="card-title">${product.title}</h1>
            <h2>${product.category}</h2>
            <h4>
            ${product.description}</h4>
            <a href="#" class="btn btn-primary">Ir a la tarea</a>
          </div>
        </div>
      </div>
        `

    });
}

fillProducts()