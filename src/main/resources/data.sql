insert into pricecategories (pricecategory_id, pricecategory_type) values (1, 'Regular');
insert into pricecategories (pricecategory_id, pricecategory_type) values (2, 'Children');
insert into pricecategories (pricecategory_id, pricecategory_type) values (3, 'NewRelease');

insert into movies (movie_id, movie_releasedate, movie_title, movie_rented, pricecategory_fk) values (1, '2016-05-11', 'The Revenant', true, 1);
insert into movies (movie_id, movie_releasedate, movie_title, movie_rented, pricecategory_fk) values (2, '2016-07-20', 'Room', true, 1);
insert into movies (movie_id, movie_releasedate, movie_title, movie_rented, pricecategory_fk) values (3, '2016-08-18', 'Das Dschungelbuch', true, 2);
insert into movies (movie_id, movie_releasedate, movie_title, movie_rented, pricecategory_fk) values (4, '2016-08-31', 'Eddie the Eagle', false, 3);
insert into movies (movie_id, movie_releasedate, movie_title, movie_rented, pricecategory_fk) values (5, '2016-09-07', 'The Man Who Knew Infinity', false, 3);

insert into users (user_id, user_name, user_firstname, user_email) values (1, 'Keller', 'Marc', 'marc.keller@gmail.com');
insert into users (user_id, user_name, user_firstname, user_email) values (2, 'Knecht', 'Werner', 'werner.knecht@gmail.com');
insert into users (user_id, user_name, user_firstname, user_email) values (3, 'Meyer', 'Barbara', 'barbara.meyer@gmail.com');
insert into users (user_id, user_name, user_firstname, user_email) values (4, 'Kummer', 'Adolf', 'adolf.kummer@gmail.com');

insert into rentals (rental_id, movie_id, user_id, rental_rentaldate, rental_rentaldays) values (1, 1, 1, '2016-09-23', 7);
insert into rentals (rental_id, movie_id, user_id, rental_rentaldate, rental_rentaldays) values (2, 2, 1, '2016-09-25', 365);
insert into rentals (rental_id, movie_id, user_id, rental_rentaldate, rental_rentaldays) values (3, 3, 3, '2016-09-27', 365);

