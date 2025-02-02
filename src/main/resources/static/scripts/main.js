fetch('/medicines')
    .then(response => response.json())
    .then(medicines => {
        const list = document.getElementById('medicinesList');
        medicines.forEach(medicine => {

           const card = criarCards(medicine);
           list.appendChild(card);
            console.log(medicines)
        });
    })
    .catch(error => console.error('Erro ao buscar medicamentos:', error));



 function criarCards (medicine){
     const card = document.createElement("div");
     card.classList.add("card");

     const title = document.createElement("h3");
     title.innerText = `Medicamento: ${medicine.name}`;
     card.appendChild(title);

     const dosagem = document.createElement("p");
     dosagem.innerText =  `Dosagem: ${medicine.dosagem} mg`;
     card.appendChild(dosagem);

     const frequency = document.createElement("p");
     frequency.innerText =  `Frequência: ${medicine.frequencia}`;
     card.appendChild(frequency);


     const time = document.createElement("p");
     time.classList.add("time");
     time.innerText = `Horário: ${medicine.horario}`;
     card.appendChild(time);


     if(medicine.observacao){
         const note = document.createElement("p");
         note.classList.add("note");
         note.innerText = `Observação: ${medicine.observacao}`;
         card.appendChild(note)
     }

     return card;
}