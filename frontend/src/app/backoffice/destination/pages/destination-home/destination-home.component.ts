import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Destination } from '../../models/destination';
import { cPAGE_SIZE } from 'src/app/shared/consts/consts';
import { DestinationService } from '../../services/destination.service';
import { Router } from '@angular/router';
import { faArrowLeft, faPlus, faTrash, faPen } from '@fortawesome/free-solid-svg-icons';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AddOrUpdateDestinationModalComponent } from '../../components/add-or-update-destination-modal/add-or-update-destination-modal.component';
import { ABMAction } from 'src/app/shared/emuns/abmAction.enum';

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

    const modalRef = this._modalService.open(AddOrUpdateDestinationModalComponent);

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

    const modalRef = this._modalService.open(AddOrUpdateDestinationModalComponent);

		modalRef.componentInstance.action = ABMAction.update;
		modalRef.componentInstance.destination = destination;

    modalRef.result.then(destination => {

      if (destination) {
        this._destinationService.updateDestination(destination).subscribe(() => {

          this.getDestinations();
        });
      }
    });
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
