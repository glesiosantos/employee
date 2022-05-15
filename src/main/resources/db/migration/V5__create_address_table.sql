CREATE TABLE IF NOT EXISTS addresses (
    id VARCHAR(150) PRIMARY KEY DEFAULT REPLACE(uuid_generate_v4()::text, '-',''),
    zip_code VARCHAR(10) NOT NULL,
    street VARCHAR(150) NOT NULL,
    district VARCHAR(60) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(2) NOT NULL,
    complement TEXT,
    employee_id VARCHAR(150) NOT NULL,
    CONSTRAINT FK_ADDRESS_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employees (id) ON UPDATE NO ACTION ON DELETE CASCADE
);