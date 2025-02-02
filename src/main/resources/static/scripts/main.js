document.addEventListener("DOMContentLoaded", function () {


    fetch('/medicines')
        .then(response => response.json())
        .then(medicines => {
            const list = document.getElementById('medicinesList');
            medicines.forEach(medicine => {
                const card = criarListaMedicamento(medicine);
                list.appendChild(card);
            });
        })
        .catch(error => console.error('Erro ao buscar medicamentos:', error));


    function criarListaMedicamento(medicine) {
        const item = document.createElement("li");
        item.classList.add("medication-item");

        // Horário do medicamento
        const time = document.createElement("div");
        time.classList.add("medication-time");
        time.innerText = `Horário: ${medicine.horario}`;
        item.appendChild(time);

        // Nome do medicamento
        const title = document.createElement("div");
        title.classList.add("medication-name");
        title.innerText = `Medicamento: ${medicine.name}`;
        item.appendChild(title);

        // Dosagem
        const dosagem = document.createElement("div");
        dosagem.classList.add("medication-dosage");
        dosagem.innerText = `Dosagem: ${medicine.dosagem} mg`;
        item.appendChild(dosagem);

        // Frequência
        const frequency = document.createElement("div");
        frequency.classList.add("medication-frequency");
        frequency.innerText = `Frequência: ${medicine.frequencia}`;
        item.appendChild(frequency);


        if (medicine.observacao) {
            const note = document.createElement("div");
            note.classList.add("note");
            note.innerText = `Observação: ${medicine.observacao}`;
            item.appendChild(note);
        }

        return item;
    }

} );