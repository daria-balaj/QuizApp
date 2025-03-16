import { Component, OnInit } from '@angular/core';
import { NavComponent } from '../nav/nav.component';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-home',
  imports: [
    CommonModule,
    NavComponent,
    MatButtonModule,
    FormsModule,
    MatIconModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  
  categories = {
    history: false,
    science: false,
    geography: false,
    sports: false,
    movies: false,
    music: false
  };

  difficulty: string = 'easy';

  questionCount: number = 10;

  mode = 'single';

  constructor() { }

  ngOnInit(): void {
  }

  updateCategories(): void {
    console.log('Categories updated:', this.categories);
  }

  updateDifficulty(level: string): void {
    this.difficulty = level;
    console.log('Difficulty updated to:', level);
  }

  updateQuestionCount(): void {
    console.log('Question count updated to:', this.questionCount);
  }

  isCategorySelected(): boolean {
    return Object.values(this.categories).some(value => value === true);
  }

  startQuiz(): void {
    if (this.isCategorySelected()) {
      console.log('Starting quiz with:');
      console.log('- Categories:', this.categories);
      console.log('- Difficulty:', this.difficulty);
      console.log('- Question Count:', this.questionCount);
      
    }
  }

  updateGameMode(mode: string = 'single'): void {
    this.mode = this.mode = mode;
  }
}
