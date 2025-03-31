import {
  Component,
  effect,
  input,
  output,
} from '@angular/core';
import { Subscription, interval } from 'rxjs';
import { Question } from '../../models/question';
import { MatIconModule } from '@angular/material/icon';
import { CommonModule } from '@angular/common';
import { Answer } from '../../models/answer';

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

  constructor() {
    effect(() => {
      const currentQuestion = this.question();
      if (currentQuestion) {
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
    this.selectedAnswer = option;
    this.answerSelected.emit(option);
    this.nextQuestion(); //delete this line after testing
  }

  nextQuestion(): void {
    if (this.timerSubscription) {
      this.timerSubscription.unsubscribe();
    }
    this.next.emit();
  }

  timeUp(): void {
    // auto-select the first answer and moves to next question
    if (!this.selectedAnswer) {
      this.answerSelected.emit(this.answers()[0]);
    }
    this.next.emit();
  }

  formatTime(seconds: number): string {
    const mins = Math.floor(seconds / 60);
    const secs = seconds % 60;
    return `${mins}:${secs < 10 ? '0' : ''}${secs}`;
  }
}
