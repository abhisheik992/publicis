import React, { useState, Fragment, useEffect } from 'react'
import './App.css';
import AddCreditCard from './credit/AddCreditCard';
import CreditCardList from './credit/CreditCardList';
import axios from "axios"



function App() {

  const usersData = []
  // Setting state
  const [users, setUsers] = useState(usersData);

  useEffect(() => {
    axios.get('http://localhost:8080/api/v1/cards')
      .then((response) => {
        setUsers(response.data)
      });
  }, []);

  const addUser = user => {
    user.id = users.length + 1
    setUsers([...users, user])
  }

  return (
    <div className="App">
      <h2 className='main'>Credit Card System</h2>
      <Fragment>
        <h2>Add</h2>
        <AddCreditCard addUser={addUser} />

      </Fragment>
      <div className="flex-large">
        <h2>Existing Credit Cards</h2>
        <CreditCardList users={users} />
      </div>
    </div>
  );
}

export default App;
