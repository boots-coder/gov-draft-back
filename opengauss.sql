-- 创建数据库
CREATE DATABASE gov WITH ENCODING 'UTF8' TEMPLATE template0;

\c gov -- 切换到 gov 数据库

-- 设置外键检查关闭
SET SESSION CHARACTERISTICS AS TRANSACTION ISOLATION LEVEL READ COMMITTED;
SET CONSTRAINTS ALL DEFERRED;

-- ----------------------------
-- Table structure for articles
-- ----------------------------
DROP TABLE IF EXISTS articles;
CREATE TABLE articles (
                          article_id SERIAL PRIMARY KEY,
                          content TEXT NOT NULL,
                          submitter_id INT NOT NULL,
                          submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          status VARCHAR(10) CHECK (status IN ('待审核', '已采纳', '已发布', '拒绝')) DEFAULT '待审核'
);

-- ----------------------------
-- Records of articles
-- ----------------------------
INSERT INTO articles (article_id, content, submitter_id, submitted_at, status) VALUES
                                                                                   (1, '这是稿件内容1', 1, '2025-01-05 11:15:17', '已采纳'),
                                                                                   (2, '这是稿件内容2', 3, '2025-01-05 11:15:17', '拒绝'),
                                                                                   (3, '这是稿件内容3', 3, '2025-01-05 11:15:17', '待审核'),
                                                                                   (4, '稿件内容', 123, '2025-01-09 12:57:39', '待审核'),
                                                                                   (5, '111', 3, '2025-01-09 12:58:13', '已发布'),
                                                                                   (6, 'hello', 3, '2025-01-09 12:58:54', '拒绝'),
                                                                                   (7, 'hello', 3, '2025-01-09 13:03:50', '拒绝');

-- ----------------------------
-- Table structure for journals
-- ----------------------------
DROP TABLE IF EXISTS journals;
CREATE TABLE journals (
                          journal_id SERIAL PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          publish_date DATE NOT NULL,
                          content JSON NOT NULL -- 使用 JSON 存储文章 ID
);

-- ----------------------------
-- Records of journals
-- ----------------------------
INSERT INTO journals (journal_id, title, publish_date, content) VALUES
                                                                    (1, '政府期刊2025年第1期', '2025-01-01', '[{"article_id": 1}, {"article_id": 2}]'),
                                                                    (2, '政府期刊2025年第2期', '2025-02-01', '[{"article_id": 3}]');

-- ----------------------------
-- Table structure for solicitations
-- ----------------------------
DROP TABLE IF EXISTS solicitations;
CREATE TABLE solicitations (
                               solicitation_id SERIAL PRIMARY KEY,
                               topic VARCHAR(255) NOT NULL,
                               solicited_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               solicitor_id INT NOT NULL,
                               solicited_person_id INT NOT NULL,
                               deadline DATE NOT NULL
);

-- ----------------------------
-- Records of solicitations
-- ----------------------------
INSERT INTO solicitations (solicitation_id, topic, solicited_at, solicitor_id, solicited_person_id, deadline) VALUES
                                                                                                                  (1, '关于环境保护的约稿', '2025-01-05 11:16:13', 2, 4, '2025-02-01'),
                                                                                                                  (2, '关于城市发展规划的约稿', '2025-01-05 11:16:13', 2, 3, '2025-02-15');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS users;
CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(20) NOT NULL,
                       permissions JSON,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO users (user_id, username, password, role, permissions, created_at) VALUES
                                                                                   (1, 'contributor1', '1', '投稿者', '{"submit_articles": true}', '2025-01-05 11:15:16'),
                                                                                   (3, 'admin', '1', '管理员', '{"manage_users": true, "edit_articles": true}', '2025-01-08 01:33:51'),
                                                                                   (4, 'solicitor1', '1', '投稿者', '{"submit_articles": true}', '2025-01-05 11:15:16');

-- 恢复外键检查
SET CONSTRAINTS ALL IMMEDIATE;