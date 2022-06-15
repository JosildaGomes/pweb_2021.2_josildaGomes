document.getElementById('cep').addEventListener('focusout', function () { 
    fetchAddress(); 
  }) 
   
  async function fetchAddress() { 
    const CEP = document.getElementById("cep").value; 
   
    try { 
      let response = await fetch(`https://viacep.com.br/ws/${CEP}/json/`); 
      let address = await response.json(); 
      setAddress(address); 
    } catch (err) { 
      alert('CEP inválido!') 
    } 
  } 
   
  function setAddress(address) { 
    document.getElementById("cidade").value = address.localidade || ''; 
  }