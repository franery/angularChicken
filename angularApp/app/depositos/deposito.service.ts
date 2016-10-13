import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';

import { Deposito } from './deposito';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class DepositoService {
  private depositosListarUrl = 'http://localhost:8080/ChickenEscuelita/depositosJson';  // URL to web API
  private depositosBorrarUrl = 'http://localhost:8080/ChickenEscuelita/depositosBorrarJson';
  constructor (private http: Http) {}

  getDepositos (): Observable<Deposito[]> {
    return this.http.get(this.depositosListarUrl)
                    .map(this.extractData)
                    .catch(this.handleError);
  }
  
  delete(deposito: Deposito): void {
    this.http.post(this.depositosBorrarUrl, JSON.stringify({deposito}));
  }

  private extractData(res: Response) {
    let body = res.json();
    return body.data || { };
  }

  private handleError (error: any) {
    // In a real world app, we might use a remote logging infrastructure
    // We'd also dig deeper into the error to get a better message
    let errMsg = (error.message) ? error.message :
      error.status ? `${error.status} - ${error.statusText}` : 'Server error';
    console.error(errMsg); // log to console instead
    return Observable.throw(errMsg);
  }
}