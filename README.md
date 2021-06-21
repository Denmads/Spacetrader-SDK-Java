# Spacetrader-SDK-Java
 
 Spacetrader SDK Java is a java library for providing interaction with the Spacetraders API.
 
 Both the library and the SDK is under development.
 
 ## Quickstart
 ```java
 import spacetraderapi.entities.System;
 import java.util.List;

 public class Main {

     public static void main(String[] args) throws Exception {
         SpaceTraderAPI.setToken("1b036f31-31be-49ab-bd96-9471b13ea3f0");
         SpaceTraderAPI.createUser("MyNewUser");

         List<System> systems = SpaceTraderAPI.Systems().getListOfSystems();

         java.lang.System.out.println(systems);
     }
 }
 ```
