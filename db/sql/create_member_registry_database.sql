/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2012                    */
/* Created on:     06/11/2019 15:13:03                          */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CLASSIFICATION') and o.name = 'FK_CLASSIFI_REFERENCE_CLASSIFI')
alter table CLASSIFICATION
   drop constraint FK_CLASSIFI_REFERENCE_CLASSIFI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CONTACT_INFORMATION') and o.name = 'FK_CONTACT__REFERENCE_MEMBER')
alter table CONTACT_INFORMATION
   drop constraint FK_CONTACT__REFERENCE_MEMBER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CONTACT_INFORMATION') and o.name = 'FK_CONTACT__REFERENCE_ORG')
alter table CONTACT_INFORMATION
   drop constraint FK_CONTACT__REFERENCE_ORG
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEMBER') and o.name = 'FK_MEMBER_STATUS_ID')
alter table MEMBER
   drop constraint FK_MEMBER_STATUS_ID
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEMBER') and o.name = 'FK_MEMBER_GENDER')
alter table MEMBER
   drop constraint FK_MEMBER_GENDER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEMBER') and o.name = 'FK_MEMBER_CATEGORY')
alter table MEMBER
   drop constraint FK_MEMBER_CATEGORY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEMBER') and o.name = 'FK_MEMBER_TERM_REASON')
alter table MEMBER
   drop constraint FK_MEMBER_TERM_REASON
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEMBER_ORG_RLSHIP') and o.name = 'FK_MEMBER_O_REFERENCE_MEMBER')
alter table MEMBER_ORG_RLSHIP
   drop constraint FK_MEMBER_O_REFERENCE_MEMBER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEMBER_ORG_RLSHIP') and o.name = 'FK_MEMBER_O_ROLE_ID')
alter table MEMBER_ORG_RLSHIP
   drop constraint FK_MEMBER_O_ROLE_ID
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEMBER_ORG_RLSHIP') and o.name = 'FK_MEMBER_O_EVENT_ID')
alter table MEMBER_ORG_RLSHIP
   drop constraint FK_MEMBER_O_EVENT_ID
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEMBER_ORG_RLSHIP') and o.name = 'FK_MEMBER_O_REFERENCE_ORG')
alter table MEMBER_ORG_RLSHIP
   drop constraint FK_MEMBER_O_REFERENCE_ORG
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ORG') and o.name = 'FK_ORG_REFERENCE_ORG')
alter table ORG
   drop constraint FK_ORG_REFERENCE_ORG
go

alter table CLASSIFICATION
   drop constraint PK_CLASSIFICATION
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CLASSIFICATION')
            and   type = 'U')
   drop table CLASSIFICATION
go

alter table CLASSIFICATION_TYPE
   drop constraint PK_CLASSIFICATION_TYPE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CLASSIFICATION_TYPE')
            and   type = 'U')
   drop table CLASSIFICATION_TYPE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CONTACT_INFORMATION')
            and   type = 'U')
   drop table CONTACT_INFORMATION
go

alter table MEMBER
   drop constraint PK_MEMBER
go

if exists (select 1
            from  sysobjects
           where  id = object_id('MEMBER')
            and   type = 'U')
   drop table MEMBER
go

if exists (select 1
            from  sysobjects
           where  id = object_id('MEMBER_ORG_RLSHIP')
            and   type = 'U')
   drop table MEMBER_ORG_RLSHIP
go

alter table ORG
   drop constraint PK_ORG
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ORG')
            and   type = 'U')
   drop table ORG
go

/*==============================================================*/
/* Table: CLASSIFICATION                                        */
/*==============================================================*/
create table CLASSIFICATION (
   CLASSIFICATION_ID    bigint               not null,
   CLASSIFICATION_TYPE_ID bigint               null,
   NAME                 nvarchar(60)         not null,
   DESCRIPTION          nvarchar(255)        null,
   VALID_FROM           datetime2            not null,
   VALID_TO             datetime2            not null,
   VALID_FLAG           nchar(1)             not null,
   CREATED_ON           datetime2            not null,
   CREATED_BY           nvarchar(60)         not null,
   MODIFIED_ON          datetime2            null,
   MODIFIED_BY          nvarchar(60)         null
)
go

alter table CLASSIFICATION
   add constraint PK_CLASSIFICATION primary key (CLASSIFICATION_ID)
go

/*==============================================================*/
/* Table: CLASSIFICATION_TYPE                                   */
/*==============================================================*/
create table CLASSIFICATION_TYPE (
   CLASSIFICATION_TYPE_ID bigint               not null,
   NAME                 nvarchar(60)         not null,
   DESCRIPTION          nvarchar(255)        null,
   VALID_FROM           datetime2            not null,
   VALID_TO             datetime2            not null,
   VALID_FLAG           nchar(1)             not null,
   CREATED_ON           datetime2            not null,
   CREATED_BY           nvarchar(60)         not null,
   MODIFIED_ON          datetime2            null,
   MODIFIED_BY          nvarchar(60)         null
)
go

alter table CLASSIFICATION_TYPE
   add constraint PK_CLASSIFICATION_TYPE primary key (CLASSIFICATION_TYPE_ID)
go

/*==============================================================*/
/* Table: CONTACT_INFORMATION                                   */
/*==============================================================*/
create table CONTACT_INFORMATION (
   MEMBER_ID            bigint               null,
   ORGANIZATION_ID      bigint               null,
   ZIP_1                nvarchar(4)          not null,
   CITY_1               nvarchar(60)         not null,
   ADDRESS_1            nvarchar(255)        not null,
   ZIP_2                nvarchar(4)          null,
   CITY_2               nvarchar(60)         null,
   ADDRESS_2            nvarchar(255)        null,
   ZIP_3                nvarchar(4)          null,
   CITY_3               nvarchar(60)         null,
   ADDRESS_3            nvarchar(255)        null,
   PHONE_1              nvarchar(20)         null,
   PHONE_2              nvarchar(20)         null,
   PHONE_3              nvarchar(20)         null,
   EMAIL_1              nvarchar(60)         null,
   EMAIL_2              nvarchar(60)         null,
   VALID_FROM           datetime2            not null,
   VALID_TO             datetime2            not null,
   VALID_FLAG           nchar(1)             not null,
   CREATED_ON           datetime2            not null,
   CREATED_BY           nvarchar(60)         not null,
   MODIFIED_ON          datetime2            null,
   MODIFIED_BY          nvarchar(60)         null
)
go

/*==============================================================*/
/* Table: MEMBER                                                */
/*==============================================================*/
create table MEMBER (
   MEMBER_ID            bigint               not null,
   NAME                 nvarchar(255)        not null,
   SUPPORTING_MEMBER    nchar(1)             not null,
   BIRTHDATE            date                 not null,
   GENDER_ID            bigint               null,
   NEW_DECLARATION_FLAG nchar(1)             not null,
   MEMBER_CATEGORY_ID   bigint               null,
   DECLARATION_DATE     datetime2            null,
   APPROVAL_DATE        datetime2            null,
   ENTRY_DATE           datetime2            null,
   TERMINATION_DATE     datetime2            null,
   TERMINATION_REASON_ID bigint               null,
   STATUS_ID            bigint               null,
   CREATED_ON           datetime2            not null,
   CREATED_BY           nvarchar(60)         not null,
   MODIFIED_ON          datetime2            null,
   MODIFIED_BY          nvarchar(60)         null
)
go

alter table MEMBER
   add constraint PK_MEMBER primary key (MEMBER_ID)
go

/*==============================================================*/
/* Table: MEMBER_ORG_RLSHIP                                     */
/*==============================================================*/
create table MEMBER_ORG_RLSHIP (
   MEMBER_ID            bigint               null,
   ORGANIZATION_ID      bigint               null,
   ROLE_ID              bigint               null,
   EVENT_ID             bigint               not null,
   NOTES                nvarchar(255)        null,
   VALID_FROM           datetime2            not null,
   VALID_TO             datetime2            not null,
   VALID_FLAG           nchar(1)             not null,
   CREATED_ON           datetime2            not null,
   CREATED_BY           nvarchar(60)         not null,
   MODIFIED_ON          datetime2            null,
   MODIFIED_BY          nvarchar(60)         null
)
go

/*==============================================================*/
/* Table: ORG                                                   */
/*==============================================================*/
create table ORG (
   ORG_ID               bigint               not null,
   PARENT_ORG_ID        bigint               null,
   NAME                 nvarchar(255)        not null,
   DESCRIPTION          nvarchar(255)        null,
   ACCEPTS_MEMBERS_FLAG nchar(1)             null,
   TERMINATION_DATE     datetime2            null,
   TERMINATION_REASON_ID bigint               null,
   CREATED_ON           datetime2            not null,
   CREATED_BY           nvarchar(60)         not null,
   MODIFIED_ON          datetime2            null,
   MODIFIED_BY          nvarchar(60)         null
)
go

alter table ORG
   add constraint PK_ORG primary key (ORG_ID)
go

alter table CLASSIFICATION
   add constraint FK_CLASSIFI_REFERENCE_CLASSIFI foreign key (CLASSIFICATION_TYPE_ID)
      references CLASSIFICATION_TYPE (CLASSIFICATION_TYPE_ID)
go

alter table CONTACT_INFORMATION
   add constraint FK_CONTACT__REFERENCE_MEMBER foreign key (MEMBER_ID)
      references MEMBER (MEMBER_ID)
go

alter table CONTACT_INFORMATION
   add constraint FK_CONTACT__REFERENCE_ORG foreign key (ORGANIZATION_ID)
      references ORG (ORG_ID)
go

alter table MEMBER
   add constraint FK_MEMBER_STATUS_ID foreign key (STATUS_ID)
      references CLASSIFICATION (CLASSIFICATION_ID)
go

alter table MEMBER
   add constraint FK_MEMBER_GENDER foreign key (GENDER_ID)
      references CLASSIFICATION (CLASSIFICATION_ID)
go

alter table MEMBER
   add constraint FK_MEMBER_CATEGORY foreign key (MEMBER_CATEGORY_ID)
      references CLASSIFICATION (CLASSIFICATION_ID)
go

alter table MEMBER
   add constraint FK_MEMBER_TERM_REASON foreign key (TERMINATION_REASON_ID)
      references CLASSIFICATION (CLASSIFICATION_ID)
go

alter table MEMBER_ORG_RLSHIP
   add constraint FK_MEMBER_O_REFERENCE_MEMBER foreign key (MEMBER_ID)
      references MEMBER (MEMBER_ID)
go

alter table MEMBER_ORG_RLSHIP
   add constraint FK_MEMBER_O_ROLE_ID foreign key (ROLE_ID)
      references CLASSIFICATION (CLASSIFICATION_ID)
go

alter table MEMBER_ORG_RLSHIP
   add constraint FK_MEMBER_O_EVENT_ID foreign key (EVENT_ID)
      references CLASSIFICATION (CLASSIFICATION_ID)
go

alter table MEMBER_ORG_RLSHIP
   add constraint FK_MEMBER_O_REFERENCE_ORG foreign key (ORGANIZATION_ID)
      references ORG (ORG_ID)
go

alter table ORG
   add constraint FK_ORG_REFERENCE_ORG foreign key (PARENT_ORG_ID)
      references ORG (ORG_ID)
go

