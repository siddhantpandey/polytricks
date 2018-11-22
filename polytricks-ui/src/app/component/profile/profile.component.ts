import { Component, OnInit } from "@angular/core";
import { Politician } from "../../models/politician";
import { ActivatedRoute } from "@angular/router";
import { Party } from "src/app/models/Party";
import { CardsService } from "src/app/services/cards.service";

@Component({
  selector: "app-profile",
  templateUrl: "./profile.component.html",
  styleUrls: ["./profile.component.css"]
})
export class ProfileComponent implements OnInit {
  politician: Politician;
  allparties: Party[];
  constituency: String;
  constructor(
    private activatedRoute: ActivatedRoute,
    private ser: CardsService,
    private partyserv: CardsService
  ) {}
  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      let pId = params["pId"];
      if (pId) {
        this.ser
          .searchPoliticiansById(pId)
          .subscribe(
            data => (this.politician = data),
            err => (this.politician = undefined)
          );
      }
    });

    this.partyserv
      .getAllParties()
      .subscribe(
        data => (this.allparties = data),
        err => (this.allparties = undefined)
      );
    console.log(this.allparties);
  }
}
