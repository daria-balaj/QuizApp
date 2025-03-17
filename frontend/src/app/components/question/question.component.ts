import { Component, EventEmitter, Input, OnDestroy, OnInit, Output } from '@angular/core';
import { Subscription, interval } from 'rxjs';
import { Question } from '../../models/question';
import { MatIconModule } from '@angular/material/icon';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-question',
  imports: [
    CommonModule,
    MatIconModule
  ],
  templateUrl: './question.component.html',
  styleUrl: './question.component.css'
})
export class QuestionComponent {
  @Input() question: Question | undefined;
  @Input() index!: number;
  @Input() totalQuestions!: number;
  answer: number | undefined;
  timePerQuestion = 30;
  options: string[] = [];

  selectedAnswer: string | null = null;
  timeRemaining: number = this.timePerQuestion;
  timerSubscription: Subscription = new Subscription();

  @Output() answerSelected = new EventEmitter<string>();
  @Output() next = new EventEmitter<void>();
  @Output() finish = new EventEmitter<void>();

  ngOnInit(): void {
    this.startTimer();
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

  selectOption(option: string): void {
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
    // auto-select an answer or just move to next question
    if (!this.selectedAnswer) {
      this.answerSelected.emit('');
    }
  }

  formatTime(seconds: number): string {
    const mins = Math.floor(seconds / 60);
    const secs = seconds % 60;
    return `${mins}:${secs < 10 ? '0' : ''}${secs}`;
  }

}
