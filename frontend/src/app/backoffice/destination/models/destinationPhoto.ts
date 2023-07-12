export interface DestinationPhoto {
    id: number;
    url: string;
    description: string;
    createdDate: Date;
    lastUpdatedDate: Date;
}

export interface InsertDestinationPhoto {
    url: string;
    description: string;
}

export interface UpdateDestinationPhoto {
    id: number;
    url: string;
    description: string;
}