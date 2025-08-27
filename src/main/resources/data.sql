INSERT INTO USERS(username, password, enabled)
VALUES ('user#team_04', '$2a$12$/x6QXEB1/jqBMBJgIDql8.hdbX2agK9KFXf05tU1r7ZTWZrMbHi7m', true),      -- pwd=1234
       ('moderator#team_04', '$2a$12$/x6QXEB1/jqBMBJgIDql8.hdbX2agK9KFXf05tU1r7ZTWZrMbHi7m', true), -- pwd=1234
       ('admin#team_04', '$2a$12$/x6QXEB1/jqBMBJgIDql8.hdbX2agK9KFXf05tU1r7ZTWZrMbHi7m', true); -- pwd=1234

INSERT INTO AUTHORITIES(username, authority)
VALUES ('user#team_04', 'ROLE_USER'),
       ('moderator#team_04', 'ROLE_MODERATOR'),
       ('admin#team_04', 'ROLE_ADMIN');

INSERT INTO USER_DETAILS_EXTRA(username, first_name, last_name, mail, birth_date, fav_team, sport)
VALUES ('user#team_04', 'Marco', 'Bianchi', 'marco.bianchi@example.com', '1990-11-05', 'Inter', 'CALCIO'),
       ('moderator#team_04', 'Alice', 'Rossi', 'alice.rossi@example.com', '1995-03-21', 'Milan', 'CALCIO'),
       ('admin#team_04', 'Luca', 'Moretti', 'luca.moretti@example.com', '1998-07-14', 'Torino', 'CALCIO');

INSERT INTO REVIEW (username, rating, text, created_at)
VALUES ('user#team_04', 2, 'Non sono rimasto soddisfatto, troppo costoso per quello che offre.',
        CURRENT_TIMESTAMP - 1 DAY),
       ('user#team_04', 5, 'Ottima assistenza via mail, lo consiglio a tutti!', CURRENT_TIMESTAMP),
       ('user#team_04', 5, 'Sito programmato veramente bene!', CURRENT_TIMESTAMP),
       ('moderator#team_04', 2, 'Sito crashato sul più bello ...', CURRENT_TIMESTAMP),
       ('admin#team_04', 5, 'Eccellente!', CURRENT_TIMESTAMP - 10 DAY),
       ('admin#team_04', 4, 'Buona esperienza complessiva, ma sarebbe bello funzionassi con più sport.',
        CURRENT_TIMESTAMP - 7 DAY),
       ('admin#team_04', 3, 'Normale, niente di speciale. Ci sono margini di miglioramento.',
        CURRENT_TIMESTAMP - 3 DAY);

INSERT INTO PRIZE (username, description, assigned_at)
VALUES ('admin#team_04', 'Bonus Benvenuto', '2025-08-01 10:30:00'),
       ('user#team_04', 'Vittoria Giornata 3', '2025-08-05 18:45:00'),
       ('user#team_04', 'Maglietta del napoli', '2025-08-05 18:45:00'),
       ('moderator#team_04', 'Miglior Punteggio della Settimana', '2025-08-12 21:15:00');

INSERT INTO BET (username, played_at, score)
VALUES ('admin#team_04', '2025-08-01 15:00:00', 5),
       ('admin#team_04', '2025-08-05 16:20:00', 3),
       ('admin#team_04', '2025-08-12 14:00:00', 4),
       ('user#team_04', '2025-08-01 15:10:00', 2),
       ('user#team_04', '2025-08-03 17:00:00', 4),
       ('user#team_04', '2025-08-06 19:30:00', 1),
       ('user#team_04', '2025-08-10 20:00:00', 5),
       ('moderator#team_04', '2025-08-13 21:45:00', 3);
