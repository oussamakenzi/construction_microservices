CREATE TABLE project (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          start_date DATE NOT NULL,
                          end_date DATE NOT NULL,
                          budget DECIMAL(10, 2) NOT NULL
);
