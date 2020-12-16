import { Component, OnInit } from '@angular/core';
import { EventService } from '../event.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router'

@Component({
  selector: 'app-special-events',
  templateUrl: './special-events.component.html',
  styleUrls: ['./special-events.component.css']
})
export class SpecialEventsComponent implements OnInit {
  selectedString : string ='';
  items=[
    {id:'1',name:"Syonara",date:"10-12-2020"},
    {id:'2',name:"Explorica",date:"02-01-2021"},
    {id:'3',name:"Mantra",date:"08-01-2021"},
    {id:'4',name:"Glimpse",date:"09-02-2021"},
    {id:'5',name:"Samyak",date:"06-03-2021"},
    {id:'6',name:"Surabhi",date:"10-04-2021"},
  ];
  
  specialEvents = []

  constructor(private _eventService: EventService,
              private _router: Router) { }


  ngOnInit() {
    this._eventService.getSpecialEvents()
      .subscribe(
        res => this.specialEvents = res,
        err => {
          if( err instanceof HttpErrorResponse ) {
            if (err.status === 401) {
              this._router.navigate(['/login'])
            }
          }
        }
      )
  }
  registerEvent() {
      {
        this._router.navigate(['/atendee'])
      }     
  }

}
