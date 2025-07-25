-- Tạo database nếu chưa có
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
('Spring Boot là gì?', 'Spring Boot là một framework Java giúp đơn giản hóa việc phát triển ứng dụng Spring. Nó cung cấp các tính năng auto-configuration và starter dependencies.', '2024-01-15', '2024-01-15', 1),
('Hướng dẫn học Spring MVC', 'Spring MVC là một framework web mạnh mẽ cho Java. Bài viết này sẽ hướng dẫn bạn từ cơ bản đến nâng cao.', '2024-01-16', '2024-01-16', 1),
('JPA và Hibernate', 'JPA (Java Persistence API) là một specification cho ORM trong Java. Hibernate là implementation phổ biến nhất của JPA.', '2024-01-17', '2024-01-17', 1),
('Phim bom tấn 2024', 'Những bộ phim bom tấn đáng chờ đợi nhất trong năm 2024. Từ Marvel đến DC, từ Hollywood đến các nền điện ảnh khác.', '2024-01-18', '2024-01-18', 2),
('Game hay nhất năm 2024', 'Tổng hợp những game hay nhất được phát hành trong năm 2024. Từ AAA đến indie games.', '2024-01-19', '2024-01-19', 2),
('Bóng đá Việt Nam', 'Tin tức mới nhất về bóng đá Việt Nam. Các trận đấu, giải đấu và sự kiện quan trọng.', '2024-01-20', '2024-01-20', 3),
('Thể thao thế giới', 'Tin tức thể thao quốc tế. Từ bóng đá, tennis, bóng rổ đến các môn thể thao khác.', '2024-01-21', '2024-01-21', 3),
('Kinh tế Việt Nam 2024', 'Phân tích tình hình kinh tế Việt Nam trong năm 2024. Các chỉ số quan trọng và xu hướng phát triển.', '2024-01-22', '2024-01-22', 4),
('Thị trường chứng khoán', 'Phân tích thị trường chứng khoán Việt Nam. Các cổ phiếu tiềm năng và chiến lược đầu tư.', '2024-01-23', '2024-01-23', 4),
('Giáo dục trực tuyến', 'Xu hướng giáo dục trực tuyến trong thời đại số. Các nền tảng học tập và phương pháp giảng dạy mới.', '2024-01-24', '2024-01-24', 5),
('Học lập trình Java', 'Hướng dẫn chi tiết cách học lập trình Java từ cơ bản đến nâng cao. Tài liệu và tài nguyên học tập.', '2024-01-25', '2024-01-25', 5),
('Spring Security cơ bản', 'Hướng dẫn sử dụng Spring Security để bảo mật ứng dụng Spring Boot. Từ authentication đến authorization.', '2024-01-26', '2024-01-26', 1),
('RESTful API với Spring', 'Thiết kế và xây dựng RESTful API sử dụng Spring Boot. Các best practices và patterns phổ biến.', '2024-01-27', '2024-01-27', 1),
('Microservices với Spring Cloud', 'Kiến trúc microservices sử dụng Spring Cloud. Service discovery, load balancing và distributed tracing.', '2024-01-28', '2024-01-28', 1),
('Docker cho Java developers', 'Hướng dẫn sử dụng Docker để containerize ứng dụng Java. Từ Dockerfile đến docker-compose.', '2024-01-29', '2024-01-29', 1),
('Kubernetes cơ bản', 'Tìm hiểu về Kubernetes - platform để quản lý containerized applications. Các khái niệm cơ bản và thực hành.', '2024-01-30', '2024-01-30', 1),
('DevOps practices', 'Các practices và tools trong DevOps. Từ CI/CD đến monitoring và logging.', '2024-01-31', '2024-01-31', 1),
('Machine Learning cơ bản', 'Giới thiệu về Machine Learning. Các thuật toán cơ bản và ứng dụng thực tế.', '2024-02-01', '2024-02-01', 1),
('Data Science với Python', 'Hướng dẫn sử dụng Python cho Data Science. Pandas, NumPy, Matplotlib và các thư viện khác.', '2024-02-02', '2024-02-02', 1),
('Big Data và Hadoop', 'Tìm hiểu về Big Data và Hadoop ecosystem. HDFS, MapReduce, Spark và các công nghệ liên quan.', '2024-02-03', '2024-02-03', 1); 