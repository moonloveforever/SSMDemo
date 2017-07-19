CREATE TABLE `org_user` (
  `id` varchar(50) NOT NULL,
  `branch_id` varchar(50) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '״̬ 0���� 1����',
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `org_branch` (
  `branch_id` varchar(50) NOT NULL,
  `branch_name` varchar(50) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '0',
  `branch_type` varchar(20) NOT NULL,
  PRIMARY KEY (`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

