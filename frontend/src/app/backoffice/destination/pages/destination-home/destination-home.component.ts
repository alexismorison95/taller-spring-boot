import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Destination } from '../../models/destination';
import { cPAGE_SIZE } from 'src/app/shared/consts/consts';
import { DestinationService } from '../../services/destination.service';
import { Router } from '@angular/router';
import { faPlus, faTrash, faPen } from '@fortawesome/free-solid-svg-icons';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ABMAction } from 'src/app/shared/emuns/abmAction.enum';
import { AddDestinationComponent } from '../../components/add-destination/add-destination.component';

@Component({
  selector: 'app-destination-home',
  templateUrl: './destination-home.component.html',
  styleUrls: ['./destination-home.component.css']
})
export class DestinationHomeComponent implements OnInit {

  destinations$: Observable<Destination[]>;
  page = 1;
	pageSize = cPAGE_SIZE;
  collectionSize = 0;
  faPlus = faPlus;
  faTrash = faTrash;
  faPen = faPen;

  constructor(
    private _destinationService: DestinationService,
    private _router: Router,
    private _modalService: NgbModal
  ) { }

  ngOnInit(): void {

    this.getDestinations();
  }

  getDestinations(): void {

    console.log("Traer pagina " + this.page + ", tamaño " + this.pageSize);

    this.destinations$ = this._destinationService.getDestinations();

    this.destinations$.subscribe(res => {

      this.collectionSize = res.length;
    });
  }

  addDestination() {

    const modalRef = this._modalService.open(AddDestinationComponent);

		modalRef.componentInstance.action = ABMAction.insert;

    modalRef.result.then(destination => {

      if (destination) {
        this._destinationService.insertDestination(destination).subscribe(() => {

          this.getDestinations();
        });
      }
    });
  }

  updateDestination(destination: Destination) {

    this._router.navigateByUrl('/backoffice/destination/updateDestination/' + destination.id, { state: destination });
  }

  deleteDestination(id: number) {
    
    this._destinationService.deleteDestination(id).subscribe(() => {

      this.getDestinations();
    });
  }

  editHotels(destination: Destination) {

    this._router.navigateByUrl('/backoffice/destination/hotelByDestination/' + destination.id, { state: destination });
  }
}
