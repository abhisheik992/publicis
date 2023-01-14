import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../services/http-service.service';

export interface DataElement {
  _id: string;
  creditHolder: string;
  creditCardNumber: string;
  creditLimit: number;
  creditBalance: number;
}


@Component({
  selector: 'app-list-cards',
  templateUrl: './list-cards.component.html',
  styleUrls: ['./list-cards.component.scss']
})
export class ListCardsComponent implements OnInit {

  columns = [
    {
      columnDef: 'creditHolder',
      header: 'Name',
      cell: (element: DataElement) => `${element.creditHolder}`,
    },
    {
      columnDef: 'creditCardNumber',
      header: 'Card Number',
      cell: (element: DataElement) => `${element.creditCardNumber}`,
    },
    {
      columnDef: 'creditLimit',
      header: 'Limit',
      cell: (element: DataElement) => `${element.creditLimit}`,
    },
    {
      columnDef: 'creditBalance',
      header: 'Balance',
      cell: (element: DataElement) => `${element.creditBalance}`,
    },
  ];
  dataSource :any;
  displayedColumns : any = [];
  constructor(private httpService: HttpServiceService) { }

  ngOnInit(): void {
    this.httpService.getRepos().subscribe(res => {
      console.log(res);
      this.dataSource = res.data;
      this.displayedColumns = this.columns.map(c => c.columnDef);
    })
  }

}
