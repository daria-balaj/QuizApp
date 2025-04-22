import { Component } from '@angular/core';
import { MultiplayerResultsComponent } from './multiplayer-results/multiplayer-results.component';
import { NavComponent } from '../nav/nav.component';
import { QuizService } from '../../services/quiz.service';
import { SingleplayerResultsComponent } from './singleplayer-results/singleplayer-results.component';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { Quiz } from '../../models/quiz';

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
  matchId!: string;
  score: number = 0;
  correctAnswerCount: number = 0;
  
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    public quizService: QuizService
  ) {}

  ngOnInit(): void {
    this.matchId = this.route.snapshot.paramMap.get('matchId')!;
  }


  returnToHome() {
    this.router.navigate(['/']);
  }

  playAgain() {
    this.quizService.startQuiz(this.quizService.getQuizSettings()).subscribe(
      (quiz: Quiz) => {
        this.router.navigate(['/quiz', quiz.id], { state: { questions: quiz.questions } });
      },
      (error) => {
        console.error('Error starting quiz:', error);
      }
    );
  }
}