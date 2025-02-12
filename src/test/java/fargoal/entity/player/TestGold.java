/*package fargoal.entity.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

 import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fargoal.model.entity.player.api.Gold;
import fargoal.model.entity.player.impl.GoldImpl;

public class TestGold {

    private Gold gold;

    @BeforeEach
    void setup() {
        gold = new GoldImpl();
    }

    @Test
    void TestInitialization() {
        assertEquals(0, gold.getCurrentGold());
        assertEquals(100, gold.getMaxCapacity());
    }

    @Test
    void TestObtainingGold() {
        gold.addGold(11);
        gold.addGold(100);
        assertEquals(100, gold.getCurrentGold());
    }

    @Test
    void TestGoldReset() {
        gold.addGold(99);
        assertEquals(99, gold.getCurrentGold());
        gold.resetGold();
        assertEquals(0, gold.getCurrentGold());
    }

    @Test
    void TestMaxCapacity() {
        gold.setMaxCapacity(1000);
        assertEquals(1000, gold.getMaxCapacity());
        assertEquals(0, gold.getCurrentGold());

        gold.addGold(9999);
        assertEquals(1000, gold.getCurrentGold());
        assertEquals(1000, gold.getMaxCapacity());
    }
}
 */