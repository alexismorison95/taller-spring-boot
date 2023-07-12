import { Component, Input, OnInit } from '@angular/core';
import { ABMAction } from 'src/app/shared/emuns/abmAction.enum';
import { Destination, InsertDestination } from '../../models/destination';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { faPen } from '@fortawesome/free-solid-svg-icons';
import { DestinationPhoto } from '../../models/destinationPhoto';

@Component({
  selector: 'app-add-or-update-destination-photo',
  templateUrl: './add-or-update-destination-photo.component.html',
  styleUrls: ['./add-or-update-destination-photo.component.css']
})
export class AddOrUpdateDestinationPhotoComponent implements OnInit {

  @Input() action: ABMAction;
  @Input() destinationPhoto: DestinationPhoto;

  public formGroup: FormGroup;
  faPen = faPen;
  title: string;
  isUpdateAction: boolean;

  constructor(
    public _activeModal: NgbActiveModal,
    private _fb: FormBuilder
  ) { }

  ngOnInit(): void {

    this.title = this.action == ABMAction.insert ? "Nueva fotografía" : "Editar fotografía";
    this.isUpdateAction = this.action == ABMAction.update ? true : false;

    this.formGroup = this._fb.group({
      id: [this.destinationPhoto ? this.destinationPhoto.id : ''],
      url: [this.destinationPhoto ? this.destinationPhoto.url : '', Validators.required],
      description: [this.destinationPhoto ? this.destinationPhoto.description : '']
    });
  }

  cancel() {
    this._activeModal.close(null);
  }

  save() {
    this._activeModal.close(this.formGroup.value);
  }
}
