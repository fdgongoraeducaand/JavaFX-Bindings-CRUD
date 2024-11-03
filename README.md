# JavaFX-Bindings-CRUD
Documentación de la aplicación CRUD con JavaFX
Esta aplicación JavaFX demuestra un ejemplo básico de una aplicación CRUD (Crear, Leer, Actualizar, Eliminar) que utiliza conceptos importantes como propiedades y enlaces.

Objetivo:

El objetivo principal de esta aplicación es mostrar cómo se pueden usar las propiedades y los enlaces en JavaFX para crear una interfaz de usuario interactiva y dinámica para gestionar datos.

Componentes principales:

Clase Person:

Representa la estructura de los datos que vamos a manejar.
Tiene dos propiedades: firstName (nombre) y lastName (apellido).
Estas propiedades son de tipo StringProperty, lo que significa que son observables y se pueden usar en enlaces.
Clase principal (CRUDApplication):

Interfaz de usuario:
TableView: Muestra los datos de las personas en una tabla.
TextField: Permite al usuario introducir el nombre y el apellido.
Button: Botones para añadir, actualizar y eliminar personas.
Propiedades:
firstNameProperty y lastNameProperty: almacenan los valores de los campos de texto.
Enlaces:
Se utilizan enlaces bidireccionales (bindBidirectional) para conectar las propiedades con los campos de texto. Esto asegura que cualquier cambio en un campo de texto se refleje en la propiedad correspondiente y viceversa.
Validación:
El botón "Añadir" se deshabilita si alguno de los campos de texto está vacío. Esto se logra mediante un enlace booleano que verifica si las propiedades tienen valores válidos.
Acciones de los botones:
Añadir: Crea un nuevo objeto Person con los valores de las propiedades y lo añade a la tabla.
Actualizar: Modifica los datos de la persona seleccionada en la tabla con los valores de los campos de texto.
Eliminar: Elimina la persona seleccionada de la tabla.
Listener de selección:
Cuando se selecciona una persona en la tabla, sus datos se muestran en los campos de texto.
Conceptos clave:

Propiedades: Las propiedades en JavaFX permiten observar los cambios en los valores. Cuando una propiedad cambia, se notifica a todos los elementos que están enlazados a ella.
Enlaces: Los enlaces establecen relaciones entre las propiedades. Un cambio en una propiedad puede provocar un cambio automático en otra propiedad enlazada.
CRUD: CRUD son las siglas de Crear, Leer, Actualizar y Eliminar. Estas son las operaciones básicas que se realizan en la gestión de datos.
ObservableList: Una lista observable es una colección de datos que notifica a sus observadores cuando se producen cambios en ella (añadir, eliminar o modificar elementos).
Conclusión:

Este ejemplo ilustra cómo se pueden utilizar las propiedades y los enlaces en JavaFX para crear aplicaciones interactivas y dinámicas. La aplicación CRUD muestra cómo se pueden realizar operaciones básicas de gestión de datos de forma eficiente y con una interfaz de usuario intuitiva.

Ejercicio:

Intenta modificar la aplicación para añadir nuevas funcionalidades, como:

Validar que el nombre y el apellido solo contengan letras.
Añadir un campo de edad a la clase Person.
Implementar la búsqueda de personas por nombre o apellido.
Guardar los datos en un archivo o base de datos.
¡Explora las posibilidades y diviértete programando con JavaFX!
