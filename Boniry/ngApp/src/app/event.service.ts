import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Event } from './event.model';
@Injectable()
export class EventService {
  selectedEvent: Event;
  events: Event[]
  private _eventsUrl = "http://localhost:3000/api/events";
  private _specialEventsUrl = "http://localhost:3000/api/special";

  constructor(private http: HttpClient) { }

  getEvents() {
    return this.http.get<any>(this._eventsUrl)
  }
  
  postEvent(e: Event) {
    return this.http.post(this._eventsUrl, e);
  }

  getEventList() {
    return this.http.get(this._eventsUrl);
  }

  putEvent(e: Event) {
    return this.http.put(this._eventsUrl + `/${e._id}`, e);
  }

  deleteEvent(_id: string) {
    return this.http.delete(this._eventsUrl + `/${_id}`);
  }

  getSpecialEvents() {
    return this.http.get<any>(this._specialEventsUrl)
  }
}
