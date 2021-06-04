# custom-genesys-backend

This is a quick sample for creating a .jsp that can be called in Genesys Composer.  
The `src/main/webapp/CFGTransaction.jsp` is the entry point into the example. That .jsp uses `com.wti.genesys.CFGTransactionJsp` which extends `com.wti.genesys.AbstractHttpJspBase` and implements a single method that returns `Map<String, Object>` 
