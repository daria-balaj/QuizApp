import { Component, effect, input, output } from '@angular/core';
import { Subscription, interval } from 'rxjs';
import { Question } from '../../models/question';
import { MatIconModule } from '@angular/material/icon';
import { CommonModule } from '@angular/common';
import { Answer } from '../../models/answer';
import { QuizService } from '../../services/quiz.service';

@Component({
  selector: 'app-question',
  imports: [CommonModule, MatIconModule],
  templateUrl: './question.component.html',
  styleUrl: './question.component.css',
})
export class QuestionComponent {
  question = input.required<Question>();
  answers = input.required<Answer[]>();

  index = input.required<number>();
  totalQuestions = input.required<number>();
  timePerQuestion = 30;

  selectedAnswer: Answer | null = null;
  timeRemaining: number = this.timePerQuestion;
  timerSubscription: Subscription = new Subscription();

  answerSelected = output<Answer>();
  next = output<void>();
  finish = output<void>();

  correctAnswerId: number | null = null;

  constructor(private quizService: QuizService) {
    effect(() => {
      const currentQuestion = this.question();
      if (currentQuestion) {
        this.selectedAnswer = null;
        this.startTimer();
      }
    });
  }

  ngOnDestroy(): void {
    if (this.timerSubscription) {
      this.timerSubscription.unsubscribe();
    }
  }

  startTimer(): void {
    this.timeRemaining = this.timePerQuestion;

    this.timerSubscription = interval(1000).subscribe(() => {
      this.timeRemaining--;

      if (this.timeRemaining <= 0) {
        this.timerSubscription.unsubscribe();
        this.timeUp();
      }
    });
  }

  selectOption(option: Answer): void {
    if (this.selectedAnswer) {
      return; 
    }
    this.selectedAnswer = option;

    this.answerSelected.emit(option);

    this.quizService.checkAnswer(this.question().id, this.selectedAnswer.id).subscribe((correctAnswerId) => {
      this.correctAnswerId = correctAnswerId;
      setTimeout(() => {
        this.nextQuestion();
      }, 2000); 
    });
  }

  nextQuestion(): void {
    if (this.timerSubscription) {
      this.timerSubscription.unsubscribe();
    }
    this.next.emit();
  }

  timeUp(): void {
    this.quizService.getCorrectAnswer(this.question().id).subscribe((correctAnswerId) => {
      this.correctAnswerId = correctAnswerId;
      setTimeout(() => {
        this.next.emit();
      }, 2000);
    });
  }

  formatTime(seconds: number): string {
    const mins = Math.floor(seconds / 60);
    const secs = seconds % 60;
    return `${mins}:${secs < 10 ? '0' : ''}${secs}`;
  }

  getCorrectAnswerId() {
    this.quizService.getCorrectAnswer(this.question().id).subscribe((correctAnswerId) => {
      this.correctAnswerId = correctAnswerId;
    });
  }

  getAnswerClass(answer: Answer): string {
    if (this.selectedAnswer || (!this.selectedAnswer && this.timeRemaining <= 0)) {
      if (!this.correctAnswerId)  {
        this.getCorrectAnswerId();
      }
      if (this.selectedAnswer?.id === answer.id && this.selectedAnswer.id !== this.correctAnswerId) {
        return 'wrong';
      } 
      else if (this.correctAnswerId === answer.id) {
        return 'correct';
      }
    }
    return '';
  }
}
