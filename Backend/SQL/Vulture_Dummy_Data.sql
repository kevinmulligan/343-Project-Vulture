#password is sha hash of dickbutt

USE Vulture;

insert into Users (	Username, 
			Password,
			Email,
			FirstName,
			LastName,
			Address,
			City,
			State,
			ZipCode,
			Age,
			Sexuality,
			Gender,
			Accent,
			Active) 
	values ('bill',
		'dd19447119baf097c358b4f06856132491c74159',
		'bill@bill.com',
		'Bill',
		'Jobs',
		'189 Perkins Rd',
		'Rochester',
		'NY',
		'14623',
		22,
		(select id from Sexuality where Name='Straight'),
		(select id from Gender where Name='Cis Male'),
		(select id from Accent where Name='English'),
		1);

insert into UserImage (UserID, ImagePath) values ((select id from Users where Username='bill'), 'http://i.imgur.com/fxkvPrM.jpg');

insert into Users (	Username,
			Password,
			Email,
			FirstName,
			LastName,
			Address,
			City,
			State,
			ZipCode,
			Age,
			Sexuality,
			Gender,
			Accent,
			Active) 
	values ('tswift',
		'dd19447119baf097c358b4f06856132491c74159',
		'tswift@tswiftSecretemail.com',
		'Taylor', 
		'Swift',
		'3800 W Henrietta Rd',
		'Rochester',
		'NY',
		'14623',
		18,
		(select id from Sexuality where Name='Bisexual'),
		(select id from Gender where Name='Woman'),
		(select id from Accent where Name='French'),
		1);

insert into UserImage (UserID, ImagePath) values ((select id from Users where Username='tswift'), 'http://i.imgur.com/Nt5idPD.jpg');

insert into Tutor (	CostPerHour,
			Description,
			Height,
			Weight,
			HairColor,
			HasTattoos,
			UserID,
			Active)
	values (20.00,
		'The best tutor in the world!',
		63,
		120,
		(select id from HairColor where Name='Blonde'),
		0,
		(select id from Users where Username='tswift'),
		1);
 
insert into TutorSubjects (TutorID, SubjectID) values ((select id from Tutor where UserID=(select id from Users where Username='tswift')), (select id from Subject where Name='Art'));

insert into Products (Name, Description, Quantity, Cost) values ('Book', 'Its a book', 100, 12.32);

insert into ProductImage (productID, ImagePath) values ((select id from Products where Name='Book'), 'http://i.imgur.com/1BVyKfk.jpg');
