-- Create database
CREATE DATABASE IF NOT EXISTS bilabonnementhamsa;
USE bilabonnementhamsa;

-- Create car table
CREATE TABLE IF NOT EXISTS car (
                                   carNumberID INT AUTO_INCREMENT PRIMARY KEY,
                                   model VARCHAR(255),
    brand VARCHAR(255),
    frameNumber INT
    );

-- Create purchaseagreement table
CREATE TABLE IF NOT EXISTS purchaseagreement (
                                                 purchaseAgreementID INT AUTO_INCREMENT PRIMARY KEY,
                                                 exceedKm INT,
                                                 customerID INT,
                                                 rentalContractID INT
);

-- Create purchaseagreement_damagetype table
CREATE TABLE IF NOT EXISTS purchaseagreement_damagetype (
                                                            purchaseAgreement_damageTypeID INT AUTO_INCREMENT PRIMARY KEY,
                                                            purchaseAgreementID INT,
                                                            damageTypeID INT
);

-- Create subscription table
CREATE TABLE IF NOT EXISTS subscription (
                                            subscriptionID INT AUTO_INCREMENT PRIMARY KEY,
                                            name VARCHAR(255),
    description VARCHAR(1024)
    );

-- Create location table
CREATE TABLE IF NOT EXISTS location (
                                        locationID INT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(255),
    city VARCHAR(255),
    zipCode INT,
    address VARCHAR(255)
    );

-- Create damagetype table
CREATE TABLE IF NOT EXISTS damagetype (
                                          damageTypeID INT AUTO_INCREMENT PRIMARY KEY,
                                          name VARCHAR(255),
    price DECIMAL(19,0)
    );

-- Create rentalcontract table
CREATE TABLE IF NOT EXISTS rentalcontract (
                                              rentalContractID INT AUTO_INCREMENT PRIMARY KEY,
                                              startDate DATE,
                                              endDate DATE,
                                              price INT,
                                              customerID INT,
                                              subscriptionID INT,
                                              carNumberID INT,
                                              pickupLocationID INT,
                                              deliveryLocationID INT,
                                              purchaseOptional TINYINT(1)
    );

-- Seed data only if tables are empty
-- Seed car table
IF (SELECT COUNT(*) FROM car) < 1 THEN
    INSERT INTO car (model, brand, frameNumber) VALUES
        ('Model S', 'Tesla', 12345),
        ('Civic', 'Honda', 67890),
        ('Corolla', 'Toyota', 11223);
END IF;

-- Seed purchaseagreement table
IF (SELECT COUNT(*) FROM purchaseagreement) < 1 THEN
    INSERT INTO purchaseagreement (exceedKm, customerID, rentalContractID) VALUES
        (100, 1, 1),
        (200, 2, 2),
        (150, 3, 3);
END IF;

-- Seed purchaseagreement_damagetype table
IF (SELECT COUNT(*) FROM purchaseagreement_damagetype) < 1 THEN
    INSERT INTO purchaseagreement_damagetype (purchaseAgreementID, damageTypeID) VALUES
        (1, 1),
        (2, 2),
        (3, 3);
END IF;

-- Seed subscription table
IF (SELECT COUNT(*) FROM subscription) < 1 THEN
    INSERT INTO subscription (name, description) VALUES
        ('Limited', 'Limited subscription with restricted mileage'),
        ('Unlimited', 'Unlimited subscription with no mileage limit');
END IF;

-- Seed location table
IF (SELECT COUNT(*) FROM location) < 1 THEN
    INSERT INTO location (name, city, zipCode, address) VALUES
        ('Main Office', 'Copenhagen', 1000, 'Main Street 1'),
        ('Branch Office', 'Aarhus', 8000, 'Branch Street 5');
END IF;

-- Seed damagetype table
IF (SELECT COUNT(*) FROM damagetype) < 1 THEN
    INSERT INTO damagetype (name, price) VALUES
        ('Scratch', 500),
        ('Dent', 1000),
        ('Broken Light', 750);
END IF;

-- Seed rentalcontract table
IF (SELECT COUNT(*) FROM rentalcontract) < 1 THEN
    INSERT INTO rentalcontract (startDate, endDate, price, customerID, subscriptionID, carNumberID, pickupLocationID, deliveryLocationID, purchaseOptional) VALUES
        ('2024-01-01', '2024-06-01', 3000, 1, 1, 1, 1, 2, 1),
        ('2024-02-01', '2024-07-01', 3500, 2, 2, 2, 2, 1, 0),
        ('2024-03-01', '2024-08-01', 4000, 3, 1, 3, 1, 2, 1);
END IF;
