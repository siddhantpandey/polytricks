import { Comments } from "src/app/models/comment";

export class User {

    id: number;
    username: string;
    password:string;
    uName: string;
    uEmailId:string;
    uComments: Comments[];
  }
  