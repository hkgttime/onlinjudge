CREATE DATABASE onlinejudge;
USE onlinejudge;
CREATE TABLE USERS(
      uuid VARCHAR(32),
      name VARCHAR(10) NOT NULL,
      password VARCHAR(16) NOT NULL,
      email VARCHAR(16) NOT NULL,
      avatar VARCHAR(100),
      motto VARCHAR(32),
      commitTotal INT,
      acceptedTotal INT,
      status INT(1),
      score LONG NOT NULL,
      creatDate DATE NOT NULL,
      PRIMARY KEY(uuid, name, email)
);

CREATE TABLE PROBLEMS(
    pid VARCHAR(32),
    title VARCHAR(32),
    description VARCHAR(1000),
    inputFormat VARCHAR(1000),
    outputFormat VARCHAR(1000),
    hint VARCHAR(1000),
    sampleTestcases VARCHAR(1000),
    status INT(1),
    score LONG NOT NULL,
    provider VARCHAR(32) NOT NULL,
    PRIMARY KEY(pid),
    FOREIGN KEY (provider) REFERENCES USERS(uuid)
);

CREATE TABLE OUTINTEMS(
     cid VARCHAR(32) NOT NULL,
     problemId VARCHAR(32) NOT NULL,
     userId VARCHAR(32) NOT NULL,
     temName VARCHAR(10) NOT NULL,
     temPath VARCHAR(20) NOT NULL,
     creatDate DATE NOT NULL,
     FOREIGN KEY (userId) REFERENCES USERS(uuid),
     FOREIGN KEY (problemId) REFERENCES PROBLEMS(pid)
);


