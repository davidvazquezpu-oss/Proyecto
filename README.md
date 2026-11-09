# 🚀 Habit Tracker Dashboard

Aplicación de escritorio para el seguimiento de hábitos con un **dashboard visual moderno estilo cyberpunk/oscuro**.

Desarrollada primero en **Java puro** (lógica sólida y testeable) y posteriormente con interfaz gráfica usando **JavaFX**.

---

## 🎯 Objetivo del Proyecto

Crear un rastreador de hábitos completo que permita:

- Registrar hábitos diarios
- Calcular rachas actuales y máximas
- Visualizar estadísticas con gráficos (heatmap, barras y anillo)
- Persistencia de datos en JSON
- Interfaz moderna y atractiva

---

## 📑 Índice

1. [Fase 0 – Entorno y Estructura](#fase-0--entorno-y-estructura)
2. [Fase 1 – Modelo de Datos](#fase-1--modelo-de-datos)
3. [Fase 2 – Lógica y Cálculos](#fase-2--lógica-y-cálculos)
4. [Fase 3 – Persistencia](#fase-3--persistencia)
5. [Fase 4 – Interfaz de Consola](#fase-4--interfaz-de-consola)
6. [Fase 5 – Introducción a JavaFX](#fase-5--introducción-a-javafx)
7. [Fase 6 – Construcción del Dashboard](#fase-6--construcción-del-dashboard)
8. [Fase 7 – Estilos y CSS](#fase-7--estilos-y-css)
9. [Fase 8 – Mejoras y Escalabilidad](#fase-8--mejoras-y-escalabilidad)

---

## Fase 0 – Entorno y Estructura

**Objetivo:** Tener un proyecto Maven limpio y bien organizado.

- [ ] Crear proyecto Maven en VS Code (`Java: Create Java Project` → `Maven` → `No Archetype`)
- [ ] Configurar:
  - `groupId`: `com.tunombre.habittracker`
  - `artifactId`: `habit-tracker`
- [ ] Crear la estructura de paquetes dentro de `src/main/java/habittracker/`:


> **Regla de oro:**  
> Los paquetes `modelo` y `logica` **nunca** deben contener `System.out.println` ni `Scanner`. Solo devuelven datos.

---

## Fase 1 – Modelo de Datos

**Objetivo:** Definir las piezas básicas del sistema.

### Clase `Habito.java`
- Atributos:
  - `id` → `String` (generado con `UUID`)
  - `nombre`
  - `descripcion`
  - `color` (para el diseño visual)
- Constructor, getters y setters

### Clase `Registro.java`
- Atributos:
  - `idHabito` → `String`
  - `fecha` → `LocalDate`
- Constructor, getters y setters

**Prueba:**  
Instanciar un `Habito` y un `Registro` en un `Main` temporal e imprimirlos por consola.

---

## Fase 2 – Lógica y Cálculos

**Objetivo:** Programar el cerebro de la aplicación.

Crear la clase `GestorHabitos.java` en el paquete `logica`.

### Atributos internos
- `List<Habito> listaHabitos`
- `List<Registro> listaRegistros`

### Métodos a implementar

| Método | Descripción |
|--------|-------------|
| `añadirHabito(Habito h)` | Añade un nuevo hábito |
| `marcarCumplido(String idHabito, LocalDate fecha)` | Marca un hábito como cumplido en una fecha |
| `obtenerRachaActual(String idHabito)` | Días consecutivos cumplidos hasta hoy |
| `obtenerRachaMaxima(String idHabito)` | Racha más larga de todo el historial |
| `obtenerPorcentajeExito(String idHabito, int mes, int anio)` | % de éxito en un mes concreto |
| `obtenerHabitos()` / `obtenerRegistros()` | Acceso a los datos |

**Prueba recomendada:**  
Simular varios días con `LocalDate.of(...)` y verificar que las rachas y porcentajes son correctos.

---

## Fase 3 – Persistencia

**Objetivo:** Que los datos no se pierdan al cerrar la aplicación.

1. Añadir dependencia de **Gson** en el `pom.xml`
2. Crear la clase `GestorArchivos.java` en el paquete `persistencia`

### Métodos
- `guardarDatos(GestorHabitos gestor)` → Guarda las listas en `datos.json`
- `cargarDatos(GestorHabitos gestor)` → Lee el archivo y reconstruye los objetos

**Prueba:**  
Añadir un hábito → cerrar el programa → volver a abrir → comprobar que los datos se cargan correctamente.

---

## Fase 4 – Interfaz de Consola (Hito Funcional)

**Objetivo:** Tener una aplicación 100% funcional por terminal.

Crear `Main.java` en el paquete `consola` con un menú interactivo:

1. Ver hábitos y rachas actuales
2. Marcar hábito como cumplido hoy
3. Crear nuevo hábito
4. Ver estadísticas mensuales
5. Guardar y salir

**Consejo:**  
Usa la aplicación durante 2-3 días reales. Si es útil y funciona bien, el núcleo de Java está terminado.

---

## Fase 5 – Introducción a JavaFX

**Objetivo:** Sustituir la consola por una ventana de escritorio.

- [ ] Configurar JavaFX (nuevo proyecto Maven JavaFX o añadir dependencias)
- [ ] Crear `MainApp.java` que herede de `Application`
- [ ] Sobrescribir el método `start(Stage primaryStage)`
- [ ] Usar un `BorderPane` como layout principal
- [ ] Cargar los datos al iniciar con `GestorArchivos.cargarDatos()`
- [ ] Mostrar los hábitos en un `ListView` o `TableView`

---

## Fase 6 – Construcción del Dashboard

**Objetivo:** Replicar la estructura visual de un dashboard moderno.

### Layout principal
Usar `BorderPane` o `GridPane` para dividir la pantalla en:
- Panel lateral (menú / lista de hábitos)
- Panel de estadísticas
- Zona de gráficos

### Componentes clave

| Componente | Implementación |
|------------|----------------|
| **Heatmap (calendario de calor)** | `GridPane` + `Rectangle` por día. Color del hábito si hay registro, gris oscuro si no |
| **Gráfico de barras** | `BarChart` de JavaFX (días cumplidos por semana/mes) |
| **Gráfico de anillo** | `PieChart` o `Arc` para el % de éxito del mes |
| **Panel de rachas** | `Label` / `Text` con racha actual y máxima |

---

## Fase 7 – Estilos y CSS

**Objetivo:** Aplicar el tema oscuro cyberpunk.

1. Crear `styles.css` en `src/main/resources`
2. Vincularlo a la escena:

```java
scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());