import { Component, OnInit } from "@angular/core";

import { Comments } from "../../models/comment";
import { Politician } from "src/app/models/politician";
import { FeedbackService } from "../../services/feedback.service";
import { ActivatedRoute, Router } from "@angular/router";
import { Party } from "src/app/models/Party";
import { CardsService } from "src/app/services/cards.service";
import { User } from "src/app/components/user/user";
import { TokenStorage } from "src/app/core/token.sotrage.service";


@Component({
  selector: "app-statisticks",
  templateUrl: "./statisticks.component.html",
  styleUrls: ["./statisticks.component.css"]
})
export class StatisticksComponent implements OnInit {
  comments: Comments;
  politician: Politician;
  user: User;
  politiciandata: Politician;
  allparties: Party[];

  value: boolean = null;
  buttonDisabled: boolean;
  formDisabled: boolean;
  pId = null;
  stats: Number[];
  healthy: boolean;
  unhealthy: boolean;

  likes: any;
  dislikes: any;
  totalLikes: any;
  totalDislikes: any;
  popularity: any;
  dummyUser: User;
  constructor(
    private feedBackService: FeedbackService,
    private activatedRoute: ActivatedRoute,
    private ser: CardsService,
    private partyserv: CardsService,
    private router: Router,
    private tokenStorage: TokenStorage
  ) { }

  ngOnInit() {
    this.comments = new Comments();
    this.comments.user = new User();
    this.comments.politician = new Politician();
    this.buttonDisabled = false;
    this.formDisabled = false;

    this.activatedRoute.params.subscribe(params => {
      this.pId = params["pId"];

      if (this.pId) {
        this.ser.searchPoliticiansById(this.pId).subscribe(
          (data) => (this.politiciandata = data),

          (err) => alert("Data Not entered")
        );
      }
    });



    this.ser.getAllStats().subscribe(
      data => (this.stats = data),


      err => (this.stats = undefined)
    );

    this.partyserv
      .getAllParties()
      .subscribe(
        data => (this.allparties = data),
        err => (this.allparties = undefined)
      );

  }

  async delay(ms: number) {
    await new Promise(resolve => setTimeout(()=>resolve(), ms)).then(()=>console.log("fired"));
}

 

   

  save() {
    this.comments.politician.pId = this.pId;
    this.comments.uLike = this.value;
    this.buttonDisabled = true;
    this.formDisabled = true;
    
    this.comments.cId = 1;
    this.feedBackService.getUser(this.comments.user.uEmailId)
      .subscribe(
        (data) => {
        this.dummyUser = data;
          console.log("DUMMY: " + this.dummyUser);
          console.log(this.dummyUser.id);
          if (this.comments) {

            // console.log(this.dummyUser);
      
            this.comments.user = this.dummyUser;
            console.log(this.comments.user);
            this.feedBackService
              .addComment(this.comments)
              .subscribe(data => { }, error => { });
          }
        }

      );
    console.log("---->" + this.dummyUser.id);
   

    //this.function();
   
  }

  like() {
    this.value = true;
  }

  dislike() {
    this.value = false;
  }

  publish(){
    let token = sessionStorage.getItem('AuthToken');
    if (token) {
      this.save();
    }
    else{
      this.router.navigate(['login']);
    }
  }

  function() {

    window.location.reload();
  }
}
