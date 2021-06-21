# Spacetrader-SDK-Java
 
 Spacetrader SDK Java is a java library for providing interaction with the Spacetraders API.
 
 Both the library and the SDK is under development.
 
 ## Quickstart
 ```java
 import madsj.entities.GameInfo;
	import madsj.entities.System;
	import java.util.List;

	public class Main {

	    public static void main(String[] args) throws Exception {
	        //Existing User
	        SpaceTrader st = new SpaceTrader.Builder().token("1b036f31-31be-49ab-bd96-9471b13ea3f0").build();
	        //New User
	        SpaceTrader st2 = new SpaceTrader.Builder().username("MyNewUser").build();

	        List<System> systems = st.Systems.getListOfSystems();
	        java.lang.System.out.println(systems);

	        GameInfo info = st.getGameInfo();
	        java.lang.System.out.println(info.getStatus());
	    }
	}
 ```
