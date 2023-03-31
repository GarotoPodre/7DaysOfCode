package br.com.gama.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.gama.modelo.UsuarioDTO;
import br.com.gama.services.Filtro;

@RestController
public class DiaDois {
	
	Gson gson=new Gson();
	
	@RequestMapping("/diadois")
	public String Inicial() {
		String resp="";

		System.out.println("Iniciando dia 2");
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create("http://192.168.0.9:8080/agenda/usuario"))
		      .build();		
		HttpResponse<String> response;
		List<UsuarioDTO>usuarios=new ArrayList<UsuarioDTO>();
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
			resp=response.body();
			System.out.println("Retotno do json :"+resp);
			UsuarioDTO usuarios2[]= gson.fromJson(resp, UsuarioDTO[].class);
			usuarios=Arrays.asList(usuarios2); 
			
			
		} catch (IOException | InterruptedException e) {
			System.out.println("\n "+ "Deu ruim... :("); 
			e.printStackTrace();
		}
		System.out.println("Iniciando filtro");
		Filtro filtro=new Filtro(resp, null);
		List<String>retorno=filtro.linhas();
		retorno.forEach(System.out::println);		
		usuarios.stream()
		.forEach(u -> System.out.println("Nome: "+u.getNome()+" - "+"telefone :"+u.getRamais()));
				
		
		return resp;
	}

}
