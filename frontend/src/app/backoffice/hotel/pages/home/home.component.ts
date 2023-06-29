import { Component, OnInit } from '@angular/core';
import { HotelService } from '../../services/hotel.service';
import { Hotel } from '../../models/hotel';
import { Observable } from 'rxjs';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AddHotelComponent } from '../../components/add-hotel/add-hotel.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  hotels$: Observable<Hotel[]>;
  page = 1;
	pageSize = 4;
  collectionSize = 0;

  constructor(
    private _hotelService: HotelService,
    private _modalService: NgbModal) { }

  ngOnInit(): void {

    this.hotels$ = this._hotelService.getHotels();

    this.hotels$.subscribe(res => {
      this.collectionSize = res.length;
    });
  }

  addHotel() {
    const modalRef = this._modalService.open(AddHotelComponent);
		//modalRef.componentInstance.name = 'World';
  }

  updateHotel() {

  }

  deleteHotel() {

  }
}
