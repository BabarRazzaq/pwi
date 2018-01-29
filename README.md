# PWI - Product Warehouse and Inventory

PWI is an application to maintain Product, Warehouse and Inventory releated information of a company.

#### Tools and Technologies
- Java 8
- Spring 4.0.6
- Hibernate 4.3.6
- MySQL 5.1.31
- Mockito 1.10.19
- JUnit 4.12
- Tomcat 8

## Project Setup

### 1. _Cloning the Project_
1. Download git from _[here](https://git-scm.com/downloads)_ and install it on your operating system.
2. Execute following command in your cmd/terminal to clone the project from github to your local disk.
```sh
    $ git clone https://github.com/BabarRazzaq/pwi.git
```
3. After cloning, two folders will be created in your current working directory.
  i. codebase
  ii.db

### 2. _Setup Server Application_
To run the server application follow the following instructions.
##### 1. MySQL:
1. Download and install MySQL from [here](https://www.mysql.com/downloads/)
2. Open your cmd/terminal and execute following command to login in to mysql command line.
```sh
    $ mysql -u your_username -p
```
3. Now create a database named ***pwi***, execute following command to do that.
```sh
    $ create database pwi;
```
4. Import the schema available under ***db*** folder with following name
```sh
    PWI_29_01_2018.sql
```
##### 2. Eclipse:
1. Download and install Eclipse from [here](https://www.eclipse.org/downloads/)
2. Open Eclipse and import existing maven project to your workspace and install the maven dependencies.
3. configure Tomcat 8 Server and deploy the application and run the server.

##### 3. Rest End Points:
After starting tomcat following end points can be used to access the application through PostMan.

| Request Type | End Point  | Description |
| ------------- | ------------- | ------------- |
| GET | http://***Server_IP***:***Port***/PWI/product/ | Get All Products  |
| GET | http://***Server_IP***:***Port***/PWI/product/{id} | Get Product By ID  |
| GET | http://***Server_IP***:***Port***/PWI/product/attributes/{id} | GET Product Attributes By ID  |
| GET | http://***Server_IP***:***Port***/PWI/product/attributes/{id}/warehouse/{warehouseId} | Get Product Attributes By Warehouse ID  |
| POST | http://***Server_IP***:***Port***/PWI/product/ | Add Product  |
| PUT | http://***Server_IP***:***Port***/PWI/product/{id} | Update Product By ID  |
| DELETE | http://***Server_IP***:***Port***/PWI/product/{id} | Delete Product  |
| GET | http://***Server_IP***:***Port***/PWI/warehouse/ | Get All Warehouses  |
| GET | http://***Server_IP***:***Port***/PWI/warehouse/{id} | Get Warehouse By ID  |
| POST | http://***Server_IP***:***Port***/PWI/warehouse/ | Add Warehouse  |
| PUT | http://***Server_IP***:***Port***/PWI/warehouse/{id} | Update Warehouse  |
| DELETE | http://***Server_IP***:***Port***/PWI/warehouse/{id} | Delete Warehouse  |
| PUT | http://***Server_IP***:***Port***/PWI/inventory/stock/{productId} | Update Product Stock  |
| PUT | http://***Server_IP***:***Port***/PWI/inventory/stock/{productId}/warehouse/{warehouseId} | Update Product Stock By Product ID and Warehouse ID |

For ensuring,  please refer ***pwi_config.properties*** of the project.
