/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Noticia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kesgr
 */
@Stateless
public class NoticiaFacade extends AbstractFacade<Noticia> {

    @PersistenceContext(unitName = "POV_Gaes7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NoticiaFacade() {
        super(Noticia.class);
    }
    
    public List<Noticia> consultarNoticia(int estado, int categoria){
        Query q = em.createQuery("SELECT n FROM Noticia n WHERE n.estado=:estado AND n.categoria.idCategoria=:categoria");
                q.setParameter("estado", estado);
                q.setParameter("categoria", categoria);
                return q.getResultList();
    }
    
}
