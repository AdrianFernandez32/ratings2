let id;

function obtenerIdDesdeUrl() {
    // Obtiene la URL completa
    const urlCompleta = window.location.href;

    // Analiza la URL para extraer el parámetro "id"
    const url = new URL(urlCompleta);
    id = url.searchParams.get("id");

    // Muestra el ID en la consola (puedes hacer lo que quieras con el ID)
    console.log('ID desde la URL:', id);
  }

  // Llama a la función al cargar la página
  window.onload = obtenerIdDesdeUrl;


  const url = 'http://localhost:8181/api/restrooms/avg';

  // Realiza la solicitud Fetch
  fetch(url)
    .then(response => {
      if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
      }
      
      return response.json();
    })
    .then(data => {
  
      function ordenarPorPromedioGeneral(jsonDatos) {
        const datosOrdenados = Object.entries(jsonDatos)
          .map(([key, value]) => ({ nombre: key, promedio_general: value.promedio_general }))
          .sort((a, b) => b.promedio_general - a.promedio_general);
  
        return datosOrdenados;
      }
  
      const responseData = ordenarPorPromedioGeneral(data);
  
      console.log(responseData);
  
      // Manipula el DOM después de que los datos estén disponibles
      const container = document.getElementById("all-baths");
      container.innerHTML = responseData.map(baño => 
        `<div class="flex justify-between items-center px-2 py-2 bg-gray-400 rounded-full mb-5">
            <span class="boton-rate ml-6">${baño.nombre}</span>
            <span class="ml-6">Promedio: ${baño.promedio_general}</span>
        </div>`
      ).join('');
  
    })
    .catch(error => {
      console.error('Fetch error:', error);
    });
  


//   const url = 'http://localhost:8181/api/restrooms/avg';

//   // Realiza la solicitud Fetch
//   fetch(url)
//     .then(response => {
//       if (!response.ok) {
//         throw new Error(`HTTP error! Status: ${response.status}`);
//       }
      
//       return response.json();
//     })
//     .then(data => {

//       function ordenarPorPromedioGeneral(jsonDatos) {
//         const datosOrdenados = Object.entries(jsonDatos)
//           .sort(([, a], [, b]) => b.promedio_general - a.promedio_general)
//           .reduce((acc, [key, value]) => ({ ...acc, [key]: value }), {});
      
//         return datosOrdenados;
//       }

//       const responseData = ordenarPorPromedioGeneral(data);

//       console.log(responseData);
  
//       // Manipula el DOM después de que los datos estén disponibles
//       const container = document.getElementById("all-baths");
//       container.innerHTML = responseData.map(user => 
//         `<div class="flex justify-between items-center px-2 py-2 bg-gray-400 rounded-full mb-5">
//             <span class="boton-rate ml-6">${user.ubicacion}</span>
//             <button class="bg-green-500 px-10 py-2 text-green-800 rounded-full buttons transitions" onclick="handleClick(${user.restroomId})">
//                 <span>Rate</span>
//             </button>
//         </div>`
//       ).join('');
    
//     }).catch(error => {
//       console.error('Fetch error:', error);
//     });