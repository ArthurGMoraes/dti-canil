package service;

import java.util.*;
import java.io.File;
import spark.Request;
import spark.Response;
import model.PetShop;
import java.text.NumberFormat;

import java.text.SimpleDateFormat;

public class AppService {
    private PetShop mcf = new PetShop("Meu Canino Feliz", 20.0f, 40.0f, 2.0f, (20.0f*1.2f), (40.0f*1.2f));
    private PetShop vr = new PetShop("Vai Rex", 15.0f, 50.0f, 1.7f, 20.0f, 55.0f);
    private PetShop cc = new PetShop("ChowChawgas", 30.0f, 45.0f, 0.8f);
	private PetShop[] psArr = new PetShop[]{mcf,vr,cc};

    private String pathArq = "project/src/main/resources/web/index.html";
    private String form = "";
	private Calendar calendar = Calendar.getInstance();
	
	int x = 0;

    public Object load(Request request, Response response) throws Exception {
		if(x==0){
			readForm();
			x++;
		}

		String busca = "";
		String action = "/buscar";
		String buttonLabel = "Buscar";

		busca += "\t<form class=\"form--register\" action=\"" + action + "\" method=\"post\" id=\"buscar\">";
		busca += "\t<table class=\"pesq\" width=\"100%\" align=\"center\">";
		busca += "\t\t<tr>";
		busca += "\t\t\t<td colspan=\"3\" align=\"left\"><font size=\"+2\"><h2>Buscar melhor preço: </h2></font></td>";
		busca += "\t\t</tr>";
		busca += "\t\t<tr>";
		busca += "\t\t\t<td>&nbsp;Data: <input class=\"input--register\" type=\"date\" name=\"data\" placeholder=\"data\" value=\"" +"\" required></td>";
		busca += "\t\t\t<td>Quantidade de cães pequenos: <input class=\"input--register\" type=\"number\" name=\"qP\" placeholder=\"0\" min=\"0\" max=\"100\" value=\"" +"\" style=\"width: 10%;\" required></td>";
		busca += "\t\t\t<td>Quantidade de cães grandes: <input class=\"input--register\" type=\"number\" name=\"qG\" placeholder=\"0\" min=\"0\" max=\"100\" value=\"" +"\" style=\"width: 10%;\" required></td>";
		busca += "\t\t\t<td align=\"center\"><input type=\"submit\" value=\""+ buttonLabel +"\" class=\"btn\" id=\"btn\"></td>";
		busca += "\t\t</tr>";
		busca += "\t</table>";
		busca += "\t</form>";	
		
		//System.out.println(form);
		form = form.replaceFirst("<CAMPO_PESQUISA />", busca);
		
		return form;
	}
	
	public Object buscar (Request request, Response response) throws Exception{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		String form2 = form;
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

		dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		String c1 = (quantidadeP==1)?"cão pequeno":"cães pequenos";
		String c2 = (quantidadeG==1)?"cão grande":"cães grandes";

		resposta = "Para o dia " + dateFormat.format(date) + " o melhor preço é no petshop " + psArr[indice].getNome() + ", com o valor de " + NumberFormat.getCurrencyInstance().format(precos[indice]) + " para " + quantidadeP + " " + c1 + " e " + quantidadeG + " " + c2;
		resposta = "\t<p class=\"resp\">" + resposta + "</p></td>";

	
		form2 = form2.replace("<CAMPO_RESPOSTA />", resposta);

		return form2;
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





