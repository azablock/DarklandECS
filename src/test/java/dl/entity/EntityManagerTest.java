package dl.entity;

import dl.Behavior.BPosition;
import dl.Behavior.BVelocity;
import dl.Behavior.Behavior;
import dl.test.BaseSpringTest;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class EntityManagerTest extends BaseSpringTest {

    Logger LOG = LoggerFactory.getLogger(EntityManagerTest.class);

    @Autowired
    private EntityManager entityManager;

    private UUID entity;

    @Before
    public void clearEntityManager() throws Exception {
        entity = entityManager.createEntity();
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenAddingBehaviorOfAlreadyPossessedType() throws Exception {
        //given
        Behavior bPosition = mock(BPosition.class);
        Behavior anotherBPosition = mock(BPosition.class);
        UUID entity = UUID.randomUUID();

        //when
        entityManager.addBehavior(entity, bPosition);
        entityManager.addBehavior(entity, anotherBPosition);

        //then
    }

    @Test
    public void shouldAddTwoBehaviorsWithDifferentTypes() throws Exception {
        //given
        Behavior bPosition = mock(BPosition.class);
        Behavior cVelocity = mock(BVelocity.class);

        //when
        entityManager.addBehavior(entity, bPosition);
        entityManager.addBehavior(entity, cVelocity);

        //then
        assertThat(entityManager.behaviorCount(), is(2));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenRemovingNonPossessedBehavior() throws Exception {
        //given
        Behavior bPosition = new BPosition();

        //when
        entityManager.addBehavior(entity, bPosition);
        entityManager.removeBehavior(entity, BVelocity.class);
        //then
    }

    @Test
    public void shouldRemovePossessedBehaviorByBehaviorType() throws Exception {
        //given
        Behavior bPosition = mock(BPosition.class);

        //when
        entityManager.addBehavior(entity, bPosition);
        entityManager.removeBehavior(entity, bPosition.getClass());

        //then
        assertThat(entityManager.behaviorCount(), is(0));
    }

    @Test
    public void shouldRemovePossessedBehaviorByReference() throws Exception {
        //given
        Behavior bPosition = mock(BPosition.class);

        //when
        entityManager.addBehavior(entity, bPosition);
        entityManager.removeBehavior(entity, bPosition);

        //then
        assertThat(entityManager.behaviorCount(), is(0));
    }

    @Test
    public void shouldCollectAllBehaviorsOfType() throws Exception {
        //given
        for(int i = 0; i < 3; i++) {
            UUID someEntity = entityManager.createEntity();
            entityManager.addBehavior(someEntity, new BPosition());
        }

        //when
        Collection<BPosition> allBehaviorsOfType = entityManager.allBehaviorsOfType(BPosition.class);
        Set<UUID> entitiesWithPosition = entityManager.entitiesPossessingBehavior(BPosition.class);

        //then
        assertThat(allBehaviorsOfType.size(), is(3));
        assertThat(entitiesWithPosition.size(), is(3));
    }

    @Test
    public void shouldProperlyVerifyBehaviorPossession() throws Exception {
        //given
        Behavior bPosition = new BPosition();

        //when
        entityManager.addBehavior(entity, bPosition);

        //then
        assertTrue(entityManager.hasBehavior(entity, BPosition.class));
    }

    @Test
    public void shouldKillEntity() throws Exception {
        //given

        //when
        entityManager.killEntity(entity);

        //then
        assertThat(entityManager.entityCount(), is(0));
    }
}