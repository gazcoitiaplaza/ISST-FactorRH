INSERT INTO users (username, password, enabled) VALUES ('user1', 'password', true);
INSERT INTO authorities (username, authority) VALUES ('user1', 'ROLE_USER');

INSERT INTO users (username, password, enabled) VALUES ('admin', 'adminpassword', true);
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
