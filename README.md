# VetCue - Prototipo Mobile

**Materia:** UX - Mejoramiento de la Experiencia de Usuario
**Universidad:** Universidad de los Andes - Maestría en Ingeniería de Software (MISO)

## Integrantes

- Juan Camilo Acevedo Ospina
- Alex Mauricio Rodriguez Sanchez

---

## Descripción

VetCue es un prototipo de aplicación móvil para el seguimiento de tareas veterinarias, permitiendo gestionar alarmas, temporizadores y registros multimedia durante la atención de animales.

---

## Pantallas

### 1. `LoginScreen`
Pantalla de inicio de sesión. El usuario ingresa su correo y contraseña para acceder a la aplicación. Incluye opción de mostrar/ocultar contraseña y enlace para recuperarla.

### 2. `AlarmaScreen`
Muestra una alarma activa con la hora programada. El veterinario puede elegir entre **posponer** la alarma o **ejecutar** la tarea correspondiente.

### 3. `PosponerScreen`
Permite al usuario posponer la alarma activa. Ofrece dos opciones: posponer **15 minutos** o posponer hasta el **siguiente animal**.

### 4. `PospuestaScreen`
Pantalla de confirmación que indica que la alarma fue pospuesta exitosamente. Muestra un botón para continuar.

### 5. `OpcionesAccionarScreen`
Menú principal de acciones disponibles durante la atención. El usuario puede iniciar un **temporizador rápido**, **tomar una foto**, grabar una **nota de voz**, o **finalizar** la tarea. Incluye un modal de confirmación para finalizar.

### 6. `TemporizadorScreen`
Permite configurar la duración del temporizador seleccionando los minutos deseados mediante controles de incremento/decremento. Botones de cancelar y ejecutar.

### 7. `TemporizadorActivoScreen`
Muestra la cuenta regresiva del temporizador en curso con el tiempo restante en grande. El usuario puede detener el temporizador en cualquier momento.

### 8. `TemporizadorFinalizadoScreen`
Pantalla de confirmación que indica que el temporizador llegó a cero. Permite al usuario marcar la tarea como completada y continuar.

### 9. `TomarFotoScreen`
Visor de cámara simulado para capturar una fotografía del animal. Muestra el encuadre de la cámara y botones para cancelar o tomar la foto.

### 10. `GuardarFotoScreen`
Muestra la previsualización de la foto tomada. El usuario puede **cancelar** (descartar la foto) o **guardar** la imagen para asociarla al registro.

### 11. `GrabarNotaScreen`
Pantalla para grabar una nota de voz. Presenta una visualización de forma de onda del audio y botones para **cancelar** o **guardar** la grabación.

---

## Requisitos

- Android **14 o superior** (API level 35+)
- Dispositivo físico o emulador Android

---

## Instalación del APK

### Opción A — Instalar directamente en el dispositivo

1. **Transferir el APK** al dispositivo (por cable USB, Google Drive, WhatsApp, etc.).
2. Abrir el APK desde el explorador de archivos del dispositivo.
3. Si aparece el mensaje *"Instalar aplicaciones de fuentes desconocidas"*, ir a:
   > Ajustes → Seguridad → Instalar aplicaciones desconocidas → Activar para el explorador de archivos
4. Pulsar **Instalar** y esperar a que finalice.
5. Abrir **VetCue** desde el menú de aplicaciones.

### Opción B — Instalar con ADB (Android Debug Bridge)

Requiere tener [Android Studio](https://developer.android.com/studio) o las Platform Tools instaladas y la **depuración USB** activada en el dispositivo.

```bash
# Verificar que el dispositivo está conectado
adb devices

# Instalar el APK
adb install ruta/al/archivo/vetcue.apk
```

---

## Compilar desde el código fuente

### Prerrequisitos

| Herramienta | Versión recomendada |
|---|---|
| Android Studio | Ladybug (2024.2) o superior |
| JDK | 11 |
| Gradle | 8.x (incluido en el proyecto) |
| compileSdk / targetSdk | 36 |
| minSdk | 35 |

### Pasos

```bash
# 1. Clonar el repositorio
git clone https://github.com/jcacevedoo1/prototipo-MOBILE.git
cd prototipo-MOBILE

# 2. Abrir en Android Studio
#    File → Open → seleccionar la carpeta del proyecto

# 3. Sincronizar dependencias (Gradle sync automático al abrir)

# 4. Generar el APK de debug
./gradlew assembleDebug

# El APK se genera en:
# app/build/outputs/apk/debug/app-debug.apk
```

Para generar el APK de **release**:

```bash
./gradlew assembleRelease
# Resultado: app/build/outputs/apk/release/app-release-unsigned.apk
```

---

## Tecnologías

- **Lenguaje:** Kotlin
- **UI:** Jetpack Compose
- **Plataforma:** Android (API 35+)
- **Navegación:** Jetpack Navigation Compose
- **Build:** Gradle con Kotlin DSL
