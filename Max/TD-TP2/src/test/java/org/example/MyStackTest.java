package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class MyStackTest {

    private Stack pile;

    // Cette méthode est exécutée avant chaque test pour initialiser une nouvelle pile.
    @Before
    public void setUp() {
        pile = new MyStack(); // Instanciation de la pile
    }

    // Test pour vérifier qu'après l'ajout d'un élément, la pile n'est plus vide.
    @Test
    public void testEmpiler_LePremierElementRendLaPileNonVide() {
        pile.push(3.14);
        assertFalse("La pile ne devrait pas être vide après l'ajout d'un élément", pile.isEmpty());
    }

    // Test pour vérifier que la taille d'une pile vide est 0.
    @Test
    public void testObtenirTaille_NouvellePileTailleZero() {
        assertEquals("La taille de la pile devrait être 0 après sa création", 0, pile.getSize());
    }

    // Test pour vérifier que la taille de la pile augmente après plusieurs empilements.
    @Test
    public void testObtenirTaille_AprèsPlusieursEmpilements() {
        pile.push(1.0);
        pile.push(2.0);
        pile.push(3.0);
        assertEquals("La taille de la pile devrait être de 3 après trois empilements", 3, pile.getSize());
    }

    // Test pour vérifier que la méthode peek() retourne correctement l'élément en haut de la pile sans le retirer.
    @Test
    public void testRegarderSommet_ObtientLElementSansRetirer() {
        pile.push(5.5);
        assertEquals("L'élément au sommet devrait être 5.5", 5.5, pile.peek(), 0.0);
        assertEquals("La taille de la pile ne devrait pas changer après peek()", 1, pile.getSize());
    }

    // Test pour vérifier que la méthode pop() retire et retourne l'élément au sommet de la pile.
    @Test
    public void testDepiler_EnleveLElementDuSommet() {
        pile.push(7.7);
        double valeur = pile.pop();
        assertEquals("L'élément retiré devrait être 7.7", 7.7, valeur, 0.0);
        assertTrue("La pile devrait être vide après le dépilement", pile.isEmpty());
    }

    // Test pour vérifier que pop() lève une exception si la pile est vide.
    @Test(expected = EmptyStackException.class)
    public void testDepiler_PileVideLèveException() {
        pile.pop();
    }

    // Test pour vérifier que peek() lève une exception si la pile est vide.
    @Test(expected = EmptyStackException.class)
    public void testRegarderSommet_PileVideLèveException() {
        pile.peek();
    }
}
