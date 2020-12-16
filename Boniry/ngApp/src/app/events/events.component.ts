import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { EventService } from '../event.service';
import { Event } from '../event.model';
declare var M: any;

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css'],
  providers: [EventService]
})
export class EventsComponent implements OnInit {

  events = []
  constructor(public _eventService: EventService) { }

  ngOnInit() {
    this.resetForm();
    this.refreshEventList();
  }

  resetForm(form?: NgForm) {
    if (form)
      form.reset();
    this._eventService.selectedEvent = {
      _id: "",
      name: "",
      occasion: "",
      date_and_venue: "",
      budjet: null
    }
  }

  onSubmit(form: NgForm) {
    if (form.value._id == "") {
      this._eventService.postEvent(form.value).subscribe((res) => {
        this.resetForm(form);
        this.refreshEventList();
        M.toast({ html: 'Saved successfully', classes: 'rounded' });
      });
    }
    else {
      this._eventService.putEvent(form.value).subscribe((res) => {
        this.resetForm(form);
        this.refreshEventList();
        M.toast({ html: 'Updated successfully', classes: 'rounded' });
      });
    }
  }

  refreshEventList() {
    this._eventService.getEventList().subscribe((res) => {
      this._eventService.events = res as Event[];
    });
  }

  onEdit(emp: Event) {
    this._eventService.selectedEvent = emp;
  }

  onDelete(_id: string, form: NgForm) {
    if (confirm('Are you sure to delete this record ?') == true) {
      this._eventService.deleteEvent(_id).subscribe((res) => {
        this.refreshEventList();
        this.resetForm(form);
        M.toast({ html: 'Deleted successfully', classes: 'rounded' });
      });
    }
  }

}
