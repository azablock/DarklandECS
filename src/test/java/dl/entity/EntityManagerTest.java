package dl.entity;

import dl.behavior.BPosition;
import dl.behavior.BVelocity;
import dl.behavior.Behavior;
import dl.test.BaseSpringTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class EntityManagerTest extends BaseSpringTest {

    private Logger LOG = LoggerFactory.getLogger(EntityManagerTest.class);

    @Autowired
    private EntityManager em;

    private UUID entity;

    @Before
    public void prepareTestEntity() throws Exception {
        LOG.debug(String.valueOf(em.entityCount()));
        entity = em.createEntity();
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenAddingBehaviorOfAlreadyPossessedType() throws Exception {
        //given
        Behavior bPosition = mock(BPosition.class);
        Behavior anotherBPosition = mock(BPosition.class);

        //when
        em.addBehavior(entity, bPosition);
        em.addBehavior(entity, anotherBPosition);

        //then
    }

    @Test
    public void shouldAddTwoBehaviorsWithDifferentTypes() throws Exception {
        //given
        Behavior bPosition = mock(BPosition.class);
        Behavior cVelocity = mock(BVelocity.class);

        //when
        em.addBehavior(entity, bPosition);
        em.addBehavior(entity, cVelocity);

        //then
        assertThat(em.behaviorCount(), is(2));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenRemovingNonPossessedBehavior() throws Exception {
        //given
        Behavior bPosition = new BPosition();

        //when
        em.addBehavior(entity, bPosition);
        em.removeBehavior(entity, BVelocity.class);
        //then
    }

    @Test
    public void shouldRemovePossessedBehaviorByBehaviorType() throws Exception {
        //given
        Behavior bPosition = mock(BPosition.class);

        //when
        em.addBehavior(entity, bPosition);
        em.removeBehavior(entity, bPosition.getClass());

        //then
        assertThat(em.behaviorCount(), is(0));
    }

    @Test
    public void shouldRemovePossessedBehaviorByReference() throws Exception {
        //given
        Behavior bPosition = mock(BPosition.class);

        //when
        em.addBehavior(entity, bPosition);
        em.removeBehavior(entity, bPosition);

        //then
        assertThat(em.behaviorCount(), is(0));
    }

    @Test
    public void shouldCollectAllBehaviorsOfType() throws Exception {
        //given
        for (int i = 0; i < 3; i++) {
            UUID someEntity = em.createEntity();
            em.addBehavior(someEntity, new BPosition());
        }

        //when
        Collection<BPosition> allBehaviorsOfType = em.allBehaviorsOfType(BPosition.class);
        Set<UUID> entitiesWithPosition = em.entitiesPossessingBehavior(BPosition.class);

        //then
        assertThat(allBehaviorsOfType.size(), is(3));
        assertThat(entitiesWithPosition.size(), is(3));
    }

    @Test
    public void shouldProperlyVerifyBehaviorPossession() throws Exception {
        //given
        Behavior bPosition = new BPosition();

        //when
        em.addBehavior(entity, bPosition);

        //then
        assertTrue(em.hasBehavior(entity, BPosition.class));
    }

    @Test
    public void shouldKillEntity() throws Exception {
        //given

        //when
        em.killEntity(entity);

        //then
        assertThat(em.entityCount(), is(0));
    }
}