package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Marcas;
import entity.Pecas;
import util.FacesContextUtil;



@ManagedBean(name="mMB")
public class MarcasMb {

	private List<Marcas> marcas;
	private EntityManager entityManager;
	private Marcas marca;
	


	@PostConstruct
	private void init() {
		marca = new Marcas();
		entityManager = FacesContextUtil.getEntityManager();
	}
	
	public List<Marcas> getMarcas() {
		if (marcas == null) {
			Query query = entityManager.createQuery(
					"SELECT m FROM Marcas m", Marcas.class);
			marcas = query.getResultList();
		}
		return marcas;
	}

	public void setMarcas(List<Marcas> marcas) {
		this.marcas = marcas;
	}
	
	public Marcas getMarca() {
		return marca;
	}

	public void setMarca(Marcas marca) {
		this.marca = marca;
	}
	
	public String salvar(){
		entityManager.merge(marca);
		
		return "listarmarcas";
	}

	public  Marcas buscarMarcaPorId(Long id) {
		
		return entityManager.find(Marcas.class, id);
	}
	
	public String editar(Long id){
		marca = entityManager.find(Marcas.class, id);
		
		return "marcasform";
	}

	public String excluir(Long id){
		Marcas marca = entityManager.find(Marcas.class, id);
		entityManager.remove(marca);
		marcas = null;
		return "listarmarcas";
	}
}
	
