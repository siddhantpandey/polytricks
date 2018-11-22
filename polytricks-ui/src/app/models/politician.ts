import { Comments } from "./comment";
import { Party } from "./party";
import { Activity } from "./activity";
import { Statistics } from "./statistics";

export class Politician {
  public pId: number;
  public pName: string;
  public pAge: number;
  public pGender: string;
  public pEducation: string;
  public pAssets: number;
  public pProfession: string;
  public pIncome: number;
  public pState: string;
  public pParlConstituency: string;
  public pStateConstituency: string;
  public pActiveSince: string;
  public pStatus: string;
  public pParty: Party;
  public comments: Comments[];
  public activiities: Activity[];
  public stats: Statistics;
}
