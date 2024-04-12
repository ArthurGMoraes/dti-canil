package service;

import java.util.*;
import java.io.File;
import spark.Request;
import spark.Response;
import model.PetShop;
import java.text.SimpleDateFormat;

public class AppService {
    private PetShop mcf = new PetShop("Meu Canino Feliz", 20.0f, 40.0f, 2.0f, (20.0f*1.2f), (40.0f*1.2f));
    private PetShop vr = new PetShop("Vai Rex", 15.0f, 50.0f, 1.7f, 20.0f, 55.0f);
    private PetShop cc = new PetShop("ChowChawgas", 15.0f, 50.0f, 1.7f);
	private PetShop[] psArr = new PetShop[]{mcf,vr,cc};

    private String pathArq = "project/src/main/resources/web/index.html";
    private String form = "";
	private Calendar calendar = Calendar.getInstance();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public Object load(Request request, Response response) throws Exception {
		readForm();
		try{
			
		}  catch (Exception e) { System.out.println(e.getMessage()); }

		String busca = "";
		String action = "buscar";
		String buttonLabel = "Buscar";

		busca += "\t<form class=\"form--register\" action=\"" + action + "\" method=\"post\" id=\"buscar\">";
		busca += "\t<table width=\"80%\" bgcolor=\"#FFFFFF\" align=\"center\">";
		busca += "\t\t<tr>";
		busca += "\t\t\t<td colspan=\"3\" align=\"left\"><font size=\"+2\"><b>&nbsp;&nbsp;&nbsp;</b></font></td>";
		busca += "\t\t</tr>";
		busca += "\t\t<tr>";
		busca += "\t\t\t<td colspan=\"3\" align=\"left\">&nbsp;</td>";
		busca += "\t\t</tr>";
		busca += "\t\t<tr>";
		busca += "\t\t\t<td>&nbsp;Data: <input class=\"input--register\" type=\"date\" name=\"data\" placeholder=\"data\" value=\"" +"\"></td>";
		busca += "\t\t\t<td>Quantidade cachorros pequenos: <input class=\"input--register\" type=\"number\" name=\"qP\" placeholder=\"Quantidade\" min=\"0\" value=\"" +"\"></td>";
		busca += "\t\t\t<td>Quantidade cachorros grandes: <input class=\"input--register\" type=\"number\" name=\"qG\" placeholder=\"Quantidade\" min=\"0\" value=\"" +"\"></td>";
		busca += "\t\t\t<td align=\"center\"><input type=\"submit\" value=\""+ buttonLabel +"\" class=\"input--main__style input--button\"></td>";
		busca += "\t\t</tr>";
		busca += "\t</table>";
		busca += "\t</form>";	
		
		form = form.replaceFirst("<CAMPO_PESQUISA>", busca);
		
		return form;
	}

	public Object buscar (Request request, Response response) throws Exception{
		String dateString = request.queryParams("data");
		Date date = dateFormat.parse(dateString);
		int quantidadeP = Integer.parseInt(request.queryParams("qP"));
		int quantidadeG = Integer.parseInt(request.queryParams("qG"));

		int indice;

		float precos[];
		String resposta;

		calendar.setTime(date);
		int dia = calendar.get(Calendar.DAY_OF_WEEK);

		if (dia == Calendar.SATURDAY || dia == Calendar.SUNDAY) {
			precos = calcular(psArr, quantidadeP, quantidadeG, 1);
        } else {
            precos = calcular(psArr, quantidadeP, quantidadeG, 0);
        }

		indice = conferir(precos, psArr);

		resposta = psArr[indice].getNome() + " " + precos[indice];
	
		form = form.replaceFirst("<CAMPO_RESPOSTA>", resposta);

		return form;
	}

	private int conferir(float[] p, PetShop[] ps){
		int indice = 0;
		float menorValor = p[0];

		for(int i = 1; i < p.length; i++){
			if(p[i] < menorValor){
				menorValor = p[i];
				indice = i;
			} else if (p[i] == menorValor){
				if(ps[i].getDistancia() < ps[indice].getDistancia()){
					menorValor = p[i];
					indice = i;
				}
			}
		}

		return indice;
	}

	private float[] calcular(PetShop[]p, int quantidadeP, int quantidadeG, int caso){
		float result[] = new float[p.length];

		if(caso == 0){
			for (int i = 0; i < p.length; i++){
				result[i] = (quantidadeP * p[i].getPrecoP()) + (quantidadeG * p[i].getPrecoG());
			}
		} else {
			for (int i = 0; i < p.length; i++){
				if(p[i].getAlt()){
					result[i] = (quantidadeP * p[i].getAltPrecoP()) + (quantidadeG * p[i].getAltPrecoG());
				} else {
					result[i] = (quantidadeP * p[i].getPrecoP()) + (quantidadeG * p[i].getPrecoG());
				} 
			}
		}

		return result;
	}

	private void readForm() throws Exception{
		Scanner entrada = new Scanner(new File(pathArq));
		    while(entrada.hasNext()){
		    	form += (entrada.nextLine() + "\n");
		    }
		    entrada.close();
	}
}





