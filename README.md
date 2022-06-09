# Sample ShoppingCart Application


ShoppingCart Application is a sample application to calculate total amount of products purchased for a customer.
 Offers,Products and purchase invoice are the main attributes of the application.






## Tech Stack

**Build:** Maven

**Language** Java 8 and above

**Test** Junit




## Run Locally

Clone the project

```bash
git clone [https://github.com/billoreseema/ShoppingCart-Demo.git]
```

Go to the project directory

```bash
cd superMarketDemo
```

Run Application

```bash
java -cp target/superMarketDemo-1.0-SNAPSHOT.jar ShoppingCartApp

                OR 
Go to path on cmd superMarketDemo\src\main\java 
javac ShoppingCartApp.java
java ShoppingCartApp

```

Scan Product
```bash
Please follow the command line instructions to proceed for the purchase and billing
```
Sample Data
```bash
In order to run application i have created set of data for products and offers. please find the dataset class
src/main/java/data/DataInitializer.java

NOte :- products and Offers data can be added to DataInitializer.java . Comilation is required.
```
JUNIT
```bash
path for junit - src/test/ShoppingCartServiceTest.java
```

## Possible Extenstions

- Offers can be added to external file and then loaded to code inorder to avoid each time compilations.
- Application can be integrated to any Database only Repository module requires the connection changes
- Loggers can be added to investigate issues and for future refrences
- Diiferent types of offers can be exteneded. 
- More conditions on product price and Offers price can be added.
