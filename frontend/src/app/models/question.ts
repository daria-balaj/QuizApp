import { Category } from "./category";

export interface Question {
    id: number;
    text: string;
    category: Category;
    difficulty: number;
}