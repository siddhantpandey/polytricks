
import { Politician } from "./politician";
import { User } from "../components/user/user";

export class Comments {
  public cId: number;
  public politician: Politician;
  public user: User;
  public uComment: string;
  public uLike: boolean;
}