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
public class StudentsLettersFacade extends AbstractFacade<StudentsLetters> {

    @PersistenceContext(unitName = "ProjetCSL_Delbouys_Gnebehi-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentsLettersFacade() {
        super(StudentsLetters.class);
    }
    
}
