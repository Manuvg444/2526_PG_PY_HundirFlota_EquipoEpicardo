# 🚀 Release: Proyecto Hundir la Flota con POO

## ✍️ Información del Equipo

- **Alumno 1:** [Nombre Completo]
- **Alumno 2:** [Nombre Completo]
- **Grupo:** [DAW 1ºB / ...]

---

## 📋 Checklist de Implementación (Casos de Uso)

Indica con una `X` las funcionalidades que habéis implementado correctamente:

### 📍 1. Infraestructura de Localización

- [] **UC1.1 - Jerarquía de Coordenadas**: Implementación de `Componente`, `Fila` y `Columna`.
- [] **UC1.2 - Parseo Coordenada**: Constructor de `Coordenada` capaz de procesar inputs tipo "A5" o "J10".
- [] **UC1.3 - Validación**: Control de límites del tablero (A-J, 1-10).

### 🚢 2. Entidades Navales y Defensa

- [] **UC2.1 - Sistema de Blindaje (Composición)**: Uso de la interfaz `Blindaje` en la clase Barco.
- [] **UC2.2 - Estrategias de Defensa**: Implementación de `Simple`, `Reforzado` (absorbe 1º) y `Evasivo` (20% probabilidad).
- [] **UC2.3 - Jerarquía de Barcos**: Implementación de las 5 subclases con sus atributos específicos.

### 🎮 3. Lógica del Juego y Tablero

- [] **UC3.1 - Gestión de Casillas**: Uso de `EstadoCasillaEnum` y referencia al barco.
- [] **UC3.2 - Despliegue de Flota**: Validación de colisiones y "agua alrededor" al colocar barcos.
- [] **UC3.3 - Sistema de Combate**: Implementación de la interfaz `Atacable` y gestión de impactos.

### ⚡ 4. Habilidades Especiales (Polimorfismo)

- [] **UC4.1 - Portaaviones**: Reconocimiento aéreo (Radar 3x3).
- [] **UC4.2 - Buque**: Ataque en cruz (Fila y Columna completa).
- [] **UC4.3 - Submarino**: Inmersión (Invulnerabilidad temporal).
- [] **UC4.4 - Acorazado**: Bombardeo en zona.
- [] **UC4.5 - Destructor**: Disparo doble.

### 🤖 5. Jugadores e IA

- [] **UC5.1 - Jugador Humano**: Menús interactivos y selección de habilidades.
- [] **UC5.2 - Jugador Máquina**: IA que realiza disparos aleatorios sin repetir.
- [] **UC5.3 - IA Avanzada**: La máquina utiliza habilidades especiales de forma aleatoria.

---

## 👥 Reparto de Trabajo por Paquetes (Namespaces)

Detalla qué alumno ha sido el responsable de la implementación de cada bloque de clases:

### 📍 Paquete: `com.pg.poo.hundirflota.localizacion`

| Clase / Funcionalidad                | Alumno Responsable | Realizado |
| :----------------------------------- | :----------------- | :-------: |
| `Componente` (Estructura abstracta)  | sdfasdf            |           |
| `Fila` y `Columna` (Especialización) |                    |           |
| `Coordenada` (Lógica de parseo "A1") |                    |           |
| `CoordenadaException`                |                    |           |

### 🛡️ Paquete: `com.pg.poo.hundirflota.naves` (y subpaquetes)

| Clase / Funcionalidad                             | Alumno Responsable | Realizado |
| :------------------------------------------------ | :----------------- | :-------: |
| `Barco` (Base abstracta)                          |                    |           |
| `Blindaje` (Interfaz y sistemas)                  |                    |           |
| Estrategias: `Simple`, `Reforzado`, `Evasivo`     |                    |           |
| Tipos: `Portaaviones`, `Buque`, `Submarino`, etc. |                    |           |
| Lógica de Habilidades Especiales                  |                    |           |

### 🏗️ Paquete: `com.pg.poo.hundirflota.core`

| Clase / Funcionalidad            | Alumno Responsable | Realizado |
| :------------------------------- | :----------------- | :-------: |
| `Tablero` (Colocación y ataques) |                    |           |
| `Casilla` (Gestión de estado)    |                    |           |
| `EstadoCasillaEnum`              |                    |           |
| `InformeDisparo`                 |                    |           |

### 👤 Paquetes: `com.pg.poo.hundirflota.jugador` y `app`

| Clase / Funcionalidad                | Alumno Responsable | Realizado |
| :----------------------------------- | :----------------- | :-------: |
| `Jugador` (Jerarquía de jugadores)   |                    |           |
| `JugadorHumano` (Entrada teclado)    |                    |           |
| `JugadorMaquina` (IA de disparo)     |                    |           |
| `Juego` (Bucle principal de partida) |                    |           |

---

## ⚠️ Dificultades Encontradas

_Describe aquí los problemas técnicos más importantes que habéis tenido y cómo los habéis resuelto._

1. **[Dificultad 1]**: ...
2. **[Dificultad 2]**: ...

---

## 💡 Conclusiones y Aprendizaje

_Reflexión sobre el este proyecto y su aprendizaje:_

### Trabajo en equipo

### Uso de un repositorio de código compartido

### Dimensión del proyecto y aprendizaje

(Responde a la pregunta principalmente, ¿Qué habéis aprendido en el proyecto? y si os ha parecido, (fácil, asumible, o muy complejo)).
