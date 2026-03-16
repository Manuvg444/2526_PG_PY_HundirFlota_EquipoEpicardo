# 🚀 Release: Proyecto Hundir la Flota con POO

## ✍️ Información del Equipo

- **Alumno 1:** [Manuel Vaca Gómez]
- **Alumno 2:** [Mario Real Delgado]
- **Grupo:** [DAW 1ºB / EquipoEpicardo]

---

## 📋 Checklist de Implementación (Casos de Uso)

Indica con una `X` las funcionalidades que habéis implementado correctamente:

### 📍 1. Infraestructura de Localización

- [x] **UC1.1 - Jerarquía de Coordenadas**: Implementación de `Componente`, `Fila` y `Columna`.
- [x] **UC1.2 - Parseo Coordenada**: Constructor de `Coordenada` capaz de procesar inputs tipo "A5" o "J10".
- [x] **UC1.3 - Validación**: Control de límites del tablero (A-J, 1-10).

### 🚢 2. Entidades Navales y Defensa

- [x] **UC2.1 - Sistema de Blindaje (Composición)**: Uso de la interfaz `Blindaje` en la clase Barco.
- [x] **UC2.2 - Estrategias de Defensa**: Implementación de `Simple`, `Reforzado` (absorbe 1º) y `Evasivo` (20% probabilidad).
- [x] **UC2.3 - Jerarquía de Barcos**: Implementación de las 5 subclases con sus atributos específicos.

### 🎮 3. Lógica del Juego y Tablero

- [x] **UC3.1 - Gestión de Casillas**: Uso de `EstadoCasillaEnum` y referencia al barco.
- [x] **UC3.2 - Despliegue de Flota**: Validación de colisiones y "agua alrededor" al colocar barcos.
- [x] **UC3.3 - Sistema de Combate**: Implementación de la interfaz `Atacable` y gestión de impactos.

### ⚡ 4. Habilidades Especiales (Polimorfismo)

- [x] **UC4.1 - Portaaviones**: Reconocimiento aéreo (Radar 3x3).
- [x] **UC4.2 - Buque**: Ataque en cruz (Fila y Columna completa).
- [x] **UC4.3 - Submarino**: Inmersión (Invulnerabilidad temporal).
- [x] **UC4.4 - Acorazado**: Bombardeo en zona.
- [x] **UC4.5 - Destructor**: Disparo doble.

### 🤖 5. Jugadores e IA

- [x] **UC5.1 - Jugador Humano**: Menús interactivos y selección de habilidades.
- [x] **UC5.2 - Jugador Máquina**: IA que realiza disparos aleatorios sin repetir.
- [x] **UC5.3 - IA Avanzada**: La máquina utiliza habilidades especiales de forma aleatoria.

---

## 👥 Reparto de Trabajo por Paquetes (Namespaces)

Detalla qué alumno ha sido el responsable de la implementación de cada bloque de clases:

### 📍 Paquete: `com.pg.poo.hundirflota.localizacion`

| Clase / Funcionalidad                | Alumno Responsable | Realizado |
| :----------------------------------- | :----------------- | :-------: |
| `Componente` (Estructura abstracta)  |     Mario          |     si      |
| `Fila` y `Columna` (Especialización) |     Mario          |     si      |
| `Coordenada` (Lógica de parseo "A1") |     Mario          |     si      |
| `CoordenadaException`                |     Mario          |      mas o menos     |

### 🛡️ Paquete: `com.pg.poo.hundirflota.naves` (y subpaquetes)

| Clase / Funcionalidad                             | Alumno Responsable | Realizado |
| :------------------------------------------------ | :----------------- | :-------: |
| `Barco` (Base abstracta)                          |       Manuel       |     si      |
| `Blindaje` (Interfaz y sistemas)                  |       Manuel       |     si      |
| Estrategias: `Simple`, `Reforzado`, `Evasivo`     |       Manuel       |     si      |
| Tipos: `Portaaviones`, `Buque`, `Submarino`, etc. |       Manuel       |     si      |
| Lógica de Habilidades Especiales                  |       Manuel y Mario       |     si      |

### 🏗️ Paquete: `com.pg.poo.hundirflota.core`

| Clase / Funcionalidad            | Alumno Responsable | Realizado |
| :------------------------------- | :----------------- | :-------: |
| `Tablero` (Colocación y ataques) |       Mario        |     si      |
| `Casilla` (Gestión de estado)    |       Mario        |     si      |
| `EstadoCasillaEnum`              |       Mario        |     si      |
| `InformeDisparo`                 |       Mario        |     si      |

### 👤 Paquetes: `com.pg.poo.hundirflota.jugador` y `app`

| Clase / Funcionalidad                | Alumno Responsable | Realizado |
| :----------------------------------- | :----------------- | :-------: |
| `Jugador` (Jerarquía de jugadores)   |       Manuel       |     si      |
| `JugadorHumano` (Entrada teclado)    |       Manuel       |     si      |
| `JugadorMaquina` (IA de disparo)     |       Manuel       |     si      |
| `Juego` (Bucle principal de partida) |       Manuel       |     si      |

---

## ⚠️ Dificultades Encontradas

_Describe aquí los problemas técnicos más importantes que habéis tenido y cómo los habéis resuelto._

1. **[Dificultad 1]**: Al principio nos costó entender cómo funciona el tema de las coordenadas.
2. **[Dificultad 2]**: Profundizar en el tema y los conceptos de POO fue dificil porque lo hemos visto muy rápido.

---

## 💡 Conclusiones y Aprendizaje

_Reflexión sobre el este proyecto y su aprendizaje:_

### Trabajo en equipo
Este proyecto con tantas partes diferentes ha sido muy bueno para aprender a trabajar en equipo.

### Uso de un repositorio de código compartido
Con este proyecto nos hemos dado cuenta de lo útil y cómodo que es usar un repositorio compartido.

### Dimensión del proyecto y aprendizaje
Este proyecto tan complejo para nosotros, siendo principiantes, nos ha dado lecciones muy
buenas en cuanto a programación general, organización, y pensamiento lógico. Al final
lo hemos llegado a entender casi todo bastante bien.

(Responde a la pregunta principalmente, ¿Qué habéis aprendido en el proyecto? y si os ha parecido, (fácil, asumible, o muy complejo)).
