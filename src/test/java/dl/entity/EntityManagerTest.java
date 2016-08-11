package dl.entity;

import dl.behavior.Position;
import dl.behavior.Velocity;
import dl.behavior.Behavior;
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

    private Logger LOG = LoggerFactory.getLogger(EntityManagerTest.class);

    @Autowired
    private EntityManager entityManager;

    private UUID entity;

    @Before
    public void prepareTestEntity() throws Exception {
        LOG.debug(String.valueOf(entityManager.entityCount()));
        entity = entityManager.createEntity();
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenAddingBehaviorOfAlreadyPossessedType() throws Exception {
        //given
        Behavior position = mock(Position.class);
        Behavior anotherPosition = mock(Position.class);

        //when
        entityManager.addBehavior(entity, position);
        entityManager.addBehavior(entity, anotherPosition);

        //then
    }

    @Test
    public void shouldAddTwoBehaviorsWithDifferentTypes() throws Exception {
        //given
        Behavior position = mock(Position.class);
        Behavior velocity = mock(Velocity.class);

        //when
        entityManager.addBehavior(entity, position);
        entityManager.addBehavior(entity, velocity);

        //then
        assertThat(entityManager.behaviorCount(), is(2));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenRemovingNonPossessedBehavior() throws Exception {
        //given
        Behavior position = new Position();

        //when
        entityManager.addBehavior(entity, position);
        entityManager.removeBehavior(entity, Velocity.class);

        //then
    }

    @Test
    public void shouldRemovePossessedBehaviorByBehaviorType() throws Exception {
        //given
        Behavior bPosition = mock(Position.class);

        //when
        entityManager.addBehavior(entity, bPosition);
        entityManager.removeBehavior(entity, bPosition.getClass());

        //then
        assertThat(entityManager.behaviorCount(), is(0));
    }

    @Test
    public void shouldRemovePossessedBehaviorByReference() throws Exception {
        //given
        Behavior position = mock(Position.class);

        //when
        entityManager.addBehavior(entity, position);
        entityManager.removeBehavior(entity, position);

        //then
        assertThat(entityManager.behaviorCount(), is(0));
    }

    @Test
    public void shouldCollectAllBehaviorsOfType() throws Exception {
        //given
        for (int i = 0; i < 3; i++) {
            UUID someEntity = entityManager.createEntity();
            entityManager.addBehavior(someEntity, new Position());
        }

        //when
        Collection<Position> allPositions = entityManager.allBehaviorsOfType(Position.class);
        Set<UUID> entitiesWithPosition = entityManager.entitiesPossessingBehavior(Position.class);

        //then
        assertThat(allPositions.size(), is(3));
        assertThat(entitiesWithPosition.size(), is(3));
    }

    @Test
    public void shouldProperlyVerifyBehaviorPossession() throws Exception {
        //given
        Behavior position = new Position();

        //when
        entityManager.addBehavior(entity, position);

        //then
        assertTrue(entityManager.hasBehavior(entity, Position.class));
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