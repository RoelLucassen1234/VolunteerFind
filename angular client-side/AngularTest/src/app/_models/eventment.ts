import { User } from './user';
import { Company } from './company';

export class Eventment {
    id : number;
    name : String;
    description : String;
    image : string;
    company : Company;
    totalAmountOfPeople : number;
    users : User[];
}
