import {useEffect, useState} from "react";
import './App.css';

function App() {

  const [coffee, setCoffee] = useState([]);

  const getCoffees = () => {
    fetch('http://localhost:8080/api/coffee', {
      method: 'GET',
      headers: {
        'Authorization' : 'Basic ZGVuZWI6MTIzNA=='
      }
    })
      .then(res => res.json())
      .then(json => setCoffee(json));
  };

  getCoffees();

  /* front <-> back 서버 통신 간 CORS로 인한 통신이 차단되는 것을 확인 */
  return (
    <div className="App">
      <div id="container">
        {coffee}
      </div>
    </div>
  );
}

export default App;
