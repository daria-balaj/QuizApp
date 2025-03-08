import { Component } from '@angular/core';
import { NavComponent } from '../nav/nav.component';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-home',
  imports: [
    CommonModule,
    NavComponent,
    MatButtonModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  categories: string[] = [ 'General knowledge', 'Geography', 'English', 'History', 'Music', 'Cinema' ];

  onCategorySelection() {
    console.log('Category selected');
  }
}
