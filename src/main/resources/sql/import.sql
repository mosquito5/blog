# Users
INSERT INTO users(id, banned, email, name, password) VALUES (1, 0, 'John@john.com', 'John', '123');
INSERT INTO users(id, banned, email, name, password) VALUES (2, 0, 'Rob@rob.com', 'Rob', '123');
INSERT INTO users(id, banned, email, name, password) VALUES (3, 0, 'Mat@pon.com', 'Mat', '123');
INSERT INTO users(id, banned, email, name, password) VALUES (4, 0, 'Dan@pon.com', 'Dan', '123');

# Roles
INSERT INTO user_role(id, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO user_role(id, role) VALUES (2, 'ROLE_USER');

# User roles
INSERT INTO users_user_roles(user_id, user_roles_id) VALUES (1,2);
INSERT INTO users_user_roles(user_id, user_roles_id) VALUES (2,2);
INSERT INTO users_user_roles(user_id, user_roles_id) VALUES (3,2);
INSERT INTO users_user_roles(user_id, user_roles_id) VALUES (4,2);


# Posts
INSERT INTO post(id, title, content, local_date_time , user_id ) VALUES (1, 'title1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.',CURRENT_TIMESTAMP(), 1);
INSERT INTO post(id, title, content, local_date_time , user_id ) VALUES (2, 'title2', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.',CURRENT_TIMESTAMP(), 2);
INSERT INTO post(id, title, content, local_date_time , user_id ) VALUES (3, 'title3', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.',CURRENT_TIMESTAMP(), 2);
INSERT INTO post(id, title, content, local_date_time , user_id ) VALUES (4, 'title4', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.',CURRENT_TIMESTAMP(), 3);
INSERT INTO post(id, title, content, local_date_time , user_id ) VALUES (5, 'title5', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.',CURRENT_TIMESTAMP(), 1);
INSERT INTO post(id, title, content, local_date_time , user_id ) VALUES (6, 'title6', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.',CURRENT_TIMESTAMP(), 1);
INSERT INTO post(id, title, content, local_date_time , user_id ) VALUES (7, 'title7', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.',CURRENT_TIMESTAMP(), 2);
INSERT INTO post(id, title, content, local_date_time , user_id ) VALUES (8, 'title8', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.',CURRENT_TIMESTAMP(), 2);
INSERT INTO post(id, title, content, local_date_time , user_id ) VALUES (9, 'title9', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.',CURRENT_TIMESTAMP(), 3);
INSERT INTO post(id, title, content, local_date_time , user_id ) VALUES (10, 'title10', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.',CURRENT_TIMESTAMP(), 1);
INSERT INTO post(id, title, content, local_date_time , user_id ) VALUES (11, 'title11', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.',CURRENT_TIMESTAMP(), 1);
INSERT INTO post(id, title, content, local_date_time , user_id ) VALUES (12, 'title12', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.',CURRENT_TIMESTAMP(), 2);
INSERT INTO post(id, title, content, local_date_time , user_id ) VALUES (13, 'title13', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.',CURRENT_TIMESTAMP(), 2);
INSERT INTO post(id, title, content, local_date_time , user_id ) VALUES (14, 'title14', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.',CURRENT_TIMESTAMP(), 3);
INSERT INTO post(id, title, content, local_date_time , user_id ) VALUES (15, 'title15', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.',CURRENT_TIMESTAMP(), 1);




# tags
# todo


# comments
INSERT INTO comment(id, content, post_id, user_id ) VALUES (1,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.', 1, 2);
INSERT INTO comment(id, content, post_id, user_id ) VALUES (2,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.', 1, 1);
INSERT INTO comment(id, content, post_id, user_id ) VALUES (3,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.', 15, 4);
INSERT INTO comment(id, content, post_id, user_id ) VALUES (4,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.', 12, 3);
INSERT INTO comment(id, content, post_id, user_id ) VALUES (5,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.', 12, 2);
INSERT INTO comment(id, content, post_id, user_id ) VALUES (6,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.', 3, 1);
INSERT INTO comment(id, content, post_id, user_id ) VALUES (7,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.', 3, 2);
INSERT INTO comment(id, content, post_id, user_id ) VALUES (8,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.', 3, 3);
INSERT INTO comment(id, content, post_id, user_id ) VALUES (9,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet leo neque. Duis semper.', 3, 4);
