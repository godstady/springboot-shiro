???prompt PL/SQL Developer Export Tables for user SYSUR@ORCLONE
prompt Created by godstady on 2020��6��19��
set feedback off
set define off

prompt Creating T_S_FUNCTION...
create table T_S_FUNCTION
(
  id               VARCHAR2(32) not null,
  functionlevel    NUMBER(6),
  functionname     VARCHAR2(50) not null,
  functionorder    VARCHAR2(255),
  functionurl      VARCHAR2(500),
  parentfunctionid VARCHAR2(32)
)
;
comment on column T_S_FUNCTION.id
  is 'ID';
comment on column T_S_FUNCTION.functionlevel
  is '菜单等级';
comment on column T_S_FUNCTION.functionname
  is '菜单名字';
comment on column T_S_FUNCTION.functionorder
  is '排序';
comment on column T_S_FUNCTION.functionurl
  is 'URL';
comment on column T_S_FUNCTION.parentfunctionid
  is '父菜单ID';

prompt Creating T_S_LOG...
create table T_S_LOG
(
  id       VARCHAR2(32),
  operator VARCHAR2(50),
  optime   DATE,
  optype   VARCHAR2(100),
  optlx    VARCHAR2(100),
  url      VARCHAR2(200)
)
;

prompt Creating T_S_ROLE...
create table T_S_ROLE
(
  id           VARCHAR2(32) not null,
  rolecode     VARCHAR2(10),
  rolename     VARCHAR2(100) not null,
  depart_ag_id VARCHAR2(32),
  role_type    VARCHAR2(2),
  update_name  VARCHAR2(32),
  update_date  DATE,
  update_by    VARCHAR2(32),
  create_name  VARCHAR2(32),
  create_date  DATE,
  create_by    VARCHAR2(32)
)
;
comment on column T_S_ROLE.id
  is 'ID';
comment on column T_S_ROLE.rolecode
  is '角色编码';
comment on column T_S_ROLE.rolename
  is '角色名字';
comment on column T_S_ROLE.depart_ag_id
  is '部门权限组ID';
comment on column T_S_ROLE.role_type
  is '类型1部门角色/0系统角色';
comment on column T_S_ROLE.update_name
  is '修改人';
comment on column T_S_ROLE.update_date
  is '修改时间';
comment on column T_S_ROLE.update_by
  is '修改人id';
comment on column T_S_ROLE.create_name
  is '创建人';
comment on column T_S_ROLE.create_date
  is '创建时间';
comment on column T_S_ROLE.create_by
  is '创建人id';
alter table T_S_ROLE
  add primary key (ID);

prompt Creating T_S_ROLE_FUNCTION...
create table T_S_ROLE_FUNCTION
(
  id         VARCHAR2(32) not null,
  functionid VARCHAR2(32),
  roleid     VARCHAR2(32)
)
;
comment on column T_S_ROLE_FUNCTION.id
  is 'ID';
comment on column T_S_ROLE_FUNCTION.functionid
  is '菜单ID';
comment on column T_S_ROLE_FUNCTION.roleid
  is '角色ID';
create index FK_9DWW3P4W8JWVLRGWHPITSBFIF on T_S_ROLE_FUNCTION (ROLEID);
create index FK_FVSILLJ2CXYK5THNUU625URAB on T_S_ROLE_FUNCTION (FUNCTIONID);
alter table T_S_ROLE_FUNCTION
  add primary key (ID);
alter table T_S_ROLE_FUNCTION
  add foreign key (ROLEID)
  references T_S_ROLE (ID);

prompt Creating T_S_ROLE_USER...
create table T_S_ROLE_USER
(
  id     VARCHAR2(32) not null,
  roleid VARCHAR2(32),
  userid VARCHAR2(32)
)
;
comment on column T_S_ROLE_USER.id
  is 'ID';
comment on column T_S_ROLE_USER.roleid
  is '角色ID';
comment on column T_S_ROLE_USER.userid
  is '用户ID';
create index FK_D4QB5XLD2PFB0BKJX9IWTOLDA on T_S_ROLE_USER (USERID);
create index FK_N2UCXEORVPJY7QHNMUEM01KBX on T_S_ROLE_USER (ROLEID);
alter table T_S_ROLE_USER
  add primary key (ID);

prompt Creating T_S_USER...
create table T_S_USER
(
  id       VARCHAR2(32) not null,
  userno   VARCHAR2(50),
  usercode VARCHAR2(50),
  password VARCHAR2(50),
  remake   VARCHAR2(500),
  username VARCHAR2(100)
)
;
alter table T_S_USER
  add constraint ID primary key (ID);

prompt Disabling foreign key constraints for T_S_ROLE_FUNCTION...
alter table T_S_ROLE_FUNCTION disable constraint SYS_C0019205;
prompt Loading T_S_FUNCTION...
insert into T_S_FUNCTION (id, functionlevel, functionname, functionorder, functionurl, parentfunctionid)
values ('c2', 2, '系统操作日志', '1', '/tslog', 'c1');
insert into T_S_FUNCTION (id, functionlevel, functionname, functionorder, functionurl, parentfunctionid)
values ('c1', 1, '系统管理', '1', '/login', null);
commit;
prompt 2 records loaded
prompt Loading T_S_LOG...
insert into T_S_LOG (id, operator, optime, optype, optlx, url)
values ('5BF5A3AF2DDD4792BD8C1214C61DE94A', '王警官', to_date('19-06-2020 15:16:39', 'dd-mm-yyyy hh24:mi:ss'), '退出', '123456', '/logout');
insert into T_S_LOG (id, operator, optime, optype, optlx, url)
values ('4C1987B0632E4FD5A84D4FF0E6436387', '王警官', to_date('19-06-2020 15:06:46', 'dd-mm-yyyy hh24:mi:ss'), '登录', '123456', '/login');
insert into T_S_LOG (id, operator, optime, optype, optlx, url)
values ('05EB46EB51F7470185F07B1258CD18F1', '王警官', to_date('19-06-2020 15:16:33', 'dd-mm-yyyy hh24:mi:ss'), '登录', '123456', '/login');
insert into T_S_LOG (id, operator, optime, optype, optlx, url)
values ('2278E5A8B5514A2C8CB7FF7D0CB3912C', '王警官', to_date('19-06-2020 15:04:32', 'dd-mm-yyyy hh24:mi:ss'), '登录', '123456', '/login');
commit;
prompt 4 records loaded
prompt Loading T_S_ROLE...
insert into T_S_ROLE (id, rolecode, rolename, depart_ag_id, role_type, update_name, update_date, update_by, create_name, create_date, create_by)
values ('r2', 'demo', '测试', null, '1', null, null, null, null, null, null);
insert into T_S_ROLE (id, rolecode, rolename, depart_ag_id, role_type, update_name, update_date, update_by, create_name, create_date, create_by)
values ('r1', 'admin', '管理员', null, '1', null, null, null, null, null, null);
commit;
prompt 2 records loaded
prompt Loading T_S_ROLE_FUNCTION...
insert into T_S_ROLE_FUNCTION (id, functionid, roleid)
values ('qewrewewr', 'c2', 'r2');
insert into T_S_ROLE_FUNCTION (id, functionid, roleid)
values ('13123123', 'c1', 'r1');
insert into T_S_ROLE_FUNCTION (id, functionid, roleid)
values ('qeqwesaa', 'c1', 'r1');
commit;
prompt 3 records loaded
prompt Loading T_S_ROLE_USER...
insert into T_S_ROLE_USER (id, roleid, userid)
values ('13123', 'r2', '1');
insert into T_S_ROLE_USER (id, roleid, userid)
values ('asdiuqenqw', 'r1', '1');
commit;
prompt 2 records loaded
prompt Loading T_S_USER...
insert into T_S_USER (id, userno, usercode, password, remake, username)
values ('1', '123456', 'qwe', '1', null, '王警官');
commit;
prompt 1 records loaded
prompt Enabling foreign key constraints for T_S_ROLE_FUNCTION...
alter table T_S_ROLE_FUNCTION enable constraint SYS_C0019205;

set feedback on
set define on
prompt Done
