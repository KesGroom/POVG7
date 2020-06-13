/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Atencionarea;
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
public class AtencionareaFacade extends AbstractFacade<Atencionarea> {

    @PersistenceContext(unitName = "POV_Gaes7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AtencionareaFacade() {
        super(Atencionarea.class);
    }
    
    public List<Atencionarea> consultarAtencionarea(int estado){
        Query q = em.createQuery("SELECT aar FROM Atencionarea aar WHERE aar.estado=:estado");
                q.setParameter("estado", estado);
                return q.getResultList();
    }
    
}
