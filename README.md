
# Proyecto 2 Semana 4


Este proyecto se basa en el desarrollo de un microservico con Sprinboot. Desde este proyecto accederemos a nuestro microservico Book. Con las dependencias de Spring Web, Spring data Jpa, mysql connector, devtools.

Esta aplicación se ha hecho con la intención de ser ampliada a lo largo de las siguientes semanas.


## Authors

- [Sergio](https://www.github.com/sreturns)


## Tech Stack

 Java, SpringBoot, Maven


## API Reference

#### Get all Productos

```
  GET /producto
```


#### Get Product Price

```
  GET /producto/{codigoProducto}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `codigoProducto`      | `int` | **Required**. codigoProducto of Product to fetch 


#### Update Curso

```
  PUT /producto/{codigoProducto}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `codigoProducto, Producto`      |  | **Required**. Type int codigoProducto and Producto object 

