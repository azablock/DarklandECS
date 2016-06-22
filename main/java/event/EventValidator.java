package event;

import component.Component;

import java.util.function.Predicate;

public interface EventValidator<T extends Component> {

    default boolean validate(T component) {
        return predicate(component).test(component);
    }

    Predicate<T> predicate(T component);
}
