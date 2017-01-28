import { Component, OnInit } from '@angular/core';
import { HelloService } from './services/hello.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [HelloService]
})
export class AppComponent implements OnInit {

  helloService: HelloService;
  greeting = 'app works!';

  constructor(helloService: HelloService) {
    this.helloService = helloService;
  }

  ngOnInit() {
    this.helloService.getGreeting()
      .subscribe(greeting => this.greeting = greeting);
  }




}
