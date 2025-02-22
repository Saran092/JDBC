CREATE Table product(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    type TEXT,
    place VARCHAR(100),
    warranty INT
);

INSERT INTO product(name,type,place,warranty)
VALUES
('Type C','Cable','Black Drawer',2024),
('Mac Studio','Computer','White Table',2025),
('Focusrite Mixer','Audio System','White Table',2025),
('Asus Vivobook','Laptop','Brown Drawer',2021),
('Asus Rog','Laptop','Black Table',2021),
('Macbook pro','Laptop','Brown Drawe',2022),
('Wacom Pad','Writing Pad','Black Drawer',2020),
('Apple Keyboard','Keyboard','White Table',2022),
('Logitech Keyboard','Keyboard','Black Table',2024),
('Homi cable','Cable','Black Drawer',2024),
('Java Black Book','Cable','Shelf',2024),
('Logi Mouse','Mouse','Black Table',2022),
('Apple Mouse','Mouse','White Table',2022),
('Lenovo Mouse','Mouse','Black Drawer',2022),
('Black Beast','Computer','White Table',2020),
('Pen','Pen','White Table',9999);

SELECT * FROM product;