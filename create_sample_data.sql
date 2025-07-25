-- Tạo database
CREATE DATABASE IF NOT EXISTS blog_management;
USE blog_management;

-- Tạo bảng category
CREATE TABLE IF NOT EXISTS category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Tạo bảng blogs
CREATE TABLE IF NOT EXISTS blogs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    created_at DATE,
    updated_at DATE,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

-- Thêm dữ liệu mẫu cho category
INSERT INTO category (name) VALUES 
('Công nghệ'),
('Giải trí'),
('Thể thao'),
('Kinh tế'),
('Giáo dục');

-- Thêm dữ liệu mẫu cho blogs
INSERT INTO blogs (title, content, created_at, updated_at, category_id) VALUES 
('Spring Boot là gì?', 'Spring Boot là một framework Java giúp đơn giản hóa việc phát triển ứng dụng Spring.', '2024-01-15', '2024-01-15', 1),
('Hướng dẫn học Spring MVC', 'Spring MVC là một framework web mạnh mẽ cho Java.', '2024-01-16', '2024-01-16', 1),
('Phim bom tấn 2024', 'Những bộ phim bom tấn đáng chờ đợi nhất trong năm 2024.', '2024-01-18', '2024-01-18', 2),
('Bóng đá Việt Nam', 'Tin tức mới nhất về bóng đá Việt Nam.', '2024-01-20', '2024-01-20', 3),
('Kinh tế Việt Nam 2024', 'Phân tích tình hình kinh tế Việt Nam trong năm 2024.', '2024-01-22', '2024-01-22', 4); 