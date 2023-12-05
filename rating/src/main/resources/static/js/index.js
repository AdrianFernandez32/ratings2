const dummy2 = [
    {
      "id": "1",
      "ubicacion": "Biblioteca primer piso.",
      "sexo": "Hombre"
    },
    {
      "id": "2",    
      "ubicacion": "Biblioteca segundo piso.",
      "sexo": "Hombre"
    },
    {
      "id": "3",
      "ubicacion": "Gimnasio primer piso.",
      "sexo": "Hombre"
    },
    {
      "id": "4",
      "ubicacion": "Gimnasio segundo piso.",
      "sexo": "Hombre"
    },
    {
      "id": "5",
      "ubicacion": "Gimnasio regaderas.",
      "sexo": "Hombre" 
    },
    {
      "id": "6",
      "ubicacion": "Profesional primer piso.",
      "sexo": "Hombre"
    },
    {
      "id": "7",
      "ubicacion": "Profesional segundo piso.",
      "sexo": "Hombre"
    }
  ]




  const url = 'http://localhost:8181/api/restrooms';

  // Realiza la solicitud Fetch
  fetch(url)
    .then(response => {
      if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
      }
      
      return response.json();
    })
    .then(data => {
      // Asigna los datos a la variable
      const responseData = data;
  
      // Puedes hacer más cosas con los datos aquí si es necesario
      console.log(responseData);
  
      // Manipula el DOM después de que los datos estén disponibles
      const container = document.getElementById("all-baths");
      container.innerHTML = responseData.map(user => 
        `<div class="flex justify-between items-center px-2 py-2 bg-gray-400 rounded-full mb-5">
            <span class="boton-rate ml-6">${user.ubicacion}</span>
            <button class="bg-green-500 px-10 py-2 text-green-800 rounded-full buttons transitions">
                <span>Rate</span>
            </button>
        </div>`
      ).join('');
    })
    .catch(error => {
      console.error('Fetch error:', error);
    });


function handleClick(event) {
    // Obtener el ID desde el atributo data-id
    const id = event.target.dataset.id;

    // Construir la URL con el ID
    const url = `/ruta/${id}`;  // Reemplaza "/ruta" con tu ruta base

    // Navegar a la URL
    window.location.href = url;
    }

    // Asociar la función handleClick a los botones
    const botones = document.querySelectorAll('.boton-rate');
    botones.forEach(boton => {
    boton.addEventListener('click', handleClick);
    });

    