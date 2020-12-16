import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'

@Component({
  selector: 'app-atendee',
  templateUrl: './atendee.component.html',
  styleUrls: ['./atendee.component.css']
})
export class AtendeeComponent implements OnInit {
  events: string[] = [
    'Syonara',
    'Explorica',
    'Glimpse',
    'Mantra',
    'Samyak',
    'Surabhi',
  ]
  constructor(private _router: Router) { }

  ngOnInit(): void {
  }
  onSubmit() {
      confirm('Registration successful')
      this._router.navigate(['/special'])
}
}