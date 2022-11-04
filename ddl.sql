#存放创建数据库表的sql语句
CREATE DATABASE tiny_twitter;

use tiny_twitter;

CREATE TABLE IF NOT EXISTS `user`(
                                     `user_id` INT NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                     `user_name` VARCHAR(64) comment '用户名' ,
    PRIMARY KEY ( `user_id` )
    )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `post_comment`(
                                             `comment_id` INT NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                             `comment` VARCHAR(64) COMMENT '推文内容' ,
    `create_by` INT NOT NULL COMMENT '推文发布者id',
    `create_at` datetime NOT NULL COMMENT '推文发布时间',
    `last_visit_at` datetime DEFAULT NULL COMMENT '最近被访问时间',
    `status` int NOT NULL COMMENT '0-删除，1-正常',
    PRIMARY KEY ( `comment_id` ),
    KEY `createBy` (`create_by`)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS `follow`(
                                       `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                       `follower_id` INT NOT NULL COMMENT '关注人id' ,
                                       `followee_id` INT NOT NULL COMMENT '被关注人id',
                                       `create_at` datetime NOT NULL COMMENT '关注时间',
                                       PRIMARY KEY ( `id` ),
    KEY `followerId` (`follower_id`),
    KEY `followeeId` (`followee_id`)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `visit_record`(
                                             `record_id` INT NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                             `post_comment_id` INT NOT NULL COMMENT '推文id' ,
                                             `visit_id` INT NOT NULL COMMENT '访问者id',
                                             `visit_at` datetime NOT NULL COMMENT '访问时间',
                                             PRIMARY KEY ( `record_id` ),
    KEY `postCommentId` (`post_comment_id`),
    KEY `visitID` (`visit_id`)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;