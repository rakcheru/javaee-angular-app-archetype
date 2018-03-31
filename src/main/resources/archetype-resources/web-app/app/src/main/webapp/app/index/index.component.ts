import { Component } from '@angular/core';
//
@Component({
  selector: 'index',
  template: require('./index.component.html'),
  styles: [ require('./index.component.css').toString() ]
})
export class IndexComponent {

  title: string;

  constructor(){
    this.title = "index";
    console.log("instantiated");
  }
}
