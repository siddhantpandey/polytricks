import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Politician } from "../../models/politician";
import { FormControl } from "@angular/forms";
import { Observable } from "rxjs";
import { map, startWith } from "rxjs/operators";
import { CardsService } from "src/app/services/cards.service";

@Component({
  selector: "app-landing-page",
  templateUrl: "./landing-page.component.html",
  styleUrls: ["./landing-page.component.css"]
})
export class LandingPageComponent implements OnInit {
  state: string;
  politicians: Politician[];
  poliUrl: string;
  myControl = new FormControl();

  options: string[] = [
    "Andaman and Nicobar Islands",
    "Andhra Pradesh",
    "Arunachal Pradesh",
    "Assam",
    "Bihar",
    "Chandigarh",
    "Chhattisgarh",
    "Dadra and Nagar Haveli",
    "Daman and Diu",
    "Delhi",
    "Goa",
    "Gujarat",
    "Haryana",
    "Himachal Pradesh",
    "Jammu and Kashmir",
    "Jharkhand",
    "Karnataka",
    "Kerala",
    "Lakshadweep",
    "Madhya Pradesh",
    "Maharashtra",
    "Manipur",
    "Meghalaya",
    "Mizoram",
    "Nagaland",
    "Orissa",
    "Pondicherry",
    "Punjab",
    "Rajasthan",
    "Sikkim",
    "Tamil Nadu",
    "Telangana",
    "Tripura",
    "Uttaranchal",
    "Uttar Pradesh",
    "West Bengal"
  ];
  //state = new FormControl("");
  filteredOptions: Observable<string[]>;
  popularpoliticians: Politician[];

  constructor(private router: Router, private ser: CardsService) {}

  ngOnInit() {
    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(""),
      map(value => this._filter(value))
    );

    this.ser
      .getPopular()
      .subscribe(
        data => (this.popularpoliticians = data),
        err => (this.popularpoliticians = undefined)
      );

  console.log(this.popularpoliticians);
  }


  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.options.filter(option =>
      option.toLowerCase().includes(filterValue)
    );
  }

  /*search(st: HTMLInputElement) {
    this.state = st.value;
    console.log(this.state);
    this.router.navigateByUrl("dashboard/" + this.state);
  }*/

  MyFunc() {
    console.log(this.state);
    this.router.navigateByUrl("/dashboard/" + this.state);
  }

  onKeydown(event) {
    if (event.key === "Enter") {
      console.log(this.state);
      this.router.navigateByUrl("/dashboard/" + this.state);
    }
  }
}
