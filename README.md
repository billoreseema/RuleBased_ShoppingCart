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
git clone [https://github.com/billoreseema/RuleBased_ShoppingCart]
```

Go to the project directory

```bash
cd superMarketDemo
```

Run Application

```bash
java -cp target/superMarketDemo-1.0-SNAPSHOT-jar-with-dependencies.jar ShoppingCartApp

or 
java -cp superMarketDemo-1.0-SNAPSHOT-jar-with-dependencies.jar ShoppingCartApp

Note :- copy and place products.csv and offerCatalog.csv files from resources directory to jar excution directory 


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

- Application can be integrated to any Database only Repository module requires the connection changes
- Loggers can be added to investigate issues and for future refrences
- Diiferent types of offers can be exteneded. 
- More conditions on product price and Offers price can be added.
