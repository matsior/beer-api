INSERT INTO
    beer_style(name, description)
VALUES
    ('Pale Lager', 'Very pale-to-golden-colored lager beer with a well-attenuated body and a varying degree of noble hop bitterness.'),
    ('Witbier', 'Tradycyjne, belgijskie piwo pszeniczne zwane również biere blanche. Witbier jest warzony metodą górnej fermentacji i niefiltrowany, a ze względu na dodatek niesłodowanej pszenicy może być bardzo mętny.'),
    ('Dortmunder Export', 'Jasny lager warzony pierwotnie przez Dortmunder Union w Dortmundzie w Niemczech w 1873 roku. Jest to piwo o miękkiej teksturze, inspirowane piwem Pilsner warzonym w Pilźnie.');

INSERT INTO
    producer(name, description)
VALUES
    ('browar1', 'opis1'),
    ('browar2', 'opis2'),
    ('browar3', 'opis3');

INSERT INTO
    beer(name, producer_id, description, country, alcohol, blg, beer_style_id)
VALUES
       ('Tyskie', 1, 'opis tyskiego', 'Poland', 5.2, 11.7, 1),
       ('Perła Export', 1, 'opis perly', 'Poland', 5.6, null, 3),
       ('Żywiec Białe', 2, 'opis zywca białego', 'Poland', 4.9, 11.6, 2);


