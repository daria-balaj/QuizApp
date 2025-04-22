import { Component, OnInit } from '@angular/core';
import { Question } from '../../models/question';
import { QuizService } from '../../services/quiz.service';
import { QuestionComponent } from '../question/question.component';
import { Router, ActivatedRoute, RouterLink, RouterModule } from '@angular/router';
import { Answer } from '../../models/answer';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-quiz',
  imports: [
    QuestionComponent,
    MatProgressSpinnerModule,
    MatIconModule,
    RouterModule
  ],
  templateUrl: './quiz.component.html',
  styleUrl: './quiz.component.css',
})
export class QuizComponent implements OnInit {
  matchId?: string | null;
  questions: Question[] = [];
  currentIndex = 0;
  answers: Answer[] = [];
  selectedAnswer: number | null = null;
  loading: boolean = true;

  constructor(
    private readonly quizService: QuizService,
    private readonly router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.matchId = this.route.snapshot.paramMap.get('matchId');
    this.questions = history.state.questions as Question[];
    console.log(this.questions);
    if (this.questions) {
      this.loading = false;
      this.getCurrentAnswers();
    }
    else {
      // fallback: fetch questions from backend using matchId

    }
  }

  getCurrentAnswers() {
    this.quizService
      .getAnswersByQuestionId(this.questions[this.currentIndex].id)
      .subscribe((answers) => {
        this.answers = answers;
      });
  }

  // onAnswerSelected(answerId: number): void {
  //   //write quiz service method to send selected option to server
  //   // this.quizService.submitAnswer(this.matchId!, this.questions[this.currentIndex].id, answerId).subscribe((correctAnswerId) => {

    
  // }

  nextQuestion(): void {
    if (this.currentIndex < this.questions.length - 1) {
      this.currentIndex++;
      this.getCurrentAnswers();
    } else this.router.navigate(['/results', this.matchId]);
  }
}
