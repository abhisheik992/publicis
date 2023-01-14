import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpServiceService } from '../services/http-service.service';

@Component({
  selector: 'app-add-card',
  templateUrl: './add-card.component.html',
  styleUrls: ['./add-card.component.scss']
})
export class AddCardComponent implements OnInit {

  creditCardForm!: FormGroup;
  constructor(private fb: FormBuilder, private httpService: HttpServiceService, private _snackBar: MatSnackBar) { }




  ngOnInit(): void {
    this.createCreditCardForm();
  }

  createCreditCardForm() {
    this.creditCardForm = this.fb.group({
      creditHolder: ['', Validators.required],
      creditCardNumber: ['', Validators.required],
      creditLimit: ['', Validators.required],
    })
  }
  public myError = (controlName: string, errorName: string) =>{
    return this.creditCardForm.controls[controlName].hasError(errorName);
    }

  submitCreditCardForm(data: any) {
    console.log(data);
    this.httpService.postData(data).subscribe(res => {
      console.log(res);
    }, error => {
       this.openSnackBar(error.message, error.status)
    })
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action);
  }

}
