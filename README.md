# Sistema de Conversión de Monedas

Este proyecto es un sistema de conversión de monedas que permite a los usuarios convertir cantidades entre diferentes tipos de moneda utilizando tasas de cambio obtenidas de una API.

## Descripción

El sistema se basa en una arquitectura modular con clases dedicadas para manejar solicitudes HTTP, configuración de la API, respuestas de la API, y servicios de conversión de monedas. También incluye un menú interactivo para que los usuarios seleccionen las conversiones deseadas.

## Estructura del Proyecto

- `org.example.api`: Maneja las solicitudes a la API y la configuración de la misma.
  - `APIClient`: Maneja las solicitudes HTTP a la API utilizando `HttpClient`.
  - `APIConfig`: Almacena configuraciones globales de la API, como la URL base.
  - `APIResponse`: Encapsula la respuesta de la API, proporcionando métodos para acceder al código de estado y al cuerpo de la respuesta.
  - `APIUtils`: Contiene métodos de utilidad para trabajar con la API, como obtener información de una moneda específica.

- `org.example.models`: Contiene la estructura de datos para las monedas.
  - `Currency`: Representa la estructura de los datos de una moneda obtenida de la API.

- `org.example.services`: Proporciona los servicios de conversión de moneda y manejo del menú del usuario.
  - `ConversionService`: Proporciona métodos para convertir cantidades de una moneda a otra.
  - `MenuService`: Maneja la lógica del menú del usuario y las opciones de conversión.

- `org.example`: Contiene la clase principal `Main` que inicia la aplicación.

## Instalación

1. Clona el repositorio:
   ```sh
   git clone https://github.com/tu-usuario/tu-repositorio.git

2. Navega al directorio del proyecto:
    cd tu-repositorio

3. Asegúrate de tener Maven instalado para manejar las dependencias del proyecto.

## Uso

1. Compila y ejecuta el proyecto con Maven:
    mvn clean install
    mvn exec:java -Dexec.mainClass="org.example.Main"

2. Sigue las instrucciones en el menú para seleccionar las conversiones de moneda deseadas.