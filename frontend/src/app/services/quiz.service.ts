import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Question } from '../models/question';
import { Category } from '../models/category';
import { Answer } from '../models/answer';
import { Difficulties } from '../enums/difficulty';

@Injectable({
  providedIn: 'root',
})
export class QuizService {
  baseUrl = 'http://localhost:8080/api/';
  constructor(private readonly httpClient: HttpClient) {}

  quizSettings: {
    mode: string;
    categories: Category[];
    difficulty: Difficulties;
    questionCount: number;
  } = {
    mode: 'single',
    categories: [],
    difficulty: Difficulties.EASY,
    questionCount: 0,
  };

  getQuizSettings() {
    return this.quizSettings;
  }

  setQuizSettings(
    mode: string,
    categories: Category[],
    difficulty: Difficulties,
    count: number
  ) {
    this.quizSettings = {
      mode: mode,
      categories: categories,
      difficulty: difficulty,
      questionCount: count,
    };
  }

  getMode(): string {
    return this.quizSettings.mode;
  }

  getCategories() {
    return this.httpClient.get<Category[]>(this.baseUrl + 'categories');
  }

  getQuestions() {
    return this.httpClient.get<Question[]>(this.baseUrl + 'questions');
  }

  getAnswersByQuestionId(id: number) {
    return this.httpClient.get<Answer[]>(
      this.baseUrl + 'answers/question/' + id
    );
  }
}
