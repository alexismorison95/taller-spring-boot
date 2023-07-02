import { Component, Input, OnInit } from '@angular/core';
import { ABMAction } from 'src/app/shared/emuns/abmAction.enum';
import { Destination, InsertDestination } from '../../models/destination';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-add-or-update-destination-modal',
  templateUrl: './add-or-update-destination-modal.component.html',
  styleUrls: ['./add-or-update-destination-modal.component.css']
})
export class AddOrUpdateDestinationModalComponent implements OnInit {

  @Input() action: ABMAction;
  @Input() destination: Destination;

  public formGroup: FormGroup;

  title: string;

  constructor(
    public _activeModal: NgbActiveModal,
    private _fb: FormBuilder) { }

  ngOnInit(): void {

    this.title = this.action == ABMAction.insert ? "Nuevo destino" : "Editar destino";

    this.formGroup = this._fb.group({
      id: [this.destination ? this.destination.id : ''],
      name: [this.destination ? this.destination.name : '', Validators.required],
      description: [this.destination ? this.destination.description : '']
    });
  }

  cancel() {
    this._activeModal.close(null);
  }

  save() {
    this._activeModal.close(this.formGroup.value);
  }
}
