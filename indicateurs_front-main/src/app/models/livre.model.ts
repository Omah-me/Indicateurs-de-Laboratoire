import { Article } from './article.model';

export class Livre {
    constructor(
        public id: number,
        public annee: string,
        public titre: string,
        public articles: Article[]
    ) {}
}