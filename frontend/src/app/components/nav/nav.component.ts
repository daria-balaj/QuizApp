import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, Validators } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { Router, RouterLink } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatBadgeModule } from '@angular/material/badge';
import { MatMenuModule } from '@angular/material/menu';
import { AuthenticationService } from '../../services/authentication.service';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-nav',
  imports: [
    CommonModule,
    MatIconModule,
    MatToolbarModule,
    MatBadgeModule,
    FormsModule,
    MatMenuModule,
    MatSelectModule,
    MatInputModule,
    MatFormFieldModule,
    ReactiveFormsModule
  ],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent {

  errorMessage = "";

  constructor(public authService: AuthenticationService, private router: Router) { }

  form = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    phoneNumber: new FormControl('', Validators.required),
  })

  onSubmit() {
    this.authService.login(
      this.form.value.email!,
      this.form.value.password!
    ).subscribe(result => {
        console.log(result);
        if (result === true) {
          this.errorMessage = "";
          this.router.navigate(["/products/all"]);
        } 
        else {
          this.errorMessage = "Email or password is incorrect.";
          console.log(this.errorMessage);
        }
        console.log(this.errorMessage);
    });
    this.router.navigateByUrl('');
  }

  logout() {}

}
