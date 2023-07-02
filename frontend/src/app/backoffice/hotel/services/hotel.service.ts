import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Hotel, InsertHotel, UpdateHotel } from '../models/hotel';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  private readonly cBASE_URL = environment.api.url + 'hotel';

  constructor(private _http: HttpClient) { }

  getHotels(): Observable<Hotel[]> {
    return this._http.get<Hotel[]>(this.cBASE_URL);
  }

  getHotelsByDestinationId(id: number): Observable<Hotel[]> {
    return this._http.get<Hotel[]>(this.cBASE_URL + '/by-destination/' + id);
  }

  getHotel(id: number): Observable<Hotel> {
    return this._http.get<Hotel>(this.cBASE_URL + '/' + id);
  }

  insertHotel(hotel: InsertHotel): Observable<Hotel> {
    return this._http.post<Hotel>(this.cBASE_URL, hotel);
  }

  updateHotel(hotel: UpdateHotel): Observable<Hotel> {
    return this._http.put<Hotel>(this.cBASE_URL, hotel);
  }

  deleteHotel(id: number): Observable<any> {
    return this._http.delete(this.cBASE_URL + '/' + id);
  }
}
