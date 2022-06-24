INSERT INTO
    beer_style(name, description)
VALUES
    ('Pale Lager', 'Very pale-to-golden-colored lager beer with a well-attenuated body and a varying degree of noble hop bitterness.'),
    ('Witbier', 'Tradycyjne, belgijskie piwo pszeniczne zwane również biere blanche. Witbier jest warzony metodą górnej fermentacji i niefiltrowany, a ze względu na dodatek niesłodowanej pszenicy może być bardzo mętny.'),
    ('Dortmunder Export', 'Jasny lager warzony pierwotnie przez Dortmunder Union w Dortmundzie w Niemczech w 1873 roku. Jest to piwo o miękkiej teksturze, inspirowane piwem Pilsner warzonym w Pilźnie.');

INSERT INTO
    beer(name, country, alcohol, blg, beer_style_id)
VALUES
       ('Tyskie', 'Poland', 5.2, 11.7, 1),
       ('Perła Export', 'Poland', 5.6, null, 3),
       ('Żywiec Białe', 'Poland', 4.9, 11.6, 2);
