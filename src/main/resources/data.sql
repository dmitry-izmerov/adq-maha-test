insert into products(id, category, name, price) values
    ('001', 'WATCH', 'Watch 1', 200),
    ('002', 'WATCH', 'Watch 2', 300),
    ('003', 'WATCH', 'Watch 3', 400);

insert into discounts(id, number, price, product_id) values
    (1, 2, 180, '001'),
    (2, 3, 150, '001'),
    (3, 3, 200, '002'),
    (4, 4, 200, '003');
