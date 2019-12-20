/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_package;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Falkke
 */
@Stateless
public class TeamsFacade extends AbstractFacade<Teams> {

    @PersistenceContext(unitName = "ProjetCSL_Delbouys_Gnebehi-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TeamsFacade() {
        super(Teams.class);
    }
    
}
