# 💻 Ejercicios — Módulo 01: Fundamentos de Spring Boot  

> 🎯 Objetivo: practicar los conceptos básicos vistos en la teoría — estructura del proyecto, endpoints, controladores y configuración.

---

## 🧩 Ejercicio 1: Ping API

Crea un endpoint que confirme que tu API está viva.

**Ruta:**  
GET /api/ping

**Respuesta esperada:**
```json
{
  "status": "ok",
  "timestamp": "2025-10-24T14:22:31Z"
}
```
Criterios de aceptación:
- El campo timestamp debe generarse dinámicamente (formato ISO-8601).
- El código HTTP debe ser 200 OK.

---

## 🧩 Ejercicio 2: Saludo personalizado

Crea un endpoint que devuelva un saludo dinámico según el parámetro recibido.

**Ruta:**  
GET /api/greet?name=TuNombre


**Respuesta esperada:**
```json
{
  "message": "Hola, (Tu Nombre)"
}
```
Casos adicionales:
- Si no se envía name, responde "Hola, desarrollador 👋".
- Usa @RequestParam con valor por defecto.

Criterios de aceptación:
- Sin errores si falta el parámetro.
- Código HTTP 200 OK.
- Respuesta en formato JSON.

## 🧩 Ejercicio 3: Versión de la aplicación

Haz que tu API exponga su número de versión leyendo del archivo application.properties.

**Ruta:**  
GET /api/version

**Respuesta esperada:**
```json
{
  "version": "1.0.0"
}
```

Criterios de aceptación:
- El valor debe provenir de @Value("${app.version}").
- Código HTTP 200 OK.
- Si la propiedad no existe, responde con mensaje de error manejado.

## 🧩 Ejercicio 4: Estado del servidor

Crea un endpoint que devuelva información general de la aplicación.

**Ruta:**  
GET /api/status

**Respuesta esperada:**
```json
{
  "app": "Spring Boot Journey",
  "version": "1.0.0",
  "uptime": "12s",
  "activeProfiles": ["default"]
}
```
Requisitos:
- El campo uptime se calcula desde que se levantó la aplicación (usa ManagementFactory.getRuntimeMXBean().getUptime() o Instant.now() guardado).
- Incluye el nombre de la app (@Value("${spring.application.name:Spring Boot Journey}")).
- Usa Map<String, Object> o una clase DTO.

Criterios de aceptación:
- Respuesta correcta y estructurada.
- Código HTTP 200 OK.

## 🧩 Mini Proyecto: "Mi primera app curiosa"

Reto: combina todo lo aprendido para construir una pequeña API que “simule” un servicio útil o divertido.

**Ruta:**  
Crea un endpoint /api/mood que devuelva el estado de ánimo del servidor según la hora del día.
GET /api/mood

**Respuesta posibles:**
```json
{ "mood": "🌅 Madrugador y con energía" }
{ "mood": "🌞 En plena forma" }
{ "mood": "🌙 Modo nocturno activo" }

```
Pistas:
- Una LocalTime.now() y decide el mensaje según el rango horario.
- Experimenta con ResponseEntity para devolver mensajes y estados HTTP distintos (por ejemplo, 202 Accepted si está procesando algo).
- Elige un formato limpio, con un Map<String, String> o DTO.

Criterios de aceptación:
- Compila y ejecuta correctamente.
- Código organizado y legible.
- Respuesta creativa y coherente.