import { Component } from '@angular/core';
import { MultiplayerResultsComponent } from './multiplayer-results/multiplayer-results.component';
import { NavComponent } from '../nav/nav.component';
import { QuizService } from '../../services/quiz.service';
import { SingleplayerResultsComponent } from './singleplayer-results/singleplayer-results.component';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-results',
  imports: [
    CommonModule,
    SingleplayerResultsComponent,
    MultiplayerResultsComponent,
    NavComponent,
  ],
  templateUrl: './results.component.html',
  styleUrl: './results.component.css',
})
export class ResultsComponent {
  constructor(
    public quizService: QuizService,
    private readonly router: Router
  ) {}

  returnToHome() {
    this.router.navigate(['/']);
  }

  playAgain() {
    this.router.navigate(['/quiz']);
  }
}
