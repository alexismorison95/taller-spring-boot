import { Component, OnInit } from '@angular/core';
import { HotelService } from '../../services/hotel.service';
import { Hotel } from '../../models/hotel';
import { Observable } from 'rxjs';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AddOrUpdateHotelModalComponent } from '../../components/add-or-update-hotel-modal/add-or-update-hotel-modal.component';
import { ABMAction } from '../../../../shared/emuns/abmAction.enum';
import { cPAGE_SIZE } from 'src/app/shared/consts/consts';
import { Router } from '@angular/router';
import { Destination } from 'src/app/backoffice/destination/models/destination';
import { faArrowLeft, faPlus, faTrash, faPen } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  hotels$: Observable<Hotel[]>;
  page = 1;
	pageSize = cPAGE_SIZE;
  collectionSize = 0;
  destination: Destination;
  faArrowLeft = faArrowLeft;
  faPlus = faPlus;
  faTrash = faTrash;
  faPen = faPen;

  constructor(
    private _hotelService: HotelService,
    private _modalService: NgbModal,
    private _router: Router) { 

    this.getParamData();
  }

  ngOnInit(): void {

    this.getHotels();
  }

  getParamData() {

    this.destination = this._router.getCurrentNavigation().extras.state as Destination;

    if (this.destination == undefined) {

      this._router.navigateByUrl('/backoffice/destination');
    }
  }

  getHotels(): void {

    console.log("Traer pagina " + this.page + ", tamaño " + this.pageSize);

    this.hotels$ = this._hotelService.getHotelsByDestinationId(this.destination.id);

    this.hotels$.subscribe(res => {

      this.collectionSize = res.length;
    });
  }

  addHotel(): void {
    const modalRef = this._modalService.open(AddOrUpdateHotelModalComponent);

		modalRef.componentInstance.action = ABMAction.insert;
    modalRef.componentInstance.destinationId = this.destination.id;

    modalRef.result.then(hotel => {

      if (hotel) {
        this._hotelService.insertHotel(hotel).subscribe(() => {

          this.getHotels();
        });
      }
    });
  }

  updateHotel(hotel: Hotel): void {

    const modalRef = this._modalService.open(AddOrUpdateHotelModalComponent);
    
		modalRef.componentInstance.action = ABMAction.update;
		modalRef.componentInstance.hotel = hotel;
		modalRef.componentInstance.destinationId = this.destination.id;

    modalRef.result.then(hotel => {

      if (hotel) {
        this._hotelService.updateHotel(hotel).subscribe(() => {

          this.getHotels();
        });
      }
    });
  }

  deleteHotel(id: number): void {

    this._hotelService.deleteHotel(id).subscribe(() => {

      this.getHotels();
    });
  }
}
