import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, Validators } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { Router, RouterLink } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatBadgeModule } from '@angular/material/badge';
import { MatMenuModule, MatMenu } from '@angular/material/menu';
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
export class NavComponent implements OnInit {
  @ViewChild('menu') menu!: MatMenu;

  registerForm!: FormGroup;
  loginForm!: FormGroup;
  errorMessage = "";
  isSignUpMode = false;

  constructor(private fb: FormBuilder, public authService: AuthenticationService, private router: Router) { }

  ngOnInit() {
    this.registerForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });

    this.loginForm = new FormGroup({
      usernameOrEmail: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });

    this.registerForm.get('username')?.valueChanges.subscribe(username => {
        if (username) this.checkUsernameAvailability(username);
      });
  }

  checkUsernameAvailability(username: string): void {
    this.authService.checkUsernameAvailability(username).subscribe(
      isAvailable => {
        if (!isAvailable) {
          this.registerForm.get('username')?.setErrors({ usernameTaken: true });
        }
      }
    );
  }

  register(): void {
    if (this.registerForm.valid) {
      this.authService.register(this.registerForm.value).subscribe({
        next: () => {
          this.errorMessage = '';
          this.registerForm.reset();
          this.isSignUpMode = false;
          this.menu.closed.emit();
        },
        error: (error) => {
          this.errorMessage = 'Registration failed. Please try again.';
        }
      });
    }
  }

  login(): void {
    if (this.loginForm.valid) {
      const { usernameOrEmail, password } = this.loginForm.value;
      this.authService.login(usernameOrEmail, password).subscribe({
        next: () => {
          this.errorMessage = '';
          this.loginForm.reset();
          this.menu.closed.emit();
        },
        error: (error) => {
          this.errorMessage = 'Invalid username or password';
        }
      });
    }
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/']);
    this.menu.closed.emit();
  }

}
