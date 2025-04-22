import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Question } from '../models/question';
import { Category } from '../models/category';
import { Answer } from '../models/answer';
import { Difficulty } from '../enums/difficulty';
import { Observable } from 'rxjs';
import { Quiz } from '../models/quiz';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class QuizService {

  authUrl = environment.authApiUrl;
  dbUrl = environment.dbApiUrl;
  quizUrl = environment.quizApiUrl;
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
    return this.httpClient.get<Category[]>(`${this.dbUrl}/categories`);
  }

  startQuiz({categories: categoryIds, difficulty, questionCount}: { categories: number[], difficulty?: number, questionCount: number}) {
    let params = new HttpParams();

    categoryIds.forEach((id) => {
      params = params.append('categoryId', id);
    });

    if (difficulty !== undefined) {
      params = params.set('difficulty', difficulty);
    }

    console.log(questionCount)
    if (questionCount) {
      params = params.set('questionCount', questionCount);
    }

    return this.httpClient.post<Quiz>(`${this.quizUrl}/quiz/start`, null, { params });
  }

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

    return this.httpClient.get<Question[]>(`${this.quizUrl}/quiz`, { params });
  }

  getAnswersByQuestionId(id: number) {
    return this.httpClient.get<Answer[]>(`${this.dbUrl}/answers/question/${id}`);  
  }

  getCorrectAnswer(questionId: number) : Observable<number> {
    return this.httpClient.get<number>(`${this.quizUrl}/quiz/correct-answer/${questionId}`);
  }

  submitAnswer(matchId: string, questionId: number, answerId: number | null, isLastQuestion: boolean): Observable<number> {
    let params = new HttpParams()
    if (isLastQuestion) {
      params = params.set('isLastQuestion', 'true');
    }
    return this.httpClient.post<number>(
      `${this.quizUrl}/quiz/submit-answer/${matchId}/${questionId}`,
      answerId, 
      { params }
    );
  }

  getQuizResults(matchId: string) {
    return this.httpClient.get<{correctAnswers: number, score: number, time: any}>(`${this.quizUrl}/quiz/results/${matchId}`);
  }
}
