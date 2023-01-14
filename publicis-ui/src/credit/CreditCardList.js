import React from 'react'
import '../css/Table.css'

const CreditCardList = props => (
  <table className="Table">
    <thead>
      <tr>
        <th>Name</th>
        <th>Card Number</th>
        <th>Balance</th>
        <th>Limit</th>
      </tr>
    </thead>
    <tbody>
      {props.users.length > 0 ? (
        props.users.map(user => (
          <tr key={user.id}>
            <td>{user.creditHolder}</td>
            <td>{user.creditCardNumber}</td>
            <td>{user.creditBalance}</td>
            <td>{user.creditLimit}</td>
          </tr>
        ))
      ) : (
        <tr>
          <td colSpan={3}>No Data</td>
        </tr>
      )}
    </tbody>
  </table>
)

export default CreditCardList