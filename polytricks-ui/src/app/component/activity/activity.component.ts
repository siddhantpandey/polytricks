import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { CardsService } from "src/app/services/cards.service";
import { Politician } from "src/app/models/politician";
import { Party } from "src/app/models/Party";

@Component({
  selector: "app-activity",
  templateUrl: "./activity.component.html",
  styleUrls: ["./activity.component.css"]
})
export class ActivityComponent implements OnInit {
  politician: Politician;
  allparties: Party[];

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
