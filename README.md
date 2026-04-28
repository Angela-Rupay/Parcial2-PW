Para ejecutar el aplicativo debe tener en cuenta lo siguiente:
1.cambiar la contraseña a la de su usuario en postgres en el archivo "aplicattion.properties"
2.Crea una base de datos llamada "parqueadero":
CREATE DATABASE parqueadero;
3.insertar los siguiente usuarios:
INSERT INTO usuario (nombre, password, id_rol)
VALUES ('admin1', '123456', 1);
INSERT INTO usuario (nombre, password, id_rol)
VALUES ('acomodador1', '123456', 2);
INSERT INTO usuario (nombre, password, id_rol)
VALUES ('cliente1', '123456', 3);
