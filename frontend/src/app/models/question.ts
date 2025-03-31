import { Category } from "./category";
import { Difficulty } from "./difficulty";

export interface Question {
    id: number;
    text: string;
    category: Category;
    difficulty: Difficulty;
}