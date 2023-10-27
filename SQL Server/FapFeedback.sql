--CREATE DATABASE FapFeedback
--DROP DATABASE FapFeedback

/****** Object:  Table [dbo].[Student]    Script Date: 05/07/2023 ******/
CREATE TABLE [dbo].[Student](
	[username] [varchar](150) NOT NULL,
	[password] [varchar](150) NOT NULL,
	[studentId] [varchar](150) NOT NULL PRIMARY KEY,
	[displayname] [varchar](150) NOT NULL,
	[campus] [varchar](150) NOT NULL,
)

INSERT [dbo].[Student] ([username], [password], [studentId], [displayname], [campus])
VALUES 
(N'phinxhe170131', N'123', N'HE170131', N'Nguyen Xuan Phi', N'FU-Hoa Lac'),
(N'huynxhe170132', N'123', N'HE170132', N'Nguyen Xuan Huy', N'FU-Hoa Lac'),
(N'phucnxhe170133', N'123', N'HE170133', N'Nguyen Xuan Phuc', N'FU-Hoa Lac')

/****** Object:  Table [dbo].[Teacher]    Script Date: 05/07/2023 ******/
CREATE TABLE [dbo].[Teacher](
	[username] [varchar](150) NOT NULL PRIMARY KEY,
	[password] [varchar](150) NOT NULL,
	[campus] [varchar](150) NOT NULL,
)

INSERT [dbo].[Teacher] ([username], [password], [campus])
VALUES 
(N'TienTD17', N'123', N'FU-Hoa Lac'),
(N'TuanAnhNM', N'123', N'FU-Hoa Lac')

/****** Object:  Table [dbo].[Class]    Script Date: 05/07/2023 ******/
CREATE TABLE [dbo].[Class](
	[name] [varchar](150) NOT NULL,
	[studentId] [varchar](150) NOT NULL,
)

INSERT [dbo].[Class] ([name], [studentId])
VALUES 
(N'SE1734', N'HE170131'),
(N'SE1734', N'HE170132'),
(N'SE1735', N'HE170133')

/****** Object:  Table [dbo].[Subject]    Script Date: 05/07/2023 ******/
CREATE TABLE [dbo].[Subject](
	[subjectId] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[code] [varchar](150) NOT NULL,
	[name] [varchar](150) NOT NULL,
	[class] [varchar](150) NOT NULL,
	[teacher] [varchar](150) NOT NULL FOREIGN KEY REFERENCES Teacher(username),
)

INSERT [dbo].[Subject] ([code], [name], [class], [teacher])
VALUES 
(N'PRJ301', N'Java Web Application Development', N'SE1734', N'TienTD17'),
(N'IOT102', N'Internet of Things', N'SE1734', N'TuanAnhNM'),
(N'PRJ301', N'Java Web Application Development', N'SE1735', N'TienTD17')

/****** Object:  Table [dbo].[Feedback]    Script Date: 05/07/2023 ******/
CREATE TABLE [dbo].[Feedback](
	[subjectId] [int] NOT NULL FOREIGN KEY REFERENCES Subject(subjectId),
	[teacher] [varchar](150) NOT NULL FOREIGN KEY REFERENCES Teacher(username),
	[class] [varchar](150) NOT NULL,
	[studentId] [varchar](150) NOT NULL FOREIGN KEY REFERENCES Student(studentId),
	[q1] [varchar](150) NOT NULL,
	[q2] [varchar](150) NOT NULL,
	[q3] [varchar](150) NOT NULL,
	[q4] [varchar](150) NOT NULL,
	[q5] [varchar](150) NOT NULL,
	[comment] [varchar](1000),
)

INSERT [dbo].[Feedback] ([subjectId], [teacher], [class], [studentId], [q1], [q2], [q3], [q4], [q5], [comment])
VALUES 
(N'', N'', N'', N'', N'', N'')

/****** Object:  Table [dbo].[Question]    Script Date: 05/07/2023 ******/
CREATE TABLE [dbo].[Question](
	[questionId] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[question] [varchar](5000) NOT NULL,
)
/*drop table Question*/

INSERT [dbo].[Question] ([question]) 
VALUES 
('Cau 1'),
('Cau 2'),
('Cau 3'),
('Cau 4'),
('Cau 5'),
('Cau 6'),
('Cau 7')

/****** Object:  Table [dbo].[WaitingQuestion]    Script Date: 05/07/2023 ******/
CREATE TABLE [dbo].[WaitingQuestion](
	[questionId] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[question] [varchar](5000) NOT NULL,
)
/*drop table WaitingQuestion*/

/****** Object:  Table [dbo].[Answer]    Script Date: 05/07/2023 ******/
CREATE TABLE [dbo].[Answer](
	[questionId] [int] NOT NULL FOREIGN KEY REFERENCES Question(questionId),
	[answer] [varchar](8000),
)
/*drop table Answer*/

INSERT [dbo].[Answer] ([questionId], [answer]) 
VALUES 
(1, 'A1'),
(2, 'A2'),
(3, 'A3'),
(4, 'A4'),
(5, 'A5'),
(6, 'A6'),
(7, 'A7')