//Video 1
//console.log(document);

//Si ponemos getElementById y pasamos por parametros un ID que no existe, devuelve NULL
//console.log(document.getElementById("header"));
//Si ponemos getElementByClassName o getElementByTagName y pasamos como parametros el nombre de una etiqueta, te devuelve una lista de las veces que esté en el código
//console.log(document.getElementsByClassName("border-grey"));
//console.log(document.getElementsByTagName("li"))

//console.log(document.getElementByName("header")); //vuelva una lista de las veces que está "header"

//console.log(document.querySelector("li")); //(devuelve 1, el primero) 

//console.log(document.querySelector("[name=header]"));
//console.log(document.querySelectorAll("header"));  //devuelve todo de manera ordenada)

/* Guardando en constante */
//const elemento = document.getElementById("header");
//Dinamica: cambia cuando eliminamos
//const lista1 = document.getElementsByClassName("border-grey");
//Estatica: no cambia, si eliminamos, queda tal cual
//const lista2 = document.querySelectorAll(".border-grey");
//para transformar la lista en array, se pone en consola de la web (const listaArray = [...lista2])
//(.):sustituir selector de clase
//(#):ID
//([name=....]) Reemplaza "getElementByName"

//VIDEO 2:
//CREANDO ELEMENTOS:
//const titulo2= document.createElement("h2");
//const textoTitulo2 = document.createTextNode("Nuevo titulo");
//const comentario = document.createComment('Creando comentario')

//PARA CLONAR ELEMENTOS:
//const articulo = document.querySelector("article"); 
//articulo.cloneNode()
//articulo.cloneNode(true) Clona el nodo completo 
//const articulo2 = articulo.cloneNode(true);

//INSERTAR ELEMENTO
//const section =document.getElementById("section"); 
//section.insertAdjacentHTML('beforeend','<h3>Título inventado<h/3>') 
//section.insertAdjacentText('beforeend','Acá termina la sección')

//ELIMINAR ELEMENTO
//section.remove(); //Eliminar NODO

//REEMPLAZAR ELEMENTO
//section.innerHTML=<h2>Nuevo Título de la sección</h2>

//REEMPLAZAR TODO EL HTML
//section.outerHTML

//OBTENER CUALQUIER ATRIBUTO
//section.getAttribute('id')//devuelve 'section' en este caso 

//OBTENER CUALQUIER ATRIBUTO CON NOMBRE Y VALOR
//section.setAttribute('nombre', 'heater')
//section.classList //(devuelve la lista)
//section.className //(devuelve el string)
//PARA AÑADIR:
//section.className += 'LOQUESEA'
//section.classList.add ('nueva clase') //Agrega clase
//section.classList.remove("nueva clase")//Elimina clase

//Hace la función inversa(como un interruptor). Comprueba si existe la clase, si no, la crea y si existe la elimina
//section.classList.toggle("nueva clase")

//Video 3:
//-------------------------------------EVENTOS: 

//NO RECOMENDADO:
//function clickTitulo(){
  //  console.log("El usuario hizo click en el título");
//}
//const titulo2 = document.getElementById("tituloForm");

//TAMPOCO ES RECOMENDADO:
//titulo2.onclick = clickTitulo;

//LA MAS RECOMENDAD
//titulo2.addEventListener("click", clickTitulo); 

//function clickTitulo(){
  //console.log("El usuario hizo click en el título");
//}
//titulo2.removeEventListener("click", clickTitulo);(removiendo función)


//EVENTO2:
//document.addEventListener("DOMContentLoaded", () =>{
    //console.log("El documento se a cargado")//DOM cargado, muestra los elementos 
//})

//Evento3: Carga de formulario.
const form = document.querySelector("#formulario");
const  enviarFormulario = (event)=>{
    //console.log(event.bubbles); (verificar si se cumple(muestra true))
    event.preventDefault();//Previene el comportamiento que tiene por defecto

    const {name, email, password}= event.target
    console.log(
        name.value,
        email.value,
        password.value
        );

        if (name, value.length == 0) alert("El nombre no es válido");
}
form.addEventListener("submit", enviarFormulario);


const section = document.querySelector("#section");
const titulo2 = document.querySelector("#titulo2");


titulo2.addEventListener("click", (event) =>{ //Bubbling(abajo a arriba)
    //En este caso, al apretar el titulo, mostraba tambien el mensaje de la section ya que se tenia bubbling, a continuacion la "eliminamos" el bubbling
    /*console.log(event.bubbles, event.cancelBubble);
    event.stopPropagation();
    console.log(event.bubbles, event.cancelBubble);*/
    console.log("CLICK EN EL TITULO"
)}
    
); 

section.addEventListener("click", (event) =>{
    console.log("CLICK EN LA SECCION"); 
},
/*
{
    capture: true, //(Invierte, si hago click en título, muestra la seccion primero(ya que es el "padre" y despúes el título))
}
*/
);
