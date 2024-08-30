# LABORATORIO 2 - PATTERNS
# Daniel Aldana, Santiago Avellaneda 
##### PATTERNS - FACTORY

## PRE-RREQUISITOS
- Java OpenJDK Runtime Environment: 17.x.x
- Apache Maven: 3.9.x

## OBJETIVOS
1. Entender ¿qué es Maven?
2. Usar comandos de generación de arquetipos, compilación y ejecución de un proyecto usando Maven
3. Obtener puntos adicionales por PR qué corrijan o mejoren los laboratorios

## LA HERRAMIENTA MAVEN
La herramienta [Apache Maven](https://maven.apache.org/what-is-maven.html) se usa para gestionar y manejar proyectos de software. La base de maven para un proyecto es el concepto de un modelo de objeto de proyecto (POM), Maven puede gestionar la compilación, los informes y la documentación de un proyecto a partir de este modelo, que se concreta en el archivo `pom.xml`.

Ingresar a la página de la herramienta y entender:
- Cuál es su mayor utilidad
- Fases de maven
- Ciclo de vida de la construcción
- Para qué sirven los plugins
- Qué es y para qué sirve el repositorio central de maven

## EJERCICIO DE LAS FIGURAS
### CREAR UN PROYECTO CON MAVEN
Buscar cómo se crea un proyecto maven con ayuda de los arquetipos (archetypes).

Busque cómo ejecutar desde línea de comandos el objetivo "generate" del plugin "archetype", con los siguientes parámetros:
```yml
ProjectId: org.apache.maven.archetypes:maven-archetype-quickstart:1.0
Id del Grupo: edu.eci.cvds
Id del Artefacto: Patterns
Paquete: edu.eci.cvds.patterns.archetype
```
![imagen](https://github.com/santiagoAvellaR/CVDS-lab02/blob/master/images/creando_proyecto.png)
![imagen](https://github.com/santiagoAvellaR/CVDS-lab02/blob/master/images/creando_proyecto2.png)
Se debió haber creado en el directorio, un nuevo proyecto `Patterns` a partir de un modelo o arquetipo, que crea un conjunto de directorios con un conjunto de archivos básicos.

Cambie al directorio `Patterns`:
```sh
$ cd Patterns
```

Para ver el conjunto de archivos y directorios creados por el comando `mvn` ejecute el comando `tree`.
```sh
$ tree
```
En caso de que no funcione en git bash, otra herramienta que se puede usar es PowerShell ya que ésta maneja el comando "tree".

En algunos sistemas operativos, este comando no funciona correctamente o puede requerir un parámetro (por ejemplo: `tree /f`). En caso que funcione, la
salida muestra la estructura del proyecto, similar a como se muestra a continuación:
```sh
.
│ pom.xml
└───src
├───main
│ └───java
│ └───edu
│ └───eci
│ └───cvds
│ └───patterns
  └───archetype
│ App.java
│
└───test
└───java
└───edu
└───eci
└───cvds
└───patterns
└───archetype
AppTest.java
```
![imagen](https://github.com/santiagoAvellaR/CVDS-lab02/blob/master/images/ver_conjunto_archivos.png)

## AJUSTAR ALGUNAS CONFIGURACIONES EN EL PROYECTO
Edite el archivo `pom.xml` y realize la siguiente actualización:

Hay que cambiar la version del compilador de Java a la versión 8, para ello, agregue la sección `properties` antes de la sección de
dependencias:
```xml
<properties>
  <maven.compiler.target>1.8</maven.compiler.target>
  <maven.compiler.source>1.8</maven.compiler.source>
</properties>
```

## COMPILAR Y EJECUTAR
Para compilar ejecute el comando:
```sh
$ mvn package
```
![imagen](https://github.com/santiagoAvellaR/CVDS-lab02/blob/master/images/compilar_ejecutar.png)
Si maven no actualiza las dependencias utilice la opción `-U` así:
```sh
$ mvn -U package
```

Busque cuál es el objetivo del parámetro "package" y qué otros parámetros se podrían enviar al comando `mvn`. 

- El objetivo del parámetro package es empaquetar el código compilado en un formato distribuible, como por ejemplo un JAR. 

Otros parametros que se podrian enviar serian: 

- mvn compile: Permite compilar el codigo fuente del proyecto, ademas de eso coloca los archivos .class resultantes en el directorio target/classes. 

- mvn test: Sirve para ejecutar los unit test propuestos en nuestros proyectos, para esto el ejecuta los que se encuentran en el directorio src/test. 

- mvn clean: Permite eliminar el directorio destino el cual contiene todos los archivos de compilación, teniendo así la posibilidad de un nuevo comienzo para una siguiente compilación. 

- mvn validate: Verifica o valida el proyecto, viendo si toda la informacion necesaria esta disponible. 

- mvn verify: Hace validaciones para poder verificar que el paquete es válido y cumple los criterios de calidad. 

Busque cómo ejecutar desde línea de comandos, un proyecto maven y verifique la salida cuando se ejecuta con la clase `App.java` como parámetro en "mainClass". Tip: https://www.mojohaus.org/exec-maven-plugin/usage.html

![imagen](https://github.com/santiagoAvellaR/CVDS-lab02/blob/master/images/ejecuta_clase_app.png)

![imagen](https://github.com/santiagoAvellaR/CVDS-lab02/blob/master/images/ejecuta_clase_app2.png)

Realice el cambio en la clase `App.java` para crear un saludo personalizado, basado en los parámetros de entrada a la aplicación. 

Utilizar la primera posición del parámetro que llega al método "main" para realizar elsaludo personalizado, en caso que no sea posible, se debe mantener el saludo como se encuentra actualmente:

![imagen](https://github.com/santiagoAvellaR/CVDS-lab02/blob/master/images/saludo_personalizado.png)

![imagen](https://github.com/santiagoAvellaR/CVDS-lab02/blob/master/images/saludo_personalizado_resultado.png)

Buscar cómo enviar parámetros al plugin "exec". 

- Para poder enviar parametros al plugin, se utiliza la propiedad de  -Dexec.args, el cual defina los argumentos que seran tomados al momento de la ejecución, para esto debemos poner -Dexec.args = “parametro1 parametro2 parametro 3 ...”, por lo que los parametros se dividen por espacios   

Ejecutar nuevamente la clase desde línea de comandos y verificar la salida: Hello World!

Ejecutar la clase desde línea de comandos enviando su nombre como parámetro y verificar la salida. Ej: Hello Pepito!

![imagen](https://github.com/santiagoAvellaR/CVDS-lab02/blob/master/images/enviando_parametros.png)

Ejecutar la clase con su nombre y apellido como parámetro. ¿Qué sucedió?

![imagen](https://github.com/santiagoAvellaR/CVDS-lab02/blob/master/images/enviando_parametros2.png)

Verifique cómo enviar los parámetros de forma "compuesta" para que el saludo se realice con nombre y apellido.

![imagen](https://github.com/santiagoAvellaR/CVDS-lab02/blob/master/images/modificando_app.png)

Ejecutar nuevamente y verificar la salida en consola. Ej: Hello Pepito Perez!

![imagen](https://github.com/santiagoAvellaR/CVDS-lab02/blob/master/images/ejecuta_clase_app3.png)

## HACER EL ESQUELETO DE LA APLICACIÓN
Cree el paquete `edu.eci.cvds.patterns.shapes` y el paquete `edu.eci.cvds.patterns.shapes.concrete`.

Cree una interfaz llamada `Shape.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` de la siguiente manera:
```java
package edu.eci.cvds.patterns.shapes;

public interface Shape {
    public int getNumberOfEdges();
}
```

Cree una enumeración llamada `RegularShapeType.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` así:

```java
package edu.eci.cvds.patterns.shapes;

public enum RegularShapeType {
    Triangle, Quadrilateral, Pentagon, Hexagon
}
```

En el directorio `src/main/java/edu/eci/cvds/patterns/shapes/concrete` cree las diferentes clases (Triangle, Quadrilateral, Pentagon, Hexagon), que implementen la interfaz creada y retornen el número correspondiente de vértices que tiene la figura. 

Siguiendo el ejemplo del triángulo:
```java
package edu.eci.cvds.patterns.shapes.concrete;

import edu.eci.cvds.patterns.shapes.Shape;

public class Triangle implements Shape {
    public int getNumberOfEdges() {
        return 3;
    }
}
```

Cree el archivo `ShapeMain.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` con el metodo main:
```java
package edu.eci.cvds.patterns.shapes;

public class ShapeMain {

  public static void main(String[] args) {
    if (args == null || args.length != 1) {
      System.err.println("Parameter of type RegularShapeType is required.");
      return;
    }
    try {
      RegularShapeType type = RegularShapeType.valueOf(args[0]);
      Shape shape = ShapeFactory.create(type);
      System.out.println(
        String.format(
          "Successfully created a %s with %s sides.",
          type,
          shape.getNumberOfEdges()
        )
      );
    } catch (IllegalArgumentException ex) {
      System.err.println(
        "Parameter '" + args[0] + "' is not a valid RegularShapeType"
      );
      return;
    }
  }
}
```

Analice y asegúrese de entender cada una de las instrucciones que se encuentran en todas las clases que se crearon anteriormente. Cree el archivo `ShapeFactory.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` implementando el patrón fábrica (Hint: https://refactoring.guru/design-patterns/catalog), haciendo uso de la instrucción switch-case de Java y usando las enumeraciones.

¿Cuál fábrica hiciste? y ¿Cuál es mejor?

Decidimos hacer la fábrica número 1, simple factory, ya que es lo que mejor se adapta al código que nos han dado inicialmente, dado un argumento, retornamos algún objeto de los que crea la fábrica. Es sencillo y funciona, no habría razón alguna para complicarse con los otros modelos.

- Simple Factory:

![imagen](https://github.com/PDSW-ECI/labs/assets/4140058/0788a0b7-a071-4b90-ac3f-5982289ff3b3)

- Factory Method:

![imagen](https://github.com/PDSW-ECI/labs/assets/4140058/cd82548d-347b-4a10-88bd-2d203dac12bd)
- Abstract Factory:

![imagen](https://github.com/PDSW-ECI/labs/assets/4140058/1c79a12b-21d4-46be-8f19-40f3b62b6af7)

Ejecute múltiples veces la clase ShapeMain, usando el plugin exec de maven con los siguientes parámetros y verifique la salida en consola para cada una:
- Sin parámetros
- Parámetro: qwerty
- Parámetro: pentagon
- Parámetro: Hexagon

¿Cuál(es) de las anteriores instrucciones se ejecutan y funcionan correctamente y por qué?
- Sin parámetros: Se valida que hayan argumentos y que el número de argumentos sea exactamente 1, si no lanza el error de que se requieren parámetros. Por tanto, al poner en consola mvn exec:java, tendriamos como resultado:

- Parámetro qwerty y pentagon: En el try, podemos verificar que se hace un RegularShapeType.valueOf(args[0]), este método posiblemente podría lanzar un error, en el caso en el que no encuentre coincidencias dentro los enums de RegularShapeType. Por tanto, pentagon y qwerty no funcionarían saliendo una excepcion de que el parametro no es valido.

- Parámetro Hexagon: Al tener exactamente un argumento y este coincida con alguno de los enums, se crearía el objeto y llamaría a los métodos correspondientes. Por tanto, Hexagon ejecuta de manera correcta.


## ENTREGAR
- Se espera al menos que durante la sesión de laboratorio, se termine el ejercicio del saludo y haya un avance significativo del ejercicio de las figuras.
Dentro del directorio del proyecto, cree un archivo de texto integrantes.txt con el nombre de los dos integrantes del taller.
- Crear un repositorio para este proyecto y agregar la url del mismo, como entrega del laboratorio.
- La entrega final se realizará en Moodle.
- NOTA: Investigue para qué sirve "gitignore" y cómo se usa. Para futuras entregas, debe estar configurado.

<!-- https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax -->