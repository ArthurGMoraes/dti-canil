package service;

import java.util.*;
import java.io.File;
import spark.Request;
import spark.Response;
import model.PetShop;

public class AppService {
    private PetShop mcf = new PetShop("Meu Canino Feliz", 20.0f, 40.0f, 2.0f, (20.0f*1.2f), (40.0f*1.2f));
    private PetShop vr = new PetShop("Vai Rex", 15.0f, 50.0f, 1.7f, 20.0f, 55.0f);
    private PetShop cc = new PetShop("ChowChawgas", 15.0f, 50.0f, 1.7f);
    private String pathArq = "project/src/main/resources/web/index.html";
    private String form;

    public Object load(Request request, Response response) {
        form = "";
		try{
			Scanner entrada = new Scanner(new File(pathArq));
		    while(entrada.hasNext()){
		    	form += (entrada.nextLine() + "\n");
		    }
		    entrada.close();
		}  catch (Exception e) { System.out.println(e.getMessage()); }
		
		System.out.println(form);
		return form;
	}
}





