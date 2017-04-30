package br.com.saracommerce.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.hateoas.Identifiable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by vinicius on 29/04/17.
 */
@MappedSuperclass
@Getter
@ToString
@EqualsAndHashCode
public class AbstractEntity implements Identifiable<Long> {

    private final @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    protected AbstractEntity() {
        this.id = null;
    }
}