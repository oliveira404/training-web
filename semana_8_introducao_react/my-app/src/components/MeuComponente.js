import './MeuComponente.css'
import {useState} from 'react';

function Contador(props) {
  const [numero, setNumero] = useState(1)

  console.log(state);
  
  return (
    <div className="meu-estilo">Contador :{numero}
    
      <button onClick={() => setNumero(10)}>clique</button>
    </div>
  );
}

export default Contador;

