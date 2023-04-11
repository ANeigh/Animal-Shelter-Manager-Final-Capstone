BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, animals, imgs, applications;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(20) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,s
	role varchar(50) DEFAULT 'ROLE_USER',
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);


CREATE TABLE applications (
    app_id serial,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    email varchar(50) NOT NULL UNIQUE,
    status varchar(10) DEFAULT 'Pending',
    username varchar(20) NOT NULL UNIQUE,

    CONSTRAINT pk_applications PRIMARY KEY (app_id),
    CONSTRAINT fk_applications_to_users FOREIGN KEY (username) REFERENCES users (username)

);


CREATE TABLE animals (
    animal_id SERIAL,
    type varchar(6) NOT NULL,
    description varchar(100) NOT NULL,
    age int,
    gender varchar(6) NOT NULL,
    adopted boolean DEFAULT false,
    breed varchar(30) NOT NULL,
    color varchar(10) NOT NULL,
    added_by int,
    CONSTRAINT pk_animals PRIMARY KEY (animal_id),
    CONSTRAINT fk_animals_to_user FOREIGN KEY (added_by) REFERENCES users (user_id)
);

CREATE TABLE imgs (
    animal_id int,
    img_id SERIAL,
    url varchar,
    CONSTRAINT pk_imgs PRIMARY KEY (img_id),
    CONSTRAINT fk_imgs_to_user FOREIGN KEY (animal_id) REFERENCES animals (animal_id)
);

COMMIT TRANSACTION;
