/* Procedimiento Buscar Un Centro*/

CREATE OR REPLACE PROCEDURE busc_cen (pro_cod IN centro_trabajo.cod_cen%type, pro_nom OUT centro_trabajo.nom_cen%type, pro_telf OUT centro_trabajo. telf_cen%type, pro_pro OUT centro_trabajo.pro_cen%type, pro_ciu OUT centro_trabajo.ciu_cen%type, pro_cod_pos OUT centro_trabajo.cod_pos_cen%type, pro_cal OUT centro_trabajo.cal_cen%type, pro_num OUT centro_trabajo. num_cen%type)

  AS 

BEGIN

SELECT nom_cen, telf_cen, pro_cen, ciu_cen, cod_pos_cen, cal_cen, num_cen
		
INTO pro_nom, pro_telf, pro_provincia, pro_ciudad, pro_cod_pos, pro_cal, pro_num
		
FROM centro_trabajo

WHERE cod_cen=pro_cod;

EXCEPTION	
	WHEN NO_DATA_FOUND
	THEN raise_application_error(-20001,'No hay datos');
	
END bus_cen;

/* Procedimiento Buscar Todos los Centros*/

CREATE OR REPLACE PROCEDURE busc_tod_cen (pro_cod OUT centro_trabajo.cod_cen%type, pro_nom OUT centro_trabajo.nom_cen%type, pro_telf OUT centro_trabajo. telf_cen%type, pro_pro OUT centro_trabajo.pro_cen%type, pro_ciu OUT centro_trabajo.ciu_cen%type, pro_cod_pos OUT centro_trabajo.cod_pos_cen%type, pro_cal OUT centro_trabajo.cal_cen%type, pro_num OUT centro_trabajo. num_cen%type)

AS

BEGIN

SELECT cod_cen, nom_cen, telf_cen, pro_cen, ciu_cen, cod_pos_cen, cal_cen, num_cen
	   
INTO    pro_cod, pro_nom, pro_telf, pro_provincia, pro_ciudad, pro_cod_pos, pro_cal, pro_num
		
FROM centro_trabajo;

EXCEPTION
 WHEN NO_DATA_FOUND
 THEN raise_application_error(-20001,'No hay datos');
  
END busc_tod_cen;

/* Procedimiento Buscar Un Trabajador*/

CREATE OR REPLACE PROCEDURE busc_tra (pro_dni IN trabajador.dni_tra%type, pro_nom OUT trabajador.nom_tra%type, pro_ape1 OUT trabajador.ape1_tra%type, pro_ape2 OUT trabajador.ape2_tra%type, pro_fec_nac OUT trabajador.fec_nac_tra%type, pro_telf_per OUT trabajador.telf_per_tra%type, pro_telf_emp OUT trabajador.telf_emp_tra%type, pro_usu OUT trabajador.usu_tra%type, pro_con OUT trabajador.con_tra%type, pro_sal OUT trabajador.sal_tra%type, pro_cal OUT trabajador.cal_tra%type, pro_por OUT trabajador.por_tra%type, pro_pis OUT trabajador.piso_tra%type, pro_man OUT trabajador.man_tra%type)

AS

BEGIN

SELECT nom_tra, ape1_tra, ape2_tra, fec_nac_tra, telf_per_tra, telf_emp_tra, usu_tra, con_tra, sal_tra, cal_tra, por_tra, piso_tra, man_tra

INTO pro_nom, pro_ape1, pro_ape2, pro_fec_nac, pro_telf_per, pro_telf_emp, pro_usu, pro_con, pro_sal, pro_cal, pro_por, pro_pis, pro_man

FROM trabajador	where dni_tra=pro_dni;

EXCEPTION
  WHEN NO_DATA_FOUND
  THEN raise_application_error(-20001,'No hay datos');
  
END busc_tra;

/* Procedimiento Buscar Todos los Trabajadores*/

CREATE OR REPLACE PROCEDURE busc_tod_tra (pro_dni OUT trabajador.dni_tra%type, pro_nom OUT trabajador.nom_tra%type, pro_ape1 OUT trabajador.ape1_tra%type, pro_ape2 OUT trabajador.ape2_tra%type, pro_fec_nac OUT trabajador.fec_nac_tra%type, pro_telf_per OUT trabajador.telf_per_tra%type, pro_telf_emp OUT trabajador.telf_emp_tra%type, pro_usu OUT trabajador.usu_tra%type, pro_sal OUT trabajador.sal_tra%type, pro_cal OUT trabajador.cal_tra%type, pro_por OUT trabajador.por_tra%type, pro_pis OUT trabajador.piso_tra%type, pro_man OUT trabajador.man_tra%type)

AS

BEGIN

SELECT nom_tra, ape1_tra, ape2_tra, fec_nac_tra, telf_per_tra, telf_emp_tra, usu_tra, con_tra, sal_tra, cal_tra, por_tra, piso_tra, man_tra

INTO pro_nom, pro_ape1, pro_ape2, pro_fec_nac, pro_telf_per, pro_telf_emp, pro_usu, pro_con, pro_sal, pro_cal, pro_por, pro_pis, pro_man
		
FROM trabajador;	

EXCEPTION
  WHEN NO_DATA_FOUND
  THEN raise_application_error(-20001,'No hay datos');
 
END busc_tod_tra;

/* Procedimiento Login*/

CREATE OR REPLACE PROCEDURE login (pro_usu IN trabajador.usu_tra%type, pro_con IN trabajador.con_tra)

AS

BEGIN

SELECT COUNT(*) INTO pro_num

FROM trabajador	

WHERE usu_tra = pro_usu and con_tra = pro_con;

EXCEPTION
  WHEN NO_DATA_FOUND
  THEN raise_application_error(-20001,'Usuario no encontrado');
  
END login;
