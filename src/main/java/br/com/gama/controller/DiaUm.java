package br.com.gama.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiaUm {
	
	@RequestMapping("/diaum")
	public String Inicial() {

		DateTimeFormatter horas= DateTimeFormatter.ofPattern("hh:mm:ss");
		String resp= LocalDateTime.now().format(horas)+" : Iniciando página...";
		System.out.println(resp);
		resp+="\n "+LocalDateTime.now().format(horas)+" : Criando httpclient e httprequest";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create("http://192.168.0.9:8080/agenda/usuario"))
		      .build();
		resp+="\n "+LocalDateTime.now().format(horas)+" : Executando o client";
		System.out.println(resp);
		HttpResponse<String> response;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
			resp+="\n "+ response.body();
		} catch (IOException | InterruptedException e) {
			resp+="\n "+ "Deu ruim... :("; 
			e.printStackTrace();
		}
		

		resp+="\n "+LocalDateTime.now().format(horas)+" :FIM";
		System.out.println(resp);
		return resp;
	}

}
