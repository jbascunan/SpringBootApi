# SpringBootApi
#PROYECTO REALIZADO CON ECLIPSE
1.Clonar proyecto.
2.Abrir consola en directorio del proyecto
3.Ejecutar "gradlew bootRun" para levantar proyecto
4.Para probar se recomienda utilizar Postman llamando al endpoint "http://localhost:8080/usuario"
JSON DE ENTRADA EJEMPLO:
{
	"name": "Jose",
	"email": "Test02@test.cl",
	"password": "123456",
	"phones": [
		{
		"number": "111111",
		"cityCode": "1",
		"countryCode": "1"
		},
		{
		"number": "222222",
		"cityCode": "2",
		"countryCode": "2"
		}
	]
}
----------------------
Para levantar proyecto en eclipse:
1.-Eclipse con STS para luego actualizar dependencias con opción Gradle --> Gradle Refresh Project
2.-Ejecutar o levantar con opción Run As --> Spring Boot App
