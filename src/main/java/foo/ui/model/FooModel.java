package foo.ui.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.atmosphere.config.service.Get;

@Getter
@Setter
@ToString
public class FooModel {
    private String name;
}
