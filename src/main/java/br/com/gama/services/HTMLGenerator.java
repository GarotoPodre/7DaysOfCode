package br.com.gama.services;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import br.com.gama.modelo.UsuarioDTO;

public class HTMLGenerator {

//	private List<UsuarioDTO>usuarios=new ArrayList<UsuarioDTO>();
//
//	public HTMLGenerator(List<UsuarioDTO> usuarios) {
//		this.usuarios = usuarios;
//	}
	private String html;
	
	public void generate(List<UsuarioDTO> usuarios) {
		html=
				"<html>"
						+ "<head>"
							+"<meta charset=\"utf-8\">"
							+"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">"
							+"<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" "
							+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">"
							+"<title>ramais</title>"						
						+ "</head>"
						+"<body>"
							+"<h1>Lista de ramais</h1>"
							+"<br>"
							+ "<ul>";
							for (int x=0; x<usuarios.size();x++) {
								html+="<li>"+usuarios.get(x).getNome()+" :";
								for(int y=0; y< usuarios.get(x).getRamais().size();y++) {
									html+=usuarios.get(x).getRamais().get(y).getNumero()+", ";
								}
								html+="</li>";
							}
						html+="</ul>";
						html+="</body>"
				+ "<html>";
		System.out.println("Resultado do html");
		System.out.println(html);
		
		PrintStream ps;
		try {
			ps = new PrintStream("ramais.html");
			ps.print(html);
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
