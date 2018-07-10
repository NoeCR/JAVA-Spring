package pruebascrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

/**
 * @author Noe
 *
 */
public class AppUpdate {
public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		//Operacion CRUD - Update
		//Busqueda del objeto a actualizar
		Optional<Noticia> optional = repo.findById(1);
		//Modificamos la entidad y la guardamos
		if(optional.isPresent()){
			Noticia noticia = optional.get();
			noticia.setEstatus("Inactiva");
			repo.save(noticia);
		}
		
		System.out.println();
		context.close();
	}
}
