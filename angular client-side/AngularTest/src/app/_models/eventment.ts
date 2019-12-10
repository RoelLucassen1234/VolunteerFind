import { User } from './user';
import { Company } from './company';

export class Eventment {
    id : number;
    name : String;
    description : String;
    image : string;
    company : Company;
    numberOfPeople : number;
    users : User[];
}
