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
  matchId = input.required<string>();
  question = input.required<Question>();
  answers = input.required<Answer[]>();

  index = input.required<number>();
  totalQuestions = input.required<number>();
  timePerQuestion = 30;

  selectedAnswerId: number | null = null;
  timeRemaining: number = this.timePerQuestion;
  timerSubscription: Subscription = new Subscription();

  next = output<void>();
  finish = output<void>();

  correctAnswerId: number | null = null;

  constructor(private quizService: QuizService) {
    effect(() => {
      const currentQuestion = this.question();
      if (currentQuestion) {
        this.selectedAnswerId = null;
        this.correctAnswerId = null;
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

  nextQuestion(): void {
    if (this.timerSubscription) {
      this.timerSubscription.unsubscribe();
    }
    this.next.emit();
  }

  timeUp(): void {
    this.submitAnswer(null);
  }

  formatTime(seconds: number): string {
    const mins = Math.floor(seconds / 60);
    const secs = seconds % 60;
    return `${mins}:${secs < 10 ? '0' : ''}${secs}`;
  }

  submitAnswer(answerId: number | null): void {
    if (this.selectedAnswerId == null) {
      if (answerId) {
        this.selectedAnswerId = answerId;
      }
      console.log(this.index(), this.totalQuestions());
      this.quizService.submitAnswer(this.matchId(), this.question().id, answerId, this.index() + 1 == this.totalQuestions()).subscribe((correctAnswerId) => {
        this.correctAnswerId = correctAnswerId;
        setTimeout(() => {
          this.nextQuestion();
        }, 2000);
      });
    }
  }

  getAnswerClass(answer: Answer): string {
    if (this.correctAnswerId === null) {
      return '';
    }
  
    if (this.selectedAnswerId === answer.id && this.selectedAnswerId !== this.correctAnswerId) {
      return 'wrong';
    }
  
    if (this.correctAnswerId === answer.id) {
      return 'correct';
    }

    return '';
  }
}