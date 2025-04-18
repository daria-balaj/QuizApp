import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Question } from '../models/question';
import { Category } from '../models/category';
import { Answer } from '../models/answer';
import { Difficulty } from '../enums/difficulty';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class QuizService {
  baseUrl = 'http://localhost:8080/api/';
  constructor(private readonly httpClient: HttpClient) {}

  quizSettings: {
    mode: string;
    categories: number[];
    difficulty: Difficulty;
    questionCount: number;
  } = {
    mode: 'single',
    categories: [],
    difficulty: Difficulty.EASY,
    questionCount: 0,
  };

  getQuizSettings() {
    return this.quizSettings;
  }

  setQuizSettings(
    mode: string,
    categories: number[],
    difficulty: Difficulty,
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

  // getQuestions(categoryIds: number[], difficulty?: number) {
  getQuestions({mode, categories: categoryIds, difficulty, questionCount}: {mode: string, categories: number[], difficulty?: number, questionCount: number}) {
    let params = new HttpParams();

    //TODO: uncomment when multiplayer is implemented
    // params = params.set('mode', mode);

    categoryIds.forEach((id) => {
      params = params.append('categoryId', id);
    });

    if (difficulty !== undefined) {
      params = params.set('difficulty', difficulty);
    }

    if (questionCount) {
      params = params.set('questionCount', questionCount);
    }

    // return this.httpClient.get<Question[]>(this.baseUrl + 'questions', {
    //   params,
    // });
    return this.httpClient.get<Question[]>("http://localhost:8081/api/quiz", { params });
  }

  getAnswersByQuestionId(id: number) {
    return this.httpClient.get<Answer[]>(
      this.baseUrl + 'answers/question/' + id
    );
  }

  getCorrectAnswer(questionId: number) : Observable<number> {
    return this.httpClient.get<number>("http://localhost:8081/api/quiz/correct-answer/" + questionId);
  }

  checkAnswer(questionId: number, answerId: number) : Observable<number> {
    return this.httpClient.get<number>(`http://localhost:8081/api/quiz/check-answer/${questionId}/${answerId}`);
  }
}
