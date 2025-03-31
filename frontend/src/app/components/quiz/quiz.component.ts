import { Component, OnInit } from '@angular/core';
import { Question } from '../../models/question';
import { QuizService } from '../../services/quiz.service';
import { QuestionComponent } from '../question/question.component';
import { Router } from '@angular/router';
import { Answer } from '../../models/answer';

@Component({
  selector: 'app-quiz',
  imports: [QuestionComponent],
  templateUrl: './quiz.component.html',
  styleUrl: './quiz.component.css',
})
export class QuizComponent implements OnInit {
  questions: Question[] = [];
  currentIndex = 0;
  answers: Answer[] = [];

  constructor(
    private readonly quizService: QuizService,
    private readonly router: Router
  ) {}

  ngOnInit(): void {
    const selectedCategories = this.quizService.getQuizSettings().categories;
    const selectedDifficulty = this.quizService.getQuizSettings().difficulty;

    this.quizService.getQuestions().subscribe((allQuestions) => {
      this.questions = allQuestions.filter((q) =>
        selectedCategories.find((c) => c.id === q.category.id) && q.difficulty.id === selectedDifficulty
      );

      if (this.questions.length > 0) {
        this.getCurrentAnswers();
      } else {
        this.router.navigate(['/']);
      }
    });
  }

  getCurrentAnswers() {
    this.quizService
      .getAnswersByQuestionId(this.questions[this.currentIndex].id)
      .subscribe((answers) => {
        this.answers = answers;
      });
  }

  onAnswerSelected(answer: any): void {
    //write quiz service method to send selected option to server
  }

  nextQuestion(): void {
    if (this.currentIndex < this.questions.length - 1) {
      this.currentIndex++;
      this.getCurrentAnswers();
    } else this.router.navigate(['/results']);
  }
}
