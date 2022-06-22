INSERT INTO
    beer_style(name, description)
VALUES
    ('Pale Lager', 'mniam mniam'),
    ('Witbier', 'też dobre');

INSERT INTO
    beer(name, country, alcohol, blg, beer_style_id)
VALUES
       ('Tyskie', 'Poland', 5.2, 11.7, 1),
       ('Perła Export', 'Poland', 5.6, null, 2),
       ('Żywiec Białe', 'Poland', 4.3, 8.9, 2);
