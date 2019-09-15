import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-page-not-found',
  templateUrl: './page-not-found.component.html',
  styleUrls: ['./page-not-found.component.scss']
})
export class PageNotFoundComponent implements OnInit {
  image="https://cdn.dribbble.com/users/623441/screenshots/2611040/404.png"; //gandalf generated meme

  constructor() { }

  ngOnInit() {
  }

}
