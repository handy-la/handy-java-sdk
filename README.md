# Handy Java SDK

Bienvenido a la documentación del Java SDK de **Handy**. Si no eres desarrollador o no tienes idea de qué es un SDK y solo deseas iniciar sesión en tu cuenta de Handy, puedes hacerlo [aquí](https://app.handy.la/).

Este SDK hace uso del [API](https://api.handy.la/guides/) de Handy para facilitar la implementación de algunos de los procesos más utilizados por nuestros clientes, ofreciendo una representación de los objetos de JSON utilizados por el API como objetos de Java listos para implementar dentro de tu proyecto.

Los procesos que se encuentran actualmente implementados son los siguientes:

 - **Escritura:**
	 - Productos
 - **Lectura**
	 - Pedidos

También incluye un job para para obtener los nuevos pedidos. Este job tiene un intervalo de actualización por default de 10 minutos, pero es posible configurarlo si así lo deseas.

El documento está dividido en las siguientes secciones:

 - [Implementación de Handy Java SDK](#implementacion-de-handy-java-sdk)
	 - Configuración de variable de entorno para API Token
	 - Inicialización del SDK
	 - JobHandler
	 	- Personalizado *(Recomendado)*
	 	- JobHandler default y Caché
	 - Clases principales

 - [Construcción desde el código fuente](#contruccion-desde-el-codigo-fuente)
	 - Versión de Java
	 - Pruebas Unitarias
	 - Pruebas de Integración
	 - Construcción de la librería

# Implementación de Handy Java SDK

A continuación se explicará el proceso para implementar el SDK de manera exitosa en tu proyecto.

## Configuración de variable de entorno para API Token

Lo primero que necesitas para trabajar con el SDK es un API Token. Si aún no sabes cómo generarlo puedes seguir los pasos [aquí.](https://api.handy.la/guides/casos-de-uso/inicio/)

Una vez generado tu API Token es necesario configurar la variable de entorno *HANDY_API_TOKEN* para que el SDK pueda conectarse exitosamente al API. Para configurar la variable sigue los siguentes pasos:

**Windows**

    setx HANDY_API_TOKEN [TU_API_TOKEN]

**MacOS**

    vim ~/.bash_profile

Editar el archivo agregando la siguiente línea al final

	export HANDY_API_TOKEN [TU_API_TOKEN]

Ejecuta lo siguiente para recargar el ambiente

	source ~/.bash_profile

**Linux**

	vim ~/.bashrc

Editar el archivo agregando la siguiente línea al final

	export HANDY_API_TOKEN [TU_API_TOKEN]

Ejecuta lo siguiente para recargar el ambiente

	source ~/.bashrc

## Inicialización del SDK

El SDK debe inicializarse para garantizar su correcto funcionamiento así como para arrancar la ejecución del job. Para ello se cuenta con el método estático *init()* incluído dentro de la clase *HandySDK*. Existen 4 formas de llamar a dicho método.

	HandySDK.init();
	HandySDK.init(boolean autoRetry);
	HandySDK.init(JobHandler jobHandler);
	HandySDK.init(boolean autoRetry, JobHandler jobHandler);

Los parámetros corresponden a la siguiente configuración del SDK.
| Parámetro | Descripción | Default |
|--|--|--|
| autoRetry | Determina si se debe intentar nuevamente el llamado al API en caso de haber alcanzado el límite de ejecuciones en un minuto (500). | *false* |
|jobHandler | Handler encargado del manejo de datos obtenidos por el job. | *new SalesOrderJobHandler()* |

## JobHandler

El SDK incluye una interfaz *JobHandler* que es implementada por las clases encargadas del manejo de los datos obtenidos por el job.

	public  interface JobHandler {
		public void process(Set<SalesOrder> dataToProcess);
	}

Para trabajar con esta interfaz se puede hacer de dos maneras:

### Personalizado *(Recomendado)*

Sabemos que las necesidades de nuestros clientes son distintas, por lo que es posible crear una implementación personalizada de JobHandler para procesar los datos de la forma que mejor se adapte a tu proyecto. Es por eso también que esta opción es la que **te recomendamos** a la hora de trabajar con el SDK.

	public class CustomJobHandler implements JobHandler {
		@Override
		public void process(Set<SalesOrder> dataToProcess) {
			// Aquí es donde haces tu magia.
		}
	}

Una vez que tengas tu implementación de *JobHandler* puedes configurarla al inicializar el SDK con los métodos mencionados anteriormente.

	HandySDK.init(new CustomJobHandler());

Y listo! El job procesará los datos obtenidos de acuerdo al comportamiento que hayas definido.

### JobHandler default y caché

El SDK incluye la clase *SalesOrderJobHandler* como implementación por default de JobHandler, sólo se recomienda su uso para escenarios de prueba del SDK. Esta clase almacena los datos obtenidos por el job en una caché para que puedan ser consultados en cualquier momento.
Puedes consultar dichos datos de la siguiente manera:

	HandySDKCache cache = HandySDKCache.getInstance();
	Set<SalesOrder> salesOrderSet = (Set<SalesOrder>)cache.getCacheValue("SalesOrderJobData");
	// cache.getCacheValue("SalesOrderJobData", true); // Si deseas limpiar la caché después de obtener los datos.

## Clases principales

Entre todas las clases incluídas en el SDK creemos que hay 4 con las que más trabajarás y que te serán muy útiles y fáciles de usar. Dos de ellas son beans y las otras dos controladores para interactuar con Handy.

### com.handy.sdk.beans.Product
Esta clase viene lista para integrar tus productos entre tu plataforma actual o ERP y Handy. Incluye las variables y objetos propios de un producto Handy, así como 4 métodos que te serán muy útiles para integrar tus objetos de Java o incluso para interactuar con objetos JSON si así lo requieres.

| Método | Descripción |
|--|--|
| public JSONObject toJsonObject() | Regresa el objeto Product en formato JSON para que puedas manipularlo de esa manera si lo requieres. |
| public static Product fromJsonObject(JSONObject jsonProduct) | Genera un objeto Product a partir de un JSON. Tampoco te tienes que preocupar por mapear los objetos anidados, este método lo hará por ti. |
| public static\<T extends Product\> Product fromSubClass(T product) | Convierte un objeto de una subclase de Product a un objeto Product. De esta forma puedes extender Product en tu proyecto sin preocuparte por tener que mapear los campos para interactuar con el SDK. |
|public\<T extends Product\> T toSubClass(Class\<T\> type)| Convierte un objeto Product a una subclase del mismo. Eso significa que tampoco tienes que preocuparte por mapear los datos obtenidos desde el API para poder trabajar con ellos en tu sistema. |

### com.handy.sdk.beans.SalesOrder
Esta clase te permitirá trabajar con los pedidos generados entre Handy y tu sistema. Al igual que la clase Product, incluye los 4 métodos que te ayudarán a tener los datos de la forma que los necesites.

	public JSONObject toJsonObject()
	public static SalesOrder fromJsonObject(JSONObject jsonSalesOrder)
	public static<T extends SalesOrder> SalesOrder fromSubClass(T salesOrder)
	public<T extends SalesOrder> T toSubClass(Class<T> type)

### com.handy.sdk.business.SalesOrderController

Esta clase te permitirá obtener una lista de pedidos de acuerdo a los filtros requeridos o la información de un pedido por su ID.

| Método | Descripción |
|--|--|
|  public SalesOrderResponse getSalesOrder(SalesOrderFilter filter)  | Regresa una lista de pedidos de acuerdo a los filtros seleccionados, así como la información sobre paginación para que tengas el control de cuántos pedidos quieres obtener. Y no te preocupes si no necesitas todos los filtros, puedes asignar al objeto SalesOrderFilter sólo los parámetros que requieres. |
|public SalesOrder getSalesOrderByID(int id)| Regresa la información de un pedido de acuerdo al ID que hayas enviado. En caso de no existir el pedido se regresará un objeto SalesOrder vacío. |


### com.handy.sdk.business.ProductController

Por ahora esta clase cuenta con un sólo método. Pero aún así creemos que te será muy útil ya que te permitirá crear productos dentro de Handy de manera muy fácil.

| Método | Descripción |
|--|--|
|  public ProductResponse postProduct(Product product)  | Crea un producto a través del API de Handy y regresa la información del mismo incluyendo el ID generado. En caso de error regresará dentro de la respuesta una lista con los errores listados como objetos *ProductUnprocessableEntity* |


# Construcción desde el código fuente

*(Sección informativa para uso interno de Handy)*

## Versión de Java

La versión de Java utilizada por este SDK es la 8, puedes descargar el JDK desde [aquí](https://www.oracle.com/mx/java/technologies/javase/javase8-archive-downloads.html).

## Pruebas Unitarias

Las pruebas unitarias se ejecutan cada vez que se contruye el proyecto, pero también es posible ejecutar sólo las pruebas con el siguiente comando.

	mvn test

## Pruebas de Integración

Las pruebas de integración no son ejecutadas al construir el proyecto, para ejecutarlas es necesario hacerlo manualmente desde el IDE o configurar el evento de Maven verify.

	mvn verify

**Nota:** Algunos IDE como Eclipse, no acceden a las variables de entorno del sistema operativo. Por lo que es necesario configurar la variable HANDY_API_TOKEN en cada prueba que se requiera. En caso de correr las pruebas desde terminal no es necesario realizar esta configuración adicional.

## Construcción de la librería

Para construir la librería es necesario correr el siguiente comando de Maven.

	mvn clean package

El comando generará dos versiones de la librería en la carpeta */target* del proyecto:
- handy-core-sdk-{version}.jar
- handy-core-sdk-{version}-jar-with-dependencies.jar

La diferencia entre dichas versiones es que la segunda incluye todas las dependencias utilizadas por el SDK por lo que no es necesario agregarlas manualmente.
