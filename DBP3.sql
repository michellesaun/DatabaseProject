CREATE TABLE Club ( 
   clubID INT PRIMARY KEY,
   clubName NVARCHAR(50) NOT NULL,
   yearFounded INT CHECK (yearFounded >= 1819)
);

INSERT INTO Club(clubID, clubName, yearFounded) VALUES
(1, 'Art History', 1971),
(2, 'Archery', 1881),
(3, 'Animal Rights', 1965),
(4, 'Black Student Alliance', 1970),
(5, 'Bluegrass', 1996),
(6, 'Campus Outreach', 1968),
(7, 'Catholic Hoos', 1900),
(8,'Cavalier Daily', 1950),
(9,'Checkers Club', 1985),
(10, 'Chess', 1984),
(11, 'Club Bowling', 2001),
(12,'Club Cycling', 2002),
(13,'Club Baseball', 1945),
(14,'Club Field Hockey', 1975),
(15, 'Club Figure Skating', 1980),
(16, 'Club Swim', 1971),
(17,'Club Table Tennis', 1982),
(18,'Club Wrestling', 1978),
(19,'College Council', 1910),
(20, 'Collegiate 100', 1924),
(21,'Competittion Cheerleading', 1986),
(22, 'Croquet', 1999),
(23,'Darden Energy', 2000),
(24, 'Darden Dance', 2005),
(25, 'Darden Golf', 2002),
(26,'First Year Council', 1955),
(27,'Forge', 2008),
(28,'Girl Up', 1999),
(29,'Girls Who Code', 2002),
(30,'Global Medicine', 2001);

CREATE TABLE Members( 
    memberID INT PRIMARY KEY,
    computingID VARCHAR(10) UNIQUE NOT NULL , 
    memberName NVARCHAR(100) NOT NULL,
    classYear INT CHECK (classYear >= 2024 ) NOT NULL,
    joinDate DATE NOT NULL, 
    phoneNumber VARCHAR(15),
    memberAddress VARCHAR(255),
    position VARCHAR(50) DEFAULT ('none'),
);

BULK INSERT Members
FROM 'C:/members.csv'
WITH (
  FIELDTERMINATOR = ',',
  ROWTERMINATOR = '\n',
  FIRSTROW = 2
);

CREATE TABLE Candidate(
    candidateID INT PRIMARY KEY,
    memberID INT NOT NULL UNIQUE,
    position NVARCHAR(100),
    CONSTRAINT candidateFK FOREIGN KEY (memberID) REFERENCES Members(memberID)
);

BULK INSERT Candidate
FROM 'C:/candidate.csv'
WITH (
  FIELDTERMINATOR = ',',
  ROWTERMINATOR = '\n',
  FIRSTROW = 2
);

CREATE TABLE Advisor(
    advisorID INT PRIMARY KEY,
    advisorName NVARCHAR(100) NOT NULL,
    computingID VARCHAR(6) NOT NULL UNIQUE ,
    phoneNumber VARCHAR(15),
    email NVARCHAR(100) NOT NULL,
    advisorAddress VARCHAR(255),
);

INSERT INTO Advisor(advisorID,advisorName, computingID,phoneNumber,email, advisorAddress) VALUES
(100,'Tom Lee', 'tll4rt', '571-989-0098', 'tlee@virginia.edu', '123 Clark Street'),
(101, 'Lisa Ray','ltr5qz','321-453-9894','ltr5qz@virginia.edu', '221 Therry Drive'),
(102, 'Jack Hill','jjh9lk', '971-543-9087', 'jjh9lk@virginia.edu', '321 Egg Lane'),
(103, 'Jane Fox', 'jmf5ty','321-123-3212', 'jmf5ty@virginia.edu', '789 Pine Road'),
(104, 'Mark Cole','mcc4cc', '301-401-5011', 'mcc4cc@virginia.edu', '654 Cedar Lane' ),
(105,'Amy Tate','att8qw','215-654-0000','att8qw@virginia.edu','891 Havana Drive'),
(106,'Paul Gray','pgg1po','407-678-1230','pgg1po@virginia.edu','987 Elm Street'),
(107,'Emma Lane','ell1ll','503-567-8901','ell1ll@virginia.edu','231 Birch Road'),
(108,'Sam Ward','swa3po','646-765-4321','swa3po@virginia.edu','876 Willow Drive'),
(109,'Sara King','skk2nn','201-876-2345','skk2nn@virginia.edu','345 Spruce Avenue'),
(110,'Matt Bell','mab4bb','312-908-5678','mab4bb@virginia.edu','567 Oakwoord Boulevard'),
(111,'Lucy Hale','lha0pl','408-456-7890','lha0pl@virginia.edu','432 Chestnut Street'),
(112,'Dave Ross','dro1we','702-321-6543','dro1we@virginia.edu','675 Hilltop Lane'),
(113,'Anna Kim','alk1lp','303-789-1230','alk1lp@virginia.edu','908 Pinecrest Drive'),
(114,'Eric Wood','erw1pl','414-543-6789','erw1pl@virginia.edu','654 Riverside Avenue'),
(115,'Kate Shaw','kas4as','502-678-3451','kas4as@virginia.edu','999 Meadow Lane'),
(116,'Ben Reed','bre0pl','612-234-5678','bre0pl@virginia.edu','875 Lakeview Road'),
(117,'Mia Nash','mnn8sl','818-567-4321','mnn8sl@virginia.edu','780 Sunset Boulevard'),
(118,'Max Dole','mad4zd','904-678-1234','mad4zd@virginia.edu','321 Ocean Drive'),
(119,'Lily West','lwe4rt','202-987-6543','lwe4rt@virginia.edu','345 Ceadarcrest Road'),
(120,'Jake Hart','jkh9zd','808-543-9876','jkh9zd@virginia.edu','908 Crescent Street'),
(121,'Eva Long','evl2nb','901-876-5432','evl2nb@virginia.edu','432 Magnolia Lane'),
(122,'Ryan Page','rpa6ds','617-234-8901','rpa6ds@virginia.edu','231 Hillheart Road'),
(123,'Zoe Dean','zde3as','210-543-6789','zde3as@virginia.edu','145 Brookside Lane'),
(124,'Kyle Ford','kaf5sq','404-678-3456','kaf5sq@virginia.edu','543 Riverbend Street'),
(125,'Nora Finn','nnf8pk','303-987-1234','nnf8pk@virginia.edu','899 Forest Drive'),
(126,'Adam Blaine','adb1rt','718-876-4321','adb1rt@virginia.edu','081 Summit Avenue'),
(127,'Ava Moss','amm1sd','503-543-6789','amm1sd@virginia.edu','019 Rosewater Street'),
(128,'Jack Carr','jkc8hg','616-234-9870','jkc8hg@virginia.edu','100 Main Street'),
(129,'Lucy Light','lgl1ox',' 210-567-4321','lgl1ox@virginia.edu','023 Virginia Avenue'),
(130,'Wendy Mass','wam2sd','415-987-1234','wam2sd@virginia.edu','921 Tindal Lane');

CREATE TABLE Election(
    electionID INT PRIMARY KEY,
    votingOpen DATE NOT NULL,
    votingClose DATE NOT NULL,
    position VARCHAR(50) NOT NULL,
    winner NVARCHAR(100) NOT NULL,
);

BULK INSERT Election
FROM 'C:/election.csv'
WITH (
  FIELDTERMINATOR = ',',
  ROWTERMINATOR = '\n',
  FIRSTROW = 2
);

CREATE TABLE Results( 
    resultsID INT PRIMARY KEY,
    winningID INT,
    electionID INT, 
    totalVotes INT,
    --CONSTRAINT electionFK FOREIGN KEY(electionID) REFERENCES Election(electionID), 
);

BULK INSERT Results
FROM 'C:/results.csv'
WITH (
  FIELDTERMINATOR = ',',
  ROWTERMINATOR = '\n',
  FIRSTROW = 2
);

SELECT * FROM Results

CREATE TABLE Vote( 
    electionID INT NOT NULL,
    candidateID INT NOT NULL,
    memberID INT NOT NULL,
    PRIMARY KEY (electionID, candidateID, memberID),
    CONSTRAINT voteFK FOREIGN KEY (electionID) REFERENCES Election(electionID),
);
BULK INSERT Vote
FROM 'C:/vote.csv'
WITH (
  FIELDTERMINATOR = ',',
  ROWTERMINATOR = '\n',
  FIRSTROW = 2
);

CREATE TABLE Sponsor(
    sponsorID INT PRIMARY KEY,
    sponsorName NVARCHAR(100) NOT NULL,
);

INSERT INTO Sponsor(sponsorID, sponsorName) VALUES
(200,'Google' ),
(201, 'Amazon'),
(202, 'Microsoft'),
(203, 'USAA'),
(204, 'Coca-Cola'),
(205, 'Pepsi'),
(206, 'UNICEF'),
(207,'Nike'),
(208,'Thomas Jefferson'),
(209, 'Bill Gates'),
(210, 'Jack Dorsey'),
(211, 'Reebok'),
(212, 'Adam West'),
(213,'Jim Ryan'),
(214, 'Joseph Alpine'),
(215, 'Barack Obama'),
(216, 'William Taft'),
(217, 'EXPO'),
(218, 'Adidas'),
(219, 'Grace Hopper'),
(220, 'Wells Fargo'),
(221, 'State Farm'),
(222, 'Fannie Mae'),
(223, 'Delta'),
(224,'Business Leaders'),
(225, 'Women in Business'),
(226, 'Kellogg'),
(227, 'Gatorade'),
(228, 'Marriott'),
(229, 'US Bank'),
(230, 'Bank of America');

CREATE TABLE Donation(
    donationID INT PRIMARY KEY,
    sponsorID INT NOT NULL,
    amount INT NOT NULL CHECK (amount >= 0),
    donationDATE DATE,
    CONSTRAINT donationFK FOREIGN KEY(sponsorID) REFERENCES Sponsor(sponsorID),
);

INSERT INTO Donation(donationID, amount, sponsorID, donationDATE)VALUES
(400, 12000,200, '2024-10-15'),
(401, 10000,201, '2024-01-16'),
(402, 5000,202, '2024-10-14'),
(403, 2000,203, '2024-10-01'),
(404, 2000,204, '2023-12-15'),
(405, 3000,205, '2023-11-15'),
(406, 500,206, '2024-03-15'),
(407, 10000,207, '2023-10-21'),
(408, 10000,208, '2024-05-15'),
(409, 10000,209, '2024-06-06'),
(410, 10000,210, '2024-04-04'),
(411, 10000,211, '2024-03-22'),
(412, 10000,212, '2024-04-18'),
(413, 10000,213, '2024-07-15'),
(414, 10000,214, '2023-11-23'),
(415, 10000,215, '2023-12-25'),
(416, 10000,216, '2023-12-14'),
(417, 10000,217, '2024-10-15'),
(418, 10000,218, '2024-04-15'),
(419, 10000,219, '2024-02-02'),
(420, 10000,220, '2024-08-18'),
(421, 10000,221, '2024-03-10'),
(422, 10000,222, '2024-07-23'),
(423, 10000,223, '2023-11-11'),
(424, 10000,224, '2023-10-04'),
(425, 10000,225, '2024-01-19'),
(426, 10000,226, '2024-06-03'),
(427, 10000,227, '2024-09-10'),
(428, 10000,228, '2024-04-11'),
(429, 10000,229, '2024-05-21'),
(430, 10000,230, '2024-06-25');

CREATE TABLE Event(
    eventID INT PRIMARY KEY,
    eventName NVARCHAR(100) NOT NULL,
    eventDate DATE NOT NULL,
);

INSERT INTO Event(eventID,eventName,eventDate)VALUES
(500, 'Modern Art Talk', '2023-11-05'),
(501, 'Archery Challenge', '2024-01-15'),
(502, 'Animal Rights Rally', '2024-03-12'),
(503, 'Excellence Gala', '2024-04-22'),
(504, 'Bluegrass Jam', '2024-07-10'),
(505, 'Volunteer Day', '2024-02-27'),
(506, 'Faith & Service Retreat', '2024-06-05'),
(507, 'Journalism Workshop', '2023-12-01'),
(508, 'Checkers Tournament', '2024-09-15'),
(509, 'Chess Invitational', '2024-05-23'),
(510, 'Bowling for Soup', '2024-08-07'),
(511, 'Charity Bike Ride', '2024-01-20'),
(512, 'Baseball Alumni Game', '2024-03-30'),
(513, 'Field Hockey Scrimmage', '2023-11-18'),
(514, 'Figure Skating Showcase', '2024-04-10'),
(515, 'Swim Relay Challenge', '2024-05-15'),
(516, 'Table Tennis Tournament', '2024-07-25'),
(517, 'Wrestling Invitational', '2024-03-09'),
(518, 'Leadership Summit', '2024-02-12'),
(519, 'Networking Night', '2024-06-20'),
(520, 'Cheer Stunt Clinic', '2024-04-05'),
(521, 'Croquet Tournament', '2024-08-02'),
(522, 'Energy Forum', '2023-12-12'),
(523, 'Dance Performance', '2024-01-28'),
(524, 'Golf Scramble', '2024-06-14'),
(525, 'Welcome BBQ', '2024-09-05'),
(526, 'Innovation Expo', '2024-05-07'),
(527, 'Empowerment Day', '2024-03-18'),
(528, 'GWC Hackathon', '2023-11-22'),
(529, 'Medicine Symposium', '2024-07-30'),
(530, 'Art Movie Night', '2024-02-17');

CREATE TABLE StudentCouncil(
    email NVARCHAR(255) PRIMARY KEY,
    website NVARCHAR(255), 
    phone VARCHAR(15),
);

BULK INSERT StudentCouncil
FROM 'C:/studentcouncil.csv'
WITH (
  FIELDTERMINATOR = ',',
  ROWTERMINATOR = '\n',
  FIRSTROW = 2
);

SELECT SUM(totalVotes) --Get Total Votes for Candidate
FROM Results;

SELECT COUNT(memberID) --Get Number of Members in the Club
FROM Members;

SELECT COUNT(electionID) FROM Vote --Get Number of Voters who Voted for Candidate
   WHERE candidateID = '401';

SELECT SUM(amount) -- Get Total Amount Sponsor has Donated, Given Name of Sponsor
   FROM Donation AS D
   JOIN Sponsor AS S ON D.sponsorID = S.sponsorID
   WHERE S.sponsorName = 'Jim Ryan';

SELECT M.memberName from Members as M --Get the Names of All Election Winners
 JOIN Candidate as C on C.memberID = M.memberID
 WHERE C.candidateID IN(
   SELECT C.candidateID from Candidate as C
   JOIN Results AS R ON R.winningID = C.candidateID
   WHERE R.winningID = C.candidateID);


SELECT M.memberName FROM Members AS M --Get Name of Candidate Running for President
JOIN Candidate AS C ON M.memberID = C.memberID
WHERE C.position = 'President';


SELECT R.totalVotes FROM Results AS R --Get Total Votes for Presidential Race
JOIN Election AS E ON R.electionID = E.ElectionID
WHERE E.position = 'President';

SELECT M.memberName FROM Members AS M --Get the Names of the Members who Voted for Certain Candidate
WHERE EXISTS (
   SELECT V.MemberID FROM Vote AS V
   JOIN Members AS M2 ON V.memberID = M2.memberID
   WHERE V.CandidateID = 400 AND V.memberID = M.memberID
);

SELECT M.memberName FROM Members AS M -- Get the Names of the Members who have Voted
WHERE M.memberID IN (
   SELECT memberID FROM Vote
);

SELECT M.memberAddress FROM Members AS M --Get Address of All Members Running for a Position
WHERE M.memberID IN (
   SELECT memberID FROM Candidate
);
