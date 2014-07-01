package converter;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import mb.MarcasMb;
import entity.Marcas;






@FacesConverter(forClass=Marcas.class)
public class MarcaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		ELContext elContext = facesContext.getELContext();
		ELResolver elResolver = elContext.getELResolver();
		
		MarcasMb marcaMb = (MarcasMb) elResolver.getValue(elContext, null, "mMB");
		
		Long id = Long.parseLong(value);
		return marcaMb.buscarMarcaPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
		Marcas marca = (Marcas) object;
		return String.valueOf(marca.getId());
	}


}
