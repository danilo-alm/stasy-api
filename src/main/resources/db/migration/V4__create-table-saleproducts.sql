CREATE TABLE SaleProducts (
    SaleID INT,
    ProductID INT,
    Quantity INT NOT NULL,
    Price DECIMAL(7, 2) NOT NULL,
    PRIMARY KEY (SaleID, ProductID),
    FOREIGN KEY (SaleID) REFERENCES Sales(ID),
    FOREIGN KEY (ProductID) REFERENCES Products(ID)
);