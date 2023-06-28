CREATE TABLE [User] (
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[loginName] VARCHAR(100) NOT NULL,
	[password] VARCHAR(MAX) NOT NULL,
	[active] BIT NOT NULL,
	[name] VARCHAR(100),
	[lastName] VARCHAR(100),
	[email] VARCHAR(100),
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME
);

CREATE TABLE [RegistrationMethod] (
	[id] TINYINT PRIMARY KEY IDENTITY(1,1),
	[name] VARCHAR(100) NOT NULL,
	[createdDate] DATETIME NOT NULL
);

CREATE TABLE [Customer] (
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[customerSourceId] VARCHAR(500) NOT NULL,
	[name] VARCHAR(100),
	[lastName] VARCHAR(100),
	[dni] VARCHAR(50),
	[email] VARCHAR(100),
	[birthdate] DATE,
	[phoneNumber] VARCHAR(100),
	[registrationCompleted] BIT NOT NULL DEFAULT(0),
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME,
	[registrationMethodId] TINYINT NOT NULL REFERENCES [RegistrationMethod]([id])
);

CREATE TABLE [RatingScale] (
	[id] TINYINT PRIMARY KEY IDENTITY(0,1),
	[name] VARCHAR(350) NOT NULL,
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME
);

CREATE TABLE [Transport] (
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[name] VARCHAR(350) NOT NULL,
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME
);

CREATE TABLE [BookingType] (
	[id] TINYINT PRIMARY KEY IDENTITY(1,1),
	[name] VARCHAR(350) NOT NULL,
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME
);

CREATE TABLE [Origin] (
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[name] VARCHAR(350) NOT NULL,
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME
);

CREATE TABLE [Destination] (
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[name] VARCHAR(350) NOT NULL,
	[description] VARCHAR(500),
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME
);

CREATE TABLE [Hotel] (
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[name] VARCHAR(350) NOT NULL,
	[description] VARCHAR(500),
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME,
	[destinationId] INT NOT NULL REFERENCES [Destination]([id])
);

CREATE TABLE [HotelPhoto] (
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[url] VARCHAR(MAX) NOT NULL,
	[description] VARCHAR(500),
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME,
	[hotelId] INT NOT NULL REFERENCES [Hotel]([id])
);

CREATE TABLE [DestinationPhoto] (
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[url] VARCHAR(MAX) NOT NULL,
	[description] VARCHAR(500),
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME,
	[destinationId] INT NOT NULL REFERENCES [Destination]([id])
);

CREATE TABLE [Excursion] (
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[name] VARCHAR(350) NOT NULL,
	[description] VARCHAR(500),
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME,
	[destinationId] INT NOT NULL REFERENCES [Destination]([id])
);

CREATE TABLE [Product] (
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[name] VARCHAR(350) NOT NULL,
	[departureDate] DATE NOT NULL,
	[returnDate] DATE NOT NULL,
	[price] FLOAT NOT NULL CHECK(Price >= 0),
	[stock] INT NOT NULL CHECK(Stock >= 0),
	[documentationDes] VARCHAR(350),
	[active] BIT NOT NULL DEFAULT(0),
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME,
	[bookingTypeId] TINYINT NOT NULL REFERENCES [BookingType]([id]),
	[originId] INT NOT NULL REFERENCES [Origin]([id]),
	[destinationId] INT NOT NULL REFERENCES [Destination]([id]),
	[hotelId] INT NOT NULL REFERENCES [Hotel]([id])
);

CREATE TABLE [ProductTransport] (
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[order] TINYINT NOT NULL CHECK([Order] >= 0),
	[information] VARCHAR(500),
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME,
	[productId] INT NOT NULL REFERENCES [Product]([id]),
	[transportId] INT NOT NULL REFERENCES [Transport]([id])
);

CREATE TABLE [ProductExcursion] (
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[createdDate] DATETIME NOT NULL,
	[productId] INT NOT NULL REFERENCES [Product]([id]),
	[excursionId] INT NOT NULL REFERENCES [Excursion]([id])
);

CREATE TABLE [Offer] (
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[offerPrice] FLOAT NOT NULL CHECK(OfferPrice >= 0),
	[startDate] DATETIME NOT NULL,
	[endtDate] DATETIME NOT NULL,
	[active] BIT NOT NULL,
	[bannerText] VARCHAR(100),
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME,
	[productId] INT NOT NULL REFERENCES [Product]([id])
);

CREATE TABLE [Favorite] (
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[createdDate] DATETIME NOT NULL,
	[productId] INT NOT NULL REFERENCES [Product]([id]),
	[customerId] INT NOT NULL REFERENCES [Customer]([id])
);

CREATE TABLE [OrderState] (
	[id] TINYINT PRIMARY KEY IDENTITY(1,1),
	[name] VARCHAR(350) NOT NULL,
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME
);

CREATE TABLE [Payment] (
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[sourceId] INT NOT NULL,
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME,
	[approvedDate] DATETIME NOT NULL,
	[paymentMethodId] VARCHAR(100) NOT NULL,
	[paymentTypeId] VARCHAR(100) NOT NULL,
	[status] VARCHAR(100) NOT NULL
);

CREATE TABLE [Order] (
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[quantity] INT NOT NULL CHECK(Quantity > 0),
	[unitPrice] FLOAT NOT NULL CHECK(UnitPrice >= 0),
	[totalPrice] FLOAT NOT NULL CHECK(TotalPrice >= 0),
	[discount] FLOAT,
	[createdDate] DATETIME NOT NULL,
	[lastUpdatedDate] DATETIME,
	[orderStateId] TINYINT NOT NULL REFERENCES [OrderState]([id]),
	[productId] INT NOT NULL REFERENCES [Product]([id]),
	[customerId] INT NOT NULL REFERENCES [Customer]([id]),
	[ratingScaleId] TINYINT NOT NULL REFERENCES [ratingScale]([id]) DEFAULT(0),
	[paymentId] INT NOT NULL REFERENCES [Payment]([id])
);

