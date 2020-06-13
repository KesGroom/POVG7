/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Categorianoticia;
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
public class CategorianoticiaFacade extends AbstractFacade<Categorianoticia> {

    @PersistenceContext(unitName = "POV_Gaes7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategorianoticiaFacade() {
        super(Categorianoticia.class);
    }
    
    public List<Categorianoticia> consultarCategoria(int estado){
        Query q = em.createQuery("SELECT cn FROM Categorianoticia cn WHERE cn.estado=:estado");
                q.setParameter("estado", estado);
                return q.getResultList();
    }
    
}
