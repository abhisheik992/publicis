import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  baseURL: string = "http://localhost:3002/cards";
  constructor(private http: HttpClient) { }

  getRepos(): Observable<any> {
    return this.http.get(this.baseURL)
  }

  postData(data: any): Observable<any> {
    return this.http.post(this.baseURL, data);
  }
}
