import axios from 'axios'
import React, { useState } from 'react'
import '../css/Form.css'

const AddCreditCard = props => {
    const initialFormState = { id: null, creditHolder: '', creditCardNumber: '', creditLimit: 0, creditBalance: 0 }
    const errorFormState = {creditHolderIsValid: true, creditCardNumberIsValid: true, creditLimitIsValid: true}
    const [user, setUser] = useState(initialFormState);
    const [formIsValid, setFormIsValid] = useState(errorFormState);

    const handleInputChange = event => {
        const { name, value } = event.target
        setUser({ ...user, [name]: value })
    }

    const formSubmitHandler = event => {
        console.log("Inside Handler");
        event.preventDefault();
        if(user.creditHolder.trim() === '') {
            setFormIsValid({...formIsValid, creditHolderIsValid: false})
        }
        if(user.creditCardNumber.trim() === '' || user.creditCardNumber.length > 19) {
            setFormIsValid({...formIsValid, creditCardNumberIsValid: false})
        }
        if(parseInt(user.creditLimit) < 0) {
            console.log(parseInt(user.creditLimit));
            setFormIsValid({...formIsValid, creditLimitIsValid: false})
        }
        if (!user.creditHolder || !user.creditCardNumber || !user.creditLimit) {
            return
        } 
        console.log(user);
        axios.post('http://localhost:8080/api/v1/card', user).then(res => {
            if(res.data) {
                user.creditBalance = user.creditLimit;
                props.addUser(user)
                setUser(initialFormState)
                setFormIsValid(errorFormState)
            }
        })
    }

    return (
        <form className='Form'
            onSubmit={formSubmitHandler}
        >
            <div>
                <label>Name</label> <br />
                <input type="text" name="creditHolder" value={user.creditHolder} onChange={handleInputChange} />
            </div>
            {!formIsValid.creditHolderIsValid && <p className='error-text'>User Name is Not Valid</p>}
            <div>
                <label>Card Number</label><br />
                <input type="text" name="creditCardNumber" value={user.creditCardNumber} onChange={handleInputChange} />
            </div>
            {!formIsValid.creditCardNumberIsValid && <p className='error-text'>Credit Card Number is Not Valid</p>}
            <div>
                <label>Limit</label><br />
                <input type="number" name="creditLimit" value={user.creditLimit} onChange={handleInputChange} />
            </div>
            {!formIsValid.creditLimitIsValid && <p className='error-text'>Credit Limit is Not Valid</p>}


            <button className='btn'>Add</button>
        </form>
    )
}

export default AddCreditCard