USE celebrity_death_pool;

CREATE USER 'cru-user' IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE ON celebrity_death_pool.* TO 'cru-user';
CREATE USER 'admin' IDENTIFIED BY 'asdf';
GRANT INSERT, SELECT, UPDATE, DELETE ON celebrity_death_pool.* TO 'admin';

INSERT INTO player (first_name, last_name, email_address) VALUES ("player1_first", "player1_last", "player1@mail.com");
INSERT INTO player (first_name, last_name, email_address) VALUES ("player2_first", "player2_last", "player2@mail.com");
INSERT INTO player (first_name, last_name, email_address) VALUES ("player3_first", "player3_last", "player3@mail.com");

INSERT INTO entry (player_id, is_approved, is_paid) VALUES (1, false, false);
INSERT INTO entry (player_id, is_approved, is_paid) VALUES (2, true, false);
INSERT INTO entry (player_id, is_approved, is_paid) VALUES (3, false, true);
INSERT INTO entry (player_id, is_approved, is_paid) VALUES (3, true, true);

INSERT INTO celebrity (celebrity_name, is_dead) VALUES ("Rony Tobbins", false);
INSERT INTO celebrity (celebrity_name, is_dead) VALUES ("Ryan Reynolds", false);
INSERT INTO celebrity (celebrity_name, is_dead) VALUES ("Randall Park", false);
INSERT INTO celebrity (celebrity_name, is_dead) VALUES ("Robert Duvall", true);
INSERT INTO celebrity (celebrity_name, is_dead) VALUES ("Ray Charles", true);
INSERT INTO celebrity (celebrity_name, is_dead) VALUES ("Rudy Giuliani", true);

INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (1, 1, true);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (1, 2, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (1, 3, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (1, 4, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (1, 5, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (1, 6, false);

INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (2, 1, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (2, 2, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (2, 3, true);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (2, 4, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (2, 5, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (2, 6, false);

INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (3, 1, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (3, 2, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (3, 3, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (3, 4, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (3, 5, true);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (3, 6, false);

INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (4, 1, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (4, 2, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (4, 3, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (4, 4, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (4, 5, false);
INSERT INTO entry_selection (entry_id, celebrity_id, is_wildcard) VALUES (4, 6, true);
