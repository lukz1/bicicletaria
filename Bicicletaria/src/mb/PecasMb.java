package mb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.Part;




import util.FacesContextUtil;
import util.ImagemUtil;
import entity.Pecas;




@ManagedBean(name="pMB")
public class PecasMb {

	private List<Pecas> pecas;
	private EntityManager entityManager;
	private Pecas peca;
	private Part imagem;
	private String imagemAntiga;



	@PostConstruct
	private void init() {
		peca = new Pecas();
		entityManager = FacesContextUtil.getEntityManager();
	}
	
	public String getCaminhoRelativo(String nomeImagem) {
		return ImagemUtil.getCaminhoRelativo(nomeImagem);
	}

	
	
	public List<Pecas> getPecas() {
		if (pecas == null) {
			Query query = entityManager.createQuery(
					"SELECT m FROM Pecas m", Pecas.class);
			pecas = query.getResultList();
		}
		return pecas;
	}
	
	public void setPecas(List<Pecas> pecas) {
		this.pecas = pecas;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Pecas getPeca() {
		return peca;
	}

	public void setPeca(Pecas peca) {
		this.peca = peca;
	}
	
	public Part getImagem() {
		return imagem;
	}


	public void setImagem(Part imagem) {
		this.imagem = imagem;
	}


	public String getImagemAntiga() {
		return imagemAntiga;
	}


	public void setImagemAntiga(String imagemAntiga) {
		this.imagemAntiga = imagemAntiga;
	}

	
	
	public String salvar() throws IOException {
		imagemAntiga = peca.getImagem();
		peca.setImagem(ImagemUtil.copiar(imagem, imagemAntiga));
		entityManager.merge(peca);

		return "listarpecas";
	}

	public String editar(Long id){
		peca = entityManager.find(Pecas.class, id);
		
		return "pecasform";
	}

	public String excluir(Long id){
		Pecas peca = entityManager.find(Pecas.class, id);
		entityManager.remove(peca);
		pecas = null;
		return "listarpecas";
	}

	
}
