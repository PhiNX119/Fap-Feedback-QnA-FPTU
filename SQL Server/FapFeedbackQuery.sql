--Student--------------------------------------------------------------------------------------------------------------------------------
select * from Student where username = 'phinxhe170131' and password = '123' and campus = 'FU-Hoa Lac'

--Teacher--------------------------------------------------------------------------------------------------------------------------------
select * from Teacher

--Class----------------------------------------------------------------------------------------------------------------------------------
select * from Class

--Subject--------------------------------------------------------------------------------------------------------------------------------
select * from Subject

select * from Subject c, Class cl, Student s
where c.class = cl.name and cl.studsentId = s.studentId and s.studentId = 'HE170131'

--Feedback-------------------------------------------------------------------------------------------------------------------------------
select * from Feedback

select * from Feedback where subjectId = '1' and teacher = and class = 

update Feedback set q1 = '', q2 = '', q3 = '', q4 = '', comment = '' where subjectId = ''

delete from Feedback where subjectId = '2' and studentId = 'HE170131'

INSERT [dbo].[Feedback] ([subjectId], [teacher], [class], [studentId], [q1], [q2], [q3], [q4], [q5], [comment])
VALUES (N'', N'', N'', N'', N'', N'')

--Question-------------------------------------------------------------------------------------------------------------------------------
select * from Question

delete from Question where questionId > '7'

update Question set question where questionId = 

select * from Question where question like '%3%'

INSERT [dbo].[Question] ([question]) VALUES ('Cau 8')

--Answer---------------------------------------------------------------------------------------------------------------------------------
select * from Answer where questionId = 

delete from Answer where questionId = '2'

INSERT [dbo].[Answer] ([questionId], [answer]) VALUES (11, 'A8')

update Answer set answer = 'ahihi' where questionId = 7

--Answer---------------------------------------------------------------------------------------------------------------------------------
select * from WaitingQuestion