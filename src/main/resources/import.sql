
INSERT INTO tb_category(name) VALUES ('Livros');
INSERT INTO tb_category(name) VALUES ('Eletrônicos');
INSERT INTO tb_category(name) VALUES ('Computadores');
INSERT INTO tb_product(name, description, price, img_Url) VALUES ('Notebook Dell', 'Notebook Dell Inspiron 15', 3500.00, 'https://example.com/notebook-dell.jpg');
INSERT INTO tb_product(name, description, price, img_Url) VALUES ('Smartphone Samsung', 'Smartphone Samsung Galaxy S21', 2500.00, 'https://example.com/samsung-s21.jpg');
INSERT INTO tb_product(name, description, price, img_Url) VALUES ('Livro Java', 'Livro de Programação Java', 150.00, 'https://example.com/livro-java.jpg');
INSERT INTO tb_role(authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role(authority) VALUES ('ROLE_USER');
INSERT INTO tb_user(first_Name, last_Name, email, password) VALUES ('João', 'Silva', 'joao.silva@example.com', '123456');
INSERT INTO tb_user(first_Name, last_Name, email, password) VALUES ('Maria', 'Santos', 'maria.santos@example.com', '654321');
INSERT INTO tb_product_category(product_id, category_id) VALUES (1, 3);
INSERT INTO tb_product_category(product_id, category_id) VALUES (2, 2);
INSERT INTO tb_product_category(product_id, category_id) VALUES (3, 1);
INSERT INTO tb_user_role(user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role(user_id, role_id) VALUES (2, 2);