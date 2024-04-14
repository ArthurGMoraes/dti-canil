let data = [
{
  nome:"Meu Canino Feliz",
  precoP: 20.00,
  precoG: 40.00,
  altPP: 20.00*1.2,
  altPG: 40.00*1.2,
  distancia: 2.00,
},

{
  nome:"Vai Rex",
  precoP: 15.00,
  precoG: 50.00,
  altPP: 20.00,
  altPG: 55.00,
  distancia: 1.7,
},

{
  nome:"ChowChawgas",
  precoP: 30.00,
  precoG: 45.00,
  altPP: 30.00,
  altPG: 45.00,
  distancia: 0.8,
}
];

function mkCard() {
  //console.log(data.length);
  str = '<div class="cards">';
for (let i = 0; i < data.length; i++) {
  let ps = data[i];
  //console.log(ps);
  str += `
  <div class="card">
  <h3 class="card-title">${ps.nome}</h3>
  <p class="card-text">Preço para cães pequenos: R$ ${ps.precoP.toLocaleString('pt-BR',{ minimumFractionDigits: 2, maximumFractionDigits: 2 })}</p>
  <p class="card-text">Preço para cães grandes: R$ ${ps.precoG.toLocaleString('pt-BR',{ minimumFractionDigits: 2, maximumFractionDigits: 2 })}</p>
  <p class="card-text">Preço para cães pequenos (fim de semana): R$ ${ps.altPP.toLocaleString('pt-BR',{ minimumFractionDigits: 2, maximumFractionDigits: 2 })}</p>
  <p class="card-text">Preço para cães grandes (fim de semana): R$ ${ps.altPG.toLocaleString('pt-BR',{ minimumFractionDigits: 2, maximumFractionDigits: 2 })}</p>
  <p class="card-text">Distância: ${ps.distancia.toLocaleString('pt-BR',{ minimumFractionDigits: 1, maximumFractionDigits: 1 })} Km</p>
</div>
          `;
} 
str += `</div>`
document.getElementById('tela').innerHTML = str;
};

onload( mkCard());
