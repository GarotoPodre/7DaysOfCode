package br.com.gama.services;

import java.util.ArrayList;
import java.util.List;

public class Filtro {
	
	private String jsonBruto;
	private List<String> campos;
	/**
	 * Recebe um json e uma lista de caplos, os quais se deseva filtrar, 
	 * se este último for null,lista todos. 
	 * @param jsonBruto
	 * @param campos
	 */
	
	public Filtro(String jsonBruto, List<String> campos) {
		this.jsonBruto = jsonBruto;
		this.campos = campos;
	}
	
	/**
	 * Retira os campos da String json, de acordo
	 * com a lista de campos.
	 * @return String json
	 */
	public List<String> linhas() {
		String temp="";

		List<String>linhas = new ArrayList<String>();// Linhas dos registros
		int fim=jsonBruto.length()-1;
		int fimRegistro=0;

		for(int x=0; x < fim;x++) { //enquanto não acabar o texto (tamanho)
			if(jsonBruto.charAt(x)=='{'){ //Se for { (início de registro)
				fimRegistro++;	
				if(fimRegistro>0) {
					temp=String.valueOf(jsonBruto.charAt(x)); //temp recebe o caracter
					int y=x+1; //índice y recebe a posição do '{'
					while(fimRegistro > 0 ) { //Enquanto não encontrar o fim de registro
						if(jsonBruto.charAt(y)=='{') {
							fimRegistro++;
						}
						if(jsonBruto.charAt(y)=='}') {
							fimRegistro--;
						}
						temp+=String.valueOf(jsonBruto.charAt(y)); //temp recebe o caracter
						y++; //incrementa índice y
						
					}
					
					temp+="},";
					x=y;//passa o valor de y para x
					linhas.add(temp);//adiciona o registro na lista de registros
				}
			}
		}
		
		return linhas;
	}

}
