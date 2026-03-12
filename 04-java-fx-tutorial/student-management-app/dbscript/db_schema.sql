-- 1. Create the database
CREATE DATABASE javafx_demo;
GO

-- 2. Switch to the new database
USE javafx_demo;
GO

-- 3. Create the registration table
CREATE TABLE registration (
      id INT PRIMARY KEY IDENTITY(1,1),
      name NVARCHAR(100) NOT NULL,
      phone VARCHAR(20),
      course NVARCHAR(100)
);
GO

USE javafx_demo;
GO

INSERT INTO registration (name, phone, course)
VALUES
('Alice Johnson', '555-0101', 'Java Programming'),
('Bob Smith', '555-0102', 'Database Management'),
('Charlie Davis', '555-0103', 'Web Development'),
('Diana Prince', '555-0104', 'UI/UX Design'),
('Ethan Hunt', '555-0105', 'Cybersecurity'),
('Fiona Gallagher', '555-0106', 'Java Programming'),
('George Miller', '555-0107', 'Data Science'),
('Hannah Abbott', '555-0108', 'Machine Learning'),
('Ian Wright', '555-0109', 'Web Development'),
('Jenny Kim', '555-0110', 'Cloud Computing'),
('Kevin Hart', '555-0111', 'Java Programming'),
('Laura Palmer', '555-0112', 'Mobile App Dev'),
('Michael Scott', '555-0113', 'Business Analysis'),
('Nina Simone', '555-0114', 'UI/UX Design'),
('Oscar Isaac', '555-0115', 'Database Management'),
('Peter Parker', '555-0116', 'Software Engineering'),
('Quinn Fabray', '555-0117', 'Java Programming'),
('Riley Reid', '555-0118', 'Network Admin'),
('Steve Rogers', '555-0119', 'Project Management'),
('Tony Stark', '555-0120', 'Artificial Intelligence');
GO
-- Verify the data
SELECT * FROM registration;