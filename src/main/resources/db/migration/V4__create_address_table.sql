CREATE TABLE IF NOT EXISTS addresses (
    id VARCHAR(150) PRIMARY KEY DEFAULT REPLACE(uuid_generate_v4()::text, '-',''),
    zip_code VARCHAR(10) NOT NULL,
    street VARCHAR(150) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(2) NOT NULL,
    complement TEXT
);