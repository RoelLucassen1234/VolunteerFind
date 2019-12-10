import { User } from './user';
import { Company } from './company';

export class Event {
    id : number;
    name : String;
    description : String;
    image : string;
    company : Company;
    numberOfPeople : number;
    users : User[];
}
