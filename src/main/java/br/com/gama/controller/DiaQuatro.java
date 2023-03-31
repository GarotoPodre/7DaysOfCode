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
import br.com.gama.services.HTMLGenerator;

@RestController
public class DiaQuatro {
	
	Gson gson=new Gson();
	
	/**
	 * Recebe o json da API
	 * Gera HTML
	 * @return
	 */
	@RequestMapping("/diaquatro")
	public void Inicial() {
		String resp="";
		System.out.println("Iniciando dia 4");
		
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
			
			
						//for (int x=0;x<retorno.size(); x++) {
							//usuarios=(List<UsuarioDTO>) gson.fromJson(resp, UsuarioDTO.class);
				UsuarioDTO usuarios2[]= gson.fromJson(resp, UsuarioDTO[].class);
							//ChannelSearchEnum[] enums = gson.fromJson(yourJson, ChannelSearchEnum[].class);usuarios.add(usuarioDTO);
						//}
				usuarios=Arrays.asList(usuarios2); 
			
			
		} catch (IOException | InterruptedException e) {
			System.out.println("\n "+ "Deu ruim... :("); 
			e.printStackTrace();
		}
//		System.out.println("Iniciando filtro");
//		Filtro filtro=new Filtro(resp, null);
//					//List<String>retorno=filtro.linhas();
//		List<String>retorno=filtro.linhas();
//		retorno.forEach(System.out::println);
		
						//Tranformando json para objeto
					//	List<UsuarioDTO>usuarios=new ArrayList<UsuarioDTO>();
					//	for (int x=0;x<retorno.size(); x++) {
					//		UsuarioDTO usuarioDTO=gson.fromJson(retorno.get(x), UsuarioDTO.class);
					//		usuarios.add(usuarioDTO);
					//	}
					//	usuarios.forEach(System.out::println);		
		usuarios.stream()
		.forEach(u -> System.out.println("Nome: "+u.getNome()+" - "+"telefone :"+u.getRamais()));
				
		
		//return resp;
		HTMLGenerator generator=new HTMLGenerator();
		generator.generate(usuarios);
	}
}
