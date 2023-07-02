import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Destination, InsertDestination, UpdateDestination } from '../models/destination';

@Injectable({
  providedIn: 'root'
})
export class DestinationService {

  private readonly cBASE_URL = environment.api.url + 'destination';

  constructor(private _http: HttpClient) { }

  getDestinations(): Observable<Destination[]> {
    return this._http.get<Destination[]>(this.cBASE_URL);
  }

  getDestination(id: number): Observable<Destination> {
    return this._http.get<Destination>(this.cBASE_URL + '/' + id);
  }

  insertDestination(destination: InsertDestination): Observable<Destination> {
    return this._http.post<Destination>(this.cBASE_URL, destination);
  }

  updateDestination(destination: UpdateDestination): Observable<Destination> {
    return this._http.put<Destination>(this.cBASE_URL, destination);
  }

  deleteDestination(id: number): Observable<any> {
    return this._http.delete(this.cBASE_URL + '/' + id);
  }
}
