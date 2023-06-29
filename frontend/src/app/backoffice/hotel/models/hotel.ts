export interface Hotel {
    id: number;
    name: string;
    description: string;
    createdDate: Date;
    lastUpdatedDate: Date;
    destinationId: number;
    hotelPhotos: any[];
}

export interface InsertHotel {
    name: string;
    description: string;
    destinationId: number;
}

export interface UpdateHotel {
    id: number;
    name: string;
    description: string;
    destinationId: number;
}