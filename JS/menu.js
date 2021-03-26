

const menu = document.querySelector('.menu');
const men = document.querySelector('.menu-navegacion');

console.log(menu)
console.log(men)

menu.addEventListener('click',()=>{
    men.classList.toggle("spread")
})


window.addEventListener('click', e=>{
    if(men.classList.contains('spread')&&e.target!=men && e.target!=menu){

        men.classList.toggle("spread")
    }

    
})