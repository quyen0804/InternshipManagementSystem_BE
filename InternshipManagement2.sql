-- Create Database
CREATE DATABASE InternshipManagement;
USE InternshipManagement;

-- Table for audit_entity
CREATE TABLE audit_entity (
    audit_id VARCHAR(255) NOT NULL,
    date DATE,
    evaluation_period SMALLINT CHECK (evaluation_period BETWEEN 0 AND 2),
    mentor_id VARCHAR(255),
    PRIMARY KEY (audit_id)
);

-- Table for audit_intern_entity
CREATE TABLE audit_intern_entity (
    audit_intern_id VARCHAR(255) NOT NULL,
    auditid VARCHAR(255),
    ave_grade FLOAT NOT NULL,
    created_time DATETIME(6),
    intern_id VARCHAR(255),
    result_id VARCHAR(255),
    updated_time DATETIME(6),
    PRIMARY KEY (audit_intern_id)
);

-- Table for audit_participants
CREATE TABLE audit_participants (
    audit_intern_id VARCHAR(255) NOT NULL,
    role SMALLINT CHECK (role BETWEEN 0 AND 1),
    user_id VARCHAR(255),
    PRIMARY KEY (audit_intern_id)
);

-- Table for audit_result_entity
CREATE TABLE audit_result_entity (
    result_id VARCHAR(255) NOT NULL,
    ave_result FLOAT NOT NULL,
    create_time DATETIME(6),
    feedback_id INT NOT NULL,
    intern_id VARCHAR(255),
    mentor_id VARCHAR(255),
    result BIT NOT NULL,
    is_qualify BIT NOT NULL,
    PRIMARY KEY (result_id)
);

-- Table for daily_report_entity
CREATE TABLE daily_report_entity (
    report_id INT NOT NULL,
    created_time DATETIME(6),
    intern_id VARCHAR(255),
    is_reviewed BIT NOT NULL,
    mentor_id VARCHAR(255),
    today DATETIME(6),
    todo_list VARCHAR(255),
    updated_time DATETIME(6),
    PRIMARY KEY (report_id)
);

-- Table for feedback_entity
CREATE TABLE feedback_entity (
    feedback_id INT NOT NULL,
    created_time DATETIME(6),
    description VARCHAR(255),
    intern_id INT NOT NULL,
    mentor_id INT NOT NULL,
    value FLOAT NOT NULL,
    PRIMARY KEY (feedback_id)
);

-- Table for grade_entity
CREATE TABLE grade_entity (
    grade_id INT NOT NULL,
    audit_intern_id VARCHAR(255),
    description VARCHAR(255),
    name SMALLINT CHECK (name BETWEEN 0 AND 2),
    value FLOAT NOT NULL,
    PRIMARY KEY (grade_id)
);

-- Table for intern_entity
CREATE TABLE intern_entity (
    avatar VARCHAR(255),
    join_date DATE,
    mentor_id VARCHAR(255),
    status SMALLINT CHECK (status BETWEEN 0 AND 2),
    user_id VARCHAR(255) NOT NULL,
    first_pass VARCHAR(255),
    PRIMARY KEY (user_id)
);

-- Table for issue_entity
CREATE TABLE issue_entity (
    issue_id INT NOT NULL,
    issue_content VARCHAR(255),
    report_id INT NOT NULL,
    PRIMARY KEY (issue_id)
);

-- Table for issue_receiver_entity
CREATE TABLE issue_receiver_entity (
    receiver_id INT NOT NULL,
    issue_id VARCHAR(255),
    reply VARCHAR(255),
    PRIMARY KEY (receiver_id)
);

-- Table for mentor_entity
CREATE TABLE mentor_entity (
    bu VARCHAR(255),
    user_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (user_id)
);

-- Table for task_entity
CREATE TABLE task_entity (
    task_id INT NOT NULL,
    completed_time DATETIME(6),
    created_time DATETIME(6),
    is_completed BIT NOT NULL,
    report_id INT NOT NULL,
    task_content VARCHAR(255),
    PRIMARY KEY (task_id)
);

-- Table for user_entity
CREATE TABLE user_entity (
    user_id VARCHAR(255) NOT NULL,
    account VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    dob DATE,
    full_name VARCHAR(255),
    gender BIT NOT NULL,
    password VARCHAR(255),
    phone VARCHAR(255),
    role SMALLINT CHECK (role BETWEEN 0 AND 1),
    social_num VARCHAR(255),
    PRIMARY KEY (user_id),
    UNIQUE (account)
);

-- Foreign Keys
ALTER TABLE intern_entity ADD FOREIGN KEY (user_id) REFERENCES user_entity(user_id);
ALTER TABLE mentor_entity ADD FOREIGN KEY (user_id) REFERENCES user_entity(user_id);
