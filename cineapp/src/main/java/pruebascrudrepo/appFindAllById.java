package pruebascrudrepo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class appFindAllById {
		public static void main(String[] args) {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
			NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
			
			List<Integer> ids = new LinkedList<>();
			ids.add(2);
			ids.add(5);
			ids.add(8);
			
			Iterable<Noticia> it = repo.findAllById(ids);
			
			for(Noticia n : it){
				System.out.println(n);
			}
			
			context.close();
		}
}
