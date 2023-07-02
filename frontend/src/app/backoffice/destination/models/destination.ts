import { Hotel } from "../../hotel/models/hotel";

export interface Destination {
    id: number;
    name: string;
    description: string;
    createdDate: Date;
    lastUpdatedDate: Date;
    hotels: Hotel[];
}

export interface InsertDestination {
    name: string;
    description: string;
}

export interface UpdateDestination {
    id: number;
    name: string;
    description: string;
}