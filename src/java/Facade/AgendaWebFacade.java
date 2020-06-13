/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.AgendaWeb;
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
public class AgendaWebFacade extends AbstractFacade<AgendaWeb> {

    @PersistenceContext(unitName = "POV_Gaes7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgendaWebFacade() {
        super(AgendaWeb.class);
    }
    
    public List<AgendaWeb> consultarAgenda(int estado){
        Query q = em.createQuery("SELECT aw FROM AgendaWeb aw WHERE aw.estado=:estado");
                q.setParameter("estado", estado);
                return q.getResultList();
    }
    
}
