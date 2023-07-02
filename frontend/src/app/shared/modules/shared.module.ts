import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
    imports: [
        NgbModule,
        ReactiveFormsModule
    ],
    exports: [
        NgbModule,
        ReactiveFormsModule,
        FontAwesomeModule
    ]
})
export class SharedModule { }