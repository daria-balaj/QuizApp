import { Component, OnInit } from '@angular/core';
import { NavComponent } from '../nav/nav.component';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { QuizService } from '../../services/quiz.service';
import { Router } from '@angular/router';
import { Category } from '../../models/category';
import { Difficulty } from '../../enums/difficulty';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    NavComponent,
    MatButtonModule,
    FormsModule,
    MatIconModule,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent implements OnInit {
  categories: Category[] = [];

  selectedCategories: number[] = [];

  difficulty: Difficulty = Difficulty.EASY;

  Difficulty = Difficulty;

  questionCount: number = 10;

  mode = 'single';

  constructor(
    private readonly quizService: QuizService,
    private readonly router: Router
  ) {}

  ngOnInit(): void {
    this.quizService.getCategories().subscribe((categories) => {
      this.categories = categories;
    });
  }

  toggleCategorySelection(category: Category): void {
    const index = this.selectedCategories.findIndex(id => id === category.id);
    if (index === -1) {
      this.selectedCategories.push(category.id);
    } else {
      this.selectedCategories.splice(index, 1);
    }
  }

  updateDifficulty(level: Difficulty): void {
    this.difficulty = level;
  }

  updateQuestionCount(): void {
    console.log('Question count updated to:', this.questionCount);
  }

  isCategorySelected(): boolean {
    return this.selectedCategories.length > 0;
  }

  updateGameMode(mode: string = 'single'): void {
    this.mode = mode;
  }

  startQuiz(): void {
    if (this.isCategorySelected()) {
      this.quizService.setQuizSettings(
        this.mode,
        this.selectedCategories,
        this.difficulty,
        this.questionCount
      );
      this.router.navigate(['/quiz']);
    }
  }

  isCategoryChecked(category: Category): boolean {
    return this.selectedCategories.some(id => id === category.id);
  }
}
