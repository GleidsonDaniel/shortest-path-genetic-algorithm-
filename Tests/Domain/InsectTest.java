package Domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class InsectTest {

    private Insect insect;

    @Mock
    private Target target;

    @Mock
    private Vector2 posTarget;

    @Before
    public void setUp(){
        insect = new Insect(100);

        insect.getPos().setX(1);
        insect.getPos().setY(1);
        when(posTarget.getX()).thenReturn(4.0);
        when(posTarget.getY()).thenReturn(5.0);
        when(target.getPos()).thenReturn(posTarget);
    }

    @Test
    public void testMove() {
        Vector2 force = new Vector2(50.0,50.0);
        insect.move(force);

        assertEquals(50, insect.getAcc().getX(), 1e-10);
        assertEquals(50, insect.getAcc().getY(), 1e-10);
    }

    @Test
    public void calculateFitness() {
        insect.calculateFitness(target);
        assertEquals(0.2, insect.getFintess(),1e-10);
    }

}