import { User } from './user';

export class Event {
    id : number;
    name : String;
    description : String;
    Image : string;
    amountOfPeopleNeeded : number;
    users : User[];
}
