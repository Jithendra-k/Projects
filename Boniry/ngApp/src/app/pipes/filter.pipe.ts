import { Pipe, PipeTransform } from '@angular/core';
import { EventsComponent } from '../events/events.component';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value:any,selectedString:string) {
    if(value.length === 0 || selectedString===""){
      return value;
    }
    const items =[];
    for(const item of value){
      if(item['name'] === selectedString){
        items.push(item);
      }
    }
    return items;
  }

}
