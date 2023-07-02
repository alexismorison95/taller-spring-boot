import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Hotel, InsertHotel } from '../../models/hotel';
import { ABMAction } from '../../../../shared/emuns/abmAction.enum';

@Component({
  selector: 'app-add-or-update-hotel-modal',
  templateUrl: './add-or-update-hotel-modal.component.html',
  styleUrls: ['./add-or-update-hotel-modal.component.css']
})
export class AddOrUpdateHotelModalComponent implements OnInit {

  @Input() action: ABMAction;
  @Input() hotel: Hotel;
  @Input() destinationId: number;

  public formGroup: FormGroup;

  title: string;

  constructor(
    public _activeModal: NgbActiveModal,
    private _fb: FormBuilder) { }

  ngOnInit(): void {

    this.title = this.action == ABMAction.insert ? "Nuevo hotel" : "Editar hotal";

    this.formGroup = this._fb.group({
      id: [this.hotel ? this.hotel.id : ''],
      name: [this.hotel ? this.hotel.name : '', Validators.required],
      description: [this.hotel ? this.hotel.description : ''],
      destinationId: [this.destinationId, Validators.required]
    });
  }

  cancel() {
    this._activeModal.close(null);
  }

  save() {
    this._activeModal.close(this.formGroup.value);
  }

}
