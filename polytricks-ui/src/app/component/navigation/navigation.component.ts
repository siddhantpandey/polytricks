import { Component, OnInit, Input } from "@angular/core";
import { Politician } from "src/app/models/politician";
import { Party } from "src/app/models/Party";
import { CardsService } from "src/app/services/cards.service";
import { ActivatedRoute, Router } from "@angular/router";
import { TokenStorage } from "src/app/core/token.sotrage.service";

@Component({
  selector: "app-navigation",
  templateUrl: "./navigation.component.html",
  styleUrls: ["./navigation.component.css"]
})
export class NavigationComponent implements OnInit {
  @Input()
  sValue: String;

  field: String;
  srchVal: String;
  loginStatus: boolean;

  constructor(private route: ActivatedRoute,private router:Router, private tokenStorage: TokenStorage) {
    this.field="pState";
    
  }
  ngOnInit() {
    this.loginStatus=false;
    let token = sessionStorage.getItem('AuthToken');
    if (token) {
      this.loginStatus = true;
    }
    else{
      this.loginStatus = false;
    }

  }

  doSearch(srchVal) {
    
    this.router.navigateByUrl("/dashboard/" + this.field + "/" + srchVal);
  }

  doChangeField(field, ele) {
    this.field = field;
    this.srchVal = "";
    switch (field) {
      case "pName":
        ele.placeholder = "Politician Name";
        ele.type = "text";
        break;
      case "pParty":
        ele.placeholder = "Political Party";
        ele.type = "text";
        break;
      case "pState":
        ele.placeholder = "State";
        ele.type = "text";
        break;
    }
  }

  async delay(ms: number) {
    await new Promise(resolve => setTimeout(()=>resolve(), ms)).then(()=>console.log("fired"));
}

  logout(){
    this.tokenStorage.signOut();
    window.location.reload();
    this.delay(3000).then(any=>{
      this.router.navigate(['login']);
 });
    
  }
}
