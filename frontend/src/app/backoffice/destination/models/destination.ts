export interface Destination {
    id: number;
    name: string;
    description: string;
    hotelQuantity: number;
    createdDate: Date;
    lastUpdatedDate: Date;
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