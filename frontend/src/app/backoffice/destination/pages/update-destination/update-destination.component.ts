import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Destination } from '../../models/destination';
import { DestinationService } from '../../services/destination.service';
import { Router } from '@angular/router';
import { DestinationPhoto } from '../../models/destinationPhoto';
import { Observable } from 'rxjs';
import { faPlus, faTrash, faPen } from '@fortawesome/free-solid-svg-icons';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AddOrUpdateDestinationPhotoComponent } from '../../components/add-or-update-destination-photo/add-or-update-destination-photo.component';
import { ABMAction } from 'src/app/shared/emuns/abmAction.enum';

@Component({
  selector: 'app-update-destination',
  templateUrl: './update-destination.component.html',
  styleUrls: ['./update-destination.component.css']
})
export class UpdateDestinationComponent implements OnInit {

  public formGroup: FormGroup;

  destination: Destination;
  destinationPhotos: Observable<DestinationPhoto[]>;

  faPlus = faPlus;
  faTrash = faTrash;
  faPen = faPen;

  constructor(
    private _fb: FormBuilder,
    private _destinationService: DestinationService,
    private _router: Router,
    private _modalService: NgbModal
    ) { 
      this.getParamData();
  }

  ngOnInit(): void {

    this.formGroup = this._fb.group({
      id: [this.destination ? this.destination.id : ''],
      name: [this.destination ? this.destination.name : '', Validators.required],
      description: [this.destination ? this.destination.description : '']
    });

    this.getDestinationPhotos();
  }

  getParamData() {

    this.destination = this._router.getCurrentNavigation().extras.state as Destination;

    if (this.destination == undefined) {

      this._router.navigateByUrl('/backoffice/destination');
    }
  }

  getDestinationPhotos() {

    this.destinationPhotos = this._destinationService.getDestinationPhotosByDestinationId(this.destination.id);
  }

  cancel() {
    this._router.navigateByUrl('/backoffice/destination');
  }

  saveDestination() {

    this._destinationService.updateDestination(this.formGroup.value).subscribe(() => {

      this._router.navigateByUrl('/backoffice/destination');
    });
  }

  deletePhoto(id: number) {

    this._destinationService.deleteDestinationPhoto(id).subscribe(() => {

      this.getDestinationPhotos();
    });
  }

  updatePhoto(photo: DestinationPhoto) {

    const modalRef = this._modalService.open(AddOrUpdateDestinationPhotoComponent);

		modalRef.componentInstance.action = ABMAction.update;
    modalRef.componentInstance.destinationPhoto = photo;

    modalRef.result.then(destinationPhoto => {

      if (destinationPhoto) {
        this._destinationService.updateDestinationPhoto(destinationPhoto, this.destination.id).subscribe(() => {

          this.getDestinationPhotos();
        });
      }
    });

  }

  addPhoto() {
    
    const modalRef = this._modalService.open(AddOrUpdateDestinationPhotoComponent);

		modalRef.componentInstance.action = ABMAction.insert;

    modalRef.result.then(destinationPhoto => {

      if (destinationPhoto) {
        this._destinationService.insertDestinationPhoto(destinationPhoto, this.destination.id).subscribe(() => {

          this.getDestinationPhotos();
        });
      }
    });
  }
}
