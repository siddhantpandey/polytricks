import { Component, OnInit } from "@angular/core";
import { CardsService } from "src/app/services/cards.service";
import { Politician } from "src/app/models/politician";
import { ActivatedRoute, Router } from "@angular/router";
import { Party } from "src/app/models/Party";

@Component({
  selector: "app-dashboard",
  templateUrl: "./dashboard.component.html",
  styleUrls: ["./dashboard.component.css"]
})
export class DashboardComponent implements OnInit {
  allpoliticians: Politician[];
  allparties: Party[];
  srchValue : String;

  party;
  constructor(
    private ser: CardsService,
    private partyserv: CardsService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      let state = params["state"];

      this.ser
        .searchPoliticians(state)
        .subscribe(
          data => (this.allpoliticians = data),
          err => (this.allpoliticians = undefined)
        );
    });
    this.activatedRoute.params.subscribe(params => {
      let field = params["field"];
      let srchVal = params["srchVal"];
      console.log(srchVal);

      this.ser
        .navSearch(field, srchVal)
        .subscribe(
          data => (this.allpoliticians = data),
          err => (this.allpoliticians = undefined)
        );
    });
  }
  commentFunc(pId) {
    this.router.navigateByUrl("/comment/" + pId);
  }
}

