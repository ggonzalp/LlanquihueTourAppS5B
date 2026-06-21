* LlanquihueTourApp

* Descripción
Proyecto realizado para la agencia turística Llanquihue tour, ubicada en la región de los Lagos.
Permite registrar y consultar clientes, trabajadores, proveedores y el catálogo de tours, organizando la información en archivos 
de texto y aplicando filtros por categoría.

*Tecnologías utilizadas
- Java 23
- IntellijIdea

* Estructura del proyecto
src/
├── catalogo/
│   └── Tour.java
├── data/
│   └── GestorDatos.java
├── model/
│   ├── Direccion.java
│   ├── Persona.java
│   └── Rut.java
├── registroPersonas/
│   ├── Cliente.java
│   ├── Proveedor.java
│   └── Trabajador.java
└── ui/
└── Main.java

  * Paquetes y clases
  1. catálogo
     1.1 Tour: Representa un tour con tipo nombre y precio.
  2. data
     2.1 GestorDatos: Clase que lee y escribe los datos en archivos .txt
  3. model
     3.1 Dirección: Representa la dirección de residencia de una persona.
     3.2 Persona: Clase madre con datos personales y datos sensibles.
     3.3 Rut: Valida el formato de rut chileno.
  4. registroPersonas
     4.1 Cliente: Representa un cliente de la agencia con edad y nacionalidad.
     4.2 Proveedor: Representa a un proveedor con nombre de empresa y giro empresarial.
     4.3 Trabajador: Representa a un trabajador con tipo y sección laboral.
  5. ui
     5.1 Main: Clase principal que da inicio al sistema.

* Ejecución
1° Clonar el repositorio:
   git clone https://github.com/ggonzalp/LlanquihueTourAppS5.git

2° Abrir el proyecto en IntelliJ IDEA

3° Ejecutar la clase principal:
   src/ui/Main.java

4° El programa cargará automáticamente los datos desde los archivos:
   - resources/cliente.txt
   - resources/trabajador.txt
   - resources/Proveedor.txt
   - resources/tours.txt

* Autoría
Estudiante: Gabriela González Peirano
Asignatura: Desarrollo Orientado a Objetos I
Instituto: DuocUC


