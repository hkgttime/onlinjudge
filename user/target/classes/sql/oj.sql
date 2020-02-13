CREATE DATABASE onlinejudge;
USE onlinejudge;
CREATE TABLE USERS(
      uid LONG AUTO_INCREMENT,
      uname VARCHAR(10) NOT NULL,
      password VARCHAR(16) NOT NULL,
      email VARCHAR(16) NOT NULL,
      phone VARCHAR(11),
      motto VARCHAR(32),
      commitTotal INT,
      acceptedTotal INT,
      status INT(1),
      creatDate DATE NOT NULL,
      PRIMARY KEY(uid)
);

CREATE TABLE PROBLEMS(
    pid LONG AUTO_INCREMENT,
    title VARCHAR(32),
    description VARCHAR(1000),
    inputFormat VARCHAR(1000),
    outputFormat VARCHAR(1000),
    hint VARCHAR(1000),
    sampleTestcases VARCHAR(1000),
    status INT(1),
    provider LONG NOT NULL,
    PRIMARY KEY(pid),
    FOREIGN KEY (provider) REFERENCES USERS(uid)
);

CREATE TABLE OUTINTEMS(
     cid  LONG AUTO_INCREMENT PRIMARY KEY,
     problemId LONG NOT NULL,
     userId LONG NOT NULL,
     temName VARCHAR(10) NOT NULL,
     temPath VARCHAR(20) NOT NULL,
     creatDate DATE NOT NULL,
     FOREIGN KEY (userId) REFERENCES USERS(uid),
     FOREIGN KEY (problemId) REFERENCES PROBLEMS(pid)
);


