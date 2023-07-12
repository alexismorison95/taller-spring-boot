import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { faPen } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-add-destination',
  templateUrl: './add-destination.component.html',
  styleUrls: ['./add-destination.component.css']
})
export class AddDestinationComponent implements OnInit {

  public formGroup: FormGroup;
  faPen = faPen;
  title: string;
  isUpdateAction: boolean;

  constructor(
    public _activeModal: NgbActiveModal,
    private _fb: FormBuilder
  ) { }

  ngOnInit(): void {

    this.formGroup = this._fb.group({
      name: ['', Validators.required],
      description: ['']
    });
  }

  cancel() {
    this._activeModal.close(null);
  }

  save() {
    this._activeModal.close(this.formGroup.value);
  }
}
