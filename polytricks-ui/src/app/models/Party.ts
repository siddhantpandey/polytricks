import { Politician } from "./politician";

export class Party {
  public partyName: string;
  public partyFormed: Date;
  public partyType: string;
  public partyStateActive: string;
  public partyMembers: Politician[];
  public pStatesRuled: string;
}
