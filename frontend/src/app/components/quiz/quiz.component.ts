import { Component, OnInit } from '@angular/core';
import { Question } from '../../models/question';
import { QuizService } from '../../services/quiz.service';
import { QuestionComponent } from "../question/question.component";
import { Router } from '@angular/router';

@Component({
  selector: 'app-quiz',
  imports: [QuestionComponent],
  templateUrl: './quiz.component.html',
  styleUrl: './quiz.component.css'
})
export class QuizComponent implements OnInit {
  questions: Question[] = [];
  currentIndex = 0;
  answers: {[questionId: number]: string} = {};

  constructor(private quizService: QuizService, private router: Router) { }
  ngOnInit(): void {
    this.testQuiz();
    // this.quizService.getQuestions().subscribe(questions => {
    //   this.questions = questions;
    // });
  }

  testQuiz(){
    this.questions = [
      {
        text: "What is the capital city of France?",
        options: ["London", "Paris", "Berlin", "Madrid"],
        correct_answer: "Paris",
        category: "geography",
        difficulty: "easy"
      },
      {
        text: "Which scientist developed the theory of relativity?",
        options: ["Isaac Newton", "Albert Einstein", "Nikola Tesla", "Marie Curie"],
        correct_answer: "Albert Einstein",
        category: "science",
        difficulty: "medium"
      },
      {
        text: "In which year did World War II end?",
        options: ["1943", "1945", "1947", "1950"],
        correct_answer: "1945",
        category: "history",
        difficulty: "medium"
      },
      {
        text: "Which movie won the Academy Award for Best Picture in 2020?",
        options: ["1917", "Joker", "Parasite", "Once Upon a Time in Hollywood"],
        correct_answer: "Parasite",
        category: "movies",
        difficulty: "hard"
      },
      {
        text: "What is the chemical symbol for gold?",
        options: ["Go", "Au", "Ag", "Gd"],
        correct_answer: "Au",
        category: "science",
        difficulty: "easy",
      }
    ];
  }

  onAnswerSelected(answer: any): void {
    //write quiz service method to send selected option to server
  }

  nextQuestion(): void {
    if (this.currentIndex < this.questions.length - 1)
      this.currentIndex++;
    else this.router.navigate(['/results']);
  }
}
