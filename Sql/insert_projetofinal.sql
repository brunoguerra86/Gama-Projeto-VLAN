create database projeto;

use projeto;

insert into tbl_usuario values(null, 'isidro@isidro.com','https://avatars2.githubusercontent.com/u/6184696?s=460&v=4','Isidro','isidro1','1234',1);
insert into tbl_usuario values(null, 'bruno@itau.com','https://avatars2.githubusercontent.com/u/20672836?s=460&u=279583933f65462f3509eff10802177d0d6c8ae3&v=4','Bruno','brpergu','1234',1);
insert into tbl_usuario values(null, 'usuario1@itau.com','','Usuario 1','usuari1','1234',2);
insert into tbl_usuario values(null, 'usuario2@itau.com','','Usuario 2','usuari2','1234',2);
insert into tbl_usuario values(null, 'usuario3@itau.com','','Usuario 3','usuari3','1234',3);
insert into tbl_usuario values(null, 'usuario1@itau.com','','Usuario X','usuariX','1234',3);

select * from tbl_usuario;
delete from tbl_usuario where id = 7

drop table tbl_departamento

insert into tbl_departamento values (null, 'Desenvolvimento Web', '192.168.0.0');
insert into tbl_departamento values (null, 'Presidencia', '192.168.0.1');
insert into tbl_departamento values (null, 'Data Center', '192.168.0.2');